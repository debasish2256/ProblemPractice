package threading;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class JavaGenerateCSV {

	public static void main(String[] args) throws IOException {
		System.out.println(filesize_in_megaBytes(new File("E:\\Coding\\big_data.csv")));
		generateCSV();
//		System.out.println(filesize_in_megaBytes(new File("E:\\Coding\\big_data.csv")));

	}
	
	public static void generateCSV() throws IOException {
		FileWriter csvwrite=new FileWriter("E:\\Coding\\big_data.csv");
		TimerTask StopApp=new TimerTask() {
			@Override
			public void run() {
				System.exit(0);
			}
		};
		//20000
		new Timer().schedule(StopApp, new Date(System.currentTimeMillis() + 2000));
		int i=10;
		csvwrite.append("Year,Primary School,HS School,Fees\n");
		while(i>0) {
			csvwrite.append("2018");
			csvwrite.append(",");
			csvwrite.append("KVS");
			csvwrite.append(",");
			csvwrite.append("DAV");
			csvwrite.append(",");
			csvwrite.append("2000");
			csvwrite.append("\n");
		}
		csvwrite.flush();
		csvwrite.close();
	}
	
	
	private static String filesize_in_megaBytes(File file) {
        return (double) file.length()/(1024*1024)+" mb";
    }
}
