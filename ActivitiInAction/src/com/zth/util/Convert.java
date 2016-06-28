package com.zth.util;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;



/**
 * 类描述: 转换类
 */
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class Convert {
	/**
	 * 避免NullPointerException发生 如果为null 返回空串，否则返回去掉空格的字符串
	 * 
	 * @param des
	 *            目标字符串
	 * @return
	 */
	public static String trimNull(String des) {
		try {
			if (des == null)
				return "";
			else
				return des.trim();
		} catch (NullPointerException npe) {
			return "";
		}
	}

	public static String trimNull(Object des) {
		try {
			if (des == null)
				return "";
			else
				return des.toString().trim();
		} catch (NullPointerException npe) {
			return "";
		}
	}    	
	
	public static String trim(String des) {
		try {
			if (des == null)
				return des;
			else
				return des.trim();
		} catch (NullPointerException npe) {
			return null;
		}
	}

	/**
	 * 将字符串转换成float，Null或空串为0
	 * 
	 * @param str
	 * @return
	 */
	public static float nullToFloat(String str) {
		float dblToReturn = 0;
		str = trimNull(str);
		if (!str.equals("")) {
			dblToReturn = Float.parseFloat(str);
		}
		return dblToReturn;
	}

	/**
	 * 将字符串转换成double，Null或空串为0.0
	 * 
	 * @param str
	 * @return
	 */
	public static double nullToDouble(String str) {
		double dblToReturn = 0.0;
		str = trimNull(str);
		if (!str.equals("")) {
			dblToReturn = Double.parseDouble(str);
		}
		return dblToReturn;
	}

	public static Double stringToDouble(String string) {
		if (string == null || string.equals("")) {
			string = "0";
		}
		return Double.valueOf(string);
	}

	public static String doubleToString(Double dbl) {
		return String.valueOf(dbl);
	}

	public static String doubleToString(double dbl) {
		return String.valueOf(dbl);
	}

	public static String stringToHtml(String str) {
		String strResult = "";
		int length = 0;
		if (str == null || str == "") {
			return "";
		} else {
			length = str.length();
			char[] chr = new char[length];
			str.getChars(0, length, chr, 0);
			for (int i = 0; i <= length - 1; i++) {
				switch (chr[i]) {
				case '<':
					strResult = strResult + "&lt;";
					break;
				case '>':
					strResult = strResult + "&gt;";
					break;
				/*
				 * case 10:屏蔽回车符号 strResult = strResult + "<br>"; break;
				 */
				case 13:
					strResult = strResult + "<br>";
					break;
				case 34:
					strResult = strResult + "&quot;";
					break;
				case '&':
					strResult = strResult + "&amp;";
					break;
				case ' ':
					strResult = strResult + "&nbsp;";
					break;

				case 9:
					strResult = strResult + "    ";
					break;
				default:
					strResult = strResult + String.valueOf(chr[i]);
				}
			}
		}
		return strResult;
	}

	public static String toGBK(String des) {
		try {
			if (des != null)
				return new String(new String(des).getBytes("iso-8859-1"), "GBK");
			return des;
		} catch (Exception uee) {
			return "erro";
		}
	}

	/**
	 * @param s
	 * @return String
	 */
	public static String replaceCtrlChar(String s, int length) {
		if (s == null) {
			return "";
		}
		StringBuffer rsb = new StringBuffer(s);
		int pos = 0;
		int pos1 = 0;
		while (rsb.indexOf("\r", pos) != -1) {
			pos1 = rsb.indexOf("\r", pos);
			rsb.replace(pos1, pos1 + 1, "\\r");
			pos = pos1 + 2;
		}
		pos = 0;
		while (rsb.indexOf("\n", pos) != -1) {
			pos1 = rsb.indexOf("\n", pos);
			rsb.replace(pos1, pos1 + 1, "\\n");
			pos = pos1 + 2;
		}
		pos = 0;
		while (rsb.indexOf("\t", pos) != -1) {
			pos1 = rsb.indexOf("\t", pos);
			rsb.replace(pos1, pos1 + 1, "\\t");
			pos = pos1 + 2;
		}
		pos = 0;
		while (rsb.indexOf("'", pos) != -1) {
			pos1 = rsb.indexOf("'", pos);
			rsb.replace(pos1, pos1 + 1, "\\'");
			pos = pos1 + 2;
		}
		String tem = rsb.toString();
		if (tem.length() > length) {
			return tem.substring(0, length) + "...";
		}
		return tem;
	}
	/**
     * @param s
     * @return String
     */
    public static String replaceCtrlChar(String s) {

        if (s == null) { return ""; }
        StringBuffer rsb = new StringBuffer(s);
        int pos = 0;
        int pos1 = 0;
        while (rsb.indexOf("\r", pos) != -1) {
            pos1 = rsb.indexOf("\r", pos);
            rsb.replace(pos1, pos1 + 1, "\\r");
            pos = pos1 + 2;
        }
        pos = 0;
        while (rsb.indexOf("\n", pos) != -1) {
            pos1 = rsb.indexOf("\n", pos);
            rsb.replace(pos1, pos1 + 1, "\\n");
            pos = pos1 + 2;
        }
        pos = 0;
        while (rsb.indexOf("\t", pos) != -1) {
            pos1 = rsb.indexOf("\t", pos);
            rsb.replace(pos1, pos1 + 1, "\\t");
            pos = pos1 + 2;
        }
        pos = 0;
        while (rsb.indexOf("'", pos) != -1) {
            pos1 = rsb.indexOf("'", pos);
            rsb.replace(pos1, pos1 + 1, "\\'");
            pos = pos1 + 2;
        }
        return rsb.toString();
    }
	public static double round(double data, int i) {
		String position = "1";
		for (int j = 0; j < i; j++) {
			position = position + "0";
		}
		int positiontmp = Integer.parseInt(position);
		data = data * positiontmp;
		BigDecimal deSource = new BigDecimal(data);
		int tmp = deSource.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
		data = Double.parseDouble(tmp + "") / positiontmp;
		return data;
	}
	
	public static Integer cvtToInt(String str){
		try{
			if(str==null || str.trim().equals("")){
				return null;
			}
			return new Integer(str.trim());
		}catch(Exception e){
			return null;
		}
	}
	
	
	public static String converMap(Map mapPara,String key) {
		try {
			if (mapPara == null){
				return "";
			}else if((String[])mapPara.get(key)!=null && ((String[])mapPara.get(key)).length!=0){
				return trimNull(((String[])mapPara.get(key))[0]);
			}else{
				return "";
			}
		} catch (NullPointerException npe) {
			return "";
		}
	}
	/**
	 * 将request.getParameter()所有参数封装成map
	 * @param request
	 * @return
	 */
	public static Map converReqMaps(HttpServletRequest request) {
		Map hashMap=new HashMap();
		try {
			Map reqmap=request.getParameterMap();
			Set entries = reqmap.entrySet();
			if(entries!=null)
			{
				Iterator iter = entries.iterator(); 
				while(iter.hasNext()) 
				{ 
					  Object value=null;
					  String key="";
				      Map.Entry entry = (Map.Entry)iter.next(); 
				      if(entry!=null)
				      {
					      key = (String)entry.getKey();
					      if(key!=null && !"".equals(key))
					      {
					    	  value = converMap(reqmap,key);
					      }
					      hashMap.put(key, value);
				      }
				}
			}
			//客户端ip
			String ip="";
			if(StringDeal.panStrNull(request.getRemoteAddr())){
				ip=request.getRemoteAddr();
			}
			hashMap.put("userIp", ip);
			//用户类型
			Map personInfoMap=(Map)request.getSession().getAttribute("personInfoMap"+Convert.trimNull(request.getParameter("userId")));
			if(personInfoMap!=null){
    			String userType=Convert.trimNull(personInfoMap.get("user_Type"));
                if(StringDeal.panStrNull(userType)){
                    hashMap.put("userType", userType);
                }
			}
			//模块ID
            String menuId="";
            if(StringDeal.panStrNull(request.getParameter("menuId"))){
                hashMap.put("menuId", Convert.trimNull(request.getParameter("menuId")));
            }
            //操作ID
            String oprateId="";
            if(StringDeal.panStrNull(request.getParameter("oprateId"))){
                hashMap.put("oprateId", Convert.trimNull(request.getParameter("oprateId")));
            }
            //页面条数
            if(StringDeal.panStrNull(request.getParameter("PageSize"))){
                hashMap.put("PageSize", request.getParameter("PageSize"));
            }
            //当前页
            if(StringDeal.panStrNull(request.getParameter("PageNum"))){
                hashMap.put("PageNum", request.getParameter("PageNum"));
            }
            //服务器IP
            String serverIp = getLocal().getHostAddress();
            hashMap.put("serverIp", serverIp);
            //服务器名称
            String serverName = getLocal().getHostName();
            hashMap.put("serverName", serverName);
			return hashMap;
		} catch (Exception npe) {
			return hashMap;
		}
	}
	
	public static boolean isLinux(ServletContext context) {
		String homePath = context.getRealPath("");
	    if (homePath.contains("/")) {
	    	return true;
	    } else {
	    	return false;
	    }
	}
	/**
	* 判断当前系统是否windows  
	*  
	* @return
	*/
	public static boolean isWindowsOS(){
    	boolean isWindowsOS = false;
    	String osName = System.getProperty("os.name");
    	if (osName.toLowerCase().indexOf("windows") > -1){
    	    isWindowsOS = true;
    	}
    	    return isWindowsOS;
	} 
	/**
	* 取当前系统站点本地地址 linux下 和 window下可用
	*  
	* @return
	*/
	public static InetAddress getLocal(){
	    InetAddress inetAddress = null;
    	try{
    	// 如果是Windows操作系统
        	if (isWindowsOS()){
        	    inetAddress = InetAddress.getLocalHost();
        	}else{// 如果是Linux操作系统
            	boolean bFindIP = false;
            	Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface.getNetworkInterfaces();
            	while (netInterfaces.hasMoreElements()){
                	if (bFindIP){
                	    break;
                	}
                	NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
                	// ----------特定情况，可以考虑用ni.getName判断
                	// 遍历所有InetAddress
                	Enumeration<InetAddress> ips = ni.getInetAddresses();
                	while (ips.hasMoreElements()){
                	    inetAddress = (InetAddress) ips.nextElement();
                         if (inetAddress.isSiteLocalAddress() && !inetAddress.isLoopbackAddress()&& inetAddress.getHostAddress().indexOf(":") == -1){// 127.开头的都是lookback地址
                        	     bFindIP = true;
                        	     return inetAddress;
                         }
                	}
        	    }
    	    }
    	}catch (Exception e){
    	}
        return inetAddress;
	} 
}
