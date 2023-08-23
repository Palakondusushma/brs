package springboot.namabus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.namabus.entities.AdminEntity;

@Repository

public interface AdminRepository extends JpaRepository<AdminEntity, Long> {

}
