package com.hackathon.skillhunt.repository;

import com.hackathon.skillhunt.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
        Optional<UserInfo> findByUsername(String username);
}
