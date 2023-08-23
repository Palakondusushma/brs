package springboot.namabus.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "bookings")
public class Booking {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)

	private int bookingId;

	@NotNull(message = " Enter BoardingPoint")

	@NotBlank

	private String boardingPoint;

	@NotNull(message = " Enter droppingPoint")

	@NotBlank

	private String droppingPoint;

	@JsonFormat(pattern = "yyyy-MM-dd")

	private LocalDate journeyDate;

	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)

	private LocalTime startTime;

	@Min(1)

	@Max(35)

	private int seatNum;

	private int amount;

	@GeneratedValue(strategy = GenerationType.AUTO)

	private long ticketNum;

	@Column

	@Enumerated(EnumType.STRING)

	private BookingStatus status;

	private PaymentStatus PaymentStatus;

	public PaymentStatus getPaymentStatus() {
		return PaymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		PaymentStatus = paymentStatus;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getBoardingPoint() {
		return boardingPoint;
	}

	public void setBoardingPoint(String boardingPoint) {
		this.boardingPoint = boardingPoint;
	}

	public String getDroppingPoint() {
		return droppingPoint;
	}

	public void setDroppingPoint(String droppingPoint) {
		this.droppingPoint = droppingPoint;
	}

	public LocalDate getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public long getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(long ticketNum) {
		this.ticketNum = ticketNum;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", boardingPoint=" + boardingPoint + ", droppingPoint="
				+ droppingPoint + ", journeyDate=" + journeyDate + ", startTime=" + startTime + ", seatNum=" + seatNum
				+ ", amount=" + amount + ", ticketNum=" + ticketNum + ", status=" + status + ", getBookingId()="
				+ getBookingId() + ", getBoardingPoint()=" + getBoardingPoint() + ", getDroppingPoint()="
				+ getDroppingPoint() + ", getJourneyDate()=" + getJourneyDate() + ", getStartTime()=" + getStartTime()
				+ ", getSeatNum()=" + getSeatNum() + ", getAmount()=" + getAmount() + ", getTicketNum()="
				+ getTicketNum() + ", getStatus()=" + getStatus() + "]";
	}

	public Booking(int bookingId, @NotNull(message = " Enter BoardingPoint") @NotBlank String boardingPoint,
			@NotNull(message = " Enter droppingPoint") @NotBlank String droppingPoint, LocalDate journeyDate,
			LocalTime startTime, @Min(1) @Max(35) int seatNum, int amount, long ticketNum, BookingStatus status) {
		super();
		this.bookingId = bookingId;
		this.boardingPoint = boardingPoint;
		this.droppingPoint = droppingPoint;
		this.journeyDate = journeyDate;
		this.startTime = startTime;
		this.seatNum = seatNum;
		this.amount = amount;
		this.ticketNum = ticketNum;
		this.status = status;
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

}