public class Duo <A,B> {
    A first;
    B second;

    public Duo(A first, B second) {
        this.first = first;
        this.second = second;
    }
}

class tester{
    Duo <String,Integer> sideShape = new Duo<>("Square",4);
    Duo <Double, Double> points = new Duo<>(3.4,2.2);
}