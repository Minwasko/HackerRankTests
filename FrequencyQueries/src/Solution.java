import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<int[]> queries) {
        List<Integer> output = new ArrayList<>();
        HashMap<Integer, Integer> appearance = new HashMap<>();
        for (int[] query : queries) {
            if (query[0] == 1) {
                if (!appearance.containsKey(query[1])) appearance.put(query[1], 0);
                appearance.put(query[1], appearance.get(query[1]) + 1);
            }
            else if (query[0] == 2) {
                if (appearance.containsKey(query[1])) {
                    if (appearance.get(query[1]) > 1) appearance.put(query[1], appearance.get(query[1]) - 1);
                    else appearance.remove(Integer.valueOf(query[1]));
                }
            }
            else if (query[0] == 3) {
                if (appearance.values().contains(Integer.valueOf(query[1]))) output.add(1);
                else output.add(0);
            }
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int q = Integer.parseInt(bufferedReader.readLine().trim());
            List<int[]> queries = new ArrayList<>(q);
            Pattern p  = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
            for (int i = 0; i < q; i++) {
                int[] query = new int[2];
                Matcher m = p.matcher(bufferedReader.readLine());
                if (m.matches()) {
                    query[0] = Integer.parseInt(m.group(1));
                    query[1] = Integer.parseInt(m.group(2));
                    queries.add(query);
                }
            }
            List<Integer> ans = freqQuery(queries);
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
                bufferedWriter.write(
                        ans.stream()
                                .map(Object::toString)
                                .collect(joining("\n"))
                                + "\n");
            }
        }
    }
}
