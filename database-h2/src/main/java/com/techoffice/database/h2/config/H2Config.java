package com.techoffice.database.h2.config;

import java.util.Properties;

import com.techoffice.database.dao.EntityDao;
import com.techoffice.database.dao.config.ApplicationConfig;
import com.techoffice.database.dao.config.BaseConfig;
import com.techoffice.database.dao.config.annoation.JdbcTypeMapping;
import com.techoffice.database.dao.config.annoation.JdbcTypeMappings;
import com.techoffice.database.dao.connection.DatabaseConnection;
import com.techoffice.database.h2.dao.H2EntityDao;

@JdbcTypeMappings({
	@JdbcTypeMapping(value = "DECIMAL", javaFullType = "java.lang.Integer", condition = "field.scale == 0"),
	@JdbcTypeMapping(value = "DECIMAL", javaFullType = "java.math.BigDecimal", condition="field.scale != 0"),
	@JdbcTypeMapping(value = "VARCHAR", javaFullType="java.lang.String"),
	@JdbcTypeMapping(value = "DATE", javaFullType = "java.util.Date")
})
public class H2Config extends BaseConfig{

	public static Properties prop = null;
    
	public static final String H2_CONNECTION_USER = "h2.connection.user";
	public static final String H2_CONNECTION_PASSWORD = "h2.connection.password";
	public static final String H2_CONNECTION_URL = "h2.connection.url";
	
	public static String getH2ConnectionUser(){
		return ApplicationConfig.getProperties().getProperty(H2_CONNECTION_USER, "");
	}
	
	public static String getH2ConnectionPassword(){
		return ApplicationConfig.getProperties().getProperty(H2_CONNECTION_PASSWORD, "");
	}
	
	public static String getH2ConnectionUrl(){
		return ApplicationConfig.getProperties().getProperty(H2_CONNECTION_URL, "");	
	}

	@Override
	public EntityDao getEntityDao() {
		return new H2EntityDao();
	}

	@Override
	public DatabaseConnection getDatabaseConnection() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
