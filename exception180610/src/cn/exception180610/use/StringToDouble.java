package cn.exception180610.use;
/**
 * 
 * @author 樗里修齢
 * 2018年6月10日
 * @core:什么时候使用异常
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
		System.out.println("重新抛出异常!");
	}

}
