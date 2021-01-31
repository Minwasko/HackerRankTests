import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        int correctWords = 0;
        boolean success = true;
        HashMap<String, Integer> neededWords = new HashMap<>();
        for (int i = 0; i < note.length; i++) {
            if (!neededWords.containsKey(note[i])) neededWords.put(note[i], 1);
            else neededWords.put(note[i], neededWords.get(note[i]) + 1);
        }
        for (int i = 0; i < magazine.length; i++) {
            if (neededWords.containsKey(magazine[i])) {
                neededWords.put(magazine[i], neededWords.get(magazine[i]) - 1);
                magazine[i] = "";
            }
        }
        for (Map.Entry<String, Integer> entry : neededWords.entrySet()) {
            if (entry.getValue() != 0) success = false;
        }
        if (!success) System.out.println("No");
        else System.out.println("Yes");
         System.out.println(neededWords);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
