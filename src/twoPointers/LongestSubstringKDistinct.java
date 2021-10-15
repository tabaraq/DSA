/*
Given a string, find the length of the longest substring that contains at most K distinct characters.

Note:

Uppercase and Lowercase characters should be considered as different characters.

There can be numbers and special characters as well.

Input format
There are 2 lines of input.

First-line contains two space-separated integers representing the value of N and K.

The next line contains the string S of length N.

Output format
The length of the longest substring T that contains at most K distinct characters.

Constraints
1 <= N <= 10^5

0 <= K <= 256

Sample Input 1
5 3

abacd

Sample Output 1
4

Explanation 1
The longest substring that has 3 distinct characters, "abac", is of length 4.

Sample Input 2
6 3

Xyyzya

Sample Output 2
5

Explanation
There are 2 substrings, "Xyyzy" and “yyzya” which are the longest ones having 3 distinct characters and their length is 5.
 */

package twoPointers;

import java.util.*;

public class LongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null) {
            return 0;
        }

        int n = s.length();

        if (n <= 1) {
            return n;
        }

        int windowStart = 0;
        int maxLength = 0;

        Map<Character, Integer> charFeqMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            charFeqMap.put(rightChar, charFeqMap.getOrDefault(rightChar, 0) + 1);

            while(charFeqMap.size() > k) {
                char leftChar = s.charAt(windowStart);
                charFeqMap.put(leftChar, charFeqMap.get(leftChar) - 1);
                if (charFeqMap.get(leftChar) == 0) {
                    charFeqMap.remove(leftChar);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        scanner.close();

        int result = new LongestSubstringKDistinct().lengthOfLongestSubstringKDistinct(s,k);
        System.out.println(result);
    }
}

