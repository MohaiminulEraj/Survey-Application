package com.mohaiminuleraj.survey.survey;

import com.mohaiminuleraj.survey.survey.entity.UserAnswer;
import com.mohaiminuleraj.survey.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer, Integer> {
    @Query("SELECT ua FROM UserAnswer ua " +
            "LEFT JOIN FETCH ua.user " +
            "LEFT JOIN FETCH ua.question " +
            "LEFT JOIN FETCH ua.answer")
    List<UserAnswer> findAllWithDetails();

    UserAnswer findByUserId(Integer id);

//    @Query("SELECT ua FROM UserAnswer ua " +
//            "JOIN FETCH ua.user " +
//            "JOIN FETCH ua.question " +
//            "JOIN FETCH ua.answer " +
//            "WHERE ua.user.id = :userId AND ua.question.id = :questionId AND ua.answer.id = :answerId")
//    List<UserAnswer> findByUserIdAndQuestionIdAndAnswerId(@Param("userId") Integer userId,
//                                                          @Param("questionId") Integer questionId,
//                                                          @Param("answerId") Integer answerId);

}
