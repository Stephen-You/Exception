package cn.exception180610.catchs;
/**
 * 
 * @author �������h
 * 2018��6��10��
 * @core:<<Java���Գ�����ƻ���-Q12.16>>
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
	
	static void method() throws Exception{	//�÷����ж��쳣�����˴���,�����쳣�������ǿ��Բ���������
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
