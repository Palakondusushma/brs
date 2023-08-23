package springboot.namabus.exception;

public class BusNotFoundException extends RuntimeException {
	private String message1;

	private static final long serialVersionUID = 1L;

	public BusNotFoundException(String message1) {

		super();

		this.message1 = message1;
	}

	public BusNotFoundException() {

	}

}
