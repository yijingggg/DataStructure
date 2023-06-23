import java.util.NoSuchElementException;

public class MyLinkedList<E> {

    private Node<E> head, tail;
    private int size;

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node() {
        }

        public Node(E element) {
            this.element = element;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(E e) {
        Node<E> firstNode = new Node<>(e);
        firstNode.next = head;
        head = firstNode;
        size++;
        if (tail == null) {
            tail = head;
        }
    }

    public void addLast(E e) {
        if (tail == null) {
            head = tail = new Node<>(e);
        } else {
            tail.next = new Node<>(e);
            tail = tail.next;
        }
        size++;
    }

    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
            size++;
        }
    }

    public E removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return temp.element;
        }
    }

    public E removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        } else {
            Node<E> current = head;
            for (int i = 1; i < size - 2; i++) {
                current = current.next;
            }
            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    public boolean contains(E e) {
        Node<E> current = head;
        for (int i = 1; i < size; i++) {
            if (current.element.equals(e)) {
                System.out.println(current.element + " is found in the linked list.");
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * @param index to get element
     * @return element at the specified index, will throw an exception if index is out of bound
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    public E getFirst() {
        if (head == null) {
            return null;
        }
        return head.element;
    }

    public E getLast() {
        if (tail == null) {
            return null;
        }
        return tail.element;
    }

    public int indexOf(E e) {
        Node<E> current = head;
        int index = 0;
        while (current != null) {
            if (current.element.equals(e)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public int lastIndexOf(E e) {
        Node<E> current = head;
        int index = -1;
        int i = 0;
        while (current != null) {
            if (current.element.equals(e)) {
                index = i;
            }
            i++;
            current = current.next;
        }
        return index;
    }

    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            Node<E> current = head;
            for (int i = 1; i <= index; i++) {
                current = current.next;
            }
            E temp = current.element;
            current.element = e;
            return temp;
        }
    }

    public void clear() {
        head = tail = null;
    }

    public void print() {
        for (Node<E> current = head; current != null; current = current.next) {
            System.out.print(current.element + " ");
        }
        System.out.println();
    }

    public void reverse() {
        String s = "";
        for (Node<E> current = head; current != null; current = current.next) {
            s = current.element + " " + s;
        }
        System.out.println(s);
    }

    public E getMiddleValue() {
        int mid = size / 2;
        Node<E> current = head;
        for (int i = 0; i < mid; i++) {
            current = current.next;
        }
        return current.element;
    }

}
