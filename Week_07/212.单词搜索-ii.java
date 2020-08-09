/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 */

// @lc code=start
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        public List<String> findWords(char[][] board, String[] words) {
            //构建字典树
            WordTrie wordTrie = new WordTrie();
            TrieNode root = wordTrie.trieNode;
            for(String s: words){
                wordTrie.insert(s);
            }
    
            Set<String> result = new HashSet<>();
            int m = board.length;
            int n = board[0].length;
    
            boolean[][] visited = new boolean[m][n];
    
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    dfs(board, visited, i, j, m, n, result, root);
                }
            }
            return new LinkedList<String>(result);
        }
    
    
    
        public void dfs(char[][] board, boolean[][] visited, int i, int j, int m, int n, Set<String> result, TrieNode currentNode){
            if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j]){
                return;
            }
            currentNode = currentNode.child[board[i][j] - 'a'];
            visited[i][j] = true;
            if(currentNode == null){
                //单词不匹配，回退状态
                visited[i][j] = false;
                return;
            }
            if(currentNode.isLeaf){
                //找到了单词
                result.add(currentNode.val);
    
            }
            //上
            dfs(board, visited, i - 1, j, m, n, result, currentNode);
            //右
            dfs(board, visited, i, j + 1, m, n, result, currentNode);
            //下
            dfs(board, visited, i + 1, j, m, n, result, currentNode);
            //左
            dfs(board, visited, i, j - 1, m, n, result, currentNode);
    
            //回溯模板，回退状态
            visited[i][j] = false;
        }
    
    
    
        class WordTrie{
            public TrieNode trieNode = new TrieNode();
            public void insert(String s){
                TrieNode currentNode = trieNode;
                for(char c : s.toCharArray()){
                    if(currentNode.child[c - 'a'] == null){
                        currentNode.child[c - 'a'] = new TrieNode();
                    }
                    currentNode = currentNode.child[c - 'a'];
                }
                currentNode.isLeaf = true;
                currentNode.val = s;
            }
    
    
        }
    
        class TrieNode{
            public String val;
            public TrieNode[] child = new TrieNode[26];
            public boolean isLeaf = false;
    
            TrieNode(){}
        }
    }
}
// @lc code=end

