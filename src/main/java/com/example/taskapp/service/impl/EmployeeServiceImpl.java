package com.example.taskapp.service.impl;

import com.example.taskapp.dto.EmployeeDto;
import com.example.taskapp.entity.Employee;
import com.example.taskapp.mapper.EmployeeMapper;
import com.example.taskapp.repository.EmployRepository;
import com.example.taskapp.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployRepository employRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
