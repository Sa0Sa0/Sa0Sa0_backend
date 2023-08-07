package com.ChaoChao.SaoSao_Server.controller;

import com.ChaoChao.SaoSao_Server.dto.ItemRequest;
import com.ChaoChao.SaoSao_Server.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/admin")
public class ItemAdminController {

    private final ItemService itemService;

    @PostMapping("/items")
    public ResponseEntity save(@RequestBody ItemRequest dto,
                               Authentication authentication){

        return itemService.save(dto,authentication);

    }


    @DeleteMapping("/items/{itemName}")
    public ResponseEntity deleteOne(@PathVariable("itemName")String itemName){
        return itemService.deleteOne(itemName);
    }

}





