package com.mohaiminuleraj.survey.survey.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mohaiminuleraj.survey.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonBackReference // prevents the serialization of the back-reference to the Question entity.
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    @JsonBackReference // prevents the serialization of the back-reference to the Question entity.
    private  Question question;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "answer_id")
    @JsonBackReference // prevents the serialization of the back-reference to the Question entity.
    private Answer answer;
}
