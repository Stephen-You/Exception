package cn.exception180610.catchs;
/**
 * 
 * @author 樗里修齢
 * 2018年6月10日
 * @core:异常处理模型基于的三种操作之3:捕获异常
 * 		我们使用try-catch语句来捕获异常并处理异常,我们需要注意的时,在try中产生一个异常后就会被catch语句捕捉,然后try语句中不在执行剩下语句
 */
public class CatchException {
	public static void main(String[] args) {
		try {
			int[] list = new int[10];
			System.out.println("list[10] is " + list[10]);//注意运行时异常即便你不声明异常,或者抛出异常,或者catch中并没有对应异常,JVM仍然能够捕捉,并且抛出异常
			//但是必检异常却不会出现这种情况,因为编译器会要求我们必须有try-catch语句,并且要catch相应异常
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}/*catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
		catch (Exception e) {
			// TODO: handle exception
			StackTraceElement[] elements =  e.getStackTrace();
			for (int i = 0; i < elements.length; i++) {
				System.out.println(elements[i].getMethodName());
			}
		}
		System.out.println("异常抛出了!");
	}
}
