/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        //解法 ：二分查找，x的平方根小于 x
        //
        long left = 1;
        long right = x;
        long mid = 1;
        while(left <= right){
            mid = left + (right - left)/2;
            if(mid * mid == x){
                return (int)mid;
            }else if(mid * mid < x){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return (int)right;
    }
}
// @lc code=end

