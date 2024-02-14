package by.ustsinovich.perseptron.utils;

import java.util.List;
import java.util.Random;

public class PerseptronUtils {
    private static final Random RANDOM = new Random();

    public static <E> void runForRandomItem(List<E> list, Action<E> action) {
        action.run(list.get(RANDOM.nextInt(list.size())));
    }

    public interface Action<E> {
        void run(E item);
    }
}
