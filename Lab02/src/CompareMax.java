public class CompareMax {
    public static <T extends Comparable> T maximum(T a, T b, T c) {
        T max = a;
        if(b.compareTo(a)>0){
            max = b;
        }
        if(c.compareTo(a)>0){
            max = c;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Maximum value: "+ maximum(6,8,2));
    }
}