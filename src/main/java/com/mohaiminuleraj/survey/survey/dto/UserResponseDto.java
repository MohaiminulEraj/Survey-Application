package com.mohaiminuleraj.survey.survey.dto;

public class UserResponseDto {
    private Integer questionId;
    private String questionText;
    private Integer answerId;
    private String answerText;


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
