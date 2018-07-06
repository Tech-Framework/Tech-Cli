package com.techoffice.database.oracle.dao;

import java.util.List;

import com.techoffice.database.oracle.model.AllObject;
import com.techoffice.database.oracle.util.OracleDaoUtil;

public class AllObjectDao {

	public List<AllObject> getAllPackageObject() {
		return OracleDaoUtil.list(AllObject.class, this.getClass(),
				"SELECT * FROM ALL_OBJECTS WHERE OBJECT_TYPE = 'PACKAGE'");
	}
	
}
