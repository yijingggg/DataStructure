import java.util.Scanner;

public class TestIntMyStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer value: ");
        int num = sc.nextInt();

        MyStack<Integer> stack = new MyStack<>();
        for(int i=1; i<=num; i++){
            stack.push(i);
        }

        System.out.println("Size of the stack: "+ stack.getSize());

        while(!stack.isEmpty())
            System.out.print(stack.pop()+" ");
        System.out.println();
    }
}

