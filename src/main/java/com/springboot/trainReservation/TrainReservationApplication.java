package com.springboot.trainReservation;

import com.springboot.trainReservation.Dao.UserDao;
import com.springboot.trainReservation.Schemas.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class TrainReservationApplication {
	@Autowired
	private UserDao userDao;
	@PostConstruct
	public void initialiseUsers(){
		List<User>users = Stream.of(
				new User(1,"Alan","alan@alan","Admin","Alan", null),
				new User(2,"Sagar","alan@alan","User","Alan", null)).collect(Collectors.toList());
	userDao.saveAll(users);
	}


	public static void main(String[] args) {
		SpringApplication.run(TrainReservationApplication.class, args);
	}

}
