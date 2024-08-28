package com.ets.config;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ets.superadmin.SuperAdmin;
import com.ets.user.User;
import com.ets.user.UserRepository;
import com.ets.user.UserRole;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SuperAdminRegistrationEvent {

	private UserRepository userRepository;
	
	@Value("${super_admin.email}" )
	private String superAdminEmail;

	public SuperAdminRegistrationEvent(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@EventListener(classes = ApplicationReadyEvent.class)
	public void registerSuperAdmin() {
		log.info("Checking if super admin is present ");
		List<User> users = userRepository.findByRole(UserRole.SUPER_ADMIN);
		if(users.isEmpty()) {
			log.info("users not present,creating one");
				SuperAdmin admin = new SuperAdmin();
				admin.setUsername("admin");
				admin.setEmail(superAdminEmail);
				admin.setRole(UserRole.SUPER_ADMIN);
				admin.setPassword(UUID.randomUUID().toString());
				userRepository.save(admin);
		}
		else {
			log.info("super admin present already : "+superAdminEmail);
		}
		
	}
}
