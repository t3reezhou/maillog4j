package log4j;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class testlog {
	static Logger LOGGER = Logger.getLogger(testlog.class.getName());

	public static void main(String[] args) {
		PropertyConfigurator.configure("./src/log4j.properties");
		try {
			List a = null;
			System.out.println(a.size());
		} catch (Exception e) {
			LOGGER.error("run error", new Throwable("test"));
		}
	}
}