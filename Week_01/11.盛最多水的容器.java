/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        //使用双指针解法
        //思路：双指针代表盛水容器的两个挡板x,y(假设) ，盛水的体积ares = min(x,y) * (两个挡板的距离)。移动较小的挡板，然后计算出新的体积ares = min(x1,y) * (两个挡板的距离-1)，比较两个体积大小.然后再比较x1和y的大小，哪个小，移动哪一个，移动规则为x往右移动，y往左移动，直到x=y。  由于盛水的体积取决于最小的挡板和挡板间的距离，所以每次移动最小挡板，才有机会得到更大的水容积

        int ares = 0;
        int left = 0;
        int right = height.length - 1;

        while(left < right){
            int tempAres = Math.min(height[left], height[right]) * (right - left);
            ares = Math.max(ares,tempAres);
            if(height[left] < height[right]){
                left ++;
            }else{
                right --;
            }
        }

        return ares;
    }
}
// @lc code=end

