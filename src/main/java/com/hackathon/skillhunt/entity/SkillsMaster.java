package com.hackathon.skillhunt.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Skills")
public class SkillsMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int skill_id;
    private String skill_name;
    private String createdBy;
    private LocalDateTime createdDate;
    private String updatedBy;
    private LocalDateTime updatedDate;
    private String isDeleted;
}
