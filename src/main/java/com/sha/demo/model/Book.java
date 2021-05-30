package com.sha.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author sa
 * @date 16.05.2021
 * @time 17:17
 */
@Data
@Entity
@Table(name="book")
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title", nullable = false, length = 100)
    private String title;

    @Column(name="description", nullable = false, length = 1000)
    private String description;

    @Column(name="author", nullable = false, length = 100)
    private String author;

    @Column(name="price", nullable = false)
    private Double price;

    @Column(name="create_time", nullable = false)
    private LocalDateTime createTime;
}
