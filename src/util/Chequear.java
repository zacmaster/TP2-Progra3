package util;

import java.util.regex.*;


public class Chequear {
	
	public static boolean queSeaDouble(String s){
		String expresion = "(\\d{1,8}\\.\\d{1,8})|(\\d{1,8}\\,\\d{1,8})|(-\\d{1,8}\\.\\d{1,8})|(-\\d{1,8}\\.\\d{1,8})";
		Pattern pattern = Pattern.compile(expresion);
		Matcher matcher = pattern.matcher(s);
		return matcher.matches();
	}
	public static boolean queSeaInt(String s){
		Pattern pattern = Pattern.compile("\\d{8}");
		Matcher matcher = pattern.matcher(s);
		return matcher.matches();
		
	}
	public static boolean nombreValido(String s) {
		Pattern pattern = Pattern.compile("([a-zA-Z]{2,20})|([a-zA-Z]{2,10}\\s[a-zA-Z]{2,10})");
		Matcher matcher = pattern.matcher(s);
		return matcher.matches();
	}

}
