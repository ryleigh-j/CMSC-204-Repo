import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
public class PasswordCheckerUtility {
	
	public PasswordCheckerUtility() {
		
	}
	
	public static void comparePasswords​(String password,String passwordConfirm) throws UnmatchedException{
		if(password.equals(passwordConfirm)== false) {
			throw new UnmatchedException();
		}
	}
     
	public static boolean comparePasswordsWithReturn​(String password,String passwordConfirm) {
		return password.equals(passwordConfirm);
	}
	
	public static boolean isValidLength​(String password) throws LengthException{
		if(password.length()>=6) {
			return true;
		}else {
			throw new LengthException();
		}
	}
	
	public static boolean hasUpperAlpha​(String password)throws NoUpperAlphaException{
		int count=0;
		for(int i=0;i<password.length();i++) {
			if(password.charAt(i)>=65 && password.charAt(i)<=90) {
				count++;
			}
		}
		if(count >0) {
			return true;
		}else {
			throw new NoUpperAlphaException ();
		}
	}
	public static boolean hasLowerAlpha​(String password)
            throws NoLowerAlphaException{
		int count=0;
		for(int i=0;i<password.length();i++) {
			if(password.charAt(i)>=97 && password.charAt(i)<=122) {
				count++;
			}
		}
		if(count >0) {
			return true;
		}else {
			throw new NoLowerAlphaException  ();
		}
	}
	public static boolean hasDigit​(String password)
            throws NoDigitException{
		int count=0;
		for(int i=0;i<password.length();i++) {
			if(password.charAt(i)>=48 && password.charAt(i)<=57) {
				count++;
			}
		}
		if(count >0) {
			return true;
		}else {
			throw new NoDigitException   ();
		}
	}
	
	public static boolean hasSpecialChar​(String password)
            throws NoSpecialCharacterException{
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		if(!matcher.matches()) {
			return true;
		}else {
			throw new NoSpecialCharacterException ();
		}


		
	}
	
	public static boolean NoSameCharInSequence​(String password)
            throws InvalidSequenceException{
		String seq="";
		for(int i=0;i<password.length();i++) {
			seq=String.valueOf(password.charAt(i))
					+String.valueOf(password.charAt(i))
					+String.valueOf(password.charAt(i)) ;
			if(password.contains(seq)) {
				throw new InvalidSequenceException ();
			
			}
		}
		
		return true;
		
		
		
		
	}
	
	public static boolean isValidPassword​(java.lang.String password)
            throws LengthException,
                   NoUpperAlphaException,
                   NoLowerAlphaException,
                   NoDigitException,
                   NoSpecialCharacterException,
                   InvalidSequenceException{
		if(!isValidLength​(password)) {
			return false;
		}else if(!hasUpperAlpha​(password)) {
			return false;
		}else if(!hasLowerAlpha​(password)) {
			return false;
		}else if(!hasDigit​(password)) {
			return false;
		}else if(!hasSpecialChar​(password)) {
			return false;
		}else if(!NoSameCharInSequence​(password)) {
			return false;
		}
		
		return true;
	}
	
	public static boolean hasBetweenSixAndNineChars​(java.lang.String password) {
		if(password.length()>=6 && password.length()<=9) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean isWeakPassword​(java.lang.String password)
            throws WeakPasswordException, LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
		
		if(isValidPassword​(password)&& hasBetweenSixAndNineChars​(password)== false ) {
			return false;
		}else if(hasBetweenSixAndNineChars​(password) ){
			throw new WeakPasswordException();
		}
		return false;
		
	}
	public static ArrayList<String> getInvalidPasswords​(ArrayList<String> passwords){
		ArrayList<String>bad= new ArrayList<String>();
		String s;
		for(String p : passwords) {
			 s=p;
			try{
				isValidPassword​(p);
			}catch(LengthException e) {
				p+=e.getMessage();
				bad.add(s);
			}catch(NoUpperAlphaException e) {
				p+=e.getMessage();
				bad.add(s);

			} catch (NoLowerAlphaException e) {
				// TODO Auto-generated catch block
				p+=e.getMessage();
				bad.add(s);

			} catch (NoDigitException e) {
				// TODO Auto-generated catch block
				p+=e.getMessage();
				bad.add(s);

			} catch (NoSpecialCharacterException e) {
				// TODO Auto-generated catch block
				p+=e.getMessage();
				bad.add(s);

			} catch (InvalidSequenceException e) {
				// TODO Auto-generated catch block
				p+=e.getMessage();
				bad.add(s);

			}
		}
		return bad;
	}


	
	
}

