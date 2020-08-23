/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        //解法 迭代
        if(null == s || s.length() == 0){
            return 0;
        }
        int charLen = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for(int i=0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(temp == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(!stack.isEmpty()){
                    int index = stack.peek();
                    charLen = Math.max(i - index,charLen);
                }else{
                    stack.push(i);
                } 
            }
        }

        return charLen;
    }
}
// @lc code=end

