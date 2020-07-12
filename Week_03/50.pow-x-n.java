/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        //解法：递归
        //分正数和负数的情况

        long m = n;
        //当n小于0的时候，x的n次幂 = 1/(x的-n次幂)
        if(m < 0){
            return 1.0/myPowHelper(x , -m);
        }
        return myPowHelper(x, m);
      
    }

    public double myPowHelper(double x, long m){
        if(m == 0){
            return 1.0;
        }

        //n > 0 的时候， 每次递归，n都减半
        double result = myPowHelper(x, m/2);
        //n % 2 == 0判断n是奇数还是偶数，奇数的话，还要再额外乘一次x
        return m % 2 == 0 ? result * result  : result * result * x; 
    }
}
// @lc code=end

