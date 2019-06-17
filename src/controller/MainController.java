package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.util.Optional;

public class MainController {
    public static String path;
    static int i=0,j=0;
    static File folder;
    static File []files;
    static int index = 0;
    @FXML
    private ImageView img;

    @FXML
    private Label lbl;
    @FXML
    private Label lbl1;
    @FXML
    private GridPane grid;
    @FXML
    private Button newbtn;

    String getNewFolderName(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        TextField directoryName = new TextField();
        alert.getDialogPane().setContent(directoryName);
        Optional<ButtonType> choice = alert.showAndWait();
        if(choice.get() == ButtonType.OK){
            return directoryName.getText();
        }
        return null;
    }


    @FXML
    void newFolder(ActionEvent event) {
        String name = getNewFolderName();
        if(name == null)
            return;
        createDirec(name);
        moveFile(name,files[index]);
        addBtn(name);
        index++;
        showImg();
    }

    Button addBtn(String name){
        if(j++ > 5){
            i++;
            j = 0;
        }
        Button btn = new Button(name);
        btn.setPrefHeight(newbtn.getPrefHeight());
        btn.setPrefWidth(newbtn.getPrefWidth());
        grid.add(btn,j,i);
        btn.setOnAction(e -> press(name));
        return btn;
    }

    void createDirec(String name){
        File folder = new File(path+"/"+name);
        folder.mkdir();
    }

    void moveFile(String d,File f){
        File dir = new File(path+"/"+d);
        f.renameTo(new File(dir+"/"+f.getName()));
    }

    void press(String d){
        moveFile(d,files[index]);
        index++;
        showImg();
    }

    void showImg(){
        if(index == files.length){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Done!");
            alert.showAndWait();
            Stage stage = (Stage) newbtn.getScene().getWindow();
            stage.close();
            return;
        }
        System.out.println(files[i].getAbsolutePath());
        Image curr = new Image(files[index].toURI().toString());
        img.setImage(curr);
    }


    @FXML
    void initialize(){
        folder = new File(path);
        files = folder.listFiles();
        lbl.setText("You are in "+path);
        lbl1.setText("We found "+files.length+" files.");
        showImg();
    }
}
