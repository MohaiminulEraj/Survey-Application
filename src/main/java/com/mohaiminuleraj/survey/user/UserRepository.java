package com.mohaiminuleraj.survey.user;

import com.mohaiminuleraj.survey.survey.entity.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    Optional<User> findByMobile(String mobile);

    User findUserById(Integer id);

    User findUserByEmail(String email);

}
