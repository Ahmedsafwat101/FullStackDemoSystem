package com.example.fullstackdemosystem.employee;

import com.example.fullstackdemosystem.employee.command.AddEmployeeCommand;
import com.example.fullstackdemosystem.employee.dto.EmployeeResponseDTO;
import com.example.fullstackdemosystem.employee.dto.EmployeeUpdateDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.rmi.NoSuchObjectException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

   private EmployeeService employeeService;

    @GetMapping("/{emp_id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployee(@PathVariable Long emp_id) throws  NoSuchObjectException {
        EmployeeResponseDTO employeeResponseDTO =  employeeService.findEmployee(emp_id);
        return  ResponseEntity.ok().body(employeeResponseDTO);

    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeResponseDTO>> getEmployee() {
        List<EmployeeResponseDTO> employeesResponseDTO =  employeeService.findAllEmployees();
        return  ResponseEntity.ok().body(employeesResponseDTO);
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeResponseDTO> addEmployee(@Valid @RequestBody  AddEmployeeCommand employeeCommand){
        EmployeeResponseDTO employeeResponseDTO =  employeeService.addEmployee(employeeCommand);
        return  ResponseEntity.ok().body(employeeResponseDTO);

    }

    @PutMapping("/update/{emp_id}")
    public ResponseEntity<EmployeeResponseDTO> updateEmployee(@Valid @RequestBody EmployeeUpdateDTO updateDTO, @PathVariable Long emp_id) throws  NoSuchObjectException {
        EmployeeResponseDTO employeeResponseDTO =  employeeService.updateEmployee(updateDTO,emp_id);
        return  ResponseEntity.ok().body(employeeResponseDTO);

    }

    @DeleteMapping("delete/{emp_id}")
    public ResponseEntity<EmployeeResponseDTO> deleteEmployee (@PathVariable Long emp_id) throws  NoSuchObjectException {
        EmployeeResponseDTO employeeResponseDTO =  employeeService.deleteEmployee(emp_id);
        return  ResponseEntity.ok().body(employeeResponseDTO);

    }
}
