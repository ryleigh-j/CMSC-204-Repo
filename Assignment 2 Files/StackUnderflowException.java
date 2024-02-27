package assignment_2;

public class StackUnderflowException extends RuntimeException {
	public StackUnderflowException () {
		this("Stack is empty");
		
	}
	
	public StackUnderflowException (String msg) {
		super(msg);
	}

}
