package springboot.namabus.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import springboot.namabus.entities.Feedback;

@Repository

public interface FeedbackDAO extends JpaRepository<Feedback, Integer> {

}
