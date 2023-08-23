package springboot.namabus.entities;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity

@Table(name = "feedback")

public class Feedback {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;

	@ManyToOne(optional = false)

	@JoinColumn(name = "user_id", nullable = false)

	private User user;

	@Column(name = "booking_id")

	private int bookingId;

	@Column(name = "comment")

	private String comment;

	@Column(name = "rating")

	private int rating;

	public int getId() {

		return id;

	}

	public void setId(int id) {

		this.id = id;

	}

	public User getUser() {

		return user;

	}

	public void setUser(User user) {

		this.user = user;

	}

	public int getBookingId() {

		return bookingId;

	}

	public void setBookingId(int bookingId) {

		this.bookingId = bookingId;

	}

	public String getComment() {

		return comment;

	}

	public void setComment(String comment) {

		this.comment = comment;

	}

	public int getRating() {

		return rating;

	}

	public void setRating(int rating) {

		this.rating = rating;

	}

	@Override

	public String toString() {

		return "Feedback [id=" + id + ", user=" + user + ", bookingId=" + bookingId + ", comment=" + comment

				+ ", rating=" + rating + ", getId()=" + getId() + ", getUser()=" + getUser() + ", getBookingId()="

				+ getBookingId() + ", getComment()=" + getComment() + ", getRating()=" + getRating() + "]";

	}

	public Feedback(int id, User user, int bookingId, String comment, int rating) {

		super();

		this.id = id;

		this.user = user;

		this.bookingId = bookingId;

		this.comment = comment;

		this.rating = rating;

	}

	public Feedback() {

		super();

	}

}