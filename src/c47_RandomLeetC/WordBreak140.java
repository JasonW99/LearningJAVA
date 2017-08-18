/**
 Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.

 Return all such possible sentences.

 For example, given
 s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].

 A solution is ["cats and dog", "cat sand dog"].

 UPDATE (2017/1/4):
 The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
 **/

package c47_RandomLeetC;

import java.util.*;

public class WordBreak140 {
    public List<String> wordBreak(String s, String[] wordDict) {
        Set<String> set = new HashSet<>();
        for (String curr : wordDict) {
            set.add(curr);
        }
        int n = s.length();
        Map<Integer, List<String>> map = new HashMap<>();
        for (int j = 0; j < n; j++) {
            List<String> curr = new ArrayList<>();
            if (set.contains(s.substring(0, j + 1))) {
                curr.add(s.substring(0, j + 1));
            }
            for (int i = 1; i <= j; i++) {
                String t = s.substring(i, j + 1);
                if (set.contains(t)) {
                    List<String> temp = map.get(i - 1);
                    for (String tempCurr : temp) {
                        curr.add(tempCurr + " " + t);
                    }
                }
            }
            map.put(j, curr);
        }
        return map.get(n - 1);
    }

    public static void main(String[] args) {
        WordBreak140 test = new WordBreak140();
        List<String> result = test.wordBreak("catsandgod", new String[] {"cat", "cats", "and", "sand", "god"});
        for (String curr : result) {
            System.out.println(curr);
        }
    }

}
