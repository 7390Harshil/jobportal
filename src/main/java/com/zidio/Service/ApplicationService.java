package com.zidio.Service;

import java.util.List;
import java.util.stream.Collectors;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidio.DTO.ApplicationDTO;
import com.zidio.DTO.UpdateApplicationStatusDTO;
import com.zidio.Entity.Application;
import com.zidio.Enum.ApplicationStatus;
import com.zidio.Repository.ApplicationRepository;

@Service
public class ApplicationService {

    @Autowired
	private ApplicationRepository applicationRepository;
	
	
	public ApplicationDTO applyJob(ApplicationDTO dto) {
		Application app= new Application();
		app.setId(dto.id);
		app.setJobId(dto.jobId);
		app.setEmployeeEmail(dto.employeeEmail);
		app.setRecruiterEmail(dto.recruiterEmail);
		app.setStatus(ApplicationStatus.APPLIED);
		app.setResumeURL(dto.resumeURL);
	
		applicationRepository.save(app);
		
		return mapToDTO(app);
		
	}
	
	public List<ApplicationDTO>getByEmployeeEmail(String employeeEmail){
		return applicationRepository.findByEmployeeEmail(employeeEmail).stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	public List<ApplicationDTO>getByRecruiterEmail(String recruiterEmail){
		return applicationRepository.findByRecruiterEmail(recruiterEmail).stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public List<ApplicationDTO>getByJobId(Long jobId){
		return applicationRepository.findByJobId(jobId).stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public ApplicationDTO updateApplicationStatus(UpdateApplicationStatusDTO dto) {
		
		Optional<Application>optional= applicationRepository.findById(dto.getApplicatiionId());
		
		if(!optional.isPresent()) {
		throw new RuntimeException("Application not found");
		}
		
		Application app= optional.get();
		
		try {
			ApplicationStatus newStatus = ApplicationStatus.valueOf(dto.getStatus().toString());
		app.setStatus(ApplicationStatus.valueOf(dto.status.toString()));
		}
		catch(IllegalArgumentException e) {
			throw new RuntimeException("Invalid status"+dto.status);
		}
		applicationRepository.save(app);
		
		return mapToDTO(app);
	}
	private ApplicationDTO mapToDTO(Application app) {
		ApplicationDTO dto= new ApplicationDTO();
		
		dto.setId(app.getId());
		dto.setJobId(app.getJobId());
		dto.setEmployeeEmail(app.getEmployeeEmail());
		dto.setRecruiterEmail(app.getRecruiterEmail());
		dto.setStatus(app.getStatus());
		dto.setResumeURL(app.getResumeURL());
		
		return dto;
		
	}
}
