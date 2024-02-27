package assignment_2;

public class QueueOverflowException extends RuntimeException {
	
	public QueueOverflowException () {
		this("Queue is full");
		
	}
	
	public QueueOverflowException (String msg) {
		super(msg);
	}

}
