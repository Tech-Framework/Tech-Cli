package com.techoffice.generator.mybatis.h2fx;

import java.util.List;

import com.techoffice.database.h2.config.H2Config;
import com.techoffice.database.h2.dao.TablesDao;
import com.techoffice.database.h2.model.Tables;

public class Test {

	public static void main(String[] args){
		new H2Config();
		List<Tables> tablesList = (new TablesDao()).getTableList();
		for (Tables tables: tablesList){
			System.out.println(tables.getTableName());
		}
	}
}
