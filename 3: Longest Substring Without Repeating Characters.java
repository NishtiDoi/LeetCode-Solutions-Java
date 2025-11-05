/*
Approach Summary:

This solution uses the Sliding Window technique with a HashSet to track unique characters in the current window.
Initialize two pointers, left and right, representing the current window.
Expand right to include new characters.
If a character repeats, move left forward while removing characters from the set until the substring becomes unique again.
Keep updating the maximum window size (maxLen) after each valid expansion.

Time Complexity: O(n) — each character is visited at most twice.
Space Complexity: O(min(n, charset)) — at most 26 for lowercase/uppercase or 128 for ASCII.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
