package cn.exception180610.log;
/**
 * 
 * @author �������h
 * 2018��6��14��
 * @core  �쳣�������־
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
