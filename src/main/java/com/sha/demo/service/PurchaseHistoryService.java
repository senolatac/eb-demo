package com.sha.demo.service;

import com.sha.demo.model.PurchaseHistory;
import com.sha.demo.repository.IPurchaseHistoryRepository;
import com.sha.demo.repository.projection.IPurchaseItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author sa
 * @date 16.05.2021
 * @time 18:17
 */
@Service
public class PurchaseHistoryService implements IPurchaseHistoryService
{
    @Autowired
    private IPurchaseHistoryRepository purchaseHistoryRepository;

    @Override
    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory)
    {
        purchaseHistory.setPurchaseTime(LocalDateTime.now());
        return purchaseHistoryRepository.save(purchaseHistory);
    }

    @Override
    public List<IPurchaseItem> findPurchasedItemsOfUser(Long userId)
    {
        return purchaseHistoryRepository.findAllPurchasesOfUser(userId);
    }
}
