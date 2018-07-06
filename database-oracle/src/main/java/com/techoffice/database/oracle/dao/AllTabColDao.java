package com.techoffice.database.oracle.dao;

import java.util.List;

import com.techoffice.database.oracle.model.AllTabCol;
import com.techoffice.database.oracle.util.OracleDaoUtil;

public class AllTabColDao {

	public List<AllTabCol> getTableColumnList(String tableName){
		return OracleDaoUtil.list(AllTabCol.class, this.getClass(),
				"SELECT * FROM ALL_TAB_COLS WHERE TABLE_NAME = '"+tableName+"'");
	}
		
}
