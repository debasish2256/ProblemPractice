package hackerRank;

import javax.xml.crypto.dsig.SignedInfo;

public class fahrenheitToCelsiusTable {
	public static void main(String[] args) {
		int low = 0, high = 100, gap = 20;
		printTemperatureConversionTable(low, high, gap);
	}

	private static void printTemperatureConversionTable(int low, int high, int gap) {
		while (low <= high) {
			System.out.println(low + " " + getFarenheitToCelcius(low));
			low += gap;
		}
	}

	private static int getFarenheitToCelcius(int F) {
		return (F - 32) * 5 / 9;
	}
}
