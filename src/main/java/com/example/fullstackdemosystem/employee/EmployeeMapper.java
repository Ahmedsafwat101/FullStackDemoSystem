package com.example.fullstackdemosystem.employee;

import com.example.fullstackdemosystem.employee.dto.EmployeeResponseDTO;
import com.example.fullstackdemosystem.employee.dto.EmployeeUpdateDTO;
import org.mapstruct.*;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "phoneNumber", target = "phone")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "code", target = "code")
    @Mapping(source = "imageURL", target = "imageURL")
    EmployeeResponseDTO EmployeeToEmployeeDto(Employee employee);


    @Mapping(source = "name", target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "title", target = "title",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "phone", target = "phoneNumber", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "email", target = "email", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "imageURL", target = "imageURL",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEmployee(EmployeeUpdateDTO updateDTO, @MappingTarget Employee employee);
}
