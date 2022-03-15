package com.example.fullstackdemosystem.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity<ID extends Serializable> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    @JsonIgnore
    protected ID id;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Column(name = "created_at", nullable = false)
    @JsonIgnore
    protected LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Column(name = "updated_at", nullable = false)
    @JsonIgnore
    protected LocalDateTime updatedAt;

}
