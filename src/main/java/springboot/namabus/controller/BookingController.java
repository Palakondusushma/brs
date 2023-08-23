package springboot.namabus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.namabus.entities.Booking;
import springboot.namabus.exception.BookingNotFoundException;
import springboot.namabus.service.BookingServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/busbookings")
public class BookingController {
	private BookingServiceImpl bookingService;

	@Autowired

	public BookingController(BookingServiceImpl bookingService) {

		this.bookingService = bookingService;

	}

	@GetMapping("/bookings")

	public ResponseEntity<Iterable<Booking>> getAllBookings() {

		Iterable<Booking> bookings = bookingService.getAllBookings();

		return ResponseEntity.ok(bookings);

	}

	@GetMapping("/bookings{bookingId}")

	public ResponseEntity<Booking> getBookingById(@PathVariable int bookingId) throws BookingNotFoundException {

		Booking booking = bookingService.getBookingById(bookingId);

		return ResponseEntity.ok(booking);

	}

	@PostMapping("/bookings")

	public ResponseEntity<String> addBooking(@RequestBody Booking booking) {

		bookingService.addBooking(booking);

		return ResponseEntity.status(HttpStatus.CREATED).body("BOOKING SUCCESSFUL.");

	}

	@PutMapping("/bookings{bookingId}")

	public ResponseEntity<String> UpdateBookingStatus(@jakarta.validation.Valid @PathVariable("bookingId") int id,
			@RequestBody Booking booking) throws BookingNotFoundException {

		return new ResponseEntity<String>(bookingService.UpdateBookingStatus(id, booking), HttpStatus.OK);

	}

	@DeleteMapping("/bookings{bookingId}")

	public ResponseEntity<String> deleteBookingById(@PathVariable int bookingId) throws BookingNotFoundException {

		try {

			bookingService.deleteBookingById(bookingId);

			return ResponseEntity.ok("Booking deleted successfully");

		}

		catch (BookingNotFoundException ex) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());

		}

	}
}