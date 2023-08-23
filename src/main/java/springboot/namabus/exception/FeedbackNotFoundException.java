package springboot.namabus.exception;

public class FeedbackNotFoundException extends RuntimeException {

	private String message1;

	public FeedbackNotFoundException(String message1) {

		super();

		this.message1 = message1;
	}

	public FeedbackNotFoundException() {

	}

}