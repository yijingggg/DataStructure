import java.util.ArrayList;

public class Q1 {
    public static void main(String[] args) {
        TestMyStack.main(args);
    }
}

class TestMyStack {
    public static void main(String[] args) {
        MyStack<Character> stack = new MyStack<>();
        for (char c = 'a'; c <= 'c'; c++) {
            stack.push(c);
        }
        System.out.println(stack);
        System.out.println("'b' is in the stack: " + stack.search('b'));
        System.out.println("'k' is in the stack: " + stack.search('k'));

        System.out.println();
        MyStack<Integer> stack1 = new MyStack<>();
        System.out.println(stack1);
        System.out.println("'6' is in the stack: " + stack1.search(6));
    }
}

class MyStack<E> {
    private ArrayList<E> list = new ArrayList<>();

    public int getSize() {
        return list.size();
    }

    public void push(E o) {
        list.add(o);
    }

    public E pop() {
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public E peek() {
        return list.get(getSize() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public String toString() {
        return "stack: " + list.toString();
    }

    public boolean search(E o) {
        return list.contains(o);
    }
}
