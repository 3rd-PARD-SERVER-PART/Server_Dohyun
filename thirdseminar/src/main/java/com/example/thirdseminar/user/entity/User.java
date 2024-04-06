package com.example.thirdseminar.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;
    @Column(name = "email", length = 20)
    private String userEmail;
    @Column(name = "password")
    private String userPassword;
    @CreationTimestamp
    private Timestamp userSignupTime;

}
