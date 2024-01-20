package com.mohaiminuleraj.survey.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mohaiminuleraj.survey.survey.entity.Answer;
import com.mohaiminuleraj.survey.survey.entity.UserAnswer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data // for getter setter
@Builder // build object using design pattern
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String address;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String mobile;
    private String password;

    @OneToMany(targetEntity = UserAnswer.class,  mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<UserAnswer> userAnswers;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }
    public String getUserMobile() {
        return mobile;
    }

//    public List<UserAnswer> getUserAnswer() {
//        return userAnswers;
//    }
//    public void setUserAnswerList(List<UserAnswer> userAnswers) { this.userAnswers = userAnswers; }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
