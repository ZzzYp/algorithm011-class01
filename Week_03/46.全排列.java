/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        //解法： 回溯
        if(nums == null || nums.length == 0){
            return result;
        }
        
        int len = nums.length;
        //用来标识当前层的元素是否被使用过
        boolean[] usered = new boolean[len];
        
        generate(len, 0, new ArrayList<>(), nums, usered);

        return result;
    }
    //start表示从0开始递归，当start = len的时候，完成了一次完整的递归，将结果返回
    public void generate(int len, int start, List<Integer> list, int[] nums, boolean[] usered){
        //ternimator
        if(start == len){
            result.add(new ArrayList<>(list));
            return;
        }
        //prepare data
        //开始for循环
        for(int i = 0; i < len ; i++){
            //如果当前层的元素没有被使用过，就将元素加入list
            if(!usered[i]){
                int temp = nums[i];
                list.add(temp);
                //将当前层的元素设为已使用
                usered[i] = true;
                //递归到下一层，start +1 ,即层数+1
                generate(len, start + 1, list, nums, usered);
                //当回溯到当前层的时候，将状态重置，将已使用重置为未使用
                usered[i] = false;
                //将当前元素移出list
                list.remove(list.size() - 1);
            }
        }
    }
}
// @lc code=end

