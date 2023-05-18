package com.springboot.trainReservation.Schemas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthReq {
String user_name;
String password;
}
