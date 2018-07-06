package com.techoffice.database.dao.config;

import com.techoffice.database.dao.EntityDao;
import com.techoffice.database.dao.connection.DatabaseConnection;
import com.techoffice.database.dao.registry.DatabaseConnectionRegistry;
import com.techoffice.database.dao.registry.EntityDaoRegistry;

public abstract class BaseConfig {
	
	public abstract EntityDao getEntityDao();
	public abstract DatabaseConnection getDatabaseConnection();
	
	public BaseConfig(){
		DatabaseConnectionRegistry.add(getDatabaseConnection().getClass(), getDatabaseConnection());
		EntityDaoRegistry.add(this.getEntityDao().getClass(), this.getEntityDao());
	}
}
