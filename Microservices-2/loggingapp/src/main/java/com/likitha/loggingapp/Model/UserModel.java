package com.likitha.loggingapp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user_details")
public class UserModel {

    @Id
    private int userId;

    private String userName;

    private String password;
}
