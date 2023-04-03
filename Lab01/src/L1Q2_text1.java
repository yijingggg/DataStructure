import java.io.*;

public class L1Q2_text1 {
    public static void main(String[] args) {

        String filePath = "text1.txt";
        int charCount = 0;
        String txt ="";
        String ori = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            String line = "";
            while ((line = reader.readLine()) != null) {
                ori = ori + line + "\n";

                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (Character.isLetterOrDigit(c)) {
                        charCount++;
                        txt += c;
                    }
                } txt += "\n";
            }

            reader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Original text: \n" + ori);
        System.out.println("Number of characters without special characters: " + charCount);
        System.out.println("Characters without special characters: \n" + txt);

    }
}

