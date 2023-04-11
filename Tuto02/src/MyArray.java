public class MyArray {

    public static <T> void listAll(T[]... arrays) {
        for (T[] array : arrays) {
            for (T item : array) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"Jane", "Tom", "Bob"};
        Character[] charArray = {'a', 'b', 'c'};

        listAll(intArray, strArray, charArray);
    }
}