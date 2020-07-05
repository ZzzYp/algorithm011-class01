学习笔记
1，用到了很多次通过HashMap，统计次数。 将数组中的值作为key，将次数作为value。比如字母异位词，前k个高频元素相关算法题

2，尾插法，比较大小的时候，将大的值插入集合尾部。比如合并有序数字

3，堆排序，有最大堆，最小堆的说法，分别是从大到小排序和从小到大排序。堆排序一般时间复杂度为logn

4，二叉树的遍历，有固定公式
   前序遍历： 中左右
   递归模板
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

    中序遍历 左中右
    // public void order(TreeNode node, List<Integer> list){
    //     if(node == null){
    //         return ;
    //     }
    //     //中序遍历  左 --> 根 --> 右
    //     order(node.left, list);
    //     list.add(node.val);
    //     order(node.right, list);

    // }
    后序遍历 左右中
    // public void order(TreeNode node, List<Integer> list){
    //     if(node == null){
    //         return ;
    //     }
    //     //中序遍历  左 --> 右 --> 根
    //     order(node.left, list);
    //     order(node.right, list);
    //     list.add(node.val);

    // }


5，二叉树的迭代遍历
   迭代遍历，就是将递归中的压栈自己实现。递归就是把每一次递归都压入了栈中
   迭代模板
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

    
           
6，学会总结很重要，而目前的总结并不好，还需继续努力