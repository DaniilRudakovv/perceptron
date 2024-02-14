module by.ustsinovich.perseptron {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens by.ustsinovich.perseptron to javafx.fxml;
    exports by.ustsinovich.perseptron;
    exports by.ustsinovich.perseptron.controller;
    opens by.ustsinovich.perseptron.controller to javafx.fxml;
}