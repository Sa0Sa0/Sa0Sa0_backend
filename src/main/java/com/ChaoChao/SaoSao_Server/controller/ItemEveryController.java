package com.ChaoChao.SaoSao_Server.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.ChaoChao.SaoSao_Server.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/every")
public class ItemEveryController {

    private final ItemService itemService;

    @GetMapping("/items/{itemName}")
    public ResponseEntity findOne(@PathVariable("itemName")String itemName){
        return itemService.findOne(itemName);
    }

    @GetMapping("/items")
    public ResponseEntity findAll(){
        return itemService.findAll();
    }

}
