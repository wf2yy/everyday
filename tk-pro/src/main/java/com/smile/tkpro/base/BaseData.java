package com.smile.tkpro.base;

import java.io.Serializable;

/**
 * 
 * @author YinYongShen
 *
 * 日期：2018年5月22日
 * 
 * 数据基类
 */
public class BaseData implements Serializable{

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 5263454014920838402L;
	
	
	/**
	 * 序列号
	 */
	protected int serialNumber;

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
		
	/**
	 * 生成当前页序列号
	 * @param pageNo 页数
	 * @param pageSize 页容量
	 * @return 返回序列号数组
	 */
	public static int[] getSerialNumber(int pageNo, int pageSize) {
		

		int[] list = new int[pageSize];
		
		int start = (pageNo - 1)* pageSize + 1;
		
		int end =  pageNo * pageSize;
		
		int k = 0;

		for (int i = start  ; i <= end; i++) {
			
			list[k] = i;
			
			k++;
		}
		
		return list;
	}

}
