package com.zth.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 类描述: 日期格式公共类
 * @author <a href="mailto:lizh911@maystar.com.cn">lizh</a>
 * @version $Id: codetemplates.xml,v 1.1.1.1 2011/08/20 lizh Exp $
 */
@SuppressWarnings("rawtypes")
public class DateTimeUtil {
  /**
   * Return current datetime string.
   * @return current datetime, pattern: "yyyy-MM-dd HH:mm:ss".
   */
	
  public static String DATEFOAMT = "yyyy-MM-dd";
  public static String DATETIMEFOAMT = "yyyy-MM-dd HH:mm:ss";
  public static String DATETIMEFOAMTM = "yyyy-MM-dd HH:mm";
  
  public static String getDateTime() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String dt = sdf.format(new Date());
    return dt;
  }

  
  public static String getTime(long time, String pattern){
	  return getTime(new Date(time), pattern);
  }
  
  public static long getTime(String date, String pattern) {
	    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	    Date dt = null;
		try {
			dt = sdf.parse(date);
		} catch (ParseException e) {
			return 0;
		}
	    return dt.getTime();
	  }

  /**
   * Return current datetime string.
   * @param pattern format pattern
   * @return current datetime
   */
  public static String getDateTime(String pattern) {
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    String dt = sdf.format(new Date());
    return dt;
  }

  /**
   * Return short format datetime string.
   * @param date java.util.Date
   * @return short format datetime
   */
  public static String strForDate(Date date) {
	  if (date == null){
		  return "";
	  }
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    return sdf.format(date);
  }
  
  /**
   * Return short format datetime string.
   * @param date java.util.Date
   * @return short format datetime
   */
  public static String yyyyMM_ForDate(Date date) {
      if (date == null){
          return "";
      }
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
    return sdf.format(date);
  }

  /**
   * Return short format datetime string.
   * @param date java.util.Date
   * @return short format datetime
   */
  public static String shortFmt(Date date) {
  	if(date==null || date.equals("")){
  		return "";
  	}
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    return sdf.format(date);
  }
  
  /**
   * 获取详细时间 精确到分钟
   * @param date
   * @return
   */
  public static String shortFmtYMDHM(Date date) {
	  	if(date==null || date.equals("")){
	  		return "";
	  	}
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    return sdf.format(date);
	  }
  
  
  public static String shortFmtYM(Date date) {
  	if(date==null || date.equals("")){
  		return "";
  	}
    SimpleDateFormat sdf = new SimpleDateFormat("yyMM");
    return sdf.format(date);
  }
  
  public static String shortFmtMM(Date date) {
  	if(date==null || date.equals("")){
  		return "";
  	}
    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
    return sdf.format(date);
  }
  
  public static String shortFmtCn(Date date) {
  	if(date==null || date.equals("")){
  		return "";
  	}
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
    return sdf.format(date);
  }
  
  public static String shortFmtCn2(Date date) {
  	if(date==null || date.equals("")){
  		return "";
  	}
    SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
    return sdf.format(date);
  }
  
  /**
   * Return short format datetime string.
   * @param date java.util.Date
   * @return short format datetime
   */
  public static String shortFmts(Date date) {
  	if(date==null || date.equals("")){
  		return "";
  	}
  	try{
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	    return sdf.format(date);
  	}catch(Exception e){  		
  	}
  	return "";
  }

  public static String shortFmt() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    return sdf.format(new Date());
  }  
  
  public static String shortFmt(String str) {
    SimpleDateFormat sdf = new SimpleDateFormat(str);
    return sdf.format(new Date());
  }  
  
  public static String shortTime() {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    return sdf.format(new Date());
  }    
  public static String getStrTime() {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
      return sdf.format(new Date());
    } 
  public static String LongFmt(Date date) {
	if(date==null){
		return "";
	}
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    return sdf.format(date);
  }


  public static String getTime(Date date) {
  	if(date==null){
  		return "";
  	}  	
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return sdf.format(date);
  }

  
  public static String getTime(Date date,String pattern) {
	  	if(date==null){
	  		return "";
	  	}  	
	    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	    return sdf.format(date);
	  }

  /**
   * Parse a datetime string.
   * @param param datetime string, pattern: "yyyy-MM-dd HH:mm:ss".
   * @return java.util.Date
   */
  public static Date parse(String param) {
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    try {
      date = sdf.parse(param);
    }
    catch (ParseException ex) {
    }
    return date;
  }

  /**
   * Parse a datetime string.
   * @param param datetime string, pattern: "yyyy-MM-dd HH:mm:ss".
   * @return java.util.Date
   */
  public static Date getShortDate(String param) {
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try {
      date = sdf.parse(param);
    }
    catch (ParseException ex) {
    }
    return date;
  }
  
  /**
   * 校验yyyy-MM-dd的日期
   * @param param
   * @return
   */
  public static boolean chkShortDate(String sourceDate) {
	  if(sourceDate==null || "".equals(sourceDate)){
		  return false;
	  }
	  try {
		  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		  dateFormat.setLenient(false);
		  dateFormat.parse(sourceDate);
		  return true;
	  } catch (Exception e) {
	  }
	  return false;
  }
  
  
  /**
   * Parse a datetime string.
   * @param param datetime string, pattern: "yyyy-MM-dd HH:mm:ss".
   * @return java.util.Date
   */
  public static Date getShortDates(String param) {
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    try {
      date = sdf.parse(param);
    }
    catch (ParseException ex) {
    }
    return date;
  }
  
  /**
   * Parse a datetime string.
   * @param param datetime string, pattern: "yyyy-MM-dd HH:mm:ss".
   * @return java.util.Date
   */
  public static Date getShortDates(String param,String format) {
  	if(param==null || param.trim().equals("")){
  		return null;
  	}
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    try {
      date = sdf.parse(param);
    }
    catch (ParseException ex) {
    }
    return date;
  }
  
  
  /**
    * Parse a datetime string.
    * @param param datetime string, pattern: "yyyy-MM-dd HH:mm:ss".
    * @return java.util.Date
    */
   public static Date getDateFomate(String param) {
     Date date = null;
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     try {
       date = sdf.parse(param);
     }
     catch (ParseException ex) {
     }
     return date;
  }
   /**
    * Parse a datetime string.
    * @param param datetime string, pattern: "yyyy-MM-dd HH:mm:ss".
    * @return java.util.Date
    */
   public static Date getDateFomates(String param) {
     Date date = null;
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
     try {
       date = sdf.parse(param);
     }
     catch (ParseException ex) {
     }
     return date;
  }
  /**
   * ���
   * @return String
   */
  public static String getCurrentYear() {
    Calendar cal = Calendar.getInstance();
    return String.valueOf(cal.get(Calendar.YEAR));
  }
  
  public static int getCurrentYearInt() {
    Calendar cal = Calendar.getInstance();
    return cal.get(Calendar.YEAR);
  }

  /**
   * ���ص�ǰ�·�
   * @return String
   */
  public static String getCurrentMonth() {
    Calendar cal = Calendar.getInstance();
    int nMonth = cal.get(Calendar.MONTH) + 1;
    if (nMonth < 10) {
      return "0" + String.valueOf(nMonth);
    }
    return String.valueOf(nMonth);
  }
  
  /**
   * ���
   * @return String
   */
  public static String getCurrentDay() {
    Calendar cal = Calendar.getInstance();
    return String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
  }  
  
  /**
   * ������һ��
   * @return String
   */
  public static String getPreviousMonth() {
    Calendar cal = Calendar.getInstance();
    int nMonth = cal.get(Calendar.MONTH);
    if (nMonth < 10) {
      if(nMonth==0){                 //�����1�£��򷵻�����12��
        return "12";
      }
      return "0" + String.valueOf(nMonth);
    }
    return String.valueOf(nMonth);
  }


  /**
   * ������һ��
   * @return String
   */
  public static String getNextMonth() {
    Calendar cal = Calendar.getInstance();
    int nMonth = cal.get(Calendar.MONTH) + 2;
    if (nMonth < 10) {
      return "0" + String.valueOf(nMonth);
    }
    return String.valueOf(nMonth);
  }

  /**
   * ������һ���
   * @return String
   */
  public static String getNextYear() {
    Calendar cal = Calendar.getInstance();
    return String.valueOf(cal.get(Calendar.YEAR) + 1);
  }

  /**������һ��� */
  public static String getLastYear() {
    Calendar cal = Calendar.getInstance();
    return String.valueOf(cal.get(Calendar.YEAR) - 1);
  }

  
  /**
   * ���返回当前小时
   * @return String
   */
  public static String getCurrentHour() {
    Calendar cal = Calendar.getInstance();
    return String.valueOf(cal.get(Calendar.HOUR_OF_DAY));
  }  
  
  /**
   * ��������ַ�
   * @return
   */
  public static String getDateString() {
    java.util.Date dToday = new java.util.Date();
    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(
        "yyyyMMddHHmmss");
    return formatter.format(dToday);
  }

  /**
   * ������������,��ȡ��ǰ�·�����
   * @param strDate String:2005-05-05
   * @return int
   * @author:gjw
   * @date:2005-07-11
   */
  public static int getDayCount(String strDate) {
    int nYear = 0;
    int nMonth = 0;
    int[] nDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //Ĭ�Ϸ�����
    if (strDate.length() > 7) {
      nYear = Integer.parseInt(strDate.substring(0, 4));
      nMonth = Integer.parseInt(strDate.substring(5, 7));
    }
    if ( (nYear % 4 == 0 && nYear % 100 != 0) || (nYear % 400 == 0)) { //�ж��Ƿ�������
      nDays[1] = 29;
    }
    for (int i = 0; i < nDays.length; i++) {
      if (nMonth == i + 1) {
        return nDays[i];
      }
    }
    return 0;
  }

  /**
   * ��ȡ��ǰ����
   * @param strDate String:2005-05-05
   * @return int
   * @author:gjw
   * @date:2005-07-11
   */
  public static int getCurrentDay(String strDate) {
    int nDay = 0;
    if (strDate.length() >=10) {
      nDay = Integer.parseInt(strDate.substring(8, 10));
    }
    return nDay;
  }

  /**
   * ���ص�ǰ����
   * @return  String
   * @author  hechangcheng
   */
  public static String getShortCurrentDate() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String dt = sdf.format(new Date());
    return dt;
  }

  /**���رȵ�ǰ��������������� */
  public static String getDay() {
      Date ndate = new Date();
      /**���칲 604800000 ����*/
      long currentdate = ndate.getTime() - 604800000 ;
      Date dd = new Date(currentdate);
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      String dt = sdf.format(dd);
      return dt ;
  }
  /**
   * ���رȵ�ǰ����һ�������
   * @return String
   */
  public static String getPreviouseDate(){
      Date ndate = new Date();
      /**һ�칲86400 ����*/
      long currentdate = ndate.getTime() - 86400 ;
      Date dd = new Date(currentdate);
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      String dt = sdf.format(dd);
      return dt ;

  }

  /**
   * 返回前一天
   * @param fomat
   * @return
   */
  public static String getPreviouseDate(String fomat){
    Date ndate = new Date();
    /**һ�칲86400 ����*/
    long currentdate = ndate.getTime() - 86400000 ;
    Date dd = new Date(currentdate);
    SimpleDateFormat sdf = new SimpleDateFormat(fomat);
    String dt = sdf.format(dd);
    return dt ;

}  
  
public static Date getDateSFomate(String param) {
   Date date = null;
   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
   try {
    date = sdf.parse(param);
   }
   catch (ParseException ex) {
   }
    return date;
 }

public static int getYear() {
	Calendar cal = Calendar.getInstance();
	return cal.get(Calendar.YEAR);
}



public static String getNl(String date) {
	if(date==null || date.trim()==null){
		return "";
	}
	if(date.length()>=10){
		return date.substring(2,4)+"."+date.substring(5,7);
	}
	return "";
}

/**
 * 时间段判断
 * @param String dateBegin 时间段开始时间
 * @param String dateEnd   时间段结束时间
 * @param Date   dateNow   一般传入当前时间
 * @return 传入时间在时间段内则返回 true
 */
public static boolean chkExpireDays(String dateBegin, String dateEnd,Date dateNow) {
	if((dateBegin!=null && !"".equals(dateBegin)) && (dateEnd!=null && !"".equals(dateEnd))){
		long lDaysBegin=getDateFomate(dateBegin).getTime();
		long lDaysEnd=getDateFomate(dateEnd).getTime();
		long lDaysNow=dateNow.getTime();
		return lDaysNow>=lDaysBegin && lDaysNow<=lDaysEnd ;
	}else{
		return false;
	}
}
/**
 * 获取从多少年份开始的年份集合
 * @param beginyear
 * @return
 */

public static List getYearList(int beginyear) {
	Calendar cal = Calendar.getInstance();
	int nowyear=cal.get(Calendar.YEAR);
	int num=nowyear-beginyear+1;
	List<String> list=new ArrayList<String>();
	for(int i=0;i<num;i++){
		list.add(String.valueOf(nowyear-i));
	}
	return list;
}

 public static void main(String[] agrs){
//    Date ds=DateTimeUtil.getDateSFomate("20051212");
//    DateTimeUtil.getDateTime("yyyy-MM-dd HH:mm:ss");
//	 Date date=DateTimeUtil.getShortDates("2008/05/16");
//	 if(date.after(new Date())){
  }
}
