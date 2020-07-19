/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        //解法： 二分查找
        if(nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[left] <= nums[mid]){
                //说明left --- mid 之间的数字是有序的，注意要nums[left] <= target
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                //说明mid ---- right之间的数字是有序的，注意要target <= nums[right]
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            
            }
        }

        return -1;
    }
}
// @lc code=end

