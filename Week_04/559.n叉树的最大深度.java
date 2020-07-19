/*
 * @lc app=leetcode.cn id=559 lang=java
 *
 * [559] N叉树的最大深度
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        //解法2： bfs 统计最大层数即可
        if(root == null){
            return 0;
        }
        int maxDepth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
 
        while(!queue.isEmpty()){
            maxDepth += 1;
            int currentSize = queue.size();
            for(int i = 0; i < currentSize; i++){
                Node node = queue.poll();
                List<Node> childrens = node.children;
                for(Node child : childrens){
                    if(child != null){
                        queue.offer(child);
                    }
                }               
            }
        }


        return maxDepth;

    }

    // public int maxDepth(Node root) {
    //     //解法1： dfs
    //     if(root == null){
    //         return 0;
    //     }
    //     int maxDepth = 0;
    //     List<Node> childrens = root.children;
    //     for(Node child : childrens){
    //         int depth = maxDepth(child);
    //         maxDepth = Math.max(maxDepth, depth);
    //     }

    //     return maxDepth + 1;

    // }    

}
// @lc code=end

