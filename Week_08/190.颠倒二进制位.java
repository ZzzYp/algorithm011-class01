/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    int result = 0;
    for(int i=0; i<32; i++){
        result ^= (n & (1 << i)) != 0 ? 1 << (31 - i) : 0; 
    }

    return result;
}
}
// @lc code=end

