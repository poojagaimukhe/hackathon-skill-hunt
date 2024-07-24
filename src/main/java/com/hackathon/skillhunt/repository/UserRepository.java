package com.hackathon.skillhunt.repository;

import com.hackathon.skillhunt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
