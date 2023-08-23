package springboot.namabus.controller;

import java.util.HashSet;

import java.util.Set;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.BadCredentialsException;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import springboot.namabus.dao.UserRepository;
import springboot.namabus.entities.AdminEntity;
import springboot.namabus.entities.CustomerEntity;
import springboot.namabus.entities.JwtRequest;
import springboot.namabus.entities.JwtResponse;
import springboot.namabus.entities.UserEntity;
import springboot.namabus.entities.UserRoles;
import springboot.namabus.exception.UsernameExistsException;
import springboot.namabus.security.JwtHelper;
import springboot.namabus.service.UserService;

@RestController

@RequestMapping("/auth")

@CrossOrigin(origins = "*")

public class AuthContoller {

	@Autowired

	private UserDetailsService userDetailsService;

	@Autowired

	private AuthenticationManager manager;

	@Autowired

	private JwtHelper helper;

	@Autowired

	private UserRepository userRepository;

	@Autowired

	private UserService userService;

	@PostMapping("/login")

	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {

		this.doAuthenticate(request.getUsername(), request.getPassword());

		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());

		UserEntity userEntity = getUserEntityByUsername(request.getUsername());

		Set<SimpleGrantedAuthority> authorities = userEntity.getRoles().stream()

				.map(UserRoles::authorityEnum)

				.collect(Collectors.toSet());

		String token = this.helper.generateToken(userDetails, authorities);

		JwtResponse response = JwtResponse.builder()

				.jwtToken(token)

				.username(userDetails.getUsername())

				.roles(userEntity.getRoles())

				.build();

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@PostMapping("/register-admin")

	public ResponseEntity<String> registerAdmin(@RequestBody UserEntity user) {

		try {

			Set<UserRoles> roles = new HashSet<>();

			roles.add(UserRoles.ADMIN);

			// Create UserEntity

			UserEntity userEntity = new UserEntity();

			userEntity.setUsername(user.getUsername());

			userEntity.setPassword(user.getPassword());

			userEntity.setRoles(roles);

			// Create AdminEntity and associate with UserEntity

			AdminEntity adminEntity = new AdminEntity();

			adminEntity.setUser(userEntity);

			userEntity.setAdmin(adminEntity);

			// Save both entities

			userService.registerUser(userEntity, roles);

			return new ResponseEntity<>("Admin registered successfully", HttpStatus.CREATED);

		} catch (UsernameExistsException e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}

	}

	@PostMapping("/register-customer")

	public ResponseEntity<String> registerCustomer(@RequestBody UserEntity user) {

		try {

			Set<UserRoles> roles = new HashSet<>();

			roles.add(UserRoles.CUSTOMER);

			// Create UserEntity

			UserEntity userEntity = new UserEntity();

			userEntity.setUsername(user.getUsername());

			userEntity.setPassword(user.getPassword());

			userEntity.setRoles(roles);

			// Create CustomerEntity and associate with UserEntity

			CustomerEntity customerEntity = new CustomerEntity();

			customerEntity.setUser(userEntity);

			userEntity.setCustomer(customerEntity);

			// Save both entities

			userService.registerUser(userEntity, roles);

			return new ResponseEntity<>("Customer registered successfully", HttpStatus.CREATED);

		} catch (UsernameExistsException e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}

	}

	private UserEntity getUserEntityByUsername(String username) {

		return userRepository.findByUsername(username); // Adjust this based on your repository method

	}

	private void doAuthenticate(String username, String password) {

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username,
				password);

		try {

			manager.authenticate(authentication);

		} catch (BadCredentialsException e) {

			throw new BadCredentialsException(" Invalid Username or Password  !!");

		}

	}

	@ExceptionHandler(BadCredentialsException.class)

	public String exceptionHandler() {

		return "Credentials Invalid !!";

	}

}