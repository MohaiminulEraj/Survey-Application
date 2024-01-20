package com.mohaiminuleraj.survey.survey;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mohaiminuleraj.survey.survey.dto.UserAnswerDto;
import com.mohaiminuleraj.survey.survey.entity.Answer;
import com.mohaiminuleraj.survey.survey.entity.Question;
import com.mohaiminuleraj.survey.survey.entity.UserAnswer;
import com.mohaiminuleraj.survey.user.User;
import com.mohaiminuleraj.survey.user.UserRepository;
import com.mohaiminuleraj.survey.user.dto.UserDto;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SurveyService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAnswerRepository userAnswerRepository;

//    @Autowired
//    private DtoMapper dtoMapper;

    @PostConstruct
    public void loadSurveyData() {
        if (questionRepository.count() == 0) {
            try {
                // Read the JSON file content
                String jsonContent = Files.readString(Path.of("src/main/java/com/mohaiminuleraj/survey/survey/data/survey.json"));
                List<Question> questions = convertJsonToQuestions(jsonContent);

                // Save questions to the database
                questionRepository.saveAll(questions);

                // Save answers to the database
                questions.forEach(question -> answerRepository.saveAll(question.getAnswers()));
            } catch (IOException e) {
                // Handle file reading exception
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    private List<Question> convertJsonToQuestions(String jsonContent) {
        List<Question> questions = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> surveyMap = objectMapper.readValue(jsonContent, Map.class);

            // Extract survey name and questions
            String surveyName = (String) surveyMap.get("surveyName");
            List<Map<String, Object>> jsonQuestions = (List<Map<String, Object>>) surveyMap.get("questions");

            // Create Question entities
            for (Map<String, Object> jsonQuestion : jsonQuestions) {
                Question question = new Question();
                question.setQuestionText((String) jsonQuestion.get("questionText"));

                // Create Answer entities for the question
                List<Answer> answers = new ArrayList<>();
                List<String> answerOptions = (List<String>) jsonQuestion.get("answerOptions");
                for (String answerText : answerOptions) {
                    Answer answer = new Answer();
                    answer.setAnswerText(answerText);
                    answer.setQuestion(question);
                    answers.add(answer);
                }

                question.setAnswers(answers);
                questions.add(question);
            }

        } catch (IOException e) {
            // Handle JSON parsing exception
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return questions;
    }

    // Question Services
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(Integer id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Question not found with id: " + id));
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    // Answer Service

    public List<Answer> getAllAnswers() {
        return answerRepository.findAll(
        );
    }

    public Answer getAnswerById(Integer id) {
        return answerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Answer not found with id: " + id));
    }

    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public User getUserById(Integer id) {
        return userRepository.findUserById(id);
    }

    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public List<User> getUsersInfo() { return (List<User>) userRepository.findAll(); }
    public List<UserAnswer> getAllUserAnswers() {
        System.out.println("Helllloooooo!!!!");
        return userAnswerRepository.findAll();
    }



    public List<UserAnswer> getAllUserAnswersWithDetails() {
        return userAnswerRepository.findAllWithDetails();
    }
//    public List<UserAnswer> getUserAnswersByUserIdAndQuestionIdAndAnswerId(Integer userId, Integer questionId, Integer answerId) {
//        return userAnswerRepository.findByUserIdAndQuestionIdAndAnswerId(userId, questionId, answerId);
//    }

//    public UserDto setUserAnswers(Integer userId, List<UserAnswerDto> userAnswersDto) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
//
//        List<UserAnswer> userAnswers = dtoMapper.mapUserAnswersToEntity(userAnswersDto);
//        for (UserAnswer userAnswer : userAnswers) {
//            userAnswer.setUser(user);
//        }
//
//        userAnswerRepository.saveAll(userAnswers);
//
//        // Refresh the user entity to reflect the changes
//        user = userRepository.findById(userId).orElse(null);
//
//        return dtoMapper.mapUserToDto(user);
//    }
}
