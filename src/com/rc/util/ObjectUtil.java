/**
 * 
 */
package com.rc.util;

import java.lang.reflect.Field;
import java.util.Arrays;

import org.apache.commons.lang.xwork.ArrayUtils;

/**
 * @author ZZA
 * 获取指定对象所有属性的信息，以便于在程序中调试
 */
public class ObjectUtil {
	private char[] arr = {'a', 'b', 'c'};
	private int[] intArr = {1, 2, 3, 4, 5};
	private String[] strArr = {"1", "2", "3"};
	public static void main(String[] args) {
		String str = "hahahaah";
		String[] arr = {"cc", "dd"};
		System.out.println(getFieldsStr(new ObjectUtil()));
		//System.out.println(getFieldsStr(str));
	}
	
	/**
	 * 返回指定对象所有属性组成的字符串
	 * @param obj 指定的对象
	 * @return 指定对象为null或不含任何域时，返回空串；否则返回格式为"类名{属性名=属性值, 属性名=属性值...}"的字符串
	 */
	public static String getFieldsStr(Object obj) {
		String result = "";
		if (obj != null) {
			Class clazz = obj.getClass();
			Field[] fields = clazz.getDeclaredFields();
			StringBuffer sb = new StringBuffer();
			sb.append(clazz.getSimpleName());
			sb.append("{");
			try {
				for (int i = 0; i < fields.length; i++) {
					Field f = fields[i];
					f.setAccessible(true);
					String name = f.getName();//属性名
					Class<?> type = f.getType();//属性类型
					Object value = f.get(obj);//属性值
					if (i > 0) {
						sb.append(", ");
					}
					if (type.isArray()) {
						String arrStr = ArrayUtils.toString(value);
						sb.append(name).append("=").append(arrStr);
					} else {
						sb.append(name).append("=").append(value);
					}
				}
				sb.append("}");
				result = sb.toString();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
