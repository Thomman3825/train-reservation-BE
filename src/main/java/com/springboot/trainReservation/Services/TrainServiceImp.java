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
    JwtUtil jwtUtil;

    @Override
    public String addTrain(List<Train> trains) {
        trainDao.saveAll(trains);
        return "Train Added";
    }


}
