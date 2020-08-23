/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        if(null == s || s.length() == 0){
            return s;
        }

        String[] strArr = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = strArr.length - 1; i >= 0; i--){
            String temp = strArr[i].trim();
            if(strArr[i].length() == 0){ 
                continue;
            }
            if(i == 0){
                sb.append(temp);
            }else{
                sb.append(temp + " ");
            }
        }

        return sb.toString();
    }
}
// @lc code=end

