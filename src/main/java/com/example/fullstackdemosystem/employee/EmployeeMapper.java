package com.example.fullstackdemosystem.employee;

import com.example.fullstackdemosystem.employee.command.AddEmployeeCommand;
import com.example.fullstackdemosystem.employee.dto.EmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "phone", target = "phoneNumber")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "imageURL", target = "imageURL")
    Employee EmployeeCommandToEmployee(AddEmployeeCommand employeeCommand);

    @Mapping(source = "id",target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "phoneNumber", target = "phone")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "code", target = "code")
    @Mapping(source = "imageURL", target = "imageURL")
    EmployeeDTO EmployeeToEmployeeDto(Employee employee);
}
