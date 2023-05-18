package com.springboot.trainReservation.Services;

import com.springboot.trainReservation.Dao.TrianDao;
import com.springboot.trainReservation.Schemas.Train;
import com.springboot.trainReservation.Schemas.User;
import com.springboot.trainReservation.Util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TrainServiceImp implements TrainService{
    @Autowired
    private TrianDao trainDao;
    @Autowired
    User user;
    @Autowired
    JwtUtil jwtUtil;

    @Override
    public String addTrain(List<Train> trains) {
        trainDao.saveAll(trains);
        return "Train Added";
    }

    @Override
    public boolean isAdmin(String token) {
        Claims claims = jwtUtil.extractAllClaims(token);
        String role = (String) claims.get("role");
        if(role=="Admin") return true;
        else return false;
    }
}
