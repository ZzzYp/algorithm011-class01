/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //解法 bfs
        //将wordList转化为一个Set，方便判重
        Set<String> wordset= new HashSet<>(wordList);
        if(wordset.size() == 0 || !wordset.contains(endWord)){
            return 0;
        }

        //bfs 模板 ，需要一个queue和visited容器
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        //将起始点插入队列，并且列入已访问过的
        queue.offer(beginWord);
        visited.add(beginWord);
         
        //因为beginWord插入了队列，已经算作一步了
        int step = 1;

        //bfs模板，从queue里面取数据遍历
        while(!queue.isEmpty()){
            //bfs模板 保存当前queue的size ，然后遍历size
            int currentSize = queue.size();
            for(int i = 0; i < currentSize; i++){
                //将队列中的元素依次取出
                String word = queue.poll();
                char[] worddArr = word.toCharArray();
                //修改取出字符串，看是否能和已经有的字符串匹配上
                for(int j=0; j < worddArr.length; j++){
                        //匹配完以后，还要还原为原字符串，所以保存修改前的字符
                        char originChar = worddArr[j];

                        for(char k = 'a'; k <= 'z'; k++){
                            if(k == originChar){
                                continue;
                            }
                            worddArr[j] = k;
                            //nextWord就是下一个可能和前字符串形成连接的字符串
                            String nextWord = String.valueOf(worddArr);
                            if(wordset.contains(nextWord)){
                                if(nextWord.equals(endWord)){
                                    //找到了匹配的字符串
                                    return step + 1;
                                }
                                if(!visited.contains(nextWord)){
                                    queue.offer(nextWord);
                                    visited.add(nextWord);
                                }
                            }
                        }  
                    
                         worddArr[j] = originChar;
                }  
            }
            step++;
        }

        return 0;
    }
}
// @lc code=end

