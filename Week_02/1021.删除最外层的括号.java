/*
 * @lc app=leetcode.cn id=1021 lang=java
 *
 * [1021] 删除最外层的括号
 */

// @lc code=start
class Solution {
    public String removeOuterParentheses(String S) {
        //解法2；使用栈
        //创建一个栈
        Stack<Character> stack = new Stack<>();
        //通过StringBuilder拼接正确的结果
        StringBuilder result = new StringBuilder();

        //需要start和end两个参数来确定正确结果再字符串中的位置，然后通过substring截取
        int start = 0;
        int end = 0;
        //每次截取完正确的结果后，要重置起始位置
        boolean isResetStart = false;

        for(int i=0; i<s.length(); i++){
            char cs = s.charAt(i);
            //当遍历到左括号的时候，入栈
            if(cs == '('){
                //入栈
                stack.push(cs);
                //当产生一次正确结果以后，就需要重置start，从遍历到的i位置，重新开始入栈，出栈，确定正确值范围
                if(isResetStart){
                    start = i;
                    isResetStart = false;
                }
            } 
            //当遍历到右括号的时候出栈，然后判断栈是否为空，如果为空，说明在start+1和end之间，就是正确的结果
            //如果不为空，则正确结果未产生，需要继续遍历以及入栈出栈
            if(cs == ')'){
                //出栈
                stack.pop();
                if(stack.isEmpty()){
                    end = i;
                    result.append(s.substring(start+1,end));
                    start = end;
                    isResetStart = true;
                }
            }

        }
        return result.toString();
    }



    //解法1. 通过判断字符串，如果是左括号，则count+1， 如果是右括号，则count-1，每次遍历都去判断count是否大于等于1，如果是，则说明还未得到一个有效括号字符串原语，需要拼接当前遍历的字符，如果为否，则说明已经得到有效括号字符串原语
    //为什么拼接动作要在中间，因为要删除每个部分的最外层括号，意味着遍历到他们的时候，不能拼接到字符串中，所以放在中间
    //     if(s.length() < 1){
    //         return s;
    //     }
    //     StringBuilder sb = new StringBuilder();
    //     int count = 0;
    //     for(int i=0; i<s.length(); i++){
    //        char c = s.charAt(i);
    //        if(c == ')'){ count--; };
    //        if(count >= 1){sb.append(c);};
    //        if(c == '('){ count++; };
    //     }

    //     return sb.toString();
    // }
    //}
}
// @lc code=end

