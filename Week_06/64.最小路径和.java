/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        //动态规划
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int clomn = grid[0].length;

       for(int i = 0; i < row; i++){
            for(int j = 0; j < clomn; j++){
                if(i == 0 && j == 0) continue;
                if(i == 0 && j != 0) grid[i][j] = grid[i][j-1] + grid[i][j];
                if(i != 0 && j == 0) grid[i][j] = grid[i -1][j] + grid[i][j];
                if(i !=0 && j != 0) grid[i][j] = Math.min(grid[i][j-1], grid[i-1][j]) + grid[i][j];                
            }
       }

       return grid[row - 1][clomn - 1];

    }
    }
}
// @lc code=end

