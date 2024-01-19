package com.mohaiminuleraj.survey.survey;

import com.mohaiminuleraj.survey.survey.entity.UserAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAnswerService {
    @Autowired
    private UserAnswerRepository userAnswerRepository;

    public UserAnswer saveUserAnswer(UserAnswer userAnswer) {
        // Add validation logic if needed
        return userAnswerRepository.save(userAnswer);
    }

    public List<UserAnswer> saveUserAnswers(List<UserAnswer> userAnswers) {
        // Add validation logic if needed
        return userAnswerRepository.saveAll(userAnswers);
    }
}
