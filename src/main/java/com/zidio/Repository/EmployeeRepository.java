package com.zidio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zidio.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    Employee findByEmail(String email);
}
