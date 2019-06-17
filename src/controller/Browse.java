package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import view.Main;

import java.io.File;

public class Browse {

    @FXML
    private TextField path;

    @FXML
    private AnchorPane anc;

    @FXML
    void browse(ActionEvent event) {
        final DirectoryChooser d = new DirectoryChooser();
        Stage stage = (Stage)anc.getScene().getWindow();
        File file = d.showDialog(stage);
        String p = file.getAbsolutePath();
        path.setText(p);
    }

    @FXML
    void start(ActionEvent event) {
        MainController.path = path.getText();
        Main.redirect("Main.fxml",event);

    }
}
