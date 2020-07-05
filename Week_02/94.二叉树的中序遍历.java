/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
    public List<Integer> inorderTraversal(TreeNode root) {
        //迭代 -- 中序遍历  左中右
        //解法2：通过迭代
        //1，先将从根节点到最左的左子节点的所有节点入栈
        //2，设置一个当前节点的变量，表示当前是哪个节点，取出栈中的左子节点，赋值给当前节点，将当前节点的值保存
        //3，将当前节点设置为当前节点的右节点，然后进行再一次的循环
        if(null == root){
            return new ArrayList<>();
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        TreeNode currnetNode = root;
        while(currnetNode != null || !stack.isEmpty()){
            while(currnetNode != null){
                stack.push(currnetNode);
                currnetNode = currnetNode.left;
            }
        
            currnetNode = stack.pop();
            list.add(currnetNode.val);
    
            currnetNode = currnetNode.right;
        }       
 

        return list;
    }




    // public List<Integer> inorderTraversal(TreeNode root) {
    //     //递归, 
    //     //解法1：通过二叉树递归公式解
    //     //时间复杂度 O(n) :  2*T(n/2) +1
    //     //空间复杂度 O(logn) ,最坏O(n)
    //     List<Integer> list = new ArrayList<>();
    //     order(root, list);
    //     return list;
    // }

    // public void order(TreeNode node, List<Integer> list){
    //     if(node == null){
    //         return ;
    //     }
    //     //中序遍历  左 --> 根 --> 右
    //     order(node.left, list);
    //     list.add(node.val);
    //     order(node.right, list);

    // }
}
// @lc code=end

