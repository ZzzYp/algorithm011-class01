/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        //解法：dfs 当遍历到了为1的位置，那么就把1以及它上下左右都为1的地方置为0，然后继续递归
        if(null == grid || grid.length == 0){
            return 0;
        }
        int row = grid.length;
        int colm = grid[0].length; 

        int landNums = 0;

        for(int i=0; i < row; i++){
            for(int j=0; j < colm; j++){
                //
                char island = grid[i][j];
                if(island == '1'){
                    dfs(grid, i, j);
                    landNums++;
                }
            }
        }

        return landNums;
    }

    public void dfs(char[][] grid, int row, int colm){
        int nrow = grid.length;
        int nclom = grid[0].length; 
        if(row < 0 || colm < 0 || row >= nrow || colm >= nclom || grid[row][colm] == '0'){
            return;
        }
        
        grid[row][colm] = '0';

        //上
        dfs(grid, row - 1, colm);
        //下
        dfs(grid, row + 1, colm);
        //左
        dfs(grid, row, colm + 1);
        //右
        dfs(grid, row, colm - 1);
    }
}
// @lc code=end

