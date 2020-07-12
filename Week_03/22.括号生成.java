import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        //解法：递归
        //思路:通过递归 插入左括号和右括号，形成符合要求的括号组
        
        //这个问题，判断条件为括号必须合法：
        //1，第一个肯定是左括号，然后才能插入右括号
        //2，左括号 <= n ,且 右括号 <= n
        //3，当插入右括号的时候，必须左括号的数量大于右括号，才能插入一个右括号
        List<String> result = new ArrayList<>();
        String s = "";
        generate(n, 0, 0, s, result);

        return result;
    }

    public void generate(int n, int leftCount, int rightCount, String s, List<String> result){
        //模板
        //中止条件 terminator
        //左括号 ==n 且 右括号 == n  ，说明一个有效的括号组合已经完成，将结果添加到result中
        if(leftCount == n && rightCount == n){
            result.add(s);
            return;
        }

        //当前层逻辑 process
        //插入左括号或者插入右括号
        //插入左括号
        String s1 = s + "(";
        //插入右括号
        String s2 = s + ")";


        //下探到下一层 drill down
        //括号数量+1 ,遵循逻辑
        //第一个肯定是左括号，然后才能插入右括号
        //当插入右括号的时候，必须左括号的数量大于右括号，才能插入一个右括号
        
        if(leftCount < n){
            generate(n, leftCount + 1, rightCount, s1, result);
        }
        //插入右括号
        if(leftCount > rightCount){
            generate(n, leftCount, rightCount + 1, s2, result);
        }

        //reverse

    }
}
// @lc code=end

