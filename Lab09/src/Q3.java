public class Q3 {
    public static void main(String[] args) {
        System.out.println(exponent(10, -3));
    }

    public static double exponent(double x, int y) {
        if (y == 0) {
            return 1;
        } else if (y < 0) {
            return 1 / (x * exponent(x, -y - 1));
//            return (1 / x) * exponent(x, y + 1));
        } else {
            return x * exponent(x, y - 1);
        }
    }
}

