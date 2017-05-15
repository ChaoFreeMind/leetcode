// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
// determine if s can be segmented into a space-separated sequence of one or more dictionary words. 
// You may assume the dictionary does not contain duplicate words.

// For example, given
// s = "leetcode",
// dict = ["leet", "code"].

// Return true because "leetcode" can be segmented as "leet code".

// UPDATE (2017/1/4):
// The wordDict parameter had been changed to a list of strings (instead of a set of strings). 
// Please reload the code definition to get the latest changes.

// 3/18/2017
public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        // breakable[i]: if s[0, i) is breakable.
        // Note that i here is exclusive!
        boolean[] breakable = new boolean[s.length() + 1];
        breakable[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // s[j, i)
                if (breakable[j] && wordDict.contains(s.substring(j, i))) {
                    breakable[i] = true;
                }
            }
        }

        return breakable[s.length()];
    }

}