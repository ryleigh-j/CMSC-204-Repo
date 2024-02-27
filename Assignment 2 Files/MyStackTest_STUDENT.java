package assignment_2;

/**
 * This class contains the test case methods that students must implement
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyStackTest_STUDENT {
	private MyStack<String>stack; 
	private ArrayList<String>greetings;
	@BeforeEach
	void setUp() throws Exception {
		stack=new MyStack<String>(5);
		greetings=new ArrayList<String>();

		greetings.add("Hello");
		greetings.add("Hi");
		greetings.add("Hey");
		greetings.add("Good morning");
		



		
		
	}

	@AfterEach
	void tearDown() throws Exception {
		stack=null;
		greetings=null;
	}

	@Test
	void testIsEmpty() {
		assertTrue(stack.isEmpty());
		stack.fill(greetings);
		assertFalse(stack.isEmpty());
	}

	@Test
	void testIsFull() {
		assertFalse(stack.isFull());
		stack.fill(greetings);
		stack.push("Bye!");
		assertTrue(stack.isFull());

		}

	@Test
	void testPop() {
		try {
			stack.pop();
			stack.fill(greetings);
			assertTrue(greetings.get(3).equals(stack.pop()));
		}catch(StackUnderflowException e) {
			System.out.println("Correct exception thrown testing pop()-"+e.getMessage());
		}
		
	}

	@Test
	void testTop() {
		try {
			stack.top();
			greetings.add("Yooooo");
			stack.fill(greetings);
			assertTrue(greetings.get(4).equals(stack.top()));
			
		}catch(StackUnderflowException e) {
			System.out.println("Correct exception thrown testing top()-"+e.getMessage());
		}
		
	}

	@Test
	void testSize() {
		stack.fill(greetings);

		assertEquals(4,stack.size());
	}

	@Test
	void testPush() {
		try {
			stack.fill(greetings);
			assertTrue(stack.push(greetings.get(0)));
			stack.push(greetings.get(0));
			stack.push(greetings.get(1));

			
		}catch(StackOverflowException e) {
			System.out.println("Correct Exception thrown testing push()-"+e.getMessage());
		}
		
		
		


	}

	@Test
	void testToString() {
		
		stack.fill(greetings);
		String s="Hello Hi Hey Good morning ";
		assertEquals(s,stack.toString());
	}

	@Test
	void testToStringString() {
		stack.fill(greetings);
		String s="Hello,Hi,Hey,Good morning,";
		assertEquals(s,stack.toString(","));
	}

	@Test
	void testFill() {
		try {
			stack.fill(greetings);
			assertEquals(4,stack.size());
			stack.push("Bye!");
			stack.push("Long time no see");

			
		}catch(StackOverflowException e) {
			System.out.println("Correct Exception was thrown testing fill()-" + e.getMessage());
		}
	}

}
