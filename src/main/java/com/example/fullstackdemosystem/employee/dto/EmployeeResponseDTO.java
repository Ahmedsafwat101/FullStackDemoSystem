package com.example.fullstackdemosystem.employee.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO {
    Long id;
    String name;
    String email;
    String phone;
    String imageURL;
    String title;
    String code;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    LocalDateTime updatedAt;

}
