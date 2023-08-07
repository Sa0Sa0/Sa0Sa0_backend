package com.ChaoChao.SaoSao_Server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

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
    @JsonManagedReference
    private Item item;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userId")
    private User user;

    @Column(nullable = false) // not null
    private Integer purchaseAmount; //구매 개수

    @Builder
    public PurchaseLog(Long purchaseLogId, Item item, User user, Integer purchaseAmount) {
        this.purchaseLogId = purchaseLogId;
        this.item = item;
        this.user = user;
        this.purchaseAmount = purchaseAmount;
    }

}