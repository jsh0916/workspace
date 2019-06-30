package SH;

import java.util.regex.Pattern;

public class CharacterCheck {
	public static void main(String[] args) {
		String sentence = "azAZ019 아이폰6를 샀는데 iphone5보다 이쁘지는 않더라";
		String[] words = sentence.split(" ");
		
		for (String word : words) {
			System.out.println(word + "=>" + getType(word));
		}
	}
	
	/*
	 * 문자의 영문, 숫자, 한글 타입을 리턴한다.
	 * 
	 * @param word
	 * @return
	 * 
	public static String getType (String word) {
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i);
			System.out.println(word.substring(i, i + 1) + " " + index);
		}
		
		return "";
	}
	*/
	
	/*
	 * 문자의 영문, 숫자, 한글 타입을 리턴한다.
	 * 
	 * @param word
	 * @return
	 * */
	public static String getType (String word) {
		boolean numeric = false;
		boolean alpha = false;
		boolean korean = false;
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i);
			
			if (index >= 48 && index <= 57) {
				numeric = true;
			} else if (index >= 65 && index <= 122) {
				alpha = true;
			} else {
				korean = true;
			}
		}
		
		if (numeric) {
			sb.append("숫자");
		}
		
		if (alpha) {
			if (sb.length() > 0) {
				sb.append(",");
			}
			
			sb.append("영문");
		}
		
		if (korean) {
			if (sb.length() > 0) {
				sb.append(",");
			}
			
			sb.append("한글");
		}
		
		//return Pattern.matches("^[0-9a-zA-Z가-힣]*$", word);
		return sb.toString();
	}
}
