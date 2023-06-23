import java.util.Stack;

public class Q4 {
    public static void main(String[] args) {

    }

    public static boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray())
            stack.push(c);
        for (char c : s.toCharArray())
            if (c != stack.pop())
                return false;

        return true;
    }
}
