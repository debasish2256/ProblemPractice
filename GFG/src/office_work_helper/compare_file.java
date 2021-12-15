package office_work_helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class compare_file {
	public static void main(String[] args) throws IOException {
		int count=1;
    	System.out.print("Enter File Name to Save : ");

		String query,strLine,strLine1,file_path_2,file_path_1,output_path=null;
		file_path_1="C:\\Users\\debasish.mahana\\Desktop\\SqlQueryHelper\\Comparision\\compare_with_file.txt";
		file_path_2="C:\\Users\\debasish.mahana\\Desktop\\SqlQueryHelper\\Comparision\\input_text_to_compare.txt";

		output_path="C:\\Users\\debasish.mahana\\Desktop\\SqlQueryHelper\\Comparision\\Output\\";
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file_path_1)));
		BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream(file_path_2)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output_path+File.separator+new Scanner(System.in).next()+".sql")));

		TreeSet<String> set1=new TreeSet<>();//old one
		TreeSet<String> set2=new TreeSet<>();//latest one
		TreeSet<String> set3=new TreeSet<>();//contains difference

		while ((strLine = br.readLine()) != null)   {
			set1.add(strLine.trim());			
		}
		br.close();
		while ((strLine1 = br1.readLine()) != null)   {
			set2.add(strLine1.trim());			
		}
		br1.close();
		for(String str:set1) {
			if(!set2.contains(str)) {
				set2.add(str);
				set3.add(str);
			}
		}
		for(String string:set2) {
			query="UPDATE caa_payment_confirmation_hdr AS pch INNER JOIN caa_bank_transmission AS bt ON pch.fk_bank_transmission_file_id=bt.pk_bank_transmission_file_id AND pch.is_deleted=0 AND "
					+ "pch.fk_account_id="+string+" SET pch.`effective_date`= bt.`payment_date`,pch.country_code=bt.country_code;\r\n";
    		bw.write(query);
    		//bw.newLine();
    		System.out.println(string+" - "+count++);
		}
		bw.close();
		System.out.println("Query File Generated Successfully....");
		System.out.println("Difference Size..."+set3.size());
	}
}
