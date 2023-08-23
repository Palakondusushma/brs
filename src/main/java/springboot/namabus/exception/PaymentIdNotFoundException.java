package springboot.namabus.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus

public class PaymentIdNotFoundException extends RuntimeException {

	public PaymentIdNotFoundException(String str) {

		super(str);

	}

}