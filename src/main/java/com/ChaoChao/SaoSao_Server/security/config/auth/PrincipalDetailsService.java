package com.ChaoChao.SaoSao_Server.security.config.auth;

import com.ChaoChao.SaoSao_Server.entity.User;
import com.ChaoChao.SaoSao_Server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByUserName(username).orElse(null);
        System.out.println("1111");
        return new PrincipalDetails(userEntity);
    }
}