package com.zth.util;
import javax.sql.DataSource;
public class InitDataSource {
   private DataSource dataSource ;

    public DataSource getDataSource() {
    	return dataSource;
    }
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
