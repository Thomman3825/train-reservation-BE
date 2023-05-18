package com.springboot.trainReservation.Dao;

import com.springboot.trainReservation.Schemas.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByUserName(String user_name);
}
