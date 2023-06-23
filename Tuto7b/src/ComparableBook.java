import java.util.Comparator;
import java.util.Queue;

class TestComparableBook {
    public static void main(String[] args) {
        Queue<ComparableBook> BookQueue = new java.util.PriorityQueue<>();
        BookQueue.add(new ComparableBook(1065, "Effective Java: Third Edition"));
        BookQueue.add(new ComparableBook(3012, "Java: A Beginner Guide Seventh Edition"));
        BookQueue.add(new ComparableBook(1097, "Learn Java in One Day and Learn It Well"));
        BookQueue.add(new ComparableBook(7063, "Beginning Programming with Java (Dummies)"));
        BookQueue.add(new ComparableBook(6481, "Java: Programming Basic for Absolute Beginner"));
        System.out.println(BookQueue);
        while (BookQueue.peek() != null) {
            System.out.println("Head Element: " + BookQueue.peek());
            BookQueue.remove();
            System.out.println("Priority queue: " + BookQueue);
        }
    }
}

public class ComparableBook implements Comparable<ComparableBook> {
    private int id;
    private String name;

    public ComparableBook() {

    }

    public ComparableBook(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int compareTo(ComparableBook o) {
        return Integer.compare(this.id, o.id);
    }

    @Override
    public String toString() {
        return "Book " + Integer.toString(this.id) + " \"" + this.name + " \"";
    }
}


