package com.ets.trainer;

import java.util.List;

import com.ets.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "trainers")
@Getter
@Setter
public class Trainer extends User{
	
	private List<Subject> subjects;

}
