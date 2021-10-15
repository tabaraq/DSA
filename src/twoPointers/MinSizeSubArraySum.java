/*
Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous sub-array whose sum is greater than or equal to ‘S’.
Return 0 if no such sub-array exists.

Example 1:

Input: [2, 1, 5, 2, 3, 2], S=7
Output: 2
Explanation: The smallest sub-array with a sum greater than or equal to '7' is [5, 2].
Example 2:

Input: [2, 1, 5, 2, 8], S=7
Output: 1
Explanation: The smallest sub-array with a sum greater than or equal to '7' is [8].
Example 3:

Input: [3, 4, 1, 1, 6], S=8
Output: 3
Explanation: Smallest sub-arrays with a sum greater than or equal to '8' are [3, 4, 1]
or [1, 1, 6].
 */

package twoPointers;

public class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        int n = arr.length;
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            windowSum = windowSum + arr[windowEnd];

            while (windowSum >= S) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum = windowSum - arr[windowStart];
                windowStart++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int result = MinSizeSubArraySum.findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2});
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(7, new int[]{2, 1, 5, 2, 8});
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(8, new int[]{3, 4, 1, 1, 6});
        System.out.println("Smallest subarray length: " + result);
    }
}
