package view;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class Main extends Application {

	public static void redirect(String file,ActionEvent event) {
		try {
			Main m = new Main();
			m.r(file,event);}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	public void r(String file, ActionEvent event) throws IOException {
		Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource(file));

		Scene scene = new Scene(root,600,600);

		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}



	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("browse.fxml"));
			Scene scene = new Scene(root,400,200);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			//primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
