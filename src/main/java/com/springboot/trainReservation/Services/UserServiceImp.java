package com.springboot.trainReservation.Services;

import com.springboot.trainReservation.Schemas.User;
import com.springboot.trainReservation.Util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class UserServiceImp implements UserService{
    @Autowired
    private JwtUtil jwtUtil;

    private User user;
    @Override
    public boolean isAdmin(String token) {
        Claims claims = jwtUtil.extractAllClaims(token);
        String role = (String) claims.get("role");
        if(role=="Admin") return true;
        else return false;
    }


}
