package com.techoffice.database.h2.dao;

import java.util.List;

import com.techoffice.database.h2.model.Columns;
import com.techoffice.database.h2.util.H2DaoUtil;

public class ColumnsDao {
	
	static ColumnsDao instance;
	
	public static ColumnsDao getInstance(){
		instance = new ColumnsDao();
		return instance;
	}
	
	public List<Columns> getColumnsList(String tableName) {
		return H2DaoUtil.list(Columns.class, ColumnsDao.class, 
				"SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '" + tableName + "'");
	}

	
}
