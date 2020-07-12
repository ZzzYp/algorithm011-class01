1，树的实现，就是通过递归，所以递归来实现树的遍历，是一种常用方式 

2，递归： 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本质也是循环，是通过函数体来进行循环，即通过循环体调用自己来进行循环

\```

public void 递归(level, param1......){

  1,中止条件 recursion terminator

  if(level > MAX_LEVEL){

​    return

  }

  2，处理当前层逻辑 process logic in current level

  process(level,param)

  

  3，下探到下一层 drill down

  递归(level+1, newParam......)

  

  4, reverse the current level status if needed 如果有需要的话，清理当前层

}



思维要点：

  1，不要人肉进行递归

  2，找到最近最简方法，将其拆解成可重复解决的问题(重复子问题)

  3，数学归纳法的思维，简单点就是，当n=1，n=2，....n=n 成立的时候，可以推导出n+1也成立

\```



3，斐波那契数列解法： 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;什么是斐波那契数列 就是指 f(n) = f(n-1) + f(n-2) 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1，傻递归，时间复杂度高，因为有很多重复计算 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2，动态规划，目前还未学到 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3，使用缓存，每次循环，将f(n-1) 和 f(n-2) 的值缓存起来，进行计算，就不会有重复计算了，时间复杂度为O(n)



4，回溯模板 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;回溯：枚举所有可能，然后把正确的解输出。举例子比较好理解，就像有一条路可以到达终点，但是有n个分叉口指向死胡同，回溯就是随意选择一个分叉口，如果发现是死胡同，就回头选择另一条路，直到到达了目的地

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;回溯优化：可以通过剪枝来达到优化的目的

\```

List<List<Integer>> result = new ArrayList<>();

public List<List<Integer>> fun(int[] nums){

  generate(0, nums.length, nums, new ArrayList<>());

}



public void generate(int start, ine len, int[] nums, List<Integer> list){

  result.add(new ArrayList<>(list));

  //terminator

  for(int i=start; i<len; i++){

​    //process

​    list.add(nums[i]);

​    //drill down

​    generate(i+1,len,nums,list);

​    //reverse

​    list.remove(list.size() - 1);

  }

}

\```



5，分治： 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分治就是将一个大问题分解为若干互不干扰的子问题，然后将子问题的答案组合起来，就成了大问题的答案。 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分治和递归的区别：分治是一种解决问题的思想，递归是解决问题的一种编程技巧 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;树问题的分治模板

\```

public void fun(TreeNode root){

  

  left = fun(root.left);

  right = fun(root.right);

  merge(left,right);

} 

\```