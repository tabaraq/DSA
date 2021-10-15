/*
Given a sorted array, remove the duplicates in-place, such that each element in the array appears at most twice, and return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Input format
There are two lines of input.

First line contains an integer n - Number of elements.

Second line contains n space separated integers - The array nums.

Output format
Print the new length in the first line.

In the second line print the nums array upto the new length.

Sample Input 1
7

2 2 2 3 4 4 9

Sample Output 1
6

2 2 3 4 4 9

Explanation 1
Your function should return 6 as the element 2 can only be present at most 2 times.
So the first 6 elements of array nums should be modified to [2, 2, 3, 4, 4, 9].

Constraints
1 <= n <= 10^5

0 <= nums[i] <= 10^6
 */

package mergeIntervals;

import java.util.*;

public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int res = removeDuplicatesFromSortedArrayII(n, arr);

        System.out.println(res);

        for (int i = 0; i < res; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static int removeDuplicatesFromSortedArrayII(int n, int[] arr) {
        int index = 1;
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                arr[index] = arr[i];
                index++;
            }
        }

        return index;
    }

    static int removeDuplicatesFromSortedArrayIIAlt(int n, int[] arr) {
        int index = 0;
        for (int a : arr) {
            if (index < 2 || a > arr[index - 2]) {
                arr[index] = a;
                index++;
            }
        }
        return index;
    }
}
