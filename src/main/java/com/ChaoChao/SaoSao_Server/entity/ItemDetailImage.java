package com.ChaoChao.SaoSao_Server.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "itemDetailImage")
@NoArgsConstructor
public class ItemDetailImage {
    @Id // pk 컬럼 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Integer itemInfoId;

    @Column(nullable = true)
    private String itemDetailImage;


}
