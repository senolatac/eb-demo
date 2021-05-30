package com.sha.demo.repository;

import com.sha.demo.model.PurchaseHistory;
import com.sha.demo.repository.projection.IPurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author sa
 * @date 16.05.2021
 * @time 17:39
 */
public interface IPurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long>
{
    @Query("select b.title as title, ph.price as price, ph.purchaseTime as purchaseTime " +
            "from PurchaseHistory ph left join Book b on b.id = ph.bookId " +
            "where ph.userId = :userId")
    List<IPurchaseItem> findAllPurchasesOfUser(@Param("userId") Long userId);
}
