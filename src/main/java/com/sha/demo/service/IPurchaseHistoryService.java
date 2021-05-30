package com.sha.demo.service;

import com.sha.demo.model.PurchaseHistory;
import com.sha.demo.repository.projection.IPurchaseItem;

import java.util.List;

/**
 * @author sa
 * @date 16.05.2021
 * @time 18:17
 */
public interface IPurchaseHistoryService
{
    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);

    List<IPurchaseItem> findPurchasedItemsOfUser(Long userId);
}
