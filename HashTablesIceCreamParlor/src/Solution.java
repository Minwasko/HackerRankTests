import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        HashMap<Integer, Integer> priceIndexes = new HashMap<>();
        HashMap<Integer, List<Integer>> indexPrices = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            priceIndexes.put(i, cost[i]);
            if (!indexPrices.containsKey(cost[i])) indexPrices.put(cost[i], new ArrayList<>());
            indexPrices.get(cost[i]).add(i);
        }
        for (int i = 0; i < cost.length; i++) {
            if (indexPrices.containsKey(money - cost[i])) {
                if (money - cost[i] == cost[i] && indexPrices.get(money - cost[i]).size() > 1) {
                    int firstIdx = i;
                    int secondIdx = indexPrices.get(money - cost[i]).get(1);
                    System.out.println((firstIdx + 1) + " " + (secondIdx + 1));
                    break;
                } else if (money - cost[i] != cost[i]) {
                    System.out.println((i + 1) + " " + (indexPrices.get(money - cost[i]).get(0) + 1));
                    break;
                }
            }
        }
        Arrays.sort(cost);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
