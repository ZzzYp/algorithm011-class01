/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        //解法： 递归 
        //思路：通过递归，在每个节点，都将sum = sum - root.val ，当递归到叶子节点的时候，就比较sum和叶子节点的val是否相同，如果相同就return true ， 反之return false；

        return generate(root, sum);

    }

    public boolean generate(TreeNode root, int sum){
        //terminator
        if(root == null){
            return false;
        }
        //判断的是根节点到叶子节点的路径，所以当递归到叶子节点，就停止递归
        if(root.left == null && root.right == null){
            return sum == root.val;
        }
        //process
        sum = sum - root.val;
        //drill down
        return generate(root.left, sum) || generate(root.right, sum);
            
        //reverse
    }
}
// @lc code=end

