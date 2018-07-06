package com.techoffice.database.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.techoffice.database.dao.connection.DatabaseConnection;
import com.techoffice.database.dao.exception.DaoException;
import com.techoffice.database.dao.registry.DatabaseConnectionRegistry;
import com.techoffice.database.dao.util.DaoQueryCacheUtil;
import com.techoffice.database.dao.util.StringUtil;

public abstract class BaseDao<T> {

	public abstract Class<? extends DatabaseConnection> getDatabaseConnectionClass();
	public abstract Class<T> getInstanceClass();
	
	public List<T> list(String query){
		Map<String, List<?>> cache = DaoQueryCacheUtil.getCache(this.getClass());
		@SuppressWarnings("unchecked")
		List<T> resultList = (List<T>) cache.get(query);
		if (resultList == null ){
			resultList = listWithoutCache(query);
		}
		return resultList ;
	}
	
	private List<T> listWithoutCache(String query){
		List<T> resultList = new ArrayList<T>();
		try {
			DatabaseConnection conn = DatabaseConnectionRegistry.getDatabaseConnection(getDatabaseConnectionClass());
			Statement stmt = conn.getConnection().createStatement();
			ResultSet resultSet = stmt.executeQuery(query);
			while(resultSet.next()){
				ResultSetMetaData metaData = resultSet.getMetaData();
				int columnCount = metaData.getColumnCount();
				Class<T> instanceClazz = getInstanceClass();
				T obj = instanceClazz.newInstance();
				for (int i=0; i<columnCount; i++){
					try{
						String propertyName = StringUtil.upperUnderscoreToLowerCamel(metaData.getColumnName(i+1));
						if (resultSet.getObject(i+1) != null){
							BeanUtils.setProperty(obj, propertyName, resultSet.getObject(i+1));
						}
					}catch(Exception e){
						throw new DaoException(e);
					}
				}
				resultList.add(obj);
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}
		return resultList;
	}
}
