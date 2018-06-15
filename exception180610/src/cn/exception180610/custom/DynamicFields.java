package cn.exception180610.custom;

public class DynamicFields {
	
	private Object[][] fields;
	//��ʼ������
	public DynamicFields(int initialSize) {
		fields = new Object[initialSize][2];
		for (int i = 0; i < fields.length; i++) {
			fields[i] = new Object[]{null,null};
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < fields.length; i++) {
			result.append(fields[i][0]);
			result.append(": ");
			result.append(fields[i][1]);
			result.append("\n");
		}
		return result.toString();
	}
	//���ݸ�����String,�ж��Ƿ��д�String��ʶ��,���ر�ʶ��������ʧ��-1
	private int hasField(String id) {
		for (int i = 0; i < fields.length; i++) {
			if(id.equals(fields[i][0])) {
				return i;
			}
		}
		return -1;
	}
	//��ȡ��ʶ������
	private int getFieldNumber(String id) throws NoSuchFieldException {
		int fieldNum = hasField(id);	//�ж��Ƿ��д˱�ʶ��
		if(fieldNum == -1) {	//���û�д˱�ʶ�����׳��쳣
			throw new NoSuchFieldException();
		}
		return fieldNum;	//����з�������
	}
	//��ʶ�����
	private int makeField(String id) {
		for (int i = 0; i < fields.length; i++) {
			if(fields[i][0] == null) {
				fields[i][0] = id;
				return i;
			}
		}
		//���û�пհ��ֶ��������,��ô�½�һ������,���ȱ�ԭ����ռ��1,Ȼ�������
		Object[][] temp = new Object[fields.length + 1][2];
		for (int i = 0; i < fields.length; i++) {
			temp[i] = fields[i];
		}
		for (int i = fields.length; i < temp.length; i++) {
			temp[i] = new Object[] {null,null};
		}
		fields = temp;
		return makeField(id);
	}
	//���ݱ�ʶ����ȡ�ֶ�ֵ
	public Object getField(String id) throws NoSuchFieldException {
		return fields[getFieldNumber(id)][1];
	}
	/**
	 * ���ݸ�����String,���value--�ֶ����
	 * @param id
	 * @param value
	 * @return
	 * @throws DynamicFieldsException
	 */
	public Object setField(String id, Object value) throws DynamicFieldsException {
		//�쳣��--����ֶ��ǿյ�,�����쳣
		if(value == null) {
			DynamicFieldsException dynamicFieldsException = new DynamicFieldsException();
			dynamicFieldsException.initCause(new NullPointerException());
			throw dynamicFieldsException;
		}
		//����id��ѯ��������
		int fieldNumber = hasField(id);
		if(fieldNumber == -1) {	//��������в����ڱ�ʶ��,��ô���
			fieldNumber = makeField(id);
		}
		Object result = null;	//�����ֶ���Ϊ��ֵ����
		try {
			result = getField(id);	//old value
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		fields[fieldNumber][1] = value;
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicFields dynamicFields = new DynamicFields(3);
		System.out.println(dynamicFields);
		try {
			dynamicFields.setField("d", "A value for d");
			dynamicFields.setField("number", 47);
			dynamicFields.setField("number2", 48);
			System.out.println(dynamicFields);
			dynamicFields.setField("number3", 11);
			System.out.println("df:" + dynamicFields);
			System.out.println("dynamicFields.getField(\"d\") : " + dynamicFields.getField("d"));
			Object field = dynamicFields.setField("d", null);
		} catch (DynamicFieldsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
