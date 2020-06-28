/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //解法3：使用hashMap，并且单循环
        Map<Integer, Integer> maps = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int num  = target - nums[i];
            if(maps.containsKey(num) && maps.get(num) !=i){
               return new int[]{maps.get(num), i};
            }
            maps.put(nums[i],i);
        }

        return null;




        //解法2：使用hashMap，做两个循环，第一个循环将数组元素加入map,第二个循环，比较map中，是否包含target - nums[i]
        //将数组的值和索引存入到map中
        // Map<Integer, Integer> maps = new HashMap<>();
        // for(int i=0; i<nums.length; i++){
        //     maps.put(nums[i],i);
        // }
        // //遍历数组，判断map中是否包含有target - nums[i]
        // for(int i=0; i<nums.length; i++){
        //     int num = target - nums[i];
        //     if(maps.containsKey(num) && maps.get(num) != i){
        //          return new int[]{i, maps.get(num)};
        //     }
        // }

        // return null;


        //解法1：遍历数组，固定左边值，移动右边值，和左边值相加，求取是否有目标值 时间复杂度为O(n2)，空间复杂度O(1)
        // int left = 0;
        // int right = 0;
        // int len = nums.length;

        // for(int i=0; i < len; i++){
        //     left = i;
        //     right = len -1;
        //     while(left < right){
        //         int sum = nums[left] + nums[right];
        //         if(sum == target){ 
        //            return new int[]{left,right};    
        //         }else{
        //             right--;
        //         }
        //     }

        // }
        // return null;
    }
}
// @lc code=end

