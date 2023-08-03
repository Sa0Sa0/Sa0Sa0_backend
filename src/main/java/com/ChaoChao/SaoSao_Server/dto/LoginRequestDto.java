package com.ChaoChao.SaoSao_Server.dto;

import lombok.Data;

@Data
public class LoginRequestDto {

    private String userName;

    private String userPassword;
}