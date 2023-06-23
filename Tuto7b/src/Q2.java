import java.util.PriorityQueue;

public class Q2 {
    public static void main(String[] args) {
        PriorityQueue<String> pq1 = new PriorityQueue<>();
        PriorityQueue<String> pq2 = new PriorityQueue<>();
        String[] arr1 = {"George", "Jim", "John", "Blake", "Kevin", "Michael"};
        String[] arr2 = {"George", "Katie", "Kevin", "Michelle", "Ryan"};

        for (String s : arr1) pq1.add(s);
        for (String s : arr2) pq2.add(s);

        System.out.println("Priority Queue 1: " + pq1.toString());
        System.out.println("Priority Queue 2: " + pq2.toString());

        //union
        System.out.println("Union:");
        PriorityQueue<String> union = new PriorityQueue<>(pq1);
        for (String s : pq2)
            if (!union.contains(s)) union.add(s);
        System.out.println(union);

        //difference
        System.out.println("Difference:");
        PriorityQueue<String> diff = new PriorityQueue<>(pq1);
        for (String s : pq2)
            if (diff.contains(s)) diff.remove(s);
        System.out.println(diff);

        //intersection
        System.out.println("Intersection");
        PriorityQueue<String> intersect = new PriorityQueue<>(pq1);
        for (Object element : intersect.toArray())
            if (!pq2.contains(element)) intersect.remove(element);
        System.out.println(intersect);
    }
}
