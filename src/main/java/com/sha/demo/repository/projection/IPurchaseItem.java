package com.sha.demo.repository.projection;

import java.time.LocalDateTime;

/**
 * @author sa
 * @date 16.05.2021
 * @time 17:54
 */
public interface IPurchaseItem
{
    String getTitle();
    Double getPrice();
    LocalDateTime getPurchaseTime();
}
