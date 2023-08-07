package com.ChaoChao.SaoSao_Server.dto;

import lombok.Data;

@Data
public class LoginRequest {

    private String userName;

    private String userPassword;
}