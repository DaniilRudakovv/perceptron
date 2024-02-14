package by.ustsinovich.perceptron.view;

import javafx.scene.control.TextField;

public class MainView {
    private TextField cTest;
    private TextField hTest;
    private TextField tTest;

    public MainView(TextField tfCTest, TextField tfHTest, TextField tfTTest) {
        this.cTest = tfCTest;
        this.hTest = tfHTest;
        this.tTest = tfTTest;
    }

    public void update(boolean isC, boolean isT, boolean isH) {
        if (isC) {
            cTest.setText("Is C letter");
        } else {
            cTest.setText("Is not C letter");
        }

        if (isT) {
            tTest.setText("Is T letter");
        } else {
            tTest.setText("Is not T letter");
        }

        if (isH) {
            hTest.setText("Is H letter");
        } else {
            hTest.setText("Is not H letter");
        }
    }
}
