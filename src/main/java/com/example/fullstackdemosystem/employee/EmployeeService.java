package com.example.fullstackdemosystem.employee;

import com.example.fullstackdemosystem.employee.command.AddEmployeeCommand;
import com.example.fullstackdemosystem.employee.dto.EmployeeResponseDTO;
import com.example.fullstackdemosystem.employee.dto.EmployeeUpdateDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.rmi.NoSuchObjectException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public EmployeeResponseDTO updateEmployee(EmployeeUpdateDTO updateDTO, Long emp_id) throws NoSuchObjectException {
        Optional<Employee> employee = employeeRepository.findById(emp_id);
        if (!employee.isPresent()) throw new NoSuchObjectException("Employee not found");
        employeeMapper.updateEmployee(updateDTO, employee.get());
        employeeRepository.save(employee.get());
        return employeeMapper.EmployeeToEmployeeDto(employee.get());
    }

    //TODO() delete Employee by ID
    public EmployeeResponseDTO deleteEmployee(Long id) {
        return null;
    }

    //TODO() find Employee by ID
    public EmployeeResponseDTO findEmployee(Long emp_id) throws NoSuchObjectException {
        Optional<Employee> employee = employeeRepository.findById(emp_id);
        if (!employee.isPresent()) throw new NoSuchObjectException("Employee not found");
        return employeeMapper.EmployeeToEmployeeDto(employee.get());
    }

    //TODO() find All Employees
    public List<EmployeeResponseDTO> findAllEmployees() {
        return null;
    }


    private Employee setCreateDateAndUpdateDate(Employee employee) {
        employee.setCreatedAt(LocalDateTime.now());
        employee.setUpdatedAt(LocalDateTime.now());
        return employee;
    }


}
