package com.EmployeeManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="First_name" ,nullable = false)
    private String name;
    @Column(name="Last_name",nullable = false)
    private String lastname;
    @Column(name = "Email_id" ,nullable = false,unique = true)
    private String email;
    @Column(name = "password",nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

}
