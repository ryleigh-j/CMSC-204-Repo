package assignment_2;

public class QueueUnderflowException extends RuntimeException {
	
	public QueueUnderflowException () {
		this("Queue is empty");
	}
	
	public QueueUnderflowException (String msg) {
		super(msg);
	}

}
