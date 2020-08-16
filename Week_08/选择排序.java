/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * 选择排序
 */

// @lc code=start
class Solution {
    public int[] fun(int[] nums) {
        int len = nums.length;
        int minIndex = 0;
        int temp = 0;
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                if(nums[minIndex] > nums[j]){
                    minIndex = j;
                }
            }
            temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        

        return nums;
    }
}