package Lab05.SList;

public class TestSList {
    public static void main(String[] args) {
        SList<String> list = new SList<>();

        //1.
        list.appendEnd("Linked list");
        list.appendEnd("is");
        list.appendEnd("easy");

        //2.
        list.display();

        //3.
        System.out.println("Removed value: "+list.removeInitial());

        //4.
        System.out.println(list.contains("difficult"));

        //5.
        list.clear();
    }
}
