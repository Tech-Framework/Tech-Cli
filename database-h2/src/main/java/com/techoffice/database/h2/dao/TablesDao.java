package com.techoffice.database.h2.dao;

import java.util.List;

import com.techoffice.database.h2.model.Tables;
import com.techoffice.database.h2.util.H2DaoUtil;

public class TablesDao {

	static TablesDao instance;
	
	public static TablesDao getInstance(){
		if (instance == null){
			instance = new TablesDao();
		}
		return instance;
	}
	
	public List<Tables> getTableList() {
		return H2DaoUtil.list(Tables.class, TablesDao.class, 
				"SELECT * FROM INFORMATION_SCHEMA.TABLES");
	}

}
