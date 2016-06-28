package com.zth.main.cache;

import javax.servlet.ServletContext;


/**
 * 基础数据加载
 * @author gaofuqiang
 *
 */
public class WebInitLoader{
	
     
   
	/**	
	 * 单服务器加载所有上下文数据
	 * @param servletContext
	 */
	public static void reloadAllParam(ServletContext servletContext) throws Exception{
			System.out.println("开始加载内存数据…,内存初始值："+(Runtime.getRuntime().maxMemory()-Runtime.getRuntime().totalMemory()+Runtime.getRuntime().freeMemory())/(1024*1024)+"M");
			
//			ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext );
	       		
	           
//			WebInitLoader initLoader = new WebInitLoader(ctx);
			System.out.println("加载完毕！内存占用值："+(Runtime.getRuntime().maxMemory()-Runtime.getRuntime().totalMemory()+Runtime.getRuntime().freeMemory())/(1024*1024)+"M");
	}
}
