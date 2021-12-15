package L1;
import java.util.*;

public class isPrime{

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int size=scn.nextInt();
		int res[]=new int[size];

		for(int i=0;i<size;i++){
			res[i]=scn.nextInt();
		} 
		for(int i=0;i<size;i++){
			System.out.println(checkPrime(res[i]));
		}
	}

	private static String checkPrime(int num) {
		int fact=0;
		for(int i=2;i*1<=num;i++) {
			if(num%i==0) {
				fact++;
				break;
			}
		}
		return fact!=0?"not prime":"prime";
}

}
