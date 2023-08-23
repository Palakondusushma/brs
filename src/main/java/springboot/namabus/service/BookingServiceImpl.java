package springboot.namabus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import springboot.namabus.dao.BookingRepo;
import springboot.namabus.entities.Booking;
import springboot.namabus.exception.BookingNotFoundException;

@Service("bookingService")
public class BookingServiceImpl implements BookingService {
	private BookingRepo bookingRepo;

	@Autowired

	public BookingServiceImpl(BookingRepo bookingRepo) {

		this.bookingRepo = bookingRepo;

	}

	@Override

	public void addBooking(Booking booking) {

		bookingRepo.save(booking);

	}

	@Override

	public String UpdateBookingStatus(int bookingId, Booking booking) throws BookingNotFoundException {

		if (bookingRepo.existsById(bookingId)) {

			bookingRepo.save(booking);

			return "Updated successfully";

		}

		else {

			throw new BookingNotFoundException("Booking with ID" + bookingId + "not found");

		}

	}

	@Override

	public Booking getBookingById(int bookingId) throws BookingNotFoundException {

		Optional<Booking> opb = bookingRepo.findById(bookingId);

		if (opb.isPresent()) {

			return opb.get();

		} else {

			throw new BookingNotFoundException("Booking with Id" + bookingId + "not found");

		}

	}

	@Override

	public Booking deleteBookingById(int bookingId) throws BookingNotFoundException {

		Optional<Booking> opb1 = bookingRepo.findById(bookingId);

		if (opb1.isPresent()) {

			Booking booking = opb1.get();

			bookingRepo.delete(booking);

			return booking;

		}

		else {

			throw new BookingNotFoundException("Booking with Id" + bookingId + "not found");

		}

	}

	@Override

	public Iterable<Booking> getAllBookings() {

		return bookingRepo.findAll();

	}

}