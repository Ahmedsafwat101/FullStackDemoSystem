package com.example.fullstackdemosystem.employee.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class AddEmployeeCommand {

    @NotEmpty(message = "Employee name can't be empty")
    @JsonProperty("name")
    String name;
    @NotEmpty(message = "Employee email can't be empty")
    @Email(message = "Email format isn't correct")
    String email;
    @NotEmpty(message = "Employee phone can't be empty")
    String phone;
    @NotEmpty(message = "Employee title can't be empty")
    String title;
    String imageURL;

}
