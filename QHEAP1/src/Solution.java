import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        TreeMap<Integer, Integer> nums = new TreeMap<>();
        for (int i = 0; i <= count; i++) {
            String[] arr = scanner.nextLine().split(" ");
            switch (arr[0]) {
                case "1":
                    nums.put(Integer.parseInt(arr[1]), Integer.parseInt(arr[1]));
                    break;
                case "2":
                    nums.remove(Integer.parseInt(arr[1]));
                    break;
                case "3":
                    System.out.println(nums.firstKey());
                    break;
            }
        }
    }
}