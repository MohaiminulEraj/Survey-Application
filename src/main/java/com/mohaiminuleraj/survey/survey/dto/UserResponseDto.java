package com.mohaiminuleraj.survey.survey.dto;

public class UserResponseDto {
    private Integer questionId;
    private Integer answerId;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }
}
