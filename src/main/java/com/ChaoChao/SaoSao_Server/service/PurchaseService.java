package com.ChaoChao.SaoSao_Server.service;

import com.ChaoChao.SaoSao_Server.dto.PurchaseRequest;
import com.ChaoChao.SaoSao_Server.entity.Item;
import com.ChaoChao.SaoSao_Server.entity.User;
import com.ChaoChao.SaoSao_Server.entity.PurchaseLog;
import com.ChaoChao.SaoSao_Server.repository.ItemRepository;
import com.ChaoChao.SaoSao_Server.repository.PurchaseLogRepository;
import com.ChaoChao.SaoSao_Server.repository.UserRepository;
import com.ChaoChao.SaoSao_Server.security.config.auth.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PurchaseService {
    private final PurchaseLogRepository purchaseLogRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public ResponseEntity purchase(Authentication authentication, PurchaseRequest request){

        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();

        Optional<Item> itemFound = itemRepository.findById(request.getItemId());
        Optional<User> userFound = userRepository.findById(principal.getUser().getUserId());

        if(itemFound.isPresent() && userFound.isPresent()) {
            PurchaseLog purchaseLog = PurchaseLog.builder()
                    .item(itemFound.get())
                    .user(userFound.get())
                    .purchaseAmount(request.getPurchaseAmount())
                    .build();

            purchaseLogRepository.save(purchaseLog);
            return ResponseEntity.ok().body(purchaseLog);

        }else{

            return ResponseEntity.badRequest().body("User or product not found.");

        }

    
    }

    public ResponseEntity<?> findAll(Authentication authentication){
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();

        Optional<User> userFound = userRepository.findById(principal.getUser().getUserId());

        if(userFound.isPresent()){
            return ResponseEntity.ok().body(userFound.get().getPurchaseLogs());
            //나중에 DTO 로 변환하는 작업 해주기
        }
        else{
            return ResponseEntity.badRequest().body("User Not Found");
        }
    }


}
