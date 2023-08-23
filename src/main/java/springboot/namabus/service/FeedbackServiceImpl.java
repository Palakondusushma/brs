package springboot.namabus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.namabus.dao.FeedbackDAO;
import springboot.namabus.entities.Feedback;
import springboot.namabus.exception.FeedbackNotFoundException;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	private FeedbackDAO feedbackDAO;

	@Override
	public List<Feedback> getFeedbacks() {

		return feedbackDAO.findAll();
	}

	@Override
	public Feedback addFeedback(Feedback feedback) {
		feedbackDAO.save(feedback);
		return feedback;
	}

	@Override
	public Optional<Feedback> getFeedbackById(int Feedback_Id) {

		return feedbackDAO.findById(Feedback_Id);

	}

	@Override
	public String deleteFeedbackById(int feedback_Id) throws FeedbackNotFoundException {
		Optional<Feedback> feedback = feedbackDAO.findById(feedback_Id);
		String message = null;
		if (feedback.isPresent()) {
			feedbackDAO.deleteById(feedback_Id);
			message = new String("feedback deleted succssfully");
		} else {
			throw new FeedbackNotFoundException("no such Feedback");
		}
		return message;
	}

}