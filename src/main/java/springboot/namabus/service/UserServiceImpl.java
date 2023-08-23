package springboot.namabus.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.namabus.dao.AdminRepository;
import springboot.namabus.dao.CustomerRepository;
import springboot.namabus.dao.UserRepository;
import springboot.namabus.entities.AdminEntity;
import springboot.namabus.entities.CustomerEntity;
import springboot.namabus.entities.UserEntity;
import springboot.namabus.entities.UserRoles;
import springboot.namabus.exception.UserNotFoundException;
import springboot.namabus.exception.UsernameExistsException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void registerUser(UserEntity user, Set<UserRoles> roles) throws UsernameExistsException {
		boolean usernameExists = userRepository.existsByUsername(user.getUsername());

		if (usernameExists) {
			throw new UsernameExistsException("Username already exists");
		}

		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(user.getUsername());
		userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
		userEntity.setRoles(user.getRoles());

		if (roles.contains(UserRoles.ADMIN)) {
			AdminEntity adminEntity = new AdminEntity();
			adminEntity.setUser(userEntity);
			userEntity.setAdmin(adminEntity);
			adminRepository.save(adminEntity);

		} else if (roles.contains(UserRoles.CUSTOMER)) {

			CustomerEntity customerEntity = new CustomerEntity();
			customerEntity.setUser(userEntity);
			userEntity.setCustomer(customerEntity);
			customerRepository.save(customerEntity);

		}
		userRepository.save(userEntity);

	}

	@Override
	public UserEntity loginUser(String username, String password) throws UserNotFoundException {
		UserEntity userEntity = userRepository.findByUsername(username);

		if (userEntity == null || !userEntity.getPassword().equals(password)) {
			throw new UserNotFoundException("Invalid username or password");
		}

		return userEntity;
	}

}