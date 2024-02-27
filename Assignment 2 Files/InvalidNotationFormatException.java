package assignment_2;

public class InvalidNotationFormatException extends RuntimeException{
	
	public InvalidNotationFormatException() {
		this("Notation format is incorrect");
		
	}
	
	public InvalidNotationFormatException(String msg) {
		super(msg);
	}
}
