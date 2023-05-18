package com.springboot.trainReservation.Services;

import com.springboot.trainReservation.Schemas.Train;

import java.util.List;

public interface TrainService {
    String addTrain(List<Train> trains);
}
