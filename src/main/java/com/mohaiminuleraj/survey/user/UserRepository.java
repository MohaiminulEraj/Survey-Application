package com.mohaiminuleraj.survey.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    Optional<User> findByMobile(String mobile);

    User findUserById(Integer id);
//    Optional<User> findUserById(Integer id);

}
