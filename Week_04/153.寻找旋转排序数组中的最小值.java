/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        //二分查找
        //找到转折点i，然后比较index = 0 ， i + 1, 的大小
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return nums[0] > nums[1] ? nums[1] : nums[0];
        }       
        if(nums[0] < nums[nums.length - 1]){
            return nums[0];
        }         
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        int num = 0;

        
        while(left <= right){
            mid = left + (right - left)/2;
            if(nums[mid] > nums[mid + 1]){
                return nums[mid + 1];
            }
            if(nums[mid] < nums[mid - 1]){
                return nums[mid];
            }
                
            if(nums[mid] > nums[0]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return -1;
    }
}
// @lc code=end

