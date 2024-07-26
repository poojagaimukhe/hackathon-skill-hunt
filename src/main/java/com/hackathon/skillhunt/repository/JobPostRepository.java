package com.hackathon.skillhunt.repository;

import com.hackathon.skillhunt.entity.JobPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobPostRepository extends JpaRepository<JobPostEntity, Integer> {
    public Optional<JobPostEntity> findById(Integer id);
}
