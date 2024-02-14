package by.ustsinovich.perseptron.controller;

import by.ustsinovich.perseptron.model.Image;
import by.ustsinovich.perseptron.perseptron.Perseptron;
import by.ustsinovich.perseptron.utils.ImageUtils;
import by.ustsinovich.perseptron.view.MainView;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    public TextField tfCTest;
    public TextField tfTTest;
    public TextField tfHTest;

    public void onBtnRunAction(ActionEvent event) throws IOException {
        List<Image> c1Images = ImageUtils.createImages("./src/main/resources/by/ustsinovich/perseptron/train/0", true);
        List<Image> h1Images = ImageUtils.createImages("./src/main/resources/by/ustsinovich/perseptron/train/1", false);
        List<Image> t1Images = ImageUtils.createImages("./src/main/resources/by/ustsinovich/perseptron/train/2", false);
        List<Image> c2Images = ImageUtils.createImages("./src/main/resources/by/ustsinovich/perseptron/train/0", false);
        List<Image> h2Images = ImageUtils.createImages("./src/main/resources/by/ustsinovich/perseptron/train/1", true);
        List<Image> t2Images = ImageUtils.createImages("./src/main/resources/by/ustsinovich/perseptron/train/2", false);
        List<Image> c3Images = ImageUtils.createImages("./src/main/resources/by/ustsinovich/perseptron/train/0", false);
        List<Image> h3Images = ImageUtils.createImages("./src/main/resources/by/ustsinovich/perseptron/train/1", false);
        List<Image> t3Images = ImageUtils.createImages("./src/main/resources/by/ustsinovich/perseptron/train/2", true);

        List<Image> cImages = new ArrayList<>();
        cImages.addAll(c1Images);
        cImages.addAll(h1Images);
        cImages.addAll(t1Images);

        List<Image> hImages = new ArrayList<>();
        hImages.addAll(c2Images);
        hImages.addAll(h2Images);
        hImages.addAll(t2Images);

        List<Image> tImages = new ArrayList<>();
        tImages.addAll(c3Images);
        tImages.addAll(h3Images);
        tImages.addAll(t3Images);

        Perseptron perceptron1 = new Perseptron(36, 1000);
        Perseptron perceptron2 = new Perseptron(36, 1000);
        Perseptron perceptron3 = new Perseptron(36, 1000);

        perceptron1.train(cImages);

        perceptron2.train(hImages);

        perceptron3.train(tImages);

        MainView view = new MainView(tfCTest, tfHTest, tfTTest);

        boolean isC = perceptron1.isTargetImage(new Image("./src/main/resources/by/ustsinovich/perseptron/test/c-test.jpg", true));
        boolean isH = perceptron2.isTargetImage(new Image("./src/main/resources/by/ustsinovich/perseptron/test/h-test.jpg", true));
        boolean isT = perceptron3.isTargetImage(new Image("./src/main/resources/by/ustsinovich/perseptron/test/t-test.jpg", true));

        view.update(isC, isT, isH);
    }
}