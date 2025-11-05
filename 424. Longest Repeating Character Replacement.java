/*
Approach Summary:
Maintain a window using two pointers (left, right).
Use a frequency array to count occurrences of each character in the current window.
Track maxCount, the count of the most frequent character in the window.
The number of replacements needed to make all characters identical is (window length - maxCount).
If replacements exceed k, move left forward to shrink the window.
Update maxLen with the maximum valid window size seen so far.

Time Complexity: O(n)
Space Complexity: O(1) — constant space since there are only 26 uppercase letters.
*/

class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map=new HashMap<>();
        int l=0;
        int maxLen=0;
        int maxCount=0;
        for(int r=0; r<s.length(); r++){
            char c=s.charAt(r);
            map.put(c, map.getOrDefault(c,0)+1);
            maxCount=Math.max(map.get(c), maxCount);

            while((r-l+1) -maxCount > k ){
                char left=s.charAt(l);
                map.put(left, map.get(left)-1);
                if(map.get(left)==0){
                    map.remove(left);
                }
                l++;
            }
            maxLen=Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
}
