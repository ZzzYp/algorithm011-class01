/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
    public List<Integer> preorderTraversal(TreeNode root) {
        //前序遍历  中左右
        //解法1： 迭代
        //1，先将中压栈，然后输出
        //2，因为输出顺序是 左 右，所以先把右压入栈，再把左压入栈
        //3，通过后入先出，先出栈的就是左，后出栈的是右， 符合顺序 中左右
        if(null == root){
            return new ArrayList<>();
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            
            TreeNode currentNode = stack.pop();
            list.add(currentNode.val);

            if(currentNode.right != null){
               stack.push(currentNode.right);
            }
            if(currentNode.left != null){
               stack.push(currentNode.left);
            }
        }

        return list;
    }
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     //前序遍历  中左右
    //     //解法1： 递归
    //     List<Integer> list = new ArrayList<>();
    //     order(root, list);
    //     return list; 
    // }

    // public void order(TreeNode root, List<Integer> list){
    //     if(root == null){
    //         return;
    //     }
    //     //中
    //     list.add(root.val);
    //     //左
    //     order(root.left, list);
    //     //右
    //     order(root.right, list);
    // }
}
// @lc code=end

