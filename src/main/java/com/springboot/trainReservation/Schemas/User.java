package com.springboot.trainReservation.Schemas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    int user_id;
    String user_name;
    String email;
    Boolean isAdmin;
    String password;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "user")
    private Booking booking;


}
