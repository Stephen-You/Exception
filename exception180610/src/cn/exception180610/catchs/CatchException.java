package cn.exception180610.catchs;
/**
 * 
 * @author �������h
 * 2018��6��10��
 * @core:�쳣����ģ�ͻ��ڵ����ֲ���֮3:�����쳣
 * 		����ʹ��try-catch����������쳣�������쳣,������Ҫע���ʱ,��try�в���һ���쳣��ͻᱻcatch��䲶׽,Ȼ��try����в���ִ��ʣ�����
 */
public class CatchException {
	public static void main(String[] args) {
		try {
			int[] list = new int[10];
			System.out.println("list[10] is " + list[10]);//ע������ʱ�쳣�����㲻�����쳣,�����׳��쳣,����catch�в�û�ж�Ӧ�쳣,JVM��Ȼ�ܹ���׽,�����׳��쳣
			//���Ǳؼ��쳣ȴ��������������,��Ϊ��������Ҫ�����Ǳ�����try-catch���,����Ҫcatch��Ӧ�쳣
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
		System.out.println("�쳣�׳���!");
	}
}
