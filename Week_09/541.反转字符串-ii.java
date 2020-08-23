/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        if(null == s || s.length() == 0){
            return s;
        }
        char[] sArr = s.toCharArray();
        for(int i = 0; i < sArr.length; i = i + 2*k){
            int start = i;
            int end = Math.min(i + k - 1, sArr.length - 1);
            while(start < end){
                char temp = sArr[start];
                sArr[start++] = sArr[end];
                sArr[end--] = temp;
            }
        }   

        return new String(sArr);
    }
}
// @lc code=end

