/*
Approach:
Create a frequency map for s1, 
parse through s2 adding frequency of the letters too, if i>s2.length start subtracting the left side wala frequency
if at any time freq1 map or freq2 map, return true
=
*/

import java.util.*;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        HashMap<Character, Integer> freq1 = new HashMap<>();
        HashMap<Character, Integer> freq2 = new HashMap<>();

        int windowLen = s1.length();
        for (char c : s1.toCharArray())
            freq1.put(c, freq1.getOrDefault(c, 0) + 1);

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            freq2.put(c, freq2.getOrDefault(c, 0) + 1);

            // shrink window
            if (i >= windowLen) {
                char left = s2.charAt(i - windowLen);
                if (freq2.get(left) == 1)
                    freq2.remove(left);
                else 
                    freq2.put(left, freq2.get(left) - 1);
            }

            if (freq1.equals(freq2)) return true;
        }

        return false;
    }
}
