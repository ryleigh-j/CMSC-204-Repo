package assignment_2;

public class Notation {
	public Notation() {
		
	}
	
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException{
		MyStack<String>stack= new MyStack<String>(100);
		for(int i=0;i<postfixExpr.length();i++) {
			char current=postfixExpr.charAt(i);
			if(Character.isDigit(current)) {
				stack.push(String.valueOf(current));
			}
			if(current=='*'|| current=='/'||current=='+'|| current=='-'){
				if(stack.size()<2) {
					throw new InvalidNotationFormatException ();
				}
				double second=Double.valueOf(stack.pop());
				double first=Double.valueOf(stack.pop());
				double result=0;
				switch(current) {
					case'*': result= first*second;
						break;
					case'/':result= first/second;
						break;
					case'-':result=first-second;
						break;
					case'+':result=first+second;
				
				}
				//System.out.println(first + " "+current+" "+second+ "=" +result);

				stack.push(String.valueOf(result));
				
			}

		}
		
		if(stack.size()>1) {
			throw new InvalidNotationFormatException ();
		}
		return Double.valueOf(stack.top());
	}
	
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException{
		
		MyStack<String> sStack=new MyStack<String>(100);
		for(int i=0;i<postfix.length();i++) {
			char current =postfix.charAt(i);
			//System.out.println("Current: "+current);
			if(Character.isDigit(current)) {
				sStack.push(String.valueOf(current));
			///	System.out.println("Stack: "+sStack.toString());

			}
			if(current=='*'|| current=='/'||current=='+'|| current=='-'){
				if(sStack.size()<2) {
					throw new InvalidNotationFormatException();
				}
				String first=sStack.pop();
				String second=sStack.pop();
				String popped=second+
						String.valueOf(current)+
						first
						;
				
				//System.out.println("Stack: "+sStack.toString());

				sStack.push("("+popped+")");
			//	System.out.println("Stack after push: "+sStack.toString());

				
			}
		}
		if(sStack.size()>1) {
			throw new InvalidNotationFormatException();
		}
		return sStack.top();
		
		
	}
	
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException{
		MyStack<Character> stack=new MyStack<Character>(100);
		MyQueue<Character> queue= new MyQueue<Character>(100);
		for(int i=0;i<infix.length();i++) {
			char current=infix.charAt(i);
			if(Character.isDigit(current)) {
				queue.enqueue(current);
				//System.out.println("Queue: "+queue.toString());
			}
			if(current=='(') {
				stack.push(current);
				//System.out.println("Stack: "+stack.toString());

			}
			if(current=='*'|| current=='/'||current=='+'|| current=='-') {
					char top;
					boolean keepGoing=true;
					while(keepGoing) {
						if(stack.isEmpty()) {
							top='a';
						}else {
							top=stack.top();
						}
						 
						if((current=='*'|| current=='/') && (top=='*'|| top=='/')) {
							queue.enqueue(stack.pop());
							//System.out.println("Queue: "+queue.toString());
							keepGoing=true;
						}else if((current=='+' || current=='-')&& (top=='/'|| top=='*'
								||top=='+'||top=='-')){
							queue.enqueue(stack.pop());
							//System.out.println("Queue: "+queue.toString());
							keepGoing=true;

									
						}else {
							stack.push(current);
							keepGoing=false;
						}
					}
				
					
					//System.out.println("Stack: "+stack.toString());
				
				

			}
			if(current==')') {
				boolean keepGoing=true;
				while(keepGoing) {
				if(stack.isEmpty()) {
					throw new InvalidNotationFormatException();
				}else {
					char top=stack.top();
					if(top=='*'|| top=='/'||top=='+'|| top=='-') {
						
						queue.enqueue(stack.pop());
						//System.out.println("Queue: "+queue.toString());
						//System.out.println("Stack: "+stack.toString());

						keepGoing=true;
					}else if(top=='(') {
						stack.pop();
						keepGoing=false;
					}else {
						throw new InvalidNotationFormatException();

					}
					
				}
					
				}
				
				
				
			}
		}
		//System.out.println("Stack: "+stack.toString());

		while(stack.isEmpty()==false) {
			queue.enqueue(stack.pop());
			
		}
		return queue.toString();
		
	}
		
	
}
