/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        //解法2：两次循环，第一次将所有非零元素移动到数组的前面，然后记录移动完以后的索引index，
        //第二次循环，将index以及后面的元素都置为0
        int index = 0;

        for(int i=0; i<nums.length; i++){
           if(nums[i] !=0){
               nums[index] = nums[i];
               index++;
           }
        }

        for(int i=index; i<nums.length; i++){
           nums[i] = 0;
        }



        // //解法1：参考快速排序，将基准点设为0，不等于0的数移动到左边，等于0的数移动到右边
        // for(int i=0,j=0; i<nums.length; i++){
        //     //如果当前元素不等于0，则交换i位置和j位置的元素，然后i和j各前进一位
        //     //如果当前元素等于0，这个时候由于j在之前交换位置之后，已经前进过一位了，所以j指向元素为0，不做调整，i元素前进一位
        //     //上面的逻辑可以保证j在第一次指向0元素后，始终会指向0，所以当数组遍历完以后，j左边就是非零元素，j以及右边是零元素
        //     if(nums[i] != 0){
        //           int temp = nums[i];
        //           nums[i] = nums[j];
        //           nums[j++] = temp;
        //     }

        // }

    }
}
// @lc code=end

