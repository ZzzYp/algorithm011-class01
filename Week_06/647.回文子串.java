/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        //动态规划
        if(null == s || s.length() == 0){
            return 0;
        }
         
        int len = s.length();

        boolean[][] dp = new boolean[len][len];
        for(int i=0; i < len; i++) dp[i][i] = true;
    
        int result = s.length();

        for(int i = len - 1; i >= 0; i--){
            for(int j = i+1; j < len; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i == 1){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else{
                    dp[i][j] = false;
                }
                if(dp[i][j]){
                    result++;
                }
            }
        }

        return result;
    }
    }
}
// @lc code=end

