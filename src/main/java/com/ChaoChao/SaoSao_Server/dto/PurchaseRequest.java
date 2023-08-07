package com.ChaoChao.SaoSao_Server.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseRequest {
    private Integer itemId; //아이템 ID
    private Integer purchaseAmount;  // 아이템 수량

}
