package com.Api.employeeApi.services;

import com.Api.employeeApi.models.employeeModel;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.Api.employeeApi.repositories.employeeRepository;

@Service
public class employeeService {

    final employeeRepository employeeRepository;

    public employeeService(employeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public employeeModel save(employeeModel employeeModel) {
        return employeeRepository.save(employeeModel);
    }

    public boolean existsByName(String name) {
        return employeeRepository.existsByName(name);
    }

    public Object getEmployee(String name) {
        return employeeRepository.findByName(name);
    }


}