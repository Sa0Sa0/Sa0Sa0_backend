package com.ChaoChao.SaoSao_Server.entity;

import com.ChaoChao.SaoSao_Server.dto.ItemRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "item")
@NoArgsConstructor
public class Item extends BaseEntity {
    @Id // pk 컬럼 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Integer itemId;

    @Column(nullable = false) // not null
    private String itemName;// 상품이름

    @Column(nullable = false) // not null
    private String itemMainImage;//상품 대표이미지

    @Column(nullable = false) // not null
    private String originalPrice;//상품 원래가격

    @Column(nullable = false) // not null
    private String salePrice;//상품 할인가격

    @Column(nullable = false) // not null
    private Integer stockNum;//상품 개수

    @Column(nullable = false) // not null
    private String totalSaleNum;//총 구매수량

    @Column(nullable = false) // not null
    private String startTime;//판매 시작시간

    @Column(nullable = false) // not null
    private String endTime;//판매 종료시간

    @Column(nullable = false) // not null
    private Integer requiredPeopleNum;//최소판매 인원

    @OneToMany(mappedBy = "item") // 일대다(One-to-Many) 관계 설정
    private List<Review> reviews;

    @OneToMany(mappedBy = "item")
    @JsonBackReference
    private List<PurchaseLog> purchaseLogs;

    @OneToOne(fetch = FetchType.LAZY)//판매자 정보
    @JoinColumn(name="userId")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemInfoId")
    private ItemInfo itemInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private Category category;


    public Item create(ItemRequest dto) {
        Item item = Item.builder()
                .itemName(dto.getItemName())
                .itemMainImage(dto.getItemMainImage())
                .originalPrice(dto.getOriginalPrice())
                .salePrice(dto.getSalePrice())
                .stockNum(dto.getStockNum())
                .totalSaleNum("0")
                .startTime(dto.getStartTime())
                .endTime(dto.getEndTime())
                .requiredPeopleNum(dto.getRequiredPeopleNum())
                .build();
        return item;
    }

    @Builder
    public Item(Integer itemId, String itemName, String itemMainImage, String originalPrice, String salePrice, Integer stockNum, String totalSaleNum, String startTime, String endTime, Integer requiredPeopleNum, List<Review> reviews, List<PurchaseLog> purchaseLogs, User user, ItemInfo itemInfo, Category category) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemMainImage = itemMainImage;
        this.originalPrice = originalPrice;
        this.salePrice = salePrice;
        this.stockNum = stockNum;
        this.totalSaleNum = totalSaleNum;
        this.startTime = startTime;
        this.endTime = endTime;
        this.requiredPeopleNum = requiredPeopleNum;
        this.reviews = reviews;
        this.purchaseLogs = purchaseLogs;
        this.user = user;
        this.itemInfo = itemInfo;
        this.category = category;
    }
}
