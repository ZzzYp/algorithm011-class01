/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        //解法3：将数组替换为两个变量
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }

        int prev1 = 1;
        int prev2 = 2;
        int count = 0;
        //先(n-2) + (n-1)的和count，然后 将n-1的值赋值给n-2，count的值赋值给n-1, 这样就相当于把n-2和n-1这两个元素存到了两个变量中，进行计算
        for(int i = 3; i <= n; i++){
            count = prev1 + prev2;
            prev1 = prev2;
            prev2 = count;
            
        }

        return count;




        //解法2： 使用数组，公式为 arr[n] = arr[n-1] + arr[n-2] ....... arr[2] + arr[1];
        //这种解法，需要创建数组，占用空间比较多，可以把数组变成变量，只保存n-1和n-2的值，这样就可以不借助数组实现了
        // int[] arr = new int[n+1];
        // if(n >= 1){
        //     arr[1] = 1;
        // }
        // if(n >= 2){
        //     arr[2] = 2;
        // }
        
        // for(int i = 3; i<=n ; i++){
        //    arr[i] = arr[i-1] + arr[i-2];
        // } 

        // return arr[n];

        //解法一 ：递归， 这个问题可以分解为，当爬到n-2或者n-1阶台阶的时候，可以直接爬2阶到n，或者先爬1阶到n-1，再爬1阶到n，所以方法数f(n) = f(n-1)+f(n-2),这就是一个斐波那契数列的形式，最简单的就是直接用递归解决
        //但是递归会有很多重复的计算，所以优化的话，应该剔除重复的计算
        //时间复杂度为O(n)
        // if(n == 2){
        //     return 2;
        // }
        // if(n == 1){
        //     return 1;
        // }
        // return climbStairs(n-1) + climbStairs(n-2);
    }
}
// @lc code=end

