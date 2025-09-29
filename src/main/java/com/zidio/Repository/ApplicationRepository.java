package com.zidio.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zidio.Entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long>{

    List<Application> findByEmployeeEmail(String email);
	List<Application>findByRecruiterEmail(String recruiterEmail);
	List<Application>findByJobId(Long jobId);
	Optional<Application> findById(Long id);

}
