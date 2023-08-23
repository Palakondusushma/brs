package springboot.namabus.entities;

 

import java.math.BigDecimal;
import java.time.LocalDate;

 

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

 

@Entity
@Table(name = "payment_details")
public class Payment {

 

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

 

    @NotNull(message = "Payment Cannot Be Done Without Booking")
    @OneToOne
    @JoinColumn(name = "booking_id")

 

    private Booking booking;
    @NotNull(message = "Amount must not be null")
    @DecimalMin(value = "0.01", message = "Amount must be greater than or equal to 0.01")
    private BigDecimal amount;
    @NotNull(message = "transaction date must not be null")
    private LocalDate transactionDate;

 

    @Enumerated(EnumType.STRING)

 

    private PaymentStatus paymentStatus = PaymentStatus.PENDING;

 

    public int getPaymentId() {
        return paymentId;
    }

 

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

 

    public Booking getBooking() {
        return booking;
    }

 

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

 

    public BigDecimal getAmount() {
        return amount;
    }

 

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

 

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

 

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

 

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

 

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

 

}