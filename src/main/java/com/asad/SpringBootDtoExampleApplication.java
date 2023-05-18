package com.asad;

import com.asad.model.Location;
import com.asad.model.User;
import com.asad.repository.LocationRepository;
import com.asad.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDtoExampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDtoExampleApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Override
	public void run(String... args) throws Exception {
		Location location = new Location();
		location.setPlace("Dhaka");
		location.setDescription("Dhaka is a great place");
		location.setLongitude(90.4125);
		location.setLatitude(23.8103);
		locationRepository.save(location);

		User user1 = new User();
		user1.setFirstName("Md. ");
		user1.setLastName("Asad");
		user1.setEmail("a@gmail.com");
		user1.setPassword("secret");
		user1.setLocation(location);
		userRepository.save(user1);

		User user2 = new User();
		user2.setFirstName("Md. ");
		user2.setLastName("Akul");
		user2.setEmail("a@gmail.com");
		user2.setPassword("secret");
		user2.setLocation(location);
		userRepository.save(user2);
	}
}
