package cn.exception180610.chained_exception;
/**
 * 
 * @author �������h
 * 2018��6��10��
 * @core:�쳣��ʽ
 */
public class ChainedExceptionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			method1();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	static void method1() throws Exception {
		try {
			method2();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("New info from method1");
		}
		
		
	}
	
	static void method2() throws Exception {
		throw new Exception("New info from method2");
	}

}
