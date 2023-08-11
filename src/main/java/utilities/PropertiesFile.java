package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

	public static Properties prop = null;
	public static File file = null;
	public static FileInputStream fis = null;

	// Static block to initialize class variables
	static {
		{
			file = new File(System.getProperty("user.dir") + "\\Resources\\config.properties");
			try {
				fis = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			prop = new Properties();
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
	}

	public static String getProperty(String key) {

		return prop.getProperty(key);

	}
}
