package cn.exception180610.custom;

public class ExtraFeatures {
	
	public static void f() throws MyException {
		// TODO Auto-generated method stub
		System.out.println("Throwing MyException2 from f()");
		throw new MyException();
	}
	
	public static void g() throws MyException {
		System.out.println("Throwing MyException2 from g()");
		throw new MyException("Originated in g()");
	}
	
	public static void h() throws MyException {
		System.out.println("Throwing MyException2 from h()");
		throw new MyException("Originated in h()", 47);
	}
	
	public static void main(String[] args) {
		try {
			f();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			g();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			h();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.val());
		}
	}
}
