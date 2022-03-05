package com.example.fullstackdemosystem.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeUpdateDTO {
    String name;
    String email;
    String phone;
    String imageURL;
    String title;
}
