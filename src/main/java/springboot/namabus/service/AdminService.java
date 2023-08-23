package springboot.namabus.service;

import java.util.List;

import springboot.busnama.dto.UserDTO;

public interface AdminService {

	List<UserDTO> viewAllUsers();

}
