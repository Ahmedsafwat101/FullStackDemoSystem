package com.example.fullstackdemosystem.employee;

import com.example.fullstackdemosystem.employee.command.AddEmployeeCommand;
import com.example.fullstackdemosystem.employee.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private  EmployeeRepository employeeRepository;
    private  EmployeeMapper employeeMapper;

    //TODO() add Employee
    public EmployeeDTO addEmployee(AddEmployeeCommand employeeCommand){
        Employee employee = employeeMapper.EmployeeCommandToEmployee(employeeCommand);
        System.out.println("emp:"+employee.toString());
        employee = setCreateDateAndUpdateDate(employee);
        employee.setCode("1");
        employeeRepository.save(employee);
        return employeeMapper.EmployeeToEmployeeDto(employee);
    }
    //TODO() update Employee by ID
    public EmployeeDTO updateEmployee(AddEmployeeCommand employeeCommand){
        return new EmployeeDTO();
    }
    //TODO() delete Employee by ID
    public EmployeeDTO deleteEmployee(Long id){
        return  null;
    }
    //TODO() find Employee by ID
    public EmployeeDTO findEmployee(Long id){
        return  null;
    }
    //TODO() find All Employees
    public List<EmployeeDTO> findAllEmployees(){
        return  null;
    }


    private Employee setCreateDateAndUpdateDate(Employee employee){
        employee.setCreatedAt(LocalDateTime.now());
        employee.setUpdatedAt(LocalDateTime.now());
        return employee;
    }



}
