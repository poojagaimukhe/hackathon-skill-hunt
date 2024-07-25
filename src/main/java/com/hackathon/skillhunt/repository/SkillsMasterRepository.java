package com.hackathon.skillhunt.repository;

import com.hackathon.skillhunt.entity.SkillsMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillsMasterRepository extends JpaRepository<SkillsMaster, Integer> {

}
