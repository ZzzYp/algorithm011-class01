/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        int[][] result = new int[intervals.length][2];

        int index = -1;

        for(int[] interval : intervals){
            if(index == -1 || interval[0] > result[index][1]){
                result[++index] = interval;
            }else{
                result[index][1] = Math.max(result[index][1], interval[1]);
            }
        }

        return Arrays.copyOf(result, index + 1);
    }
}
// @lc code=end

