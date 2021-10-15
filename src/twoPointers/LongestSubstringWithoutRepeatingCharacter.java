/*
Problem Description
Given a string, find the length of the longest substring which has no repeating characters.

Input format
Input is a string.

Output format
Output is an integer representing the longest substring with no repeating characters.

Sample Input 1
aabcccbcb

Sample Output 1
3

Explanation 1
"abc" is the longest substring with no repeating characters.

Sample Input 2
cdddddd

Sample Output 2
2

Explanation 2
"cd" is the longest substring with no repeating characters.
 */

package twoPointers;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }

        int n = s.length();

        if (n <= 1) {
            return n;
        }

        int maxLength = 0;
        int windowStart = 0;

        Map<Character, Integer> charFreqMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            if (charFreqMap.containsKey(rightChar)) {
                windowStart = Math.max(windowStart, charFreqMap.get(s.charAt(windowEnd)) + 1);
            }
            charFreqMap.put(s.charAt(windowEnd), windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int result = new LongestSubstringWithoutRepeatingCharacter().lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
