package com.jairo.renta_car.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collections;
import java.util.Map;


@RestController
public class UserController {
    @GetMapping("/user")
    public Map<String,Object> user(@AuthenticationPrincipal OAuth2User userInfo){ //un mapa (estructura clave valor) de Java , nos autenticamos y nos va a retornar un objeto Auth2User y lo vamos a llamar user Info
       System.out.println(userInfo);
       System.out.println(userInfo.getAttributes());
        return Collections.singletonMap("name",userInfo.getAttribute("name")); // Arma un mapa con la clave name y el valor es del objeto userinfo traemos el atributo login
    }
}
