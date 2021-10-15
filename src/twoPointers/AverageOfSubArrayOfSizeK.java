/*
Given an array, find the average of all contiguous sub-arrays of size ‘K’ in it.
Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
Output: [2.2, 2.8, 2.4, 3.6, 2.8]
 */

package twoPointers;

import java.util.Arrays;

public class AverageOfSubArrayOfSizeK {
    public static void main(String[] args) {
        double[] result = AverageOfSubArrayOfSizeK.findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
        System.out.println("Averages of sub-arrays of size K: " + Arrays.toString(result));
    }

    public static double[] findAverages(int K, int[] arr) {
        int n = arr.length;
        double[] result = new double[n - K + 1];
        double windowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            windowSum =  windowSum + arr[windowEnd];

            if (windowEnd >= K - 1) {
                result[windowStart] = windowSum / K;
                windowSum = windowSum - arr[windowStart];
                windowStart++;
            }
        }

        return result;
    }
}
