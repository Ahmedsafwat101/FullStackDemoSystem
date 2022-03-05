package com.example.fullstackdemosystem.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    Long id;
    String name;
    String email;
    String phone;
    String imageURL;
    String title;
    String code;
}
