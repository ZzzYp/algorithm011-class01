/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(null == matrix || matrix.length == 0 ||matrix[0].length == 0){
            return 0;
        }
 
        int rows = matrix.length;
        int cloums = matrix[0].length;

        int[][] dp = new int[rows][cloums];

        int max = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cloums; j++){
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        int maxSquare = max * max;
        return maxSquare;
    }
    }
}
// @lc code=end

