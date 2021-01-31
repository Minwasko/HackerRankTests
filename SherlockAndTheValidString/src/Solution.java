import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        if (s.length() < 3) return "YES";
        int[] occurences = new int[26];
        for (int i = 0; i < s.length(); i++) {
            occurences[s.charAt(i) - 'a'] = occurences[s.charAt(i) - 'a'] + 1;
        }
        Arrays.sort(occurences);
        int minIdx = 0;
        for (int i = 0; i < occurences.length; i++) {
            if (occurences[i] != 0 && minIdx == 0) minIdx = i;
        }
        System.out.println(minIdx);
        if (Math.abs(occurences[25] - occurences[minIdx]) == 1 && occurences[25] > occurences[24] ||
                occurences[minIdx] == 1 && occurences[minIdx + 1] == occurences[25] || occurences[minIdx] == occurences[25]) return "YES";
        return "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
