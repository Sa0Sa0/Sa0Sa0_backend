package com.ChaoChao.SaoSao_Server.service;

import com.ChaoChao.SaoSao_Server.dto.ItemRequest;
import com.ChaoChao.SaoSao_Server.entity.Item;
import com.ChaoChao.SaoSao_Server.entity.User;
import com.ChaoChao.SaoSao_Server.repository.ItemRepository;
import com.ChaoChao.SaoSao_Server.repository.UserRepository;
import com.ChaoChao.SaoSao_Server.security.config.auth.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;


    @Transactional
    public ResponseEntity save(ItemRequest dto, Authentication authentication) {

        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();

        Optional<User> foundUser = userRepository.findById(principal.getUser().getUserId());

        if (itemRepository.findByItemName(dto.getItemName()).isPresent()
        || !foundUser.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else{
            Item item = new Item().create(dto);
            item.builder().user(foundUser.get()).build();
            Item saved = itemRepository.save(item);
            return ResponseEntity.ok().body("저장성공");
        }
    }
    public ResponseEntity findOne(String itemName) {
        if (itemRepository.findByItemName(itemName).isPresent()){
            Item found=itemRepository.findByItemName(itemName).get();
            return ResponseEntity.ok().body(found);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    public ResponseEntity findAll() {
        List<Item> found = itemRepository.findAll();
        if(found.size()==0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else {
            return ResponseEntity.ok().body(found);
        }
    }


    @Transactional
    public ResponseEntity deleteOne(String itemName) {
        if (itemRepository.findByItemName(itemName).isPresent()){
            itemRepository.deleteByItemName(itemName);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
