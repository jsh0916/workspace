package SH;

//Problem: https://www.hackerrank.com/challenges/time-conversion

public class test3 {
	public static void main(String[] args) {
		String s = "07:05:45PM";

		int hour = Integer.parseInt(s.substring(0,2));
        int minute = Integer.parseInt(s.substring(3,5));
        int second = Integer.parseInt(s.substring(6,8));
        String meridiem = s.substring(8,10);

        hour += ((meridiem.equals("PM") && hour != 12)?12:0);
        hour -= ((meridiem.equals("AM") && hour == 12)?12:0);

        System.out.println(String.format("%02d",hour) + ":" + String.format("%02d",minute) + ":" + String.format("%02d",second));
	}
}
