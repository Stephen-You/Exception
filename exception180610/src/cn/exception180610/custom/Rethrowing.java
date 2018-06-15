package cn.exception180610.custom;
/**
 * 
 * @author 樗里修齢
 * 2018年6月14日
 * @core  重新抛出异常
 */
public class Rethrowing {
	
	public static void f() throws Exception {
		System.out.println("originating the exception in f()");
		throw new Exception("throw from f()");
	}
	
	public static void g() throws Exception {
		try {
			f();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Inside g(), e.printStackTrace()");
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void h() throws Exception {
		try {
			f();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("inside h(), e.printStackTrace()");
			e.printStackTrace(System.out);
			throw (Exception)e.fillInStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			g();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("main: printStackTrace()");
			e.printStackTrace();
		}
		
		try {
			h();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("main: printStackTrace()");
			e.printStackTrace();
		}
	}

}
