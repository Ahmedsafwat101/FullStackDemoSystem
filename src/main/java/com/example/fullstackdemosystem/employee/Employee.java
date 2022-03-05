package com.example.fullstackdemosystem.employee;

import com.example.fullstackdemosystem.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
@AttributeOverride(name = "id", column = @Column(name = "emp_id"))
public class Employee extends BaseEntity<Long> {
    @Column(name = "emp_name",nullable = false)
    String name;
    @Column(name = "emp_email",nullable = false)
    String email;
    @Column(name = "emp_title",nullable = false)
    String title;
    @Column(name = "emp_code",nullable = false,updatable = false)
    String code;
    @Column(name = "emp_phone_number",nullable = false)
    String phoneNumber;
    @Column(name = "emp_image_url")
    String imageURL;


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
