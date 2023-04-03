import java.io.*;
import java.util.Scanner;

public class lab1_Q1 {
    public static void main(String[] args) {

        /************** Part 1 ******************/


        try {
            String text = "";
            File file = new File("YiJing_22004875.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                text += sc.nextLine();
            }

            System.out.println(text);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist!");
        }

        /************** Part 2 ******************/

        Scanner input = new Scanner(System.in);
        System.out.println("Enter text here:");
        String textToAppend = input.nextLine();

        try {
            String fileName = "YiJing_22004875.txt";
            FileWriter fileWriter = new FileWriter(fileName, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(textToAppend);

            printWriter.close();

        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

