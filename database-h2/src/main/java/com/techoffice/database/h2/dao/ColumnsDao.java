package com.techoffice.database.h2.dao;

import java.util.List;

import com.techoffice.database.dao.BaseDao;
import com.techoffice.database.h2.connection.H2DatabaseConnection;
import com.techoffice.database.h2.model.Columns;
import com.techoffice.database.h2.util.H2DaoUtil;

public class ColumnsDao extends BaseDao<Columns>{
	
	static ColumnsDao instance;
	
	public static ColumnsDao getInstance(){
		instance = new ColumnsDao();
		return instance;
	}
	
	public List<Columns> getColumnsList(String tableName) {
		return H2DaoUtil.list(Columns.class, ColumnsDao.class, 
				"SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '" + tableName + "'");
	}

	@Override
	public Class<H2DatabaseConnection> getDatabaseConnectionClass() {
		return H2DatabaseConnection.class;
	}

	@Override
	public Class<Columns> getInstanceClass() {
		return Columns.class;
	}
	
}
