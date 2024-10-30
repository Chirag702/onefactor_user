package com.onefactor.user.controller;

import com.onefactor.user.client.AuthClient;
import com.onefactor.user.entity.User;
import com.onefactor.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;
	private final AuthClient authClient;

	@Autowired
	public UserController(UserService userService, AuthClient authClient) {
		this.userService = userService;
		this.authClient = authClient;
	}

	private boolean isUserAuthorized(String authHeader) {
		String validationResponse = authClient.validateUser(authHeader);
		return validationResponse != null;
	}

	@PostMapping("/c")
	public ResponseEntity<?> createUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization,
			@RequestBody User user) {

		if (!isUserAuthorized(authorization)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
		}

		return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization,
			@PathVariable Long id) {

		if (!isUserAuthorized(authorization)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
		}

		User user = userService.getUserById(id);
		return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
	}

	@GetMapping("/a")
	public ResponseEntity<?> getAllUsers(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization) {

		if (!isUserAuthorized(authorization)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
		}

		return ResponseEntity.ok(userService.getAllUsers());
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization,
			@PathVariable Long id, @RequestBody User user) {

		if (!isUserAuthorized(authorization)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
		}

		User updatedUser = userService.updateUser(id, user);
		return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization,
			@PathVariable Long id) {

		if (!isUserAuthorized(authorization)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
		}

		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}
