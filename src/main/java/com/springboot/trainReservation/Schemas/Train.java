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
public class Train {
    @Id
    int train_number;
    String train_name;
    String source,destination;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "train")
    private Booking booking;


}
