package com.springboot.trainReservation.Controllers;

import com.springboot.trainReservation.Schemas.AuthReq;
import com.springboot.trainReservation.Schemas.Train;
import com.springboot.trainReservation.Schemas.User;
import com.springboot.trainReservation.Services.TrainService;
import com.springboot.trainReservation.Util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class TrainController {
    @Autowired
    private TrainService trainService;
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    AuthReq authReq;
    @Autowired
    User user;
    String token = jwtUtil.generateToken(user.getUser_name());
    @Autowired


    public boolean isAdmin(String token){
        Claims claims = jwtUtil.extractAllClaims(token);
        String role = (String) claims.get("role");
        if(role=="Admin") return true;
        else return false;
    }
    @PostMapping("/addTrain")
    public String addTrain(List<Train> trains){

        if(isAdmin(token)) {
            trainService.addTrain(trains);
            return "Train Added";
        }
        else
            return("Not admin");
    }

}
