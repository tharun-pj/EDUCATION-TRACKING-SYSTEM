package com.ets.hr;

import com.ets.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "hrs")
public class HR extends User{

}
