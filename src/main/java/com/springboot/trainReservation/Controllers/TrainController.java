package com.springboot.trainReservation.Controllers;

import com.springboot.trainReservation.Schemas.Train;
import com.springboot.trainReservation.Services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainController {
    @Autowired
    private TrainService trainService;

    @PostMapping("addTrain")
    public String addTrain(List<Train> trains){
        trainService.addTrain(trains);
        return "Train Added";
    }

}
