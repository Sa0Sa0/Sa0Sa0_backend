package com.ChaoChao.SaoSao_Server.controller;

import com.ChaoChao.SaoSao_Server.dto.PurchaseRequest;
import com.ChaoChao.SaoSao_Server.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/user")
public class PurchaseController {
    private final PurchaseService purchaseService;

    //구매시에 사용
    @PostMapping("/purchase")
    public ResponseEntity purchase(Authentication authentication,
                                   @RequestBody PurchaseRequest request) {

        return purchaseService.purchase(authentication, request);

    }

    @GetMapping("/purchase")
    public ResponseEntity findAll(Authentication authentication){
        return purchaseService.findAll(authentication);
    }

}
