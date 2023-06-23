package Lab05.SList;

import java.util.NoSuchElementException;

public class Q3 {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list= new DoublyLinkedList<>();
        list.addFirst(1);
        list.addLast(100);
        list.add(2,2);
        list.remove(3);
        System.out.println();
        list.iterateForward();
        list.iterateBackward();
        System.out.println("size of current Doubly Linked List: "+list.getSize());
        list.clear();
        System.out.println("size of current Doubly Linked List: "+list.getSize());
    }
}

class DoublyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size=0;

    private static class Node<E> {
        E e;
        Node<E> prev;
        Node<E> next;

        public Node(E e) {
            this.e = e;
        }

        public Node(E e, Node next, Node prev) {
            this.e = e;
            this.next = next;
            this.prev = prev;
        }
    }

    public int getSize() {
        return size;
    }

    public void addFirst(E e) {
        Node<E> node = new Node<>(e, head, null);
        if (head != null) head.prev = node;
        head = node;
        if (tail == null) tail = head;
        size++;
        System.out.println("adding: " + e);
    }

    public void addLast(E e) {
        Node<E> node = new Node<>(e, null, tail);
        if (tail != null) tail.next = node;
        tail = node;
        if (head == null) head = tail;
        size++;
        System.out.println("adding: " + e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (index == 0)
            addFirst(e);
        else if (index == size)
            addLast(e);
        else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> node = new Node<>(e, current, current.prev);
            current.prev.next = node;
            current.prev = node;
            size++;
            System.out.println("adding: " + e);
        }
    }

    public E removeFirst() {
        if (head == null) throw new NoSuchElementException();
        Node<E> temp = head;
        head = head.next;
        head.prev = null;
        size--;
        System.out.println("deleted: " + temp.e);
        return temp.e;
    }

    public E removeLast() {
        if (size == 0) throw new NoSuchElementException();
        Node<E> temp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        System.out.println("deleted: " + temp.e);
        return temp.e;
    }

    public E remove(int index) {
        E element = null;
        if (index == 0)
            element = removeFirst();
        else if (index >= size - 1)
            element = removeLast();
        else{
            Node<E> temp = head;
            for(int i=0; i<index;i++){
                temp = temp.next;
            }
            element = temp.e;
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
            temp.next = null;
            temp.prev = null;
            size--;
        }
        return element;
    }

    public void iterateForward() {
        System.out.println("iterating forward..");
        for(Node<E> current = head; current!=null; current = current.next){
            System.out.print(current.e+" ");
        }
        System.out.println();
    }

    public void iterateBackward(){
        System.out.println("iterating backward..");
        for(Node<E> current = tail; current!=null; current = current.prev){
            System.out.print(current.e+" ");
        }
        System.out.println();
    }

    public void clear() {
        Node<E> temp = head;
        while (head != null) {
            temp = head.next;
            head.prev = head.next = null;
            head = temp;
        }
        temp = null;
        tail.prev = tail.next = null;
        System.out.printf("successfully clear %d node(s)\n", size);
        size = 0;
    }
}
