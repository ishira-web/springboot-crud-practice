package com.example.taskapp.service.impl;

import com.example.taskapp.dto.EmployeeDto;
import com.example.taskapp.entity.Employee;
import com.example.taskapp.exception.ResourceNotFoundException;
import com.example.taskapp.mapper.EmployeeMapper;
import com.example.taskapp.repository.EmployRepository;
import com.example.taskapp.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
       Employee employee = employRepository.findById(employeeId)
        .orElseThrow(()-> new ResourceNotFoundException("Employee is not exist with given id"+ employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee) )
                .collect(Collectors.toList());
    }
}
