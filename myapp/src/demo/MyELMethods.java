package demo;

public class MyELMethods {

	public static String concat(String s1,String s2 ){
		return s1+s2;
	}
	
	public static String perform (String n1,String n2,String operator) {
		String result=null;
		double num1=Double.parseDouble(n1);
		double num2=Double.parseDouble(n2);
	
	 if(operator.equals("+"))
		 result=String.valueOf(num1+num2);
	 else if(operator.equals("-"))
		 result=String.valueOf(num1-num2);
	 else if(operator.equals("*"))
		 result=String.valueOf(num1*num2);
	 else if(operator.equals("/"))
		 result=String.valueOf(num1/num2);
		
		return result;
		
		
		
	}
	
}
