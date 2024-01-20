package com.mohaiminuleraj.survey.user.dto;

import com.mohaiminuleraj.survey.survey.dto.UserAnswerDto;

import java.util.List;

public class UserDto {
    private Integer userId;
    private String email;
    private String mobile;
    private List<UserAnswerDto> userAnswers;
}
