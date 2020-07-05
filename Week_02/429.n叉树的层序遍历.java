/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N叉树的层序遍历
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
    //解法2：递归的result
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        //解法2：递归
        //时间复杂度 O(n) 因为每个节点只遍历一次，遍历n个节点
        //空间复杂度，最坏O(n),  平均O(logn)
        if(null == root){
            return new ArrayList<>();
        }
        order(root, 0);

        return result;    



        // //解法1：使用队列先进先出的特性解决
        // //时间复杂度 O(n)   n为节点的数量
        // //空间复杂度 O(n)
        // if(null == root){
        //     return new ArrayList<>();
        // }
        // Queue<Node> queue = new LinkedList<>();
        // List<List<Integer>> result = new ArrayList<>();

        // //将根节点插入队列
        // queue.add(root);
        // //当队列为空，说明已经遍历完毕
        // while(!queue.isEmpty()){
        //     //创建一个list，存储n叉树的每层的val
        //     List<Integer> level = new ArrayList<>();
        //     //由于queue的大小是动态变化的，所以再遍历层之前，记住当前层元素的size
        //     int size = queue.size();
        //     //遍历当前层
        //     for(int i=0; i < size; i++){
        //         //从队列头中取出当前层的节点
        //         Node node = queue.poll();
        //         //将节点存入level
        //         level.add(node.val);
        //         //将当前节点的子节点存入队列中，但由于队列的先进先出特性，在for循环结束之前，从队列中取出的都是当前层的元素，而不会取出这个地方存入的子节点
        //         queue.addAll(node.children);
        //     }
        //     //将当前层的节点的值存入result
        //     result.add(level);
        // }
        // return result;
    }
}
// @lc code=end

