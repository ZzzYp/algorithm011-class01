/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
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
    //解法2
    //Map中key为root.son.val, value 为root，即key存放子节点的val,value存放父节点
    //当p和q节点往根节点移动的时候，可以根据val访问到父节点
    Map<Integer, TreeNode> parents = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //解法2，递归二叉树，然后迭代判断，
        //1，存储所有节点的父节点
        //2，从p节点开始往根节点移动，记录所有访问过的父节点
        //3，从q节点开始往根节点移动，如果碰到了之前访问过的父节点，那么这个节点就是最近公共祖先
        
        //
        if(root == null){
            return root;
        }

        getParents(root);
        
        //将p从p到根移动，记录访问过的节点
        while(p != null){
             visited.add(p.val);
             p = parents.get(p.val);
        }
        
        while(q != null){
             if(visited.contains(q.val)){
                return q;
             }
             q = parents.get(q.val);
        }



        // //解法1：递归
        // //teminator
        // //
        // if(root == null || root == p || root == q){
        //     return root;
        // }
        // //process
        // //drill down
        // //当root != p且root != q，说明还没有递归到p或者q节点，继续递归左子树和右子树
        // TreeNode left =  lowestCommonAncestor(root.left, p ,q);
        // TreeNode right = lowestCommonAncestor(root.right, p, q);
         
        // if(left == null){
        // //当当前节点的left节点为null且right不为null ，说明当前节点的左子树中不包含p或者q，那么right节点就是最近公共祖先
        //     return right;
        // }
        // //同理
        // if(right == null){
        //     return left;
        // }

        // return root;
        
        return root;
    }

    public void getParents(TreeNode root){
        if(root != null && root.left != null){
            parents.put(root.left.val, root);
            getParents(root.left);
        }
        if(root != null && root.right != null){
            parents.put(root.right.val, root);
            getParents(root.right);
        }
    }
}
// @lc code=end

