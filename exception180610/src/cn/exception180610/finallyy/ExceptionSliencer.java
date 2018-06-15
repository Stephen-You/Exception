package cn.exception180610.finallyy;

public class ExceptionSliencer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			throw new RuntimeException();
		} finally {
			// TODO: handle finally clause
			return;
		}
		
	}

}
