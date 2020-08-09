/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

// @lc code=start
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        //bfs
        HashSet<String> bankSet = new HashSet<>();
        for(String str : bank){
            bankSet.add(str);
        }

        char[] bankChar = {'A','C','G','T'};
        LinkedList<String> dequeue = new LinkedList<>();
        dequeue.offer(start);
        int coount = 0;
        Set<String> visited = new HashSet<>();
        
        while(!dequeue.isEmpty()){
            int size = dequeue.size();
            for(int i = 0; i < size; i++){
                String temp = dequeue.poll();
                if(temp.equals(end)){
                    return coount;
                }
                char[] letterChar = temp.toCharArray();
                for(int j = 0; j < letterChar.length; j++){
                    char old = letterChar[j];
                    for(char c : bankChar){
                        letterChar[j] = c;
                        String newString = new String(letterChar);
                        if(!visited.contains(newString) && bankSet.contains(newString)){
                            visited.add(newString);
                            dequeue.offer(newString);
                        }
                    }
                    letterChar[j] = old;
                }
            }
            coount++;
        }

        return -1;
        
    }
}
// @lc code=end

