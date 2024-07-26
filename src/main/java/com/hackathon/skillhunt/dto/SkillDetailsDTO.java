package com.hackathon.skillhunt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillDetailsDTO {
    private Long id;
    private String name;
    private Long strength;
    private Long experience;
}
