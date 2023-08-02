package com.ChaoChao.SaoSao_Server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Table(name = "itemInfo")
@Entity
public class ItemInfo {

    @Id // pk 컬럼 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Integer itemInfoId;

    @Column(nullable = false) // not null
    private String detailInfo;//상세정보

    @OneToMany
    @JoinColumn(name = "itemInfoId")
    private List<ItemDetailImage> itemDetailImages;

}
