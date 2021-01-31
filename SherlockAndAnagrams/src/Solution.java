import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        HashMap<Integer, List<String>> anagrams = new HashMap<>();
        int answer = 0;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (!anagrams.containsKey(i)) anagrams.put(i, new ArrayList<>());
                if (anagrams.containsKey(s.substring(j, i).length())) anagrams.get(s.substring(j, i).length()).add(s.substring(j, i));
            }
        }
        for (Map.Entry<Integer, List<String>> entry : anagrams.entrySet()) {
            for (String subString1 : entry.getValue()) {
                for (String subString2 : entry.getValue()) {
                    if (subString1 != subString2) {
                        char[] s1Chars = subString1.toCharArray();
                        char[] s2Chars = subString2.toCharArray();
                        Arrays.sort(s1Chars);
                        Arrays.sort(s2Chars);
                        if (Arrays.equals(s1Chars, s2Chars)) {
                            answer++;
                        }
                    }
                }
            }
        }
        return answer / 2;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
