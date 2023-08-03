package com.ChaoChao.SaoSao_Server.service;

import com.ChaoChao.SaoSao_Server.dto.SignUpRequest;


import com.ChaoChao.SaoSao_Server.entity.User;
import com.ChaoChao.SaoSao_Server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;



    private final UserRepository userRepository;


    public ResponseEntity createUser(SignUpRequest request) {
        if (userRepository.findByUserName(request.getUserName()).isPresent()) {
            return ResponseEntity.badRequest().body("already existed username");
        } else {
            request.setUserPassword(bCryptPasswordEncoder.encode(request.getUserPassword()));
            User createdUser = new User().createUser(request);
            userRepository.save(createdUser);
            return ResponseEntity.ok().build();
        }
    }


}
