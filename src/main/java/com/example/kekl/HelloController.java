package com.example.kekl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.File;
import java.util.List;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class HelloController implements Initializable {

    @FXML
    private TableView<Person> Table1;

    @FXML
    private TableColumn<Person, String> firstNameCol;

    @FXML
    private TableColumn<Person, String> lastNameCol;

    @FXML
    private TextField textField;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(textField.getText())));
            String line;
            String[] array;

            while ((line = br.readLine()) != null){
                array = line.split(" ");
                Table1.getItems().add(new Person(array[0],array[1]));
            }

            br.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    public void ClearTable(ActionEvent event) {
        Table1.getItems().clear();
    }

    @FXML
    public void handle(ActionEvent event) {
        final FileChooser fileChooser = new FileChooser();
        textField.clear();
        List<File> files = fileChooser.showOpenMultipleDialog(null);
        if (files == null || files.isEmpty()) {
            return;
        }
        for (File file : files) {
            textField.appendText(file.getAbsolutePath() + "\n");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<>("firstName")
        );
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<>("lastName")
        );

    }
}