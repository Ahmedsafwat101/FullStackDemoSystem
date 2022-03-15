package com.example.fullstackdemosystem.employee;

import com.example.fullstackdemosystem.employee.dto.EmployeeResponseDTO;
import com.example.fullstackdemosystem.employee.dto.EmployeeUpdateDTO;
import com.example.fullstackdemosystem.employee.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    //TODO() add Employee
    public void addEmployee(Employee employeeCommand) {
        Employee employee = employeeCommand;
        setCreateDateAndUpdateDate(employee);
        setEmployeeCode(employee);
        employeeRepository.save(employee);
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
       Integer integer=4;
       integer.compareTo(1);
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

    private  void setCreateDateAndUpdateDate(Employee employee) {
        employee.setCreatedAt(LocalDateTime.now());
        employee.setUpdatedAt(LocalDateTime.now());
    }

    private void setEmployeeCode(Employee employee) {
        employee.setCode(UUID.randomUUID().toString());
    }

    public EmployeeResponseDTO getEmployee(Long emp_id) throws EmployeeNotFoundException  {
        Employee employee = employeeRepository.getById(emp_id);

        System.out.println("yes");
        if(employeeMapper.EmployeeToEmployeeDto(employee)!=null)
            System.out.println("not null");
        return employeeMapper.EmployeeToEmployeeDto(employee);
    }
}
