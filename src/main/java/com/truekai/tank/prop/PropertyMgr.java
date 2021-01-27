package com.truekai.tank.prop;

import com.truekai.tank.constant.Constants;

import java.io.IOException;
import java.util.Properties;

/**
 * 配置管理类
 */
public class PropertyMgr {
	static Properties props = new Properties();

	
	static {
		try {
			props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Object get(String key) {
		if(props == null) return null;
		return props.get(key);
	}
	
	//int getInt(key)
	//getString(key)
	
	public static void main(String[] args) {
		int initTankCount = Integer.valueOf((String)PropertyMgr.get(Constants.initTankCount));

		System.out.println(initTankCount);

	}
}
