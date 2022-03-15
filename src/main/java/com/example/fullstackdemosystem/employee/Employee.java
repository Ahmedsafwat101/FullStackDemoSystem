package com.example.fullstackdemosystem.employee;

import com.example.fullstackdemosystem.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
@AttributeOverride(name = "id", column = @Column(name = "emp_id"))
public class Employee extends BaseEntity<Long> {

    @NotEmpty(message = "Employee name can't be empty")
    @JsonProperty("name")
    @Column(name = "emp_name",nullable = false)
    String name;

    @NotEmpty(message = "Employee email can't be empty")
    @Email(message = "Email format isn't correct")
    @Column(name = "emp_email",nullable = false)
    String email;

    @Column(name = "emp_title",nullable = false)
    @NotEmpty(message = "Employee title can't be empty")
    String title;

    @JsonIgnore
    @Column(name = "emp_code",nullable = false,updatable = false)
    String code;

    @NotEmpty(message = "Employee phone can't be empty")
    @Column(name = "emp_phone_number",nullable = false)
    String phoneNumber;

    @Column(name = "emp_image_url")
    String imageURL;

    public Employee(String name, String email, String title, String phoneNumber, String imageURL) {
        this.name = name;
        this.email = email;
        this.title = title;
        this.phoneNumber = phoneNumber;
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
