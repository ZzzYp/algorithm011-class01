/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            int row = 0;
            int cloum = 0;
            int minbox = 0;
            for(int j = 0; j < 9; j++){
                int r = board[i][j] - 48;
                int c = board[j][i] - 48;
                int mb = board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3] - 48;

                if(r > 0){
                    row = fun(r, row);
                }
                if(c > 0){
                    cloum  = fun(c, cloum);
                }
                if(mb > 0){
                    minbox = fun(mb, minbox);
                }

                if(row == -1 || cloum == -1 || minbox == -1){
                    return false;
                }
            }
        }
        return true;
    }


    public int fun(int n , int val){
        return ((val >> n) & 1) == 1 ? -1 : val ^ (1 << n); 
    }
}
// @lc code=end

