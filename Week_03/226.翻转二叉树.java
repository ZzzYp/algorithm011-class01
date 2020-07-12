/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
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
    public TreeNode invertTree(TreeNode root) {
        //迭代： 从根节点开始反转，使用队列存储未反转的节点
        if(root == null){
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curremtRoot = queue.poll();
            TreeNode temp = curremtRoot.left;
            curremtRoot.left = curremtRoot.right;
            curremtRoot.right = temp;

            if(curremtRoot.left != null){
                queue.add(curremtRoot.left);
            }

            if(curremtRoot.right != null){
                queue.add(curremtRoot.right);
            }            
        }

        return root;
    }

    // public TreeNode invertTree(TreeNode root) {
    //     //递归：
    //     invert(root);

    //     return root;
    // }

    // public TreeNode invert(TreeNode root){
    //     //terminator
    //     if(root == null){
    //         return null;
    //     }
    //     //process
    //     //drill down
    //     //获取下层的左右节点，然后将下层的左节点赋值给当前节点的右节点，将下层的右节点赋值给当前节点的左节点，完成二叉树的反转
    //     TreeNode left = invert(root.left);
    //     TreeNode right = invert(root.right);
         
    //     root.left = right;
    //     root.right = left;

    //     return root;
    // }
}
// @lc code=end

