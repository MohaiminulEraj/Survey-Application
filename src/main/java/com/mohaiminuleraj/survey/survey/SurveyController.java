package com.mohaiminuleraj.survey.survey;

import com.mohaiminuleraj.survey.survey.dto.UserResponseDto;
import com.mohaiminuleraj.survey.survey.entity.Answer;
import com.mohaiminuleraj.survey.survey.entity.Question;
import com.mohaiminuleraj.survey.survey.entity.UserAnswer;
import com.mohaiminuleraj.survey.user.User;
import com.mohaiminuleraj.survey.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;

import java.util.List;
import java.util.Optional;

@RestController
@ResponseBody
@RequestMapping(value="/api/survey")
@RequiredArgsConstructor
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @Autowired
    private UserAnswerService userAnswerService;


//    @GetMapping
//    public ResponseEntity<String> sayHello(){
//        return ResponseEntity.ok("Hellloooo!");
//    }

    @GetMapping
    public List<Question> getAllQuestionsWithAnswers() {
        return surveyService.getAllQuestions();
    }

//    @PostMapping("/{userId}/answer")
//    public UserAnswer saveUserAnswer(
//            @PathVariable Integer userId,
//            @RequestParam Integer questionId,
//            @RequestParam Integer answerId,
//            HttpServletRequest request
//            ) {
////        Integer userIdFromRequest = (Integer) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE).get("userId");
////        System.out.println("User ID from HttpServletRequest: " + userIdFromRequest);
//        // Fetch user, question, and answer entities from the database
//        User user = surveyService.getUserById(userId);
//        Question question = surveyService.getQuestionById(questionId); // Fetch question by questionId from the database
//        Answer answer = surveyService.getAnswerById(answerId); // Fetch answer by answerId from the database
//
//        // Create a UserAnswer entity and set the associations
//        UserAnswer userAnswer = new UserAnswer();
//        userAnswer.setUser(user);
//        userAnswer.setQuestion(question);
//        userAnswer.setAnswer(answer);
//
//        // Save the user answer
//        return userAnswerService.saveUserAnswer(userAnswer);
//    }

    //            @PathVariable Integer userId,
    @PostMapping
    public List<UserAnswer> saveUserAnswers(
            @RequestBody List<UserResponseDto> userResponses,
            HttpServletRequest request
    ) {
        Integer userId = 1;
        System.out.println("====Req-------");
        System.out.println(request);
        Integer userIdFromAttribute = (Integer) request.getAttribute("userId");
        System.out.println("User ID from Request Attribute: " + userIdFromAttribute);
        userIdFromAttribute = (Integer) request.getAttribute("id");
        System.out.println("User ID from Request Attribute: " + userIdFromAttribute);
        System.out.println("--------Req==========");
        // Fetch user entity from the database
        User user = surveyService.getUserById(userId);
        System.out.println(user);
        // Create a list to store UserAnswer entities
        List<UserAnswer> userAnswers = userResponses.stream()
                .map(response -> createUserAnswer(user, response))
                .toList();

        // Save the user answers
        return userAnswerService.saveUserAnswers(userAnswers);
    }

    private UserAnswer createUserAnswer(User user, UserResponseDto response) {
        // Fetch question and answer entities from the database
        Question question = surveyService.getQuestionById(response.getQuestionId());
        Answer answer = surveyService.getAnswerById(response.getAnswerId());

        // Create a UserAnswer entity and set the associations
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setUser(user);
        userAnswer.setQuestion(question);
        userAnswer.setAnswer(answer);

        return userAnswer;
    }

//    @PostMapping
//    public Question createQuestion(@RequestBody Question question) {
//        return surveyService.createQuestion(question);
//    }


}
