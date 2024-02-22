package com.api.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.api.model.SourceCountry;
import com.api.service.FileService;
import com.api.utils.ExecuteShell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.model.User;
import com.api.repository.UserRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	FileService fileService;

	// Get the list of users
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// Add a user
	@PutMapping("/addUser")
	public List<User> createUser(@RequestBody User user) {
		userRepository.save(user);
		return userRepository.findAll();
	}

	// Get the user based on the id
	@GetMapping("/getUser/{id}")
	public String getUserByID(@PathVariable long id) {
		return userRepository.findById(id).toString();
	}

	// Delete the user based on the id
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<HttpStatus> deleteUserById(@PathVariable long id) {
		Optional<User> userData = userRepository.findById(id);
		if (userData.isPresent()) {
			userRepository.deleteById(userData.get().getId());
			return new ResponseEntity<>(HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	// Update the user base on the id
	@PutMapping("/upadateUser/{id}")
	public ResponseEntity<User> updateUserById(@RequestBody User user, @PathVariable long id) {
		Optional<User> userData = userRepository.findById(id);
		if (userData.isPresent()) {
			User userToUpdate = userData.get();
			userToUpdate.setEmail(user.getEmail());
			userToUpdate.setFirstName(user.getFirstName());
			userToUpdate.setLastName(user.getLastName());
			return new ResponseEntity<>(userRepository.save(userToUpdate), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	//Execute shell script
	@PostMapping("/executeshell")
	public ResponseEntity executeShell(@RequestBody SourceCountry sourceCountry) {
		System.out.println(sourceCountry.getSourceCountry());
		System.out.println(sourceCountry.getSmName());
		System.out.println(sourceCountry.getSquadName());
		Boolean status=false;
        try {
			fileService.executeShell();
			status=true;
        } catch (IOException e) {
			throw new RuntimeException(e);
		}finally {
			if(status){
				return new ResponseEntity<>(HttpStatus.OK);
			}else{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		}

	}
}
