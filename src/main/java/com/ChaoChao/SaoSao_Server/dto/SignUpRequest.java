package com.ChaoChao.SaoSao_Server.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class SignUpRequest {

    private String userName;

    private String userEmail;

    private String userPassword;

    private String userLocation;

}
