package com.techoffice.generator.mybatis.h2fx;

import java.io.InputStream;

import com.techoffice.database.h2.config.H2Config;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Appl extends Application{

	private static final String TITLE = "Tech Framework MyBatis Generator - JavaFx";
	
	@Override
	public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream applFxml = Appl.class.getClassLoader().getResourceAsStream("Tables.fxml");
        VBox root = (VBox) loader.load(applFxml);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle(TITLE);
        primaryStage.show();
	}
	
	public static void main(String[] args){
		new H2Config();
		launch(args);
	}

}