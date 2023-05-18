package com.springboot.trainReservation.Services;

import com.springboot.trainReservation.Dao.UserDao;
import com.springboot.trainReservation.Schemas.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String user_name) throws UsernameNotFoundException {
        User user = userDao.findByUserName(user_name);
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(), Collections.EMPTY_LIST);
    }
}
