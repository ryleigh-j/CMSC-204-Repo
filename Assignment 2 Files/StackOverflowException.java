package assignment_2;

public class StackOverflowException extends RuntimeException {
	
	public StackOverflowException(){
		this("Stack is full");
	}
	
	public StackOverflowException(String msg) {
		super(msg);
	}

}
