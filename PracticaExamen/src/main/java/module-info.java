module com.example.practicaexamen {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;



    opens com.example.practicaexamen to javafx.fxml;
    exports com.example.practicaexamen;
    opens com.example.practicaexamen.controller to javafx.fxml;
    exports com.example.practicaexamen.controller;
    opens com.example.practicaexamen.service to javafx.fxml;
    exports com.example.practicaexamen.service;
}