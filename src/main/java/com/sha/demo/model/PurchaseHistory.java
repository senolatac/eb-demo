package com.sha.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author sa
 * @date 16.05.2021
 * @time 17:22
 */
@Data
@Entity
@Table(name="purchase_history")
public class PurchaseHistory
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_id", nullable = false)
    private Long userId;

    @Column(name="book_id", nullable = false)
    private Long bookId;

    @Column(name="price", nullable = false)
    private Double price;

    @Column(name="purchase_time", nullable = false)
    private LocalDateTime purchaseTime;
}
