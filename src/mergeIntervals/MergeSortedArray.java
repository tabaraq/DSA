/*
Given two sorted arrays of size M and N, merge the two arrays and return the final array, sorted.

Input format
A single Integer M, that contains the number of elements in the first array.

A single Integer N, that contains the number of elements in the second array.

Next Line contains M space Integers of the array nums1.

Next Line contains N space Integers of the array nums2.

Output format
Print the array after merging.

Sample Input 1
3

3

1 2 3

2 5 6

Sample Output 1
1 2 2 3 5 6

Explanation 1
The sorted array is returned after merging.

Constraints
1 <= N,M <= 10^5

|nums1[i] | <= 10^9

|nums2[i] | <= 10^9
 */

package mergeIntervals;

import java.util.*;

public class MergeSortedArray {
    public static int [] mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        int[] mergedArray = new int[m + n];

        int mergedIndex = 0;
        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                mergedArray[mergedIndex++] = nums1[i++];
            } else {
                mergedArray[mergedIndex++] = nums2[j++];
            }
        }

        while (i < m) {
            mergedArray[mergedIndex++] = nums1[i++];
        }

        while (j < n) {
            mergedArray[mergedIndex++] = nums2[j++];
        }

        return mergedArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] nums1 = new int[m];
        int[] nums2 = new int[n];

        for (int i = 0; i < m; i++)
            nums1[i] = scanner.nextInt();
        for (int i = 0; i < n; i++)
            nums2[i] = scanner.nextInt();

        scanner.close();

        int[] nums = mergeSortedArray(nums1, m, nums2, n);
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
    }
}
