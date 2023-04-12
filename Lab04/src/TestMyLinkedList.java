public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Character> list= new MyLinkedList<>();

        //a.
        for(char c ='a'; c<='e'; c++){
            list.addLast(c);
        }

        //b.
        list.print();

        //c.
        list.reverse();

        //d.
        int size = list.lastIndexOf(list.getLast());
        System.out.println(size);

        //e.
        System.out.println("First value: "+list.getFirst());
        System.out.println("Last value: "+list.getLast());

        //f.
        list.remove(3);

        //g.
        System.out.println("Second value: "+list.get(1));
        System.out.println("Third value: "+list.get(2));

        //h.
        list.contains('c');

        //i.
        list.set(0,'j');
        list.set(1,'a');
        list.set(2,'v');
        list.set(3,'a');
    }
}
