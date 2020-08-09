/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        //
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int rows = grid.length;
        int cloum = grid[0].length;
        int count = 0;

        for(int i=0; i < rows; i++){
            for(int j = 0; j < cloum; j++){
                if(grid[i][j] == '1'){
                    dfs(i,j,grid);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int row, int cloum, char[][] grid){
        if(row < 0 || cloum < 0 || row >= grid.length || cloum >= grid[0].length || grid[row][cloum] == '0'){
            return;
        }
          
        grid[row][cloum] = '0';

        dfs(row - 1, cloum, grid);
        dfs(row + 1, cloum, grid);
        dfs(row, cloum - 1, grid);
        dfs(row, cloum + 1, grid);
    }
}
// @lc code=end

