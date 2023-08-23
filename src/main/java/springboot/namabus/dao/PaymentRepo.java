package springboot.namabus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.namabus.entities.Payment;

@Repository("dao")
public interface PaymentRepo extends JpaRepository<Payment, Integer> {

}