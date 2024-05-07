package com.likitha.loggingapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.likitha.loggingapp.Model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

}
