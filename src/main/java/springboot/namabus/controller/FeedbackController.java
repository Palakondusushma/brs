package springboot.namabus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.namabus.entities.Feedback;
import springboot.namabus.service.FeedbackService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class FeedbackController {
	@Autowired
	private FeedbackService feedbackService;

	@GetMapping("/feedbacks/{id}")
	public Optional<Feedback> getFeedbackById(@PathVariable int id) {
		return this.feedbackService.getFeedbackById(id);
	}

	@GetMapping("/feedbacks") //

	public ResponseEntity<Feedback> getFeedbacks() {

		List<Feedback> FeedbackImpl = feedbackService.getFeedbacks();
		return new ResponseEntity(FeedbackImpl, HttpStatus.OK);
	}

	@PostMapping("/feedbacks")

	public ResponseEntity<Feedback> addFeedbacks(@RequestBody Feedback feedbackDAO) {
		Feedback feedbackImpl = feedbackService.addFeedback(feedbackDAO);

		return new ResponseEntity(feedbackImpl, HttpStatus.CREATED);
	}

	@DeleteMapping("/feedbacks/{feedback_Id}")
	public void deletefeedbackById(@PathVariable int feedback_Id) {
		this.feedbackService.deleteFeedbackById(feedback_Id);
	}
}
