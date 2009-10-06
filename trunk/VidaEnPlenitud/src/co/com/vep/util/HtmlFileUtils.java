package co.com.vep.util;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

public class HtmlFileUtils {

	public static String cleanFile(String fileName, String dirName,
			String baseName) throws Exception {
		try {
			FileInputStream fis = null;
			BufferedInputStream bis = null;
			DataInputStream dis = null;
			String finalContent = "";

			fis = new FileInputStream(fileName);

			// Here BufferedInputStream is added for fast reading.
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);

			// dis.available() returns 0 if the file does not have more
			// lines.
			while (dis.available() != 0) {
				String linea = dis.readLine();
				if (!linea.contains("ISO-8859-1"))
					finalContent += linea;
			}

			// dispose all the resources after using them.
			fis.close();
			bis.close();
			dis.close();

			if (new File(fileName).exists())
				new File(fileName).delete();

			baseName = baseName + new java.util.Date().getTime();
			FileWriter fw = new FileWriter(dirName + "/reports/" + baseName
					+ ".html");
			fw.write(finalContent);
			fw.close();
			return baseName;
		} catch (Exception e) {
			throw e;
		}
	}
}
