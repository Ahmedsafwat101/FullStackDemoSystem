package com.example.fullstackdemosystem.employee;

import com.example.fullstackdemosystem.employee.command.AddEmployeeCommand;
import com.example.fullstackdemosystem.employee.dto.EmployeeResponseDTO;
import com.example.fullstackdemosystem.employee.dto.EmployeeUpdateDTO;
import com.example.fullstackdemosystem.employee.exception.EmployeeNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;

    //TODO() add Employee
    public EmployeeResponseDTO addEmployee(AddEmployeeCommand employeeCommand) {
        Employee employee = employeeMapper.EmployeeCommandToEmployee(employeeCommand);
        System.out.println("emp:" + employee.toString());
        employee = setCreateDateAndUpdateDate(employee);
        employee.setCode(UUID.randomUUID().toString());
        employeeRepository.save(employee);
        return employeeMapper.EmployeeToEmployeeDto(employee);
    }

    //TODO() update Employee by ID
    public EmployeeResponseDTO updateEmployee(EmployeeUpdateDTO updateDTO, Long emp_id) throws EmployeeNotFoundException  {
        Employee employee = employeeRepository.findById(emp_id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee by id:" + emp_id + " wasn't found"));
        employeeMapper.updateEmployee(updateDTO, employee);
        employeeRepository.save(employee);
        return employeeMapper.EmployeeToEmployeeDto(employee);
    }

    //TODO() delete Employee by ID
    public EmployeeResponseDTO deleteEmployee(Long emp_id) throws EmployeeNotFoundException  {
      Employee employee = employeeRepository.findById(emp_id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee by id:" + emp_id + " wasn't found"));
        employeeRepository.delete(employee);
        return employeeMapper.EmployeeToEmployeeDto(employee);
    }

    //TODO() find Employee by ID
    public EmployeeResponseDTO findEmployee(Long emp_id) throws EmployeeNotFoundException  {
        Employee employee = employeeRepository.findById(emp_id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee by id:" + emp_id + " wasn't found"));

        return employeeMapper.EmployeeToEmployeeDto(employee);
    }

    //TODO() find All Employees
    public List<EmployeeResponseDTO> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employeeMapper::EmployeeToEmployeeDto).collect(Collectors.toList());
    }


    private Employee setCreateDateAndUpdateDate(Employee employee) {
        employee.setCreatedAt(LocalDateTime.now());
        employee.setUpdatedAt(LocalDateTime.now());
        return employee;
    }


}
