package com.ignacionizetich.eventvantage.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36, nullable = false, updatable = false)
    private String id;

    @Column(nullable = false)
    private String name;


    @Column(name = "last_name", nullable = false)
    private String lastName;


    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, updatable = false, nullable = false)
    private String dni;


    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String password; // password hasheada con BCrypt


    private boolean enabled = false;


    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();



}
