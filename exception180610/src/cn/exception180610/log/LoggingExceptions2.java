package cn.exception180610.log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * 
 * @author �������h
 * 2018��6��14��
 * @core ���쳣�������в���ͼ�¼�쳣
 */
public class LoggingExceptions2 {
	
	private static Logger logger = Logger.getLogger("LoggingExceptions2");
	
	static void logException(Exception e) {
		StringWriter writer = new StringWriter();
		e.printStackTrace(new PrintWriter(writer));
		logger.severe(writer.toString());
	}
	
	public static void main(String[] args) {
		try {
			throw new NullPointerException();
		} catch (Exception e) {
			// TODO: handle exception
			logException(e);
		}

	}

}
