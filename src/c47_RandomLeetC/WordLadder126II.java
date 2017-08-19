package c47_RandomLeetC;

import java.util.*;

public class WordLadder126II {
    public List<List<String>> solve(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            new ArrayList<List<String>>();
        }
        set.remove(beginWord);
        Map<String, List<String>> neighbor = new HashMap<>();
        neighbor.put(beginWord, new ArrayList<String>());
        boolean find = false;

        Deque<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 0;
        while (!queue.isEmpty() && !find) {
            int size = queue.size();
            List<String> needRemove = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                for (int j = 0; j < curr.length(); j++) {
                    char[] currChar = curr.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        currChar[j] = ch;
                        String target = new String(currChar);
                        if (set.contains(target)) {
                            if (!neighbor.containsKey(target)) {
                                queue.offer(target);
                            }
                            needRemove.add(target);
                            neighbor.get(curr).add(target);
                            if (target.equals(endWord)) {
                                find = true;
                            }
                            if (!find && !neighbor.containsKey(target)) {
                                neighbor.put(target, new ArrayList<String>());
                            }
                        }
                    }
                }
            }
            set.removeAll(needRemove);
            level++;
        }
        if (!find) {
            return new ArrayList<List<String>>();
        } else {
            List<List<String>> result = new ArrayList<List<String>>();
            List<String> subResult = new ArrayList<String>();
            subResult.add(beginWord);
            walkTree(beginWord, endWord, neighbor, subResult, result, level);
            return result;
        }
    }

    private void walkTree(String curr, String endWord, Map<String, List<String>> neighbor, List<String> subResult, List<List<String>> result, int level) {
        if (level == 0) {
            if (subResult.get(subResult.size() - 1).equals(endWord)) {
                result.add(new ArrayList<>(subResult));
            }
            return;
        }
        for (String currNeighbor : neighbor.get(curr)) {
            subResult.add(currNeighbor);
            walkTree(currNeighbor, endWord, neighbor, subResult, result, level - 1);
            subResult.remove(subResult.size() - 1);
        }
    }

    public static void main(String[] args) {
        WordLadder126II test = new WordLadder126II();
        String[] wordList = new String[] {"hot","dot","dog","lot","log","cog"};
        List<List<String>> result = test.solve("hit", "cog", Arrays.asList(wordList));
        for (List<String> curr : result) {
            System.out.println(curr.toString());
        }
    }
}
