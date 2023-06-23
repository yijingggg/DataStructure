package Lab05.SList;

public class SNode<E> {
    E e;
    SNode<E> prev;
    SNode<E> next;

    public SNode() {
        this(null, null, null);
    }

    public SNode(E e) {
        this(e, null, null);
    }

    public SNode(E e, SNode<E> next, SNode<E> prev) {
        this.e = e;
        this.prev = prev;
        this.next = next;
    }
}

class SList<E> {
    private SNode<E> head;
    private SNode<E> tail;
    private int size = 0;

    public void appendEnd(E e) {
        SNode<E> temp = new SNode<>(e);
        if (head == null) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
    }

    public E removeInitial() {
        if (head == null) {
            return null;
        } else {
            E temp = head.e;
            head = head.next;
            return temp;
        }
    }

    public boolean contains(E e) {
        SNode<E> current = head;
        while (current != null) {
            if(current.e.equals(e)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void clear() {
        head = tail = null;
        System.out.println("The list is now empty!");
    }

    public void display() {
        SNode<E> current = head;
        while(current!=null){
            System.out.println(current.e+" ");
            current = current.next;
        }
        System.out.println();
    }
}
