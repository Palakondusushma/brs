package springboot.namabus.entities;

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
import lombok.Data;

@Entity

@Table(name = "Bus")
@Data
public class Bus {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;

	@Column(name = "price")

	private int price;
	@Min(value = 18, message = "must be equal or greater than 18")
	@Max(value = 45, message = "must be equal or less than 45")
	@Column(name = "seats")

	private int seats;

//    @Column(name = "amenities")
//
//     String amenities;
	@Column(name = "BusType")
	@Enumerated(EnumType.STRING)
	@NotBlank(message = "Bus Type mandatory")
	private BusType BusTypes;
	@Column(name = "StartPoint")
	private String startpoint;
	@Column(name = "EndPoint")
	private String endpoint;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public BusType getBusTypes() {
		return BusTypes;
	}

	public void setBusTypes(BusType busTypes) {
		BusTypes = busTypes;
	}

	public String getStartpoint() {
		return startpoint;
	}

	public void setStartpoint(String startpoint) {
		this.startpoint = startpoint;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public Bus(int id, int price, int seats, BusType busTypes, String startpoint, String endpoint) {
		super();
		this.id = id;
		this.price = price;
		this.seats = seats;
		BusTypes = busTypes;
		this.startpoint = startpoint;
		this.endpoint = endpoint;
	}

	@Override
	public String toString() {
		return "Bus [id=" + id + ", price=" + price + ", seats=" + seats + ", BusTypes=" + BusTypes + ", startpoint="
				+ startpoint + ", endpoint=" + endpoint + ", getId()=" + getId() + ", getPrice()=" + getPrice()
				+ ", getSeats()=" + getSeats() + ", getBusTypes()=" + getBusTypes() + ", getStartpoint()="
				+ getStartpoint() + ", getEndpoint()=" + getEndpoint() + "]";
	}

	public Bus() {
		super();

	}

}