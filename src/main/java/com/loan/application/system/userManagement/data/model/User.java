package com.loan.application.system.userManagement.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @JsonIgnore
    private String password;

    private String username;

    private String profileImage;

    @Column(unique = true, nullable = false)
    private String email;

    private Boolean isEnabled;

    private LocalDateTime lastLogin = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();

    private final LocalDateTime dateJoined = LocalDateTime.now();
}
