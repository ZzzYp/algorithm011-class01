/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        //解法1 ： 使用栈，遍历字符串，将左括号所在的索引入栈，碰到右括号就将栈顶的左括号出栈，然后字串长度为当前右括号的索引减去栈顶左括号的索引
        if(s.length() <=1){
            return 0;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        //push一个-1，是为了 比如"()()()"这种，字符串长度 = 有效括号的子串的长度 的情况下，可以得到正确的值
        stack.push(-1);
        //将字符串转化为char数组
        char[] chars = s.toCharArray();
        int len = chars.length;
        int charLength = 0;
        //遍历char数组
        for(int i = 0; i < len; i++){
            char c = chars[i];
            if(c == '('){
                //遇到左括号，将左括号对应的索引，压栈
                stack.push(i);
            }else{
                //遇到右括号,就将栈顶左括号对应的索引出栈
                stack.pop();
                if(!stack.isEmpty()){
                    //如果栈不为空，则字串长度charLength = 当前遍历到的括号的索引 - 左括号出栈以后，栈顶的索引值
                    charLength = Math.max(charLength, i - stack.peek());
                }else{
                    stack.push(i);
                }
                
            }
             
        }
        return charLength;
    }
}
// @lc code=end

