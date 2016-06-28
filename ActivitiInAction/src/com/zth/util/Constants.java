package com.zth.util;

import java.util.ArrayList;
import java.util.List;


/**
 * 类描述: 常量类
 */
@SuppressWarnings("rawtypes")
public class Constants {
	
	public static final String TITLE="springMVC";
	public static final String SUCCESS="SUCCESS";
	public static final String FAILURE="FAILURE";
	public static final String YES = "Y";
	public static final String NO = "N";
	public static final String CLIENTUSERTYPE = "5";//客户端用户类型
	public static final int LOCK_TIME = 5;//网上支付锁定时间
	public static final String OTHERWY = "9910";
	
	
	public static final String DM_HOUSEHOLD = "DM_HOUSEHOLD";
	
	public static final String OPERATE_DEL = "DEL";
	public static String SMTPHOST="";
	public static String SENDADDRESS="";
	public static String MAIL_USERNAME = ""; 
	public static String MAIL_PASSWORD = ""; 
	public static String[] EXCLUDE_YH = {"25555"};//不限制一个用户只能登录一次
	
	public static List getClientMenuList() {
		List clientMenuList = new ArrayList();
		return clientMenuList;
	}
	public static String getUnionExamZkzKsxz() {
		
		StringBuffer sbStr = new StringBuffer(" ");
        
        return sbStr.toString();
	}
}
