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
public class Booking {
    @Id
    @GeneratedValue
    int booking_id;
    String source,destination;
    String cls;

    int seat;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id",nullable = false)
    private User user;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="train_number",nullable = false)
    private Train train;
}
