class FindMax {
    public static void main(String[] args) {

        Integer[] intArray = {1, 2, 3};
        String[] strArray = {"red", "green", "blue"};
        Circle[] circleArray = {new Circle(3), new Circle(2.9), new Circle(5.9)};

        System.out.println("Max integer value: " + max(intArray));
        System.out.println("Max string value: " + max(strArray));
        System.out.println("Max circle radius: " + max(circleArray).getRadius());
    }


    public static <E extends Comparable<E>> E max(E[] list) {
        E max = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i].compareTo(max) > 0) {
                max = list[i];
            }
        }
        return max;
    }
}

public class Circle implements Comparable<Circle> {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public int compareTo(Circle other) {
        if (this.radius > other.getRadius()) {
            return 1;
        } else if (this.radius < other.getRadius()) {
            return -1;
        } else {
            return 0;
        }
    }
}

