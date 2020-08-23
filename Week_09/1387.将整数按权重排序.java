/*
 * @lc app=leetcode.cn id=1387 lang=java
 *
 * [1387] 将整数按权重排序
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        //解法2： 利用数组
        int[] charArr = new int[256];
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            charArr[temp] = charArr[temp] + 1;
        }        
   
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(charArr[temp] == 1){
                return i;
            }
        }   

        return -1;

        // //解法1： 利用map来解决，第一次将字符出现的次数记录，第二次遍历字符串，将当前字符串出现次数为1的索引返回
        // if(null == s || s.length() == 0){
        //     return -1;
        // }
        // Map<Character, Integer> maps = new HashMap<>();
        // for(int i = 0; i < s.length(); i++){
        //     char temp = s.charAt(i);
        //     if(!maps.containsKey(temp)){
        //         maps.put(temp, 1);
        //     }else{
        //         maps.put(temp, maps.get(temp) + 1);
        //     }
        // }
        // for(int i = 0; i < s.length(); i++){
        //     char temp = s.charAt(i);
        //     if(maps.get(temp) == 1){
        //         return i;
        //     }
        // }

        // return -1;

    }
}
// @lc code=end

