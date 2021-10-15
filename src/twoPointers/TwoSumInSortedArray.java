package twoPointers;

import java.util.*;

public class TwoSumInSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        boolean res = twoSumInSortedArray(n, arr, k);

        String ans = (res) ? "Present" : "Not Present";

        System.out.println(ans);

    }

    static boolean twoSumInSortedArray(int n, int[] arr, int k) {
        int start = 0;
        int end = n - 1;

        while(start < end) {
            if (arr[start] + arr[end] == k) {
                return true;
            }

            if (arr[start] + arr[end] > k) {
                end--;
            } else {
                start++;
            }
        }
        return false;
    }
}