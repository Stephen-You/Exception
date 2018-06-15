package cn.exception180610.log;
/**
 * 
 * @author 樗里修齢
 * 2018年6月14日
 * @core  异常输出到日志
 */
public class LoggingExceptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			throw new LoggingException();
		} catch (Exception e) {
			System.err.println("Caught " + e);
		}
		try {
			throw new LoggingException();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Caught " + e);
		}
	}

}
