import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the truckTour function below.
     */
    static int truckTour(int[][] petrolpumps) {
        /*
         * Write your code here.
         */
        int start = 0;
        boolean picked = false;
        long totalDistanceAbleToDrive = 0;
        long totalDistanceDriven = 0;
        for (int i = 0; i < petrolpumps.length; i++) {
            totalDistanceAbleToDrive += petrolpumps[i][0];
            if (totalDistanceAbleToDrive >= totalDistanceDriven + petrolpumps[i][1] && !picked) {
                start = i;
                picked = true;
            } else if (totalDistanceAbleToDrive < totalDistanceDriven + petrolpumps[i][1]) {
                picked = false;
                totalDistanceAbleToDrive = 0;
                totalDistanceDriven = -petrolpumps[i][1];
            }
            totalDistanceDriven += petrolpumps[i][1];
        }
        return start;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] petrolpumps = new int[n][2];

        for (int petrolpumpsRowItr = 0; petrolpumpsRowItr < n; petrolpumpsRowItr++) {
            String[] petrolpumpsRowItems = scanner.nextLine().split(" ");

            for (int petrolpumpsColumnItr = 0; petrolpumpsColumnItr < 2; petrolpumpsColumnItr++) {
                int petrolpumpsItem = Integer.parseInt(petrolpumpsRowItems[petrolpumpsColumnItr].trim());
                petrolpumps[petrolpumpsRowItr][petrolpumpsColumnItr] = petrolpumpsItem;
            }
        }

        int result = truckTour(petrolpumps);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
