/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        //解法2：排序
        //思路，对数组进行排序，然后只要处于n/2位置的元素，一定是出现次数大于n/2的元素
        Arrays.sort(nums);
        return nums[nums.length /2];


        //解法1，hash表
        //思路：通过hash表，统计元素出现的次数，然后遍历hash表，将大于n/2次数的元素输出
        // if(nums.length == 0){
        //     return 0;
        // }

        // Map<Integer, Integer> maps = new HashMap<>();
        // for(int num :nums){
        //     maps.put(num , maps.getOrDefault(num, 0) + 1);
        // }

        // int target = nums.length / 2;
        // for(Integer key : maps.keySet()){
        //     if(maps.get(key) > target){
        //        return key;
        //     }
        // }

        // return 0;
    }
}
// @lc code=end

