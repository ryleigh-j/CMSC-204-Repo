package assignment_2;

/**
 * This class contains the test case methods that students must implement
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotationTest_STUDENT {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testEvaluatePostfixExpression() {
		try {
			assertEquals(12.5,Notation.evaluatePostfixExpression("52/5*"));
			assertEquals(5.5,Notation.evaluatePostfixExpression("25+2/3-5+"));
			Notation.evaluatePostfixExpression("2/5");
		}catch(InvalidNotationFormatException e){
			System.out.println("Correct exception thrown testing evaluate-"+e.getMessage());
		}
		

	}

	@Test
	void testConvertPostfixToInfix() {
		try {
			assertEquals("((5/2)*5)",Notation.convertPostfixToInfix("52/5*"));
			assertEquals("((((2+5)/2)-3)+5)",Notation.convertPostfixToInfix("25+2/3-5+"));
			Notation.convertPostfixToInfix("2/5");
		}catch(InvalidNotationFormatException e){
			System.out.println("Correct exception thrown testing postfix to infix-"+e.getMessage());
		}
		
	}

	@Test
	void testConvertInfixToPostfix() {
		try {
			assertEquals("2 5 + 2 / 3 - 5 + ",Notation.convertInfixToPostfix("(2+5)/2-3+5"));
			assertEquals("4 5 / 2 6 2 - + * ",Notation.convertInfixToPostfix("4/5*(2+(6-2))"));
		}catch(InvalidNotationFormatException e){
			System.out.println("Correct exception thrown-"+e.getMessage());
		}
		
		
	}

}
