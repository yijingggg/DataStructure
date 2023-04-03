public class StorePairGeneric<T extends Comparable<T>> implements Comparable<StorePairGeneric<T>> {
    private T first, second;

    public StorePairGeneric(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setPair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public boolean equals(StorePairGeneric<T> o) {
        if (first.equals(o.getFirst())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(StorePairGeneric<T> other) {
        return this.first.compareTo(other.first);
    }

    @Override
    public String toString() {
        return "first = " + first.toString() + " second = " + second.toString();
    }
}

class testStorePairGeneric {
    public static void main(String[] args) {
        StorePairGeneric<Integer> a = new StorePairGeneric<>(6, 4);
        StorePairGeneric<Integer> b = new StorePairGeneric<>(2, 2);
        StorePairGeneric<Integer> c = new StorePairGeneric<>(6, 3);

        // Compare first values of a and b using compareTo() and equals() method
        if (a.compareTo(b) > 0) {
            System.out.println("a is greater than b");
        } else if (a.compareTo(b) < 0) {
            System.out.println("a is less than b");
        } else if (a.equals(b)) {
            System.out.println("a and b are equal");
        }

        // Compare first values of a and c using compareTo() and equals() method
        if (a.compareTo(c) > 0) {
            System.out.println("a is greater than c");
        } else if (a.compareTo(c) < 0) {
            System.out.println("a is less than c");
        } else if (a.equals(c)) {
            System.out.println("a and c are equal");
        }

        // Compare first values of b and c using compareTo() and equals() method
        if (b.compareTo(c) > 0) {
            System.out.println("b is greater than c");
        } else if (b.compareTo(c) < 0) {
            System.out.println("b is less than c");
        } else if (b.equals(c)) {
            System.out.println("b and c are equal");
        }


    }
}