package cn.exception180610.catchs;
/**
 * 
 * @author 樗里修齢
 * 2018年6月10日
 * @core:<<Java语言程序设计基础-Q12.16>>
 */
public class CatchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			method();
			System.out.println("After the method call");
		}catch (RuntimeException e) {
			// TODO: handle exception
			System.out.println("RuntimeException!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception!");
		}
	}
	
	static void method() throws Exception{	//该方法中对异常进行了处理,所以异常的声明是可以不用声明的
		try {
			String s = "abc";
			System.out.println(s.charAt(3));
		} 
		catch (RuntimeException e) {
			System.out.println("Runtime Exception!");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception!");
		}
	}

}
