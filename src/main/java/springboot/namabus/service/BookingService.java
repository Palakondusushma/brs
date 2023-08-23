package springboot.namabus.service;

import org.springframework.stereotype.Service;

import springboot.namabus.entities.Booking;
import springboot.namabus.exception.BookingNotFoundException;

@Service

public interface BookingService {

	void addBooking(Booking booking);

	String UpdateBookingStatus(int bookingId, Booking booking) throws BookingNotFoundException;

	Booking getBookingById(int bookingId) throws BookingNotFoundException;

	Booking deleteBookingById(int bookingId) throws BookingNotFoundException;

	Iterable<Booking> getAllBookings();

}
