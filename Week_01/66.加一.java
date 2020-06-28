/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        //思路： 元素n末尾为9的元素，只要+1，然后%10 ，必为0，这个时候，就要往n-1的位置进1，即+1，持续到%10不为0为止。
        //元素n末尾不为9的元素，+1以后，%10不为0，就可以直接返回
        for(int i = digits.length - 1; i >= 0; i--){
            digits[i]++;
            digits[i] = digits[i]%10;
            if(digits[i] != 0){
               return digits;
            }
        }
        //特殊情况 ，当数组为类似于[9,9,9,9,9,9]的时候，从最后一位+1开始，  %10都为0，直到第一位，这个时候，数组长度就要+1，然后第一位为1
        digits = new int[digits.length +1];
        digits[0] = 1;
        return digits;
    }
}
// @lc code=end

