package L1;

import java.util.Scanner;

public class rotateNumber {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
//		rotationNumber(sc.nextInt(),sc.nextInt());
		
		rotationNumber(562984,2);

	}

	private static void rotationNumber(int num,int rot) {
		int div=1,multi=1;
		int temp=num;
		int count=0;
		while(temp!=0) {
			temp=temp/10;
			count++;
		}

		rot=rot%count;
		if(rot<0){
			rot=rot+count;
		}
		for(int i=0;i<count;i++){
			if(i<rot){
				div=div*10;
			}else{
				multi=multi*10;
			}
		}
		int rem=num%div;//84
		int qo=num/div;//5629
		int res=rem*multi+qo;
		System.out.println(res);

	}
}
