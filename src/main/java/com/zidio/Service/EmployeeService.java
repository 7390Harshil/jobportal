package com.zidio.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidio.DTO.EmployeeDTO;
import com.zidio.Entity.Employee;
import com.zidio.Repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeDTO getEmployeeByEmail(String email) {
		Employee emp= employeeRepository.findByEmail(email);
		if (emp==null)return null ;
			return new EmployeeDTO(
					emp.getId(),
					emp.getName(),
					emp.getEmail(),
					emp.getPhone(),
					emp.getQualification(),
					emp.getResumeURL());
		
	}
	public EmployeeDTO updateProfile(EmployeeDTO dto) {
    Employee emp = null;

    if (dto.getId() != null) {
        emp = employeeRepository.findById(dto.getId()).orElse(null);
    }
    if (emp == null && dto.getEmail() != null) {
        emp = employeeRepository.findByEmail(dto.getEmail());
    }
    if (emp == null) {
        emp = new Employee();
    }

    // Now update fields. Do NOT set emp.setId(dto.getId()) here

    emp.setName(dto.getName());
    emp.setEmail(dto.getEmail());
    emp.setPhone(dto.getPhone());
    emp.setQualification(dto.getQualification());
    emp.setResumeURL(dto.getResumeURL());

    Employee saved = employeeRepository.save(emp);

    return new EmployeeDTO(
        saved.getId(),
        saved.getName(),
        saved.getEmail(),
        saved.getPhone(),
        saved.getQualification(),
        saved.getResumeURL()
    );
}

}
