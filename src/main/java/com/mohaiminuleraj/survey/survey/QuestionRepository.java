package com.mohaiminuleraj.survey.survey;

import com.mohaiminuleraj.survey.survey.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
