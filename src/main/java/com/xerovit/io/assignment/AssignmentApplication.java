package com.xerovit.io.assignment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.xerovit.io.assignment.entity.User;
import com.xerovit.io.assignment.repository.UserRepository;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRepository userRepository) {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				userRepository.deleteAll();

				final User user = new User().setUserId(1).setUsername("ayeminwai").setPassword("$2a$10$x1wp3I6RWBb8z7RCh8yujeYRn9YQX5qP4ScFelksNhQ3jE7MpQQUi").setEmail("ayeminwai@gmail.com").setTelephone("+959972784660");
				userRepository.save(user);

			};
		};
	}
}
