package springboot.namabus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import springboot.namabus.entities.Payment;

@Service("paymentService")
public interface PaymentService {

	public Payment viewPayment(int paymentId);

	public String makePayment(int bookingId);

	public Payment addpayment(Payment payment);

	public List<Payment> getAllPayments();

}