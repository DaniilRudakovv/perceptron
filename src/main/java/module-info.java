module by.ustsinovich.perseptron {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens by.ustsinovich.perceptron to javafx.fxml;
    exports by.ustsinovich.perceptron;
    exports by.ustsinovich.perceptron.controller;
    opens by.ustsinovich.perceptron.controller to javafx.fxml;
}