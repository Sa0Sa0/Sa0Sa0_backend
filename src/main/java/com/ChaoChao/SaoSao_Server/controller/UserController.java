package com.ChaoChao.SaoSao_Server.controller;

import com.ChaoChao.SaoSao_Server.dto.SignUpRequest;
import com.ChaoChao.SaoSao_Server.entity.User;
import com.ChaoChao.SaoSao_Server.repository.UserRepository;
import com.ChaoChao.SaoSao_Server.security.config.auth.PrincipalDetails;
import com.ChaoChao.SaoSao_Server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserService userService;

    @PostMapping("/signup")
    public void signUp (@RequestBody SignUpRequest request){
        userService.createUser(request);
    }

//    @PostMapping("/join")
//    public String join(@RequestBody Users user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setRoles("ROLE_USER");
//        userRepository.save(user);
//        return "회원가입완료";
//    }

    // 모든 사람이 접근 가능
    @GetMapping("/api/home")
    public String home() {
        return "<h1>home</h1>";
    }

//    @GetMapping("/api/user")
//    public String user(Authentication authentication) {
//        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
//        System.out.println("principal : " + principal.getUser().getId());
//        System.out.println("principal : " + principal.getUser().getUsername());
//        System.out.println("principal : " + principal.getUser().getPassword());
//
//        return "<h1>user</h1>";
//    }

    // 매니저 혹은 어드민이 접근 가능
    @GetMapping("/api/manager/reports")
    public String reports() {
        return "<h1>reports</h1>";
    }

    // 어드민이 접근 가능
    @GetMapping("/api/admin/users")
    public List<User> users() {
        return userRepository.findAll();
    }



}
