import java.util.HashMap;

public class LongestSubarraySumK {
    public static int longestSubarrayWithSumK(int[] arr, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int currentSum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            // Check if the whole array up to the current index sums to K
            if (currentSum == K) {
                maxLength = i + 1;
            }

            // If currentSum - K exists in map, there's a subarray that sums to K
            if (map.containsKey(currentSum - K)) {
                maxLength = Math.max(maxLength, i - map.get(currentSum - K));
            }

            // Only add currentSum to map if it is not already present
            // to maintain the earliest index for maximum length
            map.putIfAbsent(currentSum, i);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int K = 15;
        System.out.println("Length of the longest subarray: " + longestSubarrayWithSumK(arr, K));
    }
}
