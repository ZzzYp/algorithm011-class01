/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        //双指针
        String lowerS= s.toLowerCase();
        char[] lowerSChar = lowerS.toCharArray();
        int left = 0;
        int right = lowerS.length() - 1;
        
        while(left <= right){
            while(left <= right && !Character.isLetterOrDigit(lowerSChar[left])) left++;
            while(left <= right && !Character.isLetterOrDigit(lowerSChar[right])) right--;
            

            if(left <= right && lowerSChar[left] != lowerSChar[right]){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
// @lc code=end

