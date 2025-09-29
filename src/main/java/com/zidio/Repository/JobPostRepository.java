package com.zidio.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zidio.Entity.JobPost;
import com.zidio.Enum.JobType;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost, Long>{
    List<JobPost> findByCompanyName(String companyName);
	List<JobPost>findByJobTitle(String jobTitle);
	List<JobPost>findByJobType(JobType jobType);
	List<JobPost>findByJobLocation(String jobLocation);
	List<JobPost> findByRecruiterEmail(String recruiterEmail);
}
