class TestDIOStack {
    public static void main(String[] args) {
        DIOStack<String> stack = new DIOStack <>();
        System.out.println(stack); // the underlying array should have a length of 1 at this point
        stack.push("Spiral Staircase");
        stack.push("Rhinoceros Beetle");
        stack.push("Desolation Row");
        stack.push("Fig Tart");
        stack.push("Rhinoceros Beetle");
        System.out.println(stack); // the underlying array should have a length of 8 at this point
        System.out.println();
        for (int i = 0; i < 4; i++)
            System.out.print(stack.pop() + " > ");
        System.out.println();
        System.out.println(stack); // the underlying array should have a length of 2 at this point
        System.out.println(stack.size());
        System.out.println();
        stack.push("Via Dolorosa");
        stack.push("Rhinoceros Beetle");
        stack.push("Singularity Point");
        stack.push("Giotto");
        stack.push("Angel");
        stack.push("Hydrangea");
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack); // the underlying array should have a length of 8 at this point
        System.out.println();
        stack.push("Rhinoceros Beetle");
        stack.push("Singularity Point");
        stack.push("Secret Emperor");
        System.out.println(stack.peek());
        System.out.println(stack); // the underlying array should have a length of 16 at this point
        System.out.println(stack.size());
        System.out.println();
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " > ");
        System.out.println();
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack); // the underlying array should have a length of 2 at this point
    }
}


public class DIOStack<DIO> {
    private DIO[] array = (DIO[]) new Object[1];
    private int size = 0;

    public void push(DIO o) {
        if (size == array.length) {
            resize(2 * array.length);
        }
        array[size++] = o;
    }

    public DIO pop() {
        if (isEmpty()) {
            return null;
        }
        DIO element = array[--size];
        array[size] = null;
        if (size > 0 && size == array.length / 4) {
            resize(array.length / 2);
        }
        return element;
    }

    public DIO peek() {
        if (isEmpty()) {
            return null;
        }
        return array[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void resize(int newSize) {
        DIO[] newArray = (DIO[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}

