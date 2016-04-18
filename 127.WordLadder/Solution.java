public class Solution {
    //Run BFS on the begin word, once we found the end word, we can return the level, it is guaranteed the shorted path.
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int level = 0;
        Deque<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            level++;
            for(int i = 0; i < levelSize; i++) {
                String str = queue.poll();
                char[] carr = str.toCharArray();
                //Iterate through all strings we can transform to from current string str
                for(int j = 0; j < carr.length; j++) {
                    for(char c = 'a'; c <= 'z'; c++) {
                        char temp = carr[j];
                        carr[j] = c;
                        String newStr = new String(carr);
                        if(wordList.contains(newStr) && !visited.contains(newStr)) {
                            queue.add(newStr);
                            visited.add(newStr);
                        }
                        
                        if(newStr.equals(endWord)) return level + 1;//We have to include endWord, so we add one level
                        carr[j] = temp;//Dont forget to restore char array!
                    }
                }
            }
        }
        
        return 0;
    }
}