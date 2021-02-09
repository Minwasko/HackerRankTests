import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {
        char[] letters = s.toCharArray();
        Arrays.sort(letters);
        int appeared = 1;
        boolean oddOne = false;
        boolean fail = false;
        for (int i = 0; i < letters.length - 1; i++) {
            if (letters[i] == letters[i + 1]) appeared++;
            else if (letters[i] != letters[i + 1]) {
                if (appeared == 0 && !oddOne || appeared % 2 == 1 && !oddOne) oddOne = true;
                else if (appeared == 0 || appeared % 2 == 1 || oddOne) fail = true;
                else appeared = 1;
            }
        }
        if (fail) return "NO";
        return "YES";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
