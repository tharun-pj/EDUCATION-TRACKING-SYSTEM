package com.ets.superadmin;

import com.ets.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "super_admin")
public class SuperAdmin extends User{

	
}
