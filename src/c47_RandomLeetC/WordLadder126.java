package c47_RandomLeetC;

import java.util.*;

public class WordLadder126 {
    public List<List<String>> solve(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        dict.remove(beginWord);
        if (!dict.contains(endWord)) {
            return new ArrayList<>();
        }
        Map<String, List<List<String>>> map = new HashMap<>();
        Deque<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        List<List<String>> newCollection = new ArrayList<>();
        List<String> newPath = new ArrayList<>();
        newPath.add(beginWord);
        newCollection.add(newPath);
        map.put(beginWord, newCollection);
        boolean find = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String> needRemove = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                for (int j = 0; j < curr.length(); j++) {
                    char[] currC = curr.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        currC[j] = ch;
                        String target = new String(currC);
                        if (target.equals(endWord)) {
                            find = true;
                        }
                        if (dict.contains(target)) {
                            needRemove.add(target);
                            if (map.containsKey(target)) {
                                updatePath(map, map.get(target), curr, target);
                            } else {
                                updatePath(map, new ArrayList<>(), curr, target);
                                queue.offer(target);
                            }
                        }
                    }
                }
            }
            dict.removeAll(needRemove);
            if (find) {
                return map.get(endWord);
            }
        }
        return new ArrayList<>();
    }

    private void updatePath(Map<String, List<List<String>>> map, List<List<String>> result, String curr, String target) {
        for (List<String> prev: map.get(curr)) {
            List<String> new_path = new ArrayList<>(prev);
            new_path.add(target);
            result.add(new_path);
        }
        map.put(target, result);
    }

    public static void main(String[] args) {
        WordLadder126 test = new WordLadder126();
        String[] wordList = new String[] {"hot","dot","dog","lot","log","cog"};
        List<List<String>> result = test.solve("hit", "cog", Arrays.asList(wordList));
        for (List<String> curr : result) {
            System.out.println(curr.toString());
        }
    }
}
