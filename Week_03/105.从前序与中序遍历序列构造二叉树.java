/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //解法： 递归
        //前序遍历是 根左右
        //中序遍历是 左根右
        //1，假设preorder 的左边界为preLeft = 0，右边界为preRight = len -1, 那么可以得出左子树边界为preLeft + 1, 假设右子树边界为nodeX ,那么 左子树边界为preLeft + 1，nodeX， 右子树边界为 nodeX+1，preRight
        //2，假设inorder 的左边界为inLeft = 0, 右边界inRight = len - 1，根节点为 pIndex 那么 左子树的左右边界分别为inLeft，pIndex -1 ，右子树的左右边界分别为 pIndex + 1 , inRight;
        //由1，2可得出  二叉树左子树个数 : nodeX - (preLeft + 1)(前序遍历) = pIndex - 1 - inLeft(中序遍历) ==> nodeX = pIndex - inLeft + preLeft;
        //下面开始实现
        
        int preLen = preorder.length;
        int inLen = inorder.length;
        int preLeft = 0;
        int preRigth = preLen - 1;
        int inLeft = 0;
        int inRight = inLen - 1;

        //先将中序遍历映射为Map ，key为数组值，value为数组下标
        Map<Integer, Integer> maps = new HashMap<>();
        for(int i=0; i<inLen; i++){
            maps.put(inorder[i],i);
        }

        return buildTree(preorder, preLeft, preRigth, maps, inLeft, inRight);
    }

    public TreeNode buildTree(int[] preorder, int preLeft, int preRigth, Map<Integer, Integer> maps, int inLeft, int inRight){
        //ternimator
        if(preLeft > preRigth || inLeft > inRight){
            return null;
        }
        //process
        TreeNode root = new TreeNode(preorder[preLeft]);
        int pIndex = maps.get(root.val);
        //drill down
        //build左子树
        root.left = buildTree(preorder, preLeft + 1, pIndex - inLeft + preLeft, maps, inLeft, pIndex -1);
        //build右子树
        root.right = buildTree(preorder,  pIndex - inLeft + preLeft +1,preRigth, maps, pIndex + 1 ,inRight);

        return root;

    }
}
// @lc code=end

