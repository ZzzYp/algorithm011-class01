/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        //解法：回溯
        if(nums.length == 0){
            return result;
        }
        int len = nums.length;
        generate(nums, len, 0, new ArrayList<>());
        return result;
    }


    public void generate(int[] nums, int len, int start, List<Integer> list){
        
        result.add(new ArrayList<>(list));
        //terminator
        for(int i=start; i<len; i++){
            //process
            list.add(nums[i]);
            //drill down
            generate(nums, len, i+1, list);
            //reverse
            list.remove(list.size() - 1);
        }
       
    }
}
// @lc code=end

