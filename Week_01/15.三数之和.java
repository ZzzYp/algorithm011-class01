/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //先排序，后遍历
        List<List<Integer>> arrlist = new ArrayList();
        int len = nums.length;
        if(null == nums || len < 3){
           return arrlist;
        }
        Arrays.sort(nums);

        //遍历求值，三个数分为左，中，右，左为数组第一个数，中为左边第一个数，右为数组最右边的数
        //先固定左，然后移动中和右两个，移动规则为：
        // 1，由于是排好序的数组，如果左>0 , 则左，中，右肯定全部大于0，相加等于0是不可能的，结束循环，返回
        // 2，开始遍历 如果nums[n] == nums[n-1] ,则跳过，因为是重复了，需要去重
        // 3， 当左+中+右 = 0的时候，nums[左] == nums[左+1] ,则 去重跳过
        // 4， 当左+中+右 = 0的时候，nums[右] == nums[右-1] ,则 去重跳过
        // 5， 当左+中+右 > 0的时候，说明应该减小三个数的和，左不动的情况下，只能将右往左边移一位，即右--，这样三个数的和才会变小
        // 6， 当左+中+右 < 0的时候，说明应该增大三个数的和，左不动的情况下，只能将中往右边移一位，即中++，这样三个数的和才会增加
        for(int left = 0; left < len; left++){
            if(nums[0] > 0){
                 break;
            }
            if(left >= 1 && nums[left] == nums[left-1]){
                 continue;
            }
            int mid = left + 1;
            int right = len -1;
            while(mid < right){
                int sum = nums[left] + nums[mid] + nums[right];
                if(sum == 0){
                    arrlist.add(Arrays.asList(nums[left],nums[mid],nums[right]));
                    while(mid < right && nums[mid] == nums[mid+1]){
                        mid++;
                    }
                    while(mid < right && nums[right] == nums[right -1]){
                        right --;
                    }
                    mid++;
                    right--;                    
                }else if(sum > 0){
                  right--;
                }else{
                  mid++;
                }
            }
        }
        return arrlist;
    }
}
// @lc code=end

