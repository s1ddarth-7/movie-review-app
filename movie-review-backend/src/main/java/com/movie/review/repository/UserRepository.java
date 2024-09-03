package com.movie.review.repository;

import com.movie.review.entity.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends MongoRepository<UserEntity, Long> {
    Optional<UserEntity> findUserByEmail(String email);
    UserEntity findTopByOrderByIdDesc();
}
