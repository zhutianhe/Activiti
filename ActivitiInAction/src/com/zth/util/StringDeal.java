package com.zth.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 类描述: 有关处理字符串的类
 * 
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class StringDeal {
	
	/**
	 * 转换成ISO8859_1
	 */
	public static String getsub(String str)
	{
		try {
			return new String(str.getBytes("GBK"), "ISO8859_1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 判断字符串有几个汉字
	 * @param str
	 * @return
	 */
	public static int panHan(String str)
	{ 
		if("".equals(Convert.trimNull(str)))
		{
			return 0;
		}
		Matcher m=null;
		String temp=str;
		int temp2=0;
		for(int i=0;i<str.length();i++)
		{
			temp=str.substring(i,i+1);
			m=Pattern.compile("[\u4e00-\u9fa5]").matcher(temp); 
			while(m.find())
			{
				temp2++;
			}
		}
		return temp2;
		
	}
	/**
	 * 转换成gbk
	 */
	public static String upsub(String str)
	{
		try {
			return new String(str.getBytes("ISO8859_1"), "GBK");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 获取字符串单字节长度
	 * @param str
	 * @return
	 */
	public static int getStrLen(String str){
		if(str==null || "".equals(str)){
			return 0;
		}
		return getsub(str).length();
	}
	
	/**
	 * 截取固定长度的字符串(区分了单字节和双字节)
	 * @param str
	 * @param size 双字节长度值，比如：截取6个汉字的长度则是传入参数6
	 * @return
	 */
	public static String realString(String str,int size)
	{
		if(str==null || "".equals(str)){
			return "";
		}
		String realstring="";
		byte[] b=null;
		int count=0;
		if(getsub(str).length()>size*2)
		{
			for(int i=0;i<str.length();i++)
			{
				b=str.substring(i,i+1).getBytes();
				if(b.length==2)
					count=count+2;
				else
					count=count+1;
				if(count==size*2)
				{
					realstring=upsub(getsub(str).substring(0,size*2))+"..";
					break;
				}
				else
				{
					realstring=upsub(getsub(str).substring(0,size*2-1))+"..";
				}
			}
		}
		else
		{
			realstring=str;
		}
		return realstring;
	}
	
	
	/**
	 * 保持原格式，还原换行符和空格
	 * @param chr
	 * @return
	 */
	public static String htmltotext(String chr)
    {
	    if(chr==null)
	    return "";
	    
	    chr=chr.replaceAll("<br/>","\r");
	    chr=chr.replaceAll("&nbsp;"," ");
	    chr=chr.replaceAll("<br>", "\r");
	    return(chr);
    }
	
	/**
	 * 清除html格式
	 * @param str
	 * @return
	 */
	public static String cleanhtml(String str)
	{
		str=str.replaceAll("&nbsp;", " ");
		return str.replaceAll("<[^>]*>","");
	}
	/**
	 * 字数大于900个的加1500个空格(处理hibernate2的bug)
	 * @param str
	 * @return
	 */
	public static String addSpance(String str)
	{
		if(str!=null && !"".equals(str))
		{
			if(str.length()>900)
	        {
	        	String blank="                                                  ";
	        	StringBuffer allblank=new StringBuffer();
	            for(int i=0;i<30;i++)
	            {
	            	allblank.append(blank);
	            }
	            str=str+allblank;
	        }
		}
		return str;
	}
	/**
	 * 判读是否是纯数字
	 * @param str
	 * @return
	 */
	public static boolean isint(String str)
	{
		try{
			Integer.parseInt(str);
			return true;
		}catch(NumberFormatException ex){
			return false;
		}
	}
	
	
	
	public static String substring(String str, int start, int end) {
        if (str == null) {
            return null;
        }

        if (end < 0) {
            end = str.length() + end; // remember end is negative
        }
        if (start < 0) {
            start = str.length() + start; // remember start is negative
        }

        if (end > str.length()) {
            end = str.length();
        }

        if (start > end) {
            return "";
        }

        if (start < 0) {
            start = 0;
        }
        if (end < 0) {
            end = 0;
        }
        return str.substring(start, end);
    }

	/**
	 * 截取两个字符串之间的字符串
	 * @param str
	 * @param open
	 * @param close
	 * @return
	 */
    public static String substringBetween(String str, String open, String close) {
        if (str == null || open == null || close == null) {
            return null;
        }
        int start = str.indexOf(open);
        if (start != -1) {
            int end = str.indexOf(close, start + open.length());
            if (end != -1) {
                return str.substring(start + open.length(), end);
            }
        }
        return null;
    }

    /**
     * String数组去重复
     * @param a
     * @return
     */
    
	public static String[] arrayUnique(String[] a) {
    	String[] b=a;
    	if(a!=null && a.length>1){
        List list = new ArrayList();
	        for(int i = 0; i < a.length; i++) {
	            if(!list.contains(a[i])) {
	                list.add(a[i]);
	            }
	        }
	        b=(String[])list.toArray(new String[list.size()]);
    	}
        return b;
    }
    /**
     * 判断字符数组元素是否为空(同时防止报出数组越界的异常)
     * @param keyword  String数组
     * @param index    要判断的下标
     * @return 为空或数组越界返回false;不为空返回true.
     */
    public static boolean panStrArryNull(String[] keyword,int index){
    	if(keyword.length>index && keyword[index]!=null && !"null".equals(Convert.trimNull(keyword[index])) && !"".equals(Convert.trimNull(keyword[index]))){
    		return true;
    	}else{
    		return false;
    	}
    }
    /**
     * 判断对象数组元素是否为空，并返回它的值，防止数组越界
     * @param keyword Object对象数组
     * @param index   下标
     * @return
     */
    public static Object objArryIndex(Object[] keyword,int index){
    	if(panObjArryNull(keyword,index)){
    		return (Object)keyword[index];
    	}else{
    		return null;
    	}
    }
    
    /**
     * 判断对象数组元素是否为空(同时防止报出数组越界的异常)
     * @param keyword  对象数组
     * @param index    要判断的下标
     * @return
     */
    public static boolean panObjArryNull(Object[] keyword,int index){
    	if(keyword.length>index && keyword[index]!=null && !"null".equals(keyword[index]) && !"".equals(keyword[index])){
    		return true;
    	}else{
    		return false;
    	}
    }
    /**
     * 判断字符是否为空
     * @param strObj
     * @return 为空返回false;不为空返回true.
     */
    public static boolean panStrNull(String strObj){
    	if(strObj!=null && !"".equals(Convert.trimNull(strObj)) && !"null".equals(Convert.trimNull(strObj)) && !"undefined".equals(Convert.trimNull(strObj))){
    		return true;
    	}else{
    		return false;
    	}
    }
    
   
    /**
     * 判断是否是正整数(包括0) 没有考虑负数、小数
     * @param str
     * @return
     */
    public static boolean isNumeric(String str)
    {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ) {
           return false;
        }
        return true;
    }
    /**
     * 获取指定位数的整型随机数
     * @param size
     * @return
     */
    public static String customRandom(int size){
    	String radstr="";
		for(int j=0;j<size;j++){
			int tem=(int)((9 - 0 + 1) * Math.random() + 0);
			radstr+=String.valueOf(tem);
		}
		return radstr;
    }
    
    public static void main(String[] args) {
	}

}