package springboot.namabus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import springboot.namabus.dao.PaymentRepo;
import springboot.namabus.entities.Payment;

@SpringBootTest
@SpringJUnitConfig
public class PaymentTest {
	@MockBean
	private PaymentRepo dao;

	@BeforeEach
	public void setUp() {

		List<Payment> mockPayments = Stream.of(new Payment()).collect(Collectors.toList());
		when(dao.findAll()).thenReturn(mockPayments);
	}

	@Test
	public void testGetAllPayments() {
		List<Payment> payments = new ArrayList<>();
		payments.add(new Payment(/* Initialize payment */));

		when(dao.findAll()).thenReturn(payments);

		List<Payment> result = dao.findAll();

		assertEquals(payments, result);
	}

}
