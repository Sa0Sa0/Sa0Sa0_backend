package com.ChaoChao.SaoSao_Server.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "PurchaseLog")
@NoArgsConstructor
public class PurchaseLog extends BaseEntity {

    @Id // pk 컬럼 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long purchaseLogId;

    @ManyToOne
    @JoinColumn(name = "itemId")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(nullable = false) // not null
    private Integer itemAmount;//구매수량

    @Column(nullable = false) // not null
    private Integer purchaseAmount;//상품이름

}