package by.ustsinovich.perceptron.perceptron;

import by.ustsinovich.perceptron.model.Image;
import by.ustsinovich.perceptron.utils.PerceptronUtils;

import java.util.List;

public class Perceptron {
    private final int[] weights;
    private final int iterationCount;

    public Perceptron(int imagePixelCount, int iterationCount) {
        this.weights = new int[imagePixelCount];
        this.iterationCount = iterationCount;
    }

    public void train(List<Image> trainingSet) {
        for (int i = 0; i < iterationCount - 1; i++) {
            PerceptronUtils.runForRandomItem(trainingSet, image -> {
                boolean isTargetImage = isTargetImage(image);
                if (image.isTargetImage() != isTargetImage) {
                    if (image.isTargetImage()) {
                        praise(image);
                    } else {
                        punish(image);
                    }
                }
            });
        }
    }

    private void punish(Image image) {
        for (int i = 0; i < weights.length; i++) {
            if (image.getPixelArray()[i] == 1) {
                weights[i]--;
            }
        }
    }

    private void praise(Image image) {
        for (int i = 0; i < weights.length; i++) {
            if (image.getPixelArray()[i] == 1) {
                weights[i]++;
            }
        }
    }

    public boolean isTargetImage(Image image) {
        return image.calculateWeightSum(weights) >= 0;
    }
}
