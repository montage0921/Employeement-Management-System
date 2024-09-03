package net.javagudies.ems_backend.service.impl;

import lombok.AllArgsConstructor;
import net.javagudies.ems_backend.dito.EmployeeDto;
import net.javagudies.ems_backend.entity.Employee;
import net.javagudies.ems_backend.exceptions.ResourceNotFoundException;
import net.javagudies.ems_backend.repository.EmployeeRepository;
import net.javagudies.ems_backend.service.EmployeeService;
import org.springframework.stereotype.Service;
import net.javagudies.ems_backend.mapper.EmployeeMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto((savedEmployee));
    }

    @Override
    public EmployeeDto getEmployee(Long employeeId)
    {
        Employee employee=employeeRepository.findById(employeeId).
                orElseThrow(()->
                        new ResourceNotFoundException("Employee is not exist in the given id: "+employeeId));
        return EmployeeMapper.mapToEmployeeDto((employee));
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees=employeeRepository.findAll();

        return employees.stream()
                .map((employee)->EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee=employeeRepository.findById(employeeId).
                orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exist in the given id: " + employeeId));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        Employee updatedEmployeeObj=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId).
                orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exist in the given id: " + employeeId));
        employeeRepository.deleteById(employeeId);
    }
}
