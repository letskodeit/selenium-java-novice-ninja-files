import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {
// Please change the extension to .java before running the file
// Udemy does not allow to upload .java file, that’s why I have to change the extension

	public static void main(String[] args) throws IOException {
		String path = "//Users//atomar//Documents//workspace_personal//JavaTutorial//src/test.properties";
		
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(path);
		
		prop.load(fs);
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("course"));

	}
}