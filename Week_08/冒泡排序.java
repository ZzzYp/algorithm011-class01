/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * 冒泡排序
 */

// @lc code=start
class Solution {
    public int[] fun(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len - 1; i++){
            for(int j = 0; j < len - 1 - i; j++){
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums;
    }
}