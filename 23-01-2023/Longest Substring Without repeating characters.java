/* Given a string s, find the length of the longest substring without repeating characters. */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start=0;
        int end=0;
        int max=0;
        HashSet<Character> set= new HashSet();
        while(start<s.length()){
            if (!set.contains(s.charAt(start))){
                set.add(s.charAt(start));
                start+=1;
                max=Math.max(max,set.size());
                
            }
            else{
                set.remove(s.charAt(end));
                end+=1;
                    
            }
        }
        return max;
    }
}
