package com.hackathon.skillhunt.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Users")
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        private String firstName;
        private String lastName;
        private String username;
        private String password;
        private String role;
}
