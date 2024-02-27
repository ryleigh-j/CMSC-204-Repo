package assignment_2;

/**
 * This class contains the test case methods that students must implement
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyQueueTest_STUDENT {
	private MyQueue<String> queue;
	private ArrayList<String> greetings;

	@BeforeEach
	void setUp() throws Exception {
		queue=new MyQueue<String>(5);
		greetings=new ArrayList<String>();

		greetings.add("Hello");
		greetings.add("Hi");
		greetings.add("Hey");
		greetings.add("Good morning");
	}

	@AfterEach
	void tearDown() throws Exception {
		queue=null;
		greetings=null;
	}

	@Test
	void testIsEmpty() {
		assertTrue(queue.isEmpty());
		queue.fill(greetings);
		assertFalse(queue.isEmpty());
	}

	@Test
	void testDequeue() {
		try {
			queue.dequeue();
			queue.fill(greetings);
			assertTrue(queue.dequeue().equals(greetings.get(0)));
			queue.fill(greetings);
			assertTrue(queue.dequeue().equals(greetings.get(1)));
		}catch(QueueUnderflowException e) {
			System.out.println("Correct exception thrown testing dequeue-"+e.getMessage());
		}
	}

	@Test
	void testSize() {
		assertEquals(0,queue.size());
		queue.fill(greetings);
		assertEquals(4,queue.size());
	}

	@Test
	void testEnqueue() {
		try {
			queue.fill(greetings);
			assertTrue(queue.enqueue(greetings.get(1)));
			
			queue.enqueue(greetings.get(0));
			
			
		}catch(QueueOverflowException e) {
			System.out.println("Correct exception thrown testing enqueue-"+e.getMessage());
		}
		

	}

	@Test
	void testIsFull() {
		queue.fill(greetings);
		assertFalse(queue.isFull());
		queue.enqueue(greetings.get(0));
		assertTrue(queue.isFull());

	}

	@Test
	void testToString() {
		queue.fill(greetings);
		String s="Hello Hi Hey Good morning ";
		assertEquals(s,queue.toString());
	}

	@Test
	void testToStringString() {
		queue.fill(greetings);
		String s="Hello,Hi,Hey,Good morning,";
		assertEquals(s,queue.toString(","));
	}

	@Test
	void testFill() {
		try {	
			queue.fill(greetings);
			queue.enqueue(greetings.get(0));
			queue.dequeue();
			queue.enqueue(greetings.get(0));
			queue.enqueue(greetings.get(0));

		}catch(QueueOverflowException e) {
			System.out.println("Correct Exception was thrown testing fill()-" + e.getMessage());

		}
	}

}
