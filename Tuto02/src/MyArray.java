import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyArray {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"Jane", "Tom", "Bob"};
        Character[] charArray = {'a', 'b', 'c'};

        listAll(intArray, strArray, charArray);

    }

    public static <T> void listAll(T[]... arrays) {
        for (T[] array : arrays) {
            for (T element : array) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}

