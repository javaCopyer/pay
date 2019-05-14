package com.minghui.pay;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.minghui.pay.entity.PayAgent;

public class Main {

	public static <T> void aaa(List<T> list) throws Exception {
		for (T t : list) {
			System.out.println(getFieldValue(t, "id"));
			
			setFieldValue(t, "money", 100D);
		}
	}
	
	
	/**
	 * 获取对象属性的值
	 * @param obj  属性所在的对象
	 * @param fieldName 属性名称
	 * @return
	 * @throws Exception
	 */
	public static Object getFieldValue(Object obj, String fieldName) throws Exception {
		Object object = null;
		Field field = obj.getClass().getDeclaredField(fieldName);
		boolean accessiable = field.isAccessible();
		if (!accessiable) {
			//修改private, protected修饰的为可访问的
			field.setAccessible(true);
			object = field.get(obj);
			//还原状态
			field.setAccessible(accessiable);
			return object;
		}
		return object;
	}
	
	
	/**
	 * 设置对象属性的值
	 * @param obj
	 * @param fieldName
	 * @param value
	 * @throws Exception
	 * @author sky
	 * @date 2019-3-29 下午3:02:01
	 */
	public static void setFieldValue(Object obj, String fieldName, Object value) throws Exception {
		Field field = obj.getClass().getDeclaredField(fieldName);
		boolean accessiable = field.isAccessible();
		if (!accessiable) {
			//修改private, protected修饰的为可访问的
			field.setAccessible(true);
			field.set(obj, value);
			//还原状态
			field.setAccessible(accessiable);
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		PayAgent p1 = new PayAgent();
		p1.setId(1);
		
		PayAgent p2 = new PayAgent();
		p2.setId(2);
		
		List<PayAgent> list = new ArrayList<PayAgent>();
		list.add(p1);
		list.add(p2);
		aaa(list);
		for (PayAgent payAgent : list) {
			System.out.println(payAgent.getMoney());
		}
	}
}
