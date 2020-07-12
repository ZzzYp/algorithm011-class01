/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //中序遍历 左根右
        //后序遍历 左右根
        //解法： 参考前序遍历和中序遍历构建二叉树

        //inLeft：中序遍历数组左子树的左边界
        //pIndex-1：中序遍历数组左子树的右边界
        //pIndex : 中序遍历数组数的根节点
        //pIndex +1  : 中序遍历数组右子树的左边界
        //inRight : 中序遍历数组右子树的右边界

        //postLeft：后序遍历数组左子树的左边界
        //nodeX-1：后序遍历数组左子树的右边界
        //nodeX : 后序遍历数组右子树的左边界
        //postRight-1  : 后序遍历数组右子树的右边界
        //postRight :  后序遍历数组数的根节点
        

        //中序遍历数组： inLeft          pIndex-1       pIndex     pIndex+1            inRight
        //后序遍历数组： postLeft        nodeX-1                   nodeX               postRight-1      postRight
        //右子树区间相同 ==> postRight - 1 - nodeX = inRight - (pIndex + 1) ==> nodeX = postRight - inRight + pIndex
        
        int inLen = inorder.length;
        int postLen = postorder.length;
        if(inLen != postLen || inLen == 0 || postLen == 0){
            return null;
        }
        Map<Integer, Integer> maps = new HashMap<>();
        for(int i=0; i< inorder.length; i++){
            maps.put(inorder[i], i);
        }
        
        int inLeft = 0;
        int inRight = inLen - 1;
        int postLeft = 0;
        int postRight = postLen - 1;
  
        return buildTree(maps, inLeft, inRight, postorder, postLeft, postRight);
    }

    public TreeNode buildTree(Map<Integer, Integer> maps, int inLeft, int inRight, int[] postorder, int postLeft, int postRight){

        //ternimator
        if(inLeft > inRight || postLeft > postRight){
            return null;
        }

        //process
        //获取左右子树的根节点
        TreeNode root = new TreeNode();
        root.val = postorder[postRight];
        //根节点在中序遍历数组中的索引
        int pIndex = maps.get(root.val);
        //后序遍历数组右子树的左边界
        int nodeX = postRight - inRight + pIndex;
        //drill down
        //递归根节点的左子树
        root.left = buildTree(maps, inLeft, pIndex-1, postorder, postLeft, nodeX -1);
        //递归根节点的右子树
        root.right = buildTree(maps, pIndex +1, inRight, postorder, nodeX, postRight -1);

        return root;
    }
// @lc code=end

