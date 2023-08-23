package springboot.namabus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.namabus.dao.BookingRepo;
import springboot.namabus.dao.PaymentRepo;
import springboot.namabus.entities.Booking;
import springboot.namabus.entities.Payment;
import springboot.namabus.entities.PaymentStatus;
import springboot.namabus.exception.BookingNotFoundException;
import springboot.namabus.exception.PaymentIdNotFoundException;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepo dao;
	@Autowired
	BookingRepo dto;

	@Override
	public Payment addpayment(Payment payment) {
		Payment p = dao.save(payment);
		return p;
	}

	@Override
	public String makePayment(int bookingId) {
		Booking booking = dto.findById(bookingId).orElse(null);

		if (booking != null) {

			boolean paymentSuccessful = processPayment(booking.getAmount());

			if (paymentSuccessful) {

				booking.setPaymentStatus(PaymentStatus.SUCCESS);
				dto.save(booking);

				return "Payment done successfully";
			} else {
				return "Payment failed";
			}
		} else {
			throw new BookingNotFoundException("Booking Id not found");
		}
	}

	private boolean processPayment(int Amount) {

		return true;
	}

	@Override
	public Payment viewPayment(int paymentId) {
		Optional<Payment> op = dao.findById(paymentId);
		if (op.isPresent()) {
			return op.get();
		} else
			
			throw new PaymentIdNotFoundException("Payment Id not found");

	}

	@Override
	public List<Payment> getAllPayments() {
		return dao.findAll();
	}

}