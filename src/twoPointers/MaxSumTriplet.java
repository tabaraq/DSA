/*
Given an array nums, you need to find the maximum sum of triplet (nums[i] + nums[j] + nums[k]) such that 0 <= i < j < k and nums[i] < nums[j] < nums[k].
If no such triplet exists print 0.

Input format
There are 2t+1 lines of input

First line contains an integer t - No of test cases.

First line of each test case contains an integer n - No of elements in the array.

Second line of each test case contains N space separated integers - The array nums.

Output format
For each test case print the answer in a new line.

Sample Input 1
3

7

3 7 4 2 5 7 5

4

5 2 4 5

3

3 2 1

Sample Output 1
16

11

0

Explanation 1
In the first case valid triplets are: [3,4,5], [3,4,7], [4,5,7], [2,5,7]. Out of these [4,5,7] has the maximum sum, 16.

In the second case, it’s [2, 4, 5] with sum 11.

In the third case there are no valid triplets.

Constraints
1 <= t <= 100

3 <= n <= 300

1 <= nums[i] <= 10^9

It is guaranteed that the sum of n over all test cases is less than 3000.
 */

package twoPointers;

import java.util.*;

public class MaxSumTriplet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            long[] arr = new long[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextLong();

            long result = maxSumTriplet(n, arr);

            System.out.println(result);

        }
    }

    // O(n * log n) time complexity
    static long maxSumTriplet(int n, long[] arr) {
        long[] maxSuffixArr = new long[n];
        maxSuffixArr[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            maxSuffixArr[i] = Math.max(arr[i], maxSuffixArr[i + 1]);
        }

        long result = 0;

        TreeSet<Long> leftValue = new TreeSet<>();
        leftValue.add(Long.MIN_VALUE);

        for(int i = 0; i < n - 1; i++)
        {
            if (maxSuffixArr[i + 1] > arr[i])
            {
                result = Math.max(result, leftValue.lower(arr[i]) +
                        arr[i] + maxSuffixArr[i + 1]);

                leftValue.add(arr[i]);
            }
        }
        return result;
    }

    // O(N^2) time complexity
    static long maxSumTriplet_Alt(int n, long[] arr) {
        long result = 0;
        for (int i = 1; i < n - 1; i++) {
            long max1 = 0;
            long max2 = 0;

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    max1 = Math.max(arr[j], max1);
                }
            }

            for (int k = i + 1; k < n; k++) {
                if (arr[k] > arr[i]) {
                    max2 = Math.max(arr[k], max2);
                }
            }

            if (max1 > 0 && max2 > 0) {
                result = Math.max(result, max1 + arr[i] + max2);
            }
        }
        return result;
    }
}

