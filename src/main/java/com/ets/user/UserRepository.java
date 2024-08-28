package com.ets.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

	public List<User> findByRole(UserRole role);
}
