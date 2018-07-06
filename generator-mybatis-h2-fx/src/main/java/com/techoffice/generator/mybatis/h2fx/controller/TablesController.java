package com.techoffice.generator.mybatis.h2fx.controller;

import java.util.List;

import com.techoffice.database.dao.model.Entity;
import com.techoffice.database.h2.dao.H2EntityDao;
import com.techoffice.database.h2.dao.TablesDao;
import com.techoffice.database.h2.model.Tables;
import com.techoffice.generator.mybatis.MyBatisGenerator;
import com.techoffice.generator.mybatis.h2fx.util.AlertUtil;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class TablesController {
	
	@FXML
	private TableView<Tables> tableView;
	
	@FXML
	public void initialize(){
		ObservableList<Tables> list = tableView.getItems();
		List<Tables> tablesList = TablesDao.getInstance().getTableList();
		list.addAll(tablesList);
	}
	
    @FXML 
    public void generate(ActionEvent event) {
    	String tableName = tableView.getSelectionModel().getSelectedItem().getTableName();
    	try {
        	Entity entity = (new H2EntityDao()).getEntity(tableName);
        	MyBatisGenerator myBatisGenerator = new MyBatisGenerator();
        	myBatisGenerator .generate(entity);
        	AlertUtil.info(tableName + " generated");
    	}catch(Exception e){
        	AlertUtil.info(tableName + " failed to generate");
    	}
    }


}
