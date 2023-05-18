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





    @PostMapping("/addTrain")
    public String addTrain(List<Train> trains){

        if(trainService.isAdmin(jwtUtil.generateToken(user.getUser_name()))) {
            trainService.addTrain(trains);
            return "Train Added";
        }
        else
            return("Not admin");
    }

}
