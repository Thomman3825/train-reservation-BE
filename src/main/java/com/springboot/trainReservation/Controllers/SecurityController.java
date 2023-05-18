package com.springboot.trainReservation.Controllers;

import com.springboot.trainReservation.Schemas.AuthReq;
import com.springboot.trainReservation.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class SecurityController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to Train Resevation";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthReq authRequest) throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUser_name(),authRequest.getPassword()));
        }
        catch (Exception e) {
            throw  new Exception("Invalid username/password");
        }

        return jwtUtil.generateToken(authRequest.getUser_name());

    }
}
