package cn.exception180610.log;
/**
 * 
 * @author 樗里修齢
 * 2018年6月14日
 * @core 将异常写入到日志
 */

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class LoggingException extends Exception{

	private static Logger logger = Logger.getLogger("LoggingException");

	public LoggingException() {
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
		// TODO Auto-generated constructor stub
	}
}
