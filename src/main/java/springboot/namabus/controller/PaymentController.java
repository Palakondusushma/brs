package springboot.namabus.controller;

import java.util.List;

import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import springboot.namabus.entities.Payment;
import springboot.namabus.service.PaymentService;

@RestController

@CrossOrigin

@RequestMapping("/api")

public class PaymentController {

	@Autowired

	PaymentService paymentService;

	private static org.slf4j.Logger logger = LoggerFactory.getLogger(PaymentController.class);

	@PostMapping("/Payment/{PaymentId}")

	public String makePayment(@Valid @RequestParam int bookingId) {

		String result = paymentService.makePayment(bookingId);

		return result;

	}

	@PostMapping("/Payment")

	public Payment addPayment(@Valid @RequestBody Payment payment) {

		Payment msg = paymentService.addpayment(payment);

		return msg;

	}

	@GetMapping("/Payment/{PaymentId}")

	public ResponseEntity<Payment> viewPayment(@PathVariable int paymentId) {

		logger.debug("Debug message");

		logger.info("Info message");

		logger.warn("Warning message");

		return ResponseEntity.ok(paymentService.viewPayment(paymentId));

	}

	@GetMapping("/Payment")

	public ResponseEntity<List<Payment>> getAllPayments() {

		List<Payment> payments = paymentService.getAllPayments();

		logger.debug("Debug message");

		logger.info("Info message");

		logger.warn("Warning message");

		logger.error("Error message");

		if (payments.isEmpty()) {

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		} else {

			return new ResponseEntity<>(payments, HttpStatus.OK);

		}

	}

}
