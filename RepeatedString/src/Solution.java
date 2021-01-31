import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        if (s.equals("a")) return n;
        long totalA = 0;
        long numberOfAInS = 0;
        long numberOfAsLeftover = 0;
        // get A's in String s
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                numberOfAInS++;
                if (i < n % s.length()) {
                    numberOfAsLeftover++;
                }
            }
        }
        totalA = numberOfAInS * (n / s.length()) + numberOfAsLeftover;
        System.out.println(n % s.length());
        return totalA;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
