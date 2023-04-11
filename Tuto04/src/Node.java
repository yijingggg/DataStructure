public class Node<E> {
    E element;
    Node<E> next;
    Node<E> head = null, tail = null;
    int size = 0;

    public Node(E e) {
        this.element = e;
    }

    public void addFirst(E element) {
        Node<E> firstNode = new Node<>(element);
        firstNode.next = head;
        head = firstNode;
        size++;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void addLast(E element) {
        if (tail == null) {
            head = tail = new Node<>(element);
        } else {
            tail.next = new Node<>(element);
            tail = tail.next;
        }
        size++;
    }

    public void add(int index, E element) {
        if (index == 0) {
            addFirst(element);
        } else if (index >= size) {
            addLast(element);
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(element);
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

    public E removeLast(){
        if(size==0){
            return null;
        }
        else if(size==1){
            Node<E>temp = head;
            head = tail = null;
            size =0;
            return temp.element;
        }
        else{
            Node<E>current = head;
            for(int i =1; i<size-2;i++){
                current = current.next;
            }
            Node<E>temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }

    public E remove(int index){
        if(index<0 || index>=size){
            return null;
        }
        else if (index==0){
            return removeFirst();
        }
        else if (index==size-1){
            return removeLast();
        }
        else{
            Node<E>previous = head;
            for(int i =1;i<index;i++){
                previous = previous.next;
            }
            Node<E>current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    public boolean contains(E e) {
        Node<E> current = head;

        for (int i = 1; i < size; i++) {
            if (current.element == e) {
                System.out.println(current.element + " is found in the linked list");
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
