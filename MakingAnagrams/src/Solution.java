import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int answer = 0;
        HashMap<Character, Integer> chars = new HashMap<>();
        for (Character character : a.toCharArray()) {
            if (!chars.containsKey(character)) chars.put(character, 0);
            chars.put(character, chars.get(character) + 1);
        }
        for (Character character : b.toCharArray()) {
            if (!chars.containsKey(character)) chars.put(character, 0);
            chars.put(character, chars.get(character) - 1);
        }
        for (Integer num : chars.values()) {
            answer += Math.abs(num);
        }
        System.out.println(chars);
        return answer;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
