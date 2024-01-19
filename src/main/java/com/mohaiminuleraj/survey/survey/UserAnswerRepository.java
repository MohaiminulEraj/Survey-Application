package com.mohaiminuleraj.survey.survey;

import com.mohaiminuleraj.survey.survey.entity.UserAnswer;
import com.mohaiminuleraj.survey.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer, Integer> {
}
