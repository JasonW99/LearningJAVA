package c47_RandomLeetC;

import java.util.*;

public class WordLadder127 {
    public int solve(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        set.add(beginWord);
        set.remove(endWord);
        Deque<String> queue = new LinkedList<>();
        queue.offer(endWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String> remove= new ArrayList<>();
            for (int i = 0; i < size; i++) {
                String currS = queue.poll();
                char[] currC = currS.toCharArray();
                for (int j = 0; j < currC.length; j++) {
                    char temp = currC[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        currC[j] = ch;
                        String target = new String(currC);
                        if (set.contains(target)) {
                            remove.add(target);
//                            System.out.println(level + 1);
//                            System.out.println(target);
                            if (target.equals(beginWord)) {
                                return level + 1;
                            } else {
                                queue.add(target);
                            }
                        }
                    }
                    currC[j] = temp;
                }

            }
            for (String removeCurr : remove) {
                set.remove(removeCurr);
            }
            level++;
        }
        return 0;
    }



    public static void main(String[] args) {
        WordLadder127 test = new WordLadder127();
        String[] wordList = new String[] {"hot","dot","dog","lot","log","cog"};
        test.solve("hit", "cog", Arrays.asList(wordList));
    }
}
