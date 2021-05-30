package com.sha.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author sa
 * @date 14.05.2021
 * @time 18:43
 */
@Data
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username", unique = true, nullable = false, length = 100)
    private String username;

    @Column(name="password", nullable = false, length = 100)
    private String password;

    @Column(name="name", nullable = false, length = 100)
    private String name;

    @Column(name="create_time", nullable = false)
    private LocalDateTime createTime;

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;

    @Transient
    private String token;
}
