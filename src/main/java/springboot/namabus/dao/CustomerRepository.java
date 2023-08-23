package springboot.namabus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.namabus.entities.CustomerEntity;

@Repository

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}