package cn.exception180610.use;
/**
 * 
 * @author �������h
 * 2018��6��10��
 * @core:ʲôʱ��ʹ���쳣
 */
public class StringToDouble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			isNumeric("7.23s");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void isNumeric(String token) {
		try {
			Double.parseDouble(token);
//			return true;
		} catch (Exception e) {
			throw e;
//			e.printStackTrace();
		}
		System.out.println("�����׳��쳣!");
	}

}
