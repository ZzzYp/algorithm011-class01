/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
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
    //解法2： 迭代
    //思路：递归其实就是把递归中每一步的处理压入栈中，那么迭代就是我们自己创建一个栈，来实现递归的效果
    //1，首先创建一个栈
    //2，由于是前序遍历，先将根节点压入栈中
    //3，开始遍历，将根节点从栈顶中取出，然后获取根节点的子节点， 假如获得的子节点为 c1, c2, c3, c4, c5
    //4，然后将获取的子节点，反转然后压入栈中，即压入栈中的顺序为c5, c4, c3, c2, c1 由于栈的特性是后入先出，所以为了保证从栈顶拿的节点为上一个节点的第一个节点，要进行反转入栈的处理
    //5，然后从栈中取出栈顶的节点，将节点的值存入一个新建的list，作为结果返回，然后继续从栈顶节点获取其子节点
    //6，当stack为空的时候，说明遍历完成了
    public List<Integer> preorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        //先将根节点入栈
        stack.add(root);
        if(root == null){
            return list;
        }

        while(!stack.isEmpty()){
            //将栈中的栈顶节点取出
            Node node = stack.pollLast();
            //将节点的值存入list
            list.add(node.val);
            //反转当前节点的子节点
            Collections.reverse(node.children);
            //遍历当前节点的子节点(反转以后的), 按顺序压入栈中
            for(Node temp : node.children){
               stack.add(temp);
            }
        }

        return list;
    }


    //解法1：递归
    // List<Integer> list = new ArrayList<>();
    // public List<Integer> preorder(Node root) {
    //     order(root);
    //     return list;
    // }

    // public void order(Node root){
    //     if(root == null){
    //         return ;
    //     }
    //     //前序递归，先将根节点加入list
    //     list.add(root.val);
    //     for(int i=0; i<root.children.size(); i++){
    //         order(root.children.get(i));
    //     }
    // }
}
// @lc code=end

