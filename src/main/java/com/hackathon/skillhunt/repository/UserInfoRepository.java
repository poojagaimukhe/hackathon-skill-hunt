package com.hackathon.skillhunt.repository;

import com.hackathon.skillhunt.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
        Optional<UserInfo> findByUsername(String username);
}
