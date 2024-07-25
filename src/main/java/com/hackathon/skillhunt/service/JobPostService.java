package com.hackathon.skillhunt.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.skillhunt.dto.CreateJobPostDTO;
import com.hackathon.skillhunt.dto.SkillDetailsDTO;
import com.hackathon.skillhunt.entity.JobPostEntity;
import com.hackathon.skillhunt.entity.SkillsMaster;
import com.hackathon.skillhunt.entity.UserInfo;
import com.hackathon.skillhunt.repository.JobPostRepository;
import com.hackathon.skillhunt.repository.SkillsMasterRepository;
import com.hackathon.skillhunt.repository.UserInfoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class JobPostService {

    @Autowired
    private JobPostRepository jobPostRepository;
    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private SkillsMasterRepository skillRepo;

    ObjectMapper mapper = new ObjectMapper();

    public String createJobPost(CreateJobPostDTO createJobPostDTO) {
        try{
            Integer userId = this.getUserId(createJobPostDTO.getPostedBy());
            JobPostEntity entity = new JobPostEntity();
             if(createJobPostDTO.getId() != null) {
                Integer val = Integer.valueOf(createJobPostDTO.getId().intValue());
                Optional<JobPostEntity> byId = jobPostRepository.findById(val);

                if (byId != null && byId.get() != null) {
                    entity.setId(byId.get().getId());
                }
            }
                BeanUtils.copyProperties(createJobPostDTO, entity);
                entity.setCreatedBy("user");
                entity.setUserId(userId);
                entity.setIsDeleted("N");
                entity.setTotalExperience(createJobPostDTO.getTotalExperience().intValue());
                entity.setSkillDetails(mapper.writeValueAsString(createJobPostDTO.getSkillDetails()));
                entity.setCreatedDate(LocalDateTime.now());
                entity.setUpdatedBy("user");
                entity.setUpdatedDate(LocalDateTime.now());
                jobPostRepository.save(entity);

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "Saved Successfully.";
    }

    private Integer getUserId(String postedBy) {
        Integer userid = 0;

        Optional<UserInfo> userInfo = repository.findByUsername(postedBy);
        if(userInfo != null && userInfo.isPresent())
            userid = userInfo.get().getId();

          return userid;
    }


    public List<JobPostEntity> getAllJobPost(){
        List<JobPostEntity> list = new ArrayList<>();
        try{
            list = jobPostRepository.findAll();
            if(list != null && !list.isEmpty()){
               this.getJobPostDTO(list);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    private List<CreateJobPostDTO> getJobPostDTO(List<JobPostEntity> listOfJobPostEntity) throws Exception {
        CreateJobPostDTO dto = new CreateJobPostDTO();
        List<CreateJobPostDTO> list = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for(JobPostEntity  entity : listOfJobPostEntity){
            dto.setId(entity.getId().longValue());
            dto.setDescr(entity.getDescr());
            dto.setPostedBy(entity.getPostedBy());
            dto.setTotalExperience(entity.getTotalExperience().longValue());
            dto.setTitle(entity.getTitle());
            dto.setMatch(this.calculateSkillMatch());
            dto.setUserId(entity.getUserId());
            SkillDetailsDTO skillDto = new SkillDetailsDTO();

            List<SkillDetailsDTO> skillDataList = mapper.readValue(entity.getSkillDetails().toString(), new TypeReference<List<SkillDetailsDTO>>(){});
            if(skillDataList != null && !skillDataList.isEmpty()){
                dto.setSkillDetails(skillDataList);
            }
            list.add(dto);
        }
        return list;
    }

    private Long calculateSkillMatch() {
        return 10l;
    }

    public List<SkillsMaster> getSkills() {
        List<SkillsMaster> skills = null;
        try{
            skills = skillRepo.findAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return skills;
    }


}
