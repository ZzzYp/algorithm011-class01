/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        //解法3：旋转数组
        //思路：先旋转整个数组，然后再旋转前k个数，然后再旋转后n-k个数
        //前提，旋转k次数组，相当于将k % nums.length个尾部元素放到了数组头部，剩下的数组移到数组后部
        k = k % nums.length;

        rotateNum(nums, 0, nums.length-1);
        rotateNum(nums, 0, k-1);
        rotateNum(nums, k, nums.length-1);

        //解法2：使用额外数组
        //创建一个额外数组，然后将原数组i位置的放到新数组(i+k)%nums.length 位置
        //(i+k)%nums.length 对nums.length取余，就相当于右移了k个位置
        // int len = nums.length;
        // int[] temp = new int[len];
        // for(int i=0; i<len; i++){
        //     int index = (i+k)%len;
        //     temp[index] = nums[i];
        // }

        // for(int i=0; i<len; i++){
        //     nums[i] = temp[i];
        // }



        //解法1：暴力解法，通过两个变量，循环遍历数组，将数字集体右移k次
        //时间复杂度，数组要遍历三次，为O(n*3)
        //空间复杂度，没有根据数组长度n，动态增加空间，使用的都为固定空间，为O(1)
        // int len = nums.length;
        // while(k > 0){
        //     //index=0的时候，右移以后的值为数组的最后一个值
        //     int prevNum = nums[len-1];
        //     int curtNum = 0;
        //     for(int i=0; i < nums.length; i++){
        //         //先记录当前index索引对应的值
        //         curtNum = nums[i];
        //         //将当前index索引对应的值赋值为右移以后的值，而数组整体右移，当前值都等于前一个值
        //         nums[i] = prevNum;
        //         //将prevNum赋值为index索引对应的右移之前的值，以便下一次遍历的时候使用
        //         prevNum = curtNum;
                
        //     }
        //     k--;
        // }
    }
    public void rotateNum(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            end --;
            start++;
        }

    }

}
// @lc code=end

