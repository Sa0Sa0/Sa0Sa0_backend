package com.ChaoChao.SaoSao_Server.dto;

import lombok.Data;

@Data
public class ItemRequest {
    private String itemName;// 상품이름
    private String itemMainImage;//상품 대표이미지
    private String originalPrice;//상품 원래가격
    private String salePrice;//상품 할인가격
    private Integer stockNum;//상품 개수
    private String startTime;//판매 시작시간
    private String endTime;//판매 종료시간
    private Integer requiredPeopleNum;//최소판매 인원
}
