package springboot.namabus.service;

import java.util.Set;

import springboot.namabus.entities.UserEntity;
import springboot.namabus.entities.UserRoles;
import springboot.namabus.exception.UserNotFoundException;
import springboot.namabus.exception.UsernameExistsException;

public interface UserService {

	void registerUser(UserEntity user, Set<UserRoles> roles) throws UsernameExistsException;

	UserEntity loginUser(String username, String password) throws UserNotFoundException;

}