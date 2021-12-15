import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

public class FileTail {

	public String getLog() {
		String path="C:\\Users\\debasish.mahana\\Desktop\\Logs\\CAAV2ScheduledAgentLog-29-start-sgffit-caa-agent1.sg.highradius.com.log";
		long noOfLines=100;
		StringBuffer resLog = new StringBuffer();
		Map<Long, String> map = new HashMap<>();
		try {
			RandomAccessFile rndmFile = new RandomAccessFile(path, "r");
			long logFileLength = rndmFile.length();
			long filePos = logFileLength - 1;
			long line = 1;
			for (line = 1; line <= noOfLines; filePos--) {
				rndmFile.seek(filePos);
				if (rndmFile.readByte() == 0xA) {
					if (filePos != logFileLength - 1) {
						map.put(line, rndmFile.readLine());
						line++;
					} else {
						continue;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		long startPointer = noOfLines;
		resLog.append("<center><u><b>Viewing Last "+ startPointer+" lines</b></u></br></center>");
		while (startPointer != 0) {
			if (map.containsKey(startPointer)) {
				resLog.append(map.get(startPointer));
				startPointer--;
			}
			resLog.append("</br>\n");
		}
		return resLog.toString();
	}
}
