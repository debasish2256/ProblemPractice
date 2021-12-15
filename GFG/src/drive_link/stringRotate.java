package drive_link;

public class stringRotate {
	static boolean isRotated(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;

		String clock_wise = "";
		String anticlock_wise = "";
		int len = str2.length();

		anticlock_wise = (str2.substring(len - 2, len) + str2.substring(0, len - 2));
		clock_wise = (str2.substring(2, len) + str2.substring(0, 2));
		/*System.out.println(anticlock_wise);
		System.out.println(clock_wise);*/

		if (str1.equals(anticlock_wise) || str1.equals(clock_wise))
			return true;

		return false;

	}

	public static void main(String[] args) {
		String str1 = "amazon";
		String str2 = "onamaz";

		System.out.println(isRotated(str1, str2) ? "Match Success" : "No Match");
	}
}
