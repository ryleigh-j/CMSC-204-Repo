import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PasswordCheckerUtilityTest_STUDENT {
	ArrayList<String> passwords;
	String p1,p2;

	@BeforeEach
	void setUp() throws Exception {
		passwords= new ArrayList<String>();
		p1="bbBN3!4";
		p2="qeee!";
	}

	@AfterEach
	void tearDown() throws Exception {
		passwords=null;
		p1=p2=null;
	}

	@Test
	void testComparePasswords​() {
		try {
			PasswordCheckerUtility.comparePasswords​(p2, p1);
		}catch(UnmatchedException e) {
			assertEquals("Passwords do not match",e.getMessage());

		}
	}

	@Test
	void testComparePasswordsWithReturn​() {
		assertFalse(PasswordCheckerUtility.comparePasswordsWithReturn​(p2, p1));
		p1=p2;
		assertTrue(PasswordCheckerUtility.comparePasswordsWithReturn​(p2, p1));
	
	}

	@Test
	void testIsValidLength​() {
		try {
			assertTrue(PasswordCheckerUtility.isValidLength​(p1));
			assertFalse(PasswordCheckerUtility.isValidLength​(p2));

		}catch(LengthException e) {
			assertTrue("Threw correct exception",true);
			System.out.println(e.getMessage());
		}catch(Exception e) {
			assertTrue("Threw other exception",false);

		}
	}

	@Test
	void testHasUpperAlpha​() {
		try {
			
			assertTrue(PasswordCheckerUtility.hasUpperAlpha​(p1));
			PasswordCheckerUtility.hasUpperAlpha​(p2);

		}catch(NoUpperAlphaException e) {
			assertTrue("Threw correct exception",true);
			System.out.println(e.getMessage());
		}catch(Exception e) {
			assertTrue("Threw other exception",false);

		}
		

	}

	@Test
	void testHasLowerAlpha​() {
		
		try {
			
			assertTrue(PasswordCheckerUtility.hasLowerAlpha​("GOOGAA"));
			PasswordCheckerUtility.hasLowerAlpha​(p2);

		}catch(NoLowerAlphaException e) {
			assertTrue("Threw correct exception",true);
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			assertTrue("Threw other exception",false);

		}

	}

	@Test
	void testHasDigit​() {
		try {
			
			assertTrue(PasswordCheckerUtility.hasDigit​(p1));
			PasswordCheckerUtility.hasDigit​(p2);

		}catch(NoDigitException e) {
			assertTrue("Threw correct exception",true);
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			assertTrue("Threw other exception",false);

		}
	}

	@Test
	void testHasSpecialChar​() {
		try {
			
			assertTrue(PasswordCheckerUtility.hasSpecialChar​(p1));
			
			PasswordCheckerUtility.hasSpecialChar​("helloW0rLd");
			PasswordCheckerUtility.hasSpecialChar​(p2);


		}catch(NoSpecialCharacterException e) {
			assertTrue("Threw correct exception",true);
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			assertTrue("Threw other exception",false);

		}
	}

	@Test
	void testNoSameCharInSequence​() {
		try {
			
			assertTrue(PasswordCheckerUtility.NoSameCharInSequence​(p1));
			
			PasswordCheckerUtility.NoSameCharInSequence​(p2);



		}catch(InvalidSequenceException e) {
			assertTrue("Threw correct exception",true);
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			assertTrue("Threw other exception",false);

		}
	}

	@Test
	void testIsValidPassword​() {
		try {
			PasswordCheckerUtility.NoSameCharInSequence​(p1);
			
			PasswordCheckerUtility.NoSameCharInSequence​(p2);


			
		}catch(Exception e) {
			System.out.println("This password is not valid.");
		}

		}
	

	@Test
	void testHasBetweenSixAndNineChars​() {
		assertTrue(PasswordCheckerUtility.hasBetweenSixAndNineChars​(p1));
		assertFalse(PasswordCheckerUtility.hasBetweenSixAndNineChars​(p2));


	}

	@Test
	void testIsWeakPassword​() {
		p2="Qwer4ty2*!";
		try {
			assertFalse(PasswordCheckerUtility.isWeakPassword​(p2));
			PasswordCheckerUtility.isWeakPassword​(p1);
		}catch(WeakPasswordException e) {
			assertTrue("Threw correct exception",true);

			System.out.println(e.getMessage());
		}catch(Exception e) {
			assertTrue("Threw other exception",false);

		}
		

	}

}
