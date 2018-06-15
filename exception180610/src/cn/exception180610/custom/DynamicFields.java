package cn.exception180610.custom;

public class DynamicFields {
	
	private Object[][] fields;
	//初始化数组
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
	//根据给定的String,判断是否有此String标识符,返回标识符索引和失败-1
	private int hasField(String id) {
		for (int i = 0; i < fields.length; i++) {
			if(id.equals(fields[i][0])) {
				return i;
			}
		}
		return -1;
	}
	//获取标识符索引
	private int getFieldNumber(String id) throws NoSuchFieldException {
		int fieldNum = hasField(id);	//判断是否有此标识符
		if(fieldNum == -1) {	//如果没有此标识符就抛出异常
			throw new NoSuchFieldException();
		}
		return fieldNum;	//如果有返回索引
	}
	//标识符填充
	private int makeField(String id) {
		for (int i = 0; i < fields.length; i++) {
			if(fields[i][0] == null) {
				fields[i][0] = id;
				return i;
			}
		}
		//如果没有空白字段用于填充,那么新建一个数组,长度比原数组空间大1,然后再填充
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
	//根据标识符获取字段值
	public Object getField(String id) throws NoSuchFieldException {
		return fields[getFieldNumber(id)][1];
	}
	/**
	 * 根据给定的String,填充value--字段填充
	 * @param id
	 * @param value
	 * @return
	 * @throws DynamicFieldsException
	 */
	public Object setField(String id, Object value) throws DynamicFieldsException {
		//异常链--如果字段是空的,返回异常
		if(value == null) {
			DynamicFieldsException dynamicFieldsException = new DynamicFieldsException();
			dynamicFieldsException.initCause(new NullPointerException());
			throw dynamicFieldsException;
		}
		//根据id查询数组索引
		int fieldNumber = hasField(id);
		if(fieldNumber == -1) {	//如果数组中不存在标识符,那么填充
			fieldNumber = makeField(id);
		}
		Object result = null;	//定义字段作为旧值返回
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
