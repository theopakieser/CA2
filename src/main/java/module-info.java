module com.example.ca2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires xstream;


    opens com.example.ca2 to javafx.fxml;
    exports com.example.ca2;
}