package cn.exception180610.finallyy;

public class LostMessage {
	
	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}
	
	void dispose() throws HoHumException {
		throw new HoHumException();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LostMessage lostMessage = new LostMessage();
		try {
			lostMessage.f();
		} catch (VeryImportantException e) {
			// TODO: handle exception
			System.out.println("Exception VeryImportantException");
			e.printStackTrace();
		}
		finally {
			try {
				lostMessage.dispose();
			} catch (HoHumException e) {
				// TODO: handle exception
				System.out.println("Exception HoHumException");
				e.printStackTrace();
			}
		}
	}
}
