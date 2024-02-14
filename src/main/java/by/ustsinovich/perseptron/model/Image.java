package by.ustsinovich.perseptron.model;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

import static by.ustsinovich.perseptron.utils.ImageUtils.imageToPixelArray;

public class Image {
    private final int[] pixelArray;
    private final boolean isTargetImage;

    public Image(String fileName, boolean isTargetImage) throws IOException {
        this.pixelArray = imageToPixelArray(fileName);
        this.isTargetImage = isTargetImage;
    }

    public int calculateWeightSum(int[] weights) {
        return IntStream.range(0, weights.length).map(i -> weights[i] * pixelArray[i]).sum();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Image other)) {
            return false;
        }
        return isTargetImage == other.isTargetImage && Arrays.equals(pixelArray, other.pixelArray);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(pixelArray) * 31 + Boolean.hashCode(isTargetImage);
    }

    public int[] getPixelArray() {
        return pixelArray;
    }

    public boolean isTargetImage() {
        return isTargetImage;
    }
}