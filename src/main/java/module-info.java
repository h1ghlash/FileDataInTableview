module com.example.kekl {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kekl to javafx.fxml;
    exports com.example.kekl;
}