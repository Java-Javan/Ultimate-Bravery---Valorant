module com.example.randvalteam {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.randvalteam to javafx.fxml;
    exports com.example.randvalteam;
}