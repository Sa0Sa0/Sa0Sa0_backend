package com.ChaoChao.SaoSao_Server.entity;

import com.ChaoChao.SaoSao_Server.dto.SignUpRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class User extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    private String userLocation;

    @Column(nullable = false)
    private Integer userPoint;

    @OneToMany(mappedBy = "user")
    private List<PurchaseLog> purchaseLogs;

    @Column(nullable = false)
    private String roles; // USER, ADMIN


    public User createUser(SignUpRequest request){
        User user = User.builder()
                .userName(request.getUserName())
                .userEmail(request.getUserEmail())
                .userPassword(request.getUserPassword())
                .userLocation(request.getUserLocation())
                .roles("ROLE_ADMIN")
                .userPoint(0)
                .build();
        return user;

    }


    @Builder
    public User(Integer userId, String userName, String userEmail, String userPassword, String userLocation, Integer userPoint, List<PurchaseLog> purchaseLogs, String roles) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userLocation = userLocation;
        this.userPoint = userPoint;
        this.purchaseLogs = purchaseLogs;
        this.roles = roles;
    }






    public List<String> getRoleList(){
        if (this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }


}
