package com.ChaoChao.SaoSao_Server.entity;

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
    private Long itemId;

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
    private List<PurchaseLog> purchaseLogs;

    @OneToOne
    @JoinColumn(name = "itemInfoId")
    private ItemInfo itemInfo;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;


}
