package com.springboot.trainReservation.Dao;

import com.springboot.trainReservation.Schemas.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrianDao extends JpaRepository<Train,Integer> {
}
