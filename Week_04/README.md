学习笔记

##### 1，DFS和BFS：  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DFS:深度优先遍历  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;代码模板  
```
1.递归方式
//多叉树
Set<TreeNode> visited = new HashSet<>();
public void dfs(Treenode root, Set<TreeNode> visited){
    //terminator
    if(visited.contains(root)){
        //already visited
        return
    }
    visited.add(root);
    //process current node here
    for(Treenode node : node.children()){
        if(!visited.contains(root)){
            dfs(node, visited);
        }
    }
}

2,用栈模拟递归的方式
//多叉树

public void dfs(Treenode root){
    if(root == null){
        return
    }
    Set<TreeNode> visited = new HashSet<>();
    LinkedList<Treenode> stack = new LinkedList<>();
    stack.push(root);
    
    while(!stack.isEmpty()){
        Treenode node = stack.pop();
        visited.add(node);
        //这个地方执行在当前node的时候，需要的流程
        process(node);
        //获取node的子node列表
        List<Treenode> nodes = generate_related_nodes(node);
        stack.push(nodes);
    }
}
```


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;BFS:广度优先遍历  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;代码模板  
```
1,使用队列
public void bfs(Treenode root){
    Set<Treenode> visited = new HashSet<>();
    LinkedList<Treenode> queue = new LinkedList<>();
    List<List<Object>> result = new ArrayList<>();
    queue.add(root);
    
    while(!queue.isEmpty()){
        List<Object> saveCurrnetLevel = new ArrayList<>();
        int currentLevelSize = queue.size();
        for(int i=0; i < currentLevelSize; i++){
            Treenode node = queue.poll;
            saveCurrnetLevel.add(node);
            queue.addAll(node.children);
        }
        result.add(saveCurrnetLevel);
    }
    
    return result;
}

2,使用递归
List<List<Object>> result = new ArrayList<>();

public void bfs(Treenode root, int level){
    if(result.size() <= level){
        result.add(new ArrayList<>());
    }
    result.get(level).add(root);
    for(Treenode node : root.childern()){
        bfs(node, level+1);
    }
    
}
```

3，二分查找  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;代码模板  
```
public void binarySearch(int[] nums, int target){
    int left = 0;
    int right = nums.length - 1;
    while(left <= right){
        int mid = (left + right) / 2;
        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] < target){
            left = mid + 1;
        }else{
            right = mid - 1;
        }
        
    }
    
}
```
对于二分查找，数组一定是要有序的，否则只能一个个去遍历