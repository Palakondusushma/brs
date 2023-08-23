package springboot.namabus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.busnama.dto.UserDTO;
import springboot.namabus.service.AdminService;

@RestController

@RequestMapping("/api/admin")

@CrossOrigin(origins = "*")

public class AdminController {

	@Autowired

	private AdminService adminService;

	@GetMapping("/view-users")

	public ResponseEntity<List<UserDTO>> viewUsers() {

		List<UserDTO> users = adminService.viewAllUsers();

		return new ResponseEntity<>(users, HttpStatus.OK);

	}

}
