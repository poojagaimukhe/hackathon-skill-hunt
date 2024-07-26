package com.hackathon.skillhunt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateJobPostDTO {
    private Long id;
    private String title;
    private String descr;
    private String postedBy;
    private List<SkillDetailsDTO> skillDetails;
    private Long totalExperience;
    private Long match;
    private Integer userId;
}
