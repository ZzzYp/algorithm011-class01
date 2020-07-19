/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        //解法： 二分查找
        long left = 1;
        long right = num;
        long mid = 1;
        while(left <= right){
            mid = left + (right - left) /2;
            if(mid * mid == num){
                return true;
            }else if(mid * mid < num){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return false;
    }
}
// @lc code=end

