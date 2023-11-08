package com.example.practicespringsecurity.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@Table(name ="Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
//    @GenericGenerator(name = "native",strategy = "native")
    private long id;
    private String email;
    private String pwd;
    private String role;
}
