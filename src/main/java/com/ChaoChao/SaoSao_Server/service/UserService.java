package com.ChaoChao.SaoSao_Server.service;

import com.ChaoChao.SaoSao_Server.dto.SignUpRequest;


import com.ChaoChao.SaoSao_Server.entity.User;
import com.ChaoChao.SaoSao_Server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;



    private final UserRepository userRepository;


    public void createUser(SignUpRequest request){
        request.setUserPassword(bCryptPasswordEncoder.encode(request.getUserPassword()));
        User createdUser =  new User().createUser(request);
        userRepository.save(createdUser);
    }


}
