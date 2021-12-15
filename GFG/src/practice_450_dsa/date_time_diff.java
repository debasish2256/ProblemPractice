package practice_450_dsa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class date_time_diff {
	static void time_diff(String dateStart, String dateStop) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date1;
		Date date2;
		date1 = format.parse(dateStart);
		date2 = format.parse(dateStop);
		long difference_sec = date2.getTime() - date1.getTime();
		System.out.println(difference_sec / 1000);
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		// String dateStart = "2019-01-01 15:45:56";
		// String dateStop = "2019-01-01 16:45:56";
		String dateStart = sc.nextLine();
		String dateStop = sc.nextLine();
		time_diff(dateStart, dateStop);
	}
}