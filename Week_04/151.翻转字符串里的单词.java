/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        //解法： 分割字符串，从尾端输出
        if(null == s || s.trim().length() == 0){
            return "";
        }
        String[] sArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = sArr.length - 1; i>=0; i--){
            if(sArr[i].length() == 0){ 
                continue;
            }
            sb.append(sArr[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();

    }
}
// @lc code=end

