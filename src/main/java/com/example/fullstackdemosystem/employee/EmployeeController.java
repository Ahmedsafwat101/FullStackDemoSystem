package com.example.fullstackdemosystem.employee;

import com.example.fullstackdemosystem.employee.command.AddEmployeeCommand;
import com.example.fullstackdemosystem.employee.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

   private EmployeeService employeeService;


    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@Valid @RequestBody  AddEmployeeCommand employeeCommand){
        EmployeeDTO employeeDTO =  employeeService.addEmployee(employeeCommand);
        return  ResponseEntity.ok().body(employeeDTO);

    }
}
