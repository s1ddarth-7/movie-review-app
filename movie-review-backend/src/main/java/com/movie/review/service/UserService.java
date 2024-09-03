package com.movie.review.service;

import com.movie.review.entity.UserEntity;
import com.movie.review.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * finds a user from MongoDB based on the email address
     * @param email - email address
     * @return - UserEntity
     */
    public Optional<UserEntity> findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    /**
     * creates and saves the UserEntity after encoding the password using BCryptPasswordEncoder(salt)
     * @param user - UserEntity that's passed as JSON in POST
     * @return - UserEntity
     */
    public UserEntity createUser(UserEntity user) {
        BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setId(userRepository.findTopByOrderByIdDesc().getId()+1);
        System.out.println(user);
        return userRepository.insert(user);
    }

}
