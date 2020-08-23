/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长上升子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        //解法2：动态规划 + 二分
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            int left = 0;
            int right = result;
            while(left < right){
                int mid = left + (right - left)/2;
               
                if(dp[mid] < nums[i]){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            dp[left] = nums[i];
            //int temp = dp[left];
            //System.out.println("  dp[left]  :  " + dp[left] + "  left  :  " + left + "  right  :  " + right);
            if(result == right){
                result++;
            }
        }
        return result;

        //解法1： 动态规划
        // if(nums.length == 0){
        //     return 0;
        // }
        // int[] dp = new int[nums.length];
        // Arrays.fill(dp, 1);
        // int result = 1;
        // for(int i = 0; i < nums.length; i++){
        //     for(int j = 0; j < i; j++){
        //         if(nums[j] < nums[i]){
        //             dp[i] = Math.max(dp[i], dp[j] + 1);
        //         }
        //     }
        //     result = Math.max(result, dp[i]);
        // }

        //return result;
    }
}
// @lc code=end

