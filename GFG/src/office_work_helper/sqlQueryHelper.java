package office_work_helper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;  

/**
 @author debasish.mahana
 **/

public class sqlQueryHelper { 
	    @SuppressWarnings("resource")
		public static void main(String args[]) throws IOException{ 
	    	int count=1;
	    	String query,strLine,input_path,output_path=null;
	    	System.out.print("Enter File Name to Save : ");
	    	input_path="C:\\Users\\debasish.mahana\\Desktop\\SqlQueryHelper\\input_text_pad.txt";
	    	output_path="C:\\Users\\debasish.mahana\\Desktop\\SqlQueryHelper";
	    	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(input_path)));
	    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output_path+File.separator+new Scanner(System.in).next()+".sql")));

	    			while ((strLine = br.readLine()) != null)   {
	    				query="UPDATE caa_payment_confirmation_hdr AS pch INNER JOIN caa_bank_transmission AS bt ON pch.fk_bank_transmission_file_id=bt.pk_bank_transmission_file_id AND pch.is_deleted=0 AND "
	    						+ "pch.fk_account_id="+strLine+" SET pch.`effective_date`= bt.`payment_date`,pch.country_code=bt.country_code;\r\n";
	    	    		bw.write(query);
	    	    		//bw.newLine();
	    	    		System.out.println(strLine+" - "+count++);
	    			}
	    			br.close();bw.close();
	    	System.out.println("Query File Generated Successfully....");
	    }
}