package q.stock.product.exception;

public class NoEnoughQuantityException extends Exception {
	private String message;

	public NoEnoughQuantityException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
