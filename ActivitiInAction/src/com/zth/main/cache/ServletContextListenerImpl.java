package com.zth.main.cache;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.zth.util.Constants;

public class ServletContextListenerImpl implements ServletContextListener {
    
	
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try { 
            /* web 启动 开始加载数据 */
            init(servletContextEvent.getServletContext());
            System.out.println("............................"+Constants.TITLE+"启动成功............................");
        } catch (Exception ex) {
        	ex.printStackTrace();
        	System.err.println("............................"+"启动失败!!!请检查数据库连接情况.............."); 
        }
    }
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
    
    private void init(ServletContext servletContext) throws Exception {
    	WebInitLoader.reloadAllParam(servletContext);
    }    
}
