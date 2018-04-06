package com.zp.springboot.dynamicDataSource;

import java.util.ArrayList;
import java.util.List;

public class DynamicDataSourceContextHolder {
	
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	
	public static List<String> dataSourceIds = new ArrayList<String>();

	public static void setDataSourceType(String dataSourceType){
		contextHolder.set(dataSourceType);
	}
	
	public static String getDataSourceType(){
		return contextHolder.get();
	}
	
	/**
	 * 判断指定DataSource当前是否存在
	 */
	public static boolean containsDataSource(String dataSourceId){
		return dataSourceIds.contains(dataSourceId);
	}
	
	public static void clearDataSourceType(){
		contextHolder.remove();
	}
}
