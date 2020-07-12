/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int left = 0, top = 0, right = n-1, bottom = n-1;
        int[][] result = new int[n][n];
        int target = n * n;
        int num = 1;
        while(num <= target){
            //左上到右上
            for(int i = left; i <= right ; i++){
                result[top][i] = num;
                num++;
            }
            //当top行占满一行以后，就下移一行，用代码表示就是top++;
            top++;
            //右上到右下
            for(int i = top; i <= bottom; i++){
                result[i][right] = num;
                num++;
            }
            //当right列占满一列以后，就往左移一列，用代码表示就是right--
            right--;
            //右下到左下
            for(int i = right; i >= left; i--){
                result[bottom][i] = num;
                num++;
            }
            //当bottom占满一行以后，就往上移一行，用代码就是bottom--
            bottom--;
            //左下到左上 至此完成一圈
            for(int i = bottom; i >= top; i--){
                result[i][left] = num;
                num++;
            }
            //当left占满一列以后，就往右移一列，用代码就是left++
            left++;
        }
        return result;
    }
}
// @lc code=end

