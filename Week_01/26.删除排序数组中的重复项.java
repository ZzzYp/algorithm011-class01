/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        //解题思路3，双指针，删除重复元素意思就是将不重复的元素移动到数组的左边，重复的移动到右边，所以一个快指针，一个慢指针，快指针从数组的第二位开始遍历，当慢指针代表的元素的值和快指针代表的元素的值不等的时候，将快指针的值赋值给慢指针+1索引所在的值，这代表了快指针循环结束以后，慢指针之前的所有元素都不重复，而慢指针之后的元素就是和之前的元素重复的部分。新数组的长度就等于索引+1，即慢指针+1
        //双指针，i走的快，j走的慢
        //遍历数组，当nums[i] != nums[j]的时候，说明没有重复情况，将nums[i]的值赋值给num[j]，直到遍历结束
        //这个时候，j索引所在的元素就是无重复元素数组的最大值，数组长度为j+1
        if(nums.length < 1){
            return 0;
        }
        int j = 0;
        for(int i=1; i < nums.length; i++){
           if(nums[i] != nums[j]){
              j++;
              nums[j] = nums[i];
           }
        }
        return j + 1;




        // //解题思路2，遍历数组，将重复的元素赋值为这个数组的最大值，将每次赋值的count累加
        // //然后再进行排序， 新数组的长度 = len - count；
        // int len = nums.length; 
        // if(len <= 0){
        //    return 0;
        // }
        // int max = nums[len-1];
        // int min = nums[0];
        // int count = 0;
        // if(len < 1){
        //    return 1;
        // }
        // for(int i=0; i<len; i++){
        //     if(i>0 && nums[i] == min){
        //         nums[i] = max;
        //         count++;
        //     }else{
        //         min = nums[i];
        //     }
        // }
        // Arrays.sort(nums);

        // return len - count;




        // //解题思路1，遍历数组，将重复的元素赋值为这个数组的最大值，
        // //然后再进行排序，遍历数组，将遍历到的元素等于最大值的索引+1返回，相当于新数组的长度
        // int len = nums.length; 
        // if(len <= 0){
        //    return 0;
        // }
        // int max = nums[len-1];
        // int min = nums[0];
        // if(len < 1){
        //    return 1;
        // }
        
        // for(int i=0; i<len; i++){
        //     if(i>0 && nums[i] == min){
        //         nums[i] = max;
        //     }else{
        //         min = nums[i];
        //     }
        // }
        // Arrays.sort(nums);

        // for(int i=0; i<len; i++){
        //     if(nums[i] == max){
        //         return i+1;
        //     }
        // }
   
        //return 0;
    }
}
// @lc code=end

