/*
Given an array of integers as input, output the indices of two numbers in the array which add up to a specified target.

Assume that each input would have exactly one solution, and you cannot use the same element twice. If 2 different elements have the same value, they can be used.

Print the indices in increasing order.

Input format
First line contains an Integer N that represents the number of elements in the array.

Second line contains N space separated integers, which are members of the array.

Third line contains an integer X, which is the target value.

Output format
Print two space separated indices(in increasing order) of the numbers which add up to the specified target.

Constraints
2 <= Length of array <= 100000

1 <= Range of values <= 1000000

Sample Input 1
5 --> Number of elements in array

2 4 5 9 8 --> Array elements

7 --> Target sum value

Sample Output 1
0 2

Explanation 1
Since 0 and 2 are the indices where the numbers 2 and 5 which add up to 7 are seen
 */

package twoPointers;

import java.util.*;

public class TwoSumUnsorted {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[] { map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[scanner.nextInt()];
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = scanner.nextInt();
        int target = scanner.nextInt();
        scanner.close();

        int[] complements = new TwoSumUnsorted().twoSum(numbers, target);
        System.out.print(complements[0] + " " + complements[1]);
    }
}
