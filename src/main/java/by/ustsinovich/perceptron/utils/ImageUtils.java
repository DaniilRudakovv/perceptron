package by.ustsinovich.perceptron.utils;

import by.ustsinovich.perceptron.model.Image;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ImageUtils {
    public static int[] imageToPixelArray(String fileName) throws IOException {
        File file = new File(fileName);
        BufferedImage image = ImageIO.read(file);
        int[] pixels = new int[image.getWidth() * image.getHeight()];
        for (int i = 0; i < pixels.length; i++) {
            int x = i % image.getWidth();
            int y = i / image.getWidth();
            pixels[i] = (image.getRGB(x, y) == 0xFFFFFFFF) ? 0 : 1;
        }
        return pixels;
    }

    public static List<Image> createImages(String path, boolean isTarget) throws IOException {
        List<Image> images = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            images.add(new Image(path + i + ".jpg", isTarget));
        }
        return images;
    }
}
