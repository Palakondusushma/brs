package springboot.namabus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import springboot.namabus.entities.Feedback;

@Service

public interface FeedbackService {
	public List<Feedback> getFeedbacks();

	public Feedback addFeedback(Feedback feedback);

	Optional<Feedback> getFeedbackById(int Feedback_Id);

	public String deleteFeedbackById(int feedback_Id);

}