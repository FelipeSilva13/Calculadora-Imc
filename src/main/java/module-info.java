module com.example.calcimc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calcimc to javafx.fxml;
    exports com.example.calcimc;
}