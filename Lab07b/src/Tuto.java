public class Tuto {
    public static void main(String[] args) {
        int n = 5678;
        printDigit(n);
    }


    public static void printDigit(int num) {
        if (num < 10) {
            System.out.print(num + " ");
        } else {
            printDigit(num / 10);  // Recursive call to print the digits before the last digit
            System.out.print(num % 10 + " ");  // Print the last digit
        }
    }
}
