package cn.exception180610.custom;

public class MyException extends Exception{
	private int x;

	public MyException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MyException(String msg, int x) {
		super(msg);
		this.x = x;
	}
	
	public int val() {
		return x;
	}
	
	public String getMessage() {
		return "Detail Message: " + x + " " + super.getMessage();
	}
	
}
