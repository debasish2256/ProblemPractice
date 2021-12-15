package notification_song;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;

public class song_notify {

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, JavaLayerException{
		
		Scanner scanner = new Scanner(System.in);
		
		File file = new File("E:\\Coding\\GFG\\src\\notification_song\\Test.mp3");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		FileInputStream j=new FileInputStream(file);
		Player k=new Player(j);
//		System.out.println(k.getPosition()+10);
		k.play();
		String response = "";
			
		while(!response.equals("Q")) {
			System.out.println("P = play, S = Stop, R = Reset, Q = Quit");
			System.out.print("Enter your choice: ");
			
			response = scanner.next();
			response = response.toUpperCase();
			
			/*switch(response) {
				case ("P"): clip.start();
				break;
				case ("S"): clip.stop();
				break;
				case ("R"): clip.setMicrosecondPosition(0);
				break;
				case ("Q"): clip.close();
				break;
				default: System.out.println("Not a valid response");
			}*/
		 }
		System.out.println("Bye!");	
	}
}