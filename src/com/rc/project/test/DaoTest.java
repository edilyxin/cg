package com.rc.project.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.rc.project.dao.*;
import com.rc.project.vo.*;

public class DaoTest {

	public static void main(String[] args) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			ClassNotFoundException, InstantiationException {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"/src/applicationContext.xml");

		// CkCheckDAO dao= (CkCheckDAO) ctx.getBean("ckCheckDAO");
		String[] names = new String[] { "ckCheckDAO", "epAccessoryDAO",
				"epBidDAO", "epBidWinDAO", "epContractDAO", "epEntrancecDAO",
				"epEntrancepDAO", "epFormworkDAO", "epMailDAO", "epPackageDAO",
				"epPackageListDAO", "epPayMoneyDAO", "epPersonDAO",
				"epProcessDAO", "epProjectDAO", "epProjectDetailDAO",
				"epSettingDAO", "rpFileDAO","rpMiddleDAO",  "rpReportDAO",
				"rpReportBeginDAO" };
		String[] objs = new String[] { "CkCheck", "EpAccessory", "EpBid",
				"EpBidWin", "EpContract", "EpEntrancec", "EpEntrancep",
				"EpFormwork", "EpMail", "EpPackage", "EpPackageList",
				"EpPayMoney", "EpPerson", "EpProcess", "EpProject",
				"EpProjectDetail", "EpSetting", "RpFile", "RpMiddle","RpReport", 
				"RpReportBegin" };

		// CkCheckDAO dao= (CkCheckDAO) ctx.getBean("ckCheckDAO");
		// CkCheck record=new CkCheck();
		// setValue(record);
		// dao.insert(record);
		// dao.selectByPrimaryKey("S");
		// dao.updateByPrimaryKey(record);
		// dao.deleteByPrimaryKey("S");

		ClassLoader loader = ClassLoader.getSystemClassLoader();

		for (int i = 0; i < names.length; i++) {
			System.out.println("--------------------------------------"+names[i]+"----------------------------");
			Object bean = ctx.getBean(names[i]);
			Object record = loader.loadClass("com.rc.project.vo." + objs[i])
					.newInstance();
			setValue(record);

			Method deleteByPrimaryKey = getMethod(bean.getClass(),
					"deleteByPrimaryKey");
			Object key = getValue(deleteByPrimaryKey);
			if (key == null)
				key = record;
			deleteByPrimaryKey.invoke(bean, key);

			Method insert = getMethod(bean.getClass(), "insert");
			insert.invoke(bean, record);

			Method selectByPrimaryKey = getMethod(bean.getClass(),
					"selectByPrimaryKey");
			selectByPrimaryKey.invoke(bean, key);

			Method updateByPrimaryKey = getMethod(bean.getClass(),
					"updateByPrimaryKey");
			updateByPrimaryKey.invoke(bean, record);

		}

		System.out.println("OK");

	}

	private static Object getValue(Method method) {
		Class clazz = method.getParameterTypes()[0];
		
		try {
			if (String.class == clazz)
				return "S";
			else if (BigDecimal.class == clazz)
				return BigDecimal.valueOf(1234);
			else
				return null;
		} catch (Exception e) {
			System.out.println(clazz.getName());
			e.printStackTrace();
		}
		return null;
		
	}

	private static Method getMethod(Class clazz, String name) {
		for (Method m : clazz.getMethods()) {
			if (m.getName() == name)
				return m;
		}

		return null;
	}

	private static void setValue(Object obj) {
		for (Field field : obj.getClass().getDeclaredFields()) {
			try {
				field.setAccessible(true);
				if(field.getName()=="udSno" || field.getName()=="udSno1"){
					field.set(obj, "D0101");	
				}
				else if (field.getType() == String.class) {
					field.set(obj, "S");
				} else if (field.getType() == Date.class) {
					field.set(obj, new Date());
				} else if (field.getType() == BigDecimal.class) {
					field.set(obj, BigDecimal.valueOf(1234));
				} else {
					System.out.println("-----------------" + field.getName());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
