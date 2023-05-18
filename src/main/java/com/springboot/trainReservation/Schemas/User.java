package com.springboot.trainReservation.Schemas;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class User {
    @Id
    @GeneratedValue
    int user_id;
    String userName;
    String email;
    String role;
    String password;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "user")
    private Booking booking;


}
