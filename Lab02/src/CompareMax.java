public class CompareMax {

    public static <T extends Comparable> T maximum(T x, T y, T z){
        T max = x;
        if(y.compareTo(max)>0){
            max = y;
        }
        if(z.compareTo(max)>0){
            max = z;
        }
        return max;
    }

    public static void main(String[] args) {
        int maxInt = maximum(3,6,4);
        System.out.println("Max integer: "+maxInt);

        double maxDouble = maximum(3.5, 7.2, 1.8);
        System.out.println("Max double: " + maxDouble);

        String maxString = maximum("apple", "banana", "orange");
        System.out.println("Max string: " + maxString);
    }
}

