/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        //解法2 哈希表，也即是散列表，其实就是用一个数组当作一个散列表，将字符的ASCII值与'a'做减法以后的值，当作hash后的值，也是散列表对应的数组索引，字符在字符串中出现的次数作为散列表的值。
        //记录两个字符串中，每个字符出现的次数是否相同。不相同则不是有效的字符异位词
        if(s.length() != t.length()){
            return false;
        }
        //因为字母只有26个，所以数组长度定位26
        int[] sArr = new int[26];

        for(int i=0; i<s.length(); i++){
            //s.charAt(i) - 'a'
            //首先char是可以进行加减运算的，在运算的时候，通过查找对应字符变量值的ASCII值，利用其在ASCII里的对应值进行加减运算。
            //相同的索引代表的就是相同的字符，在s中出现就++即出现的次数+1， 在t中出现就--即出现的次数-1，最后遍历数组，如果出现的次数为0，则说明是字符异位词
           sArr[s.charAt(i) - 'a']++;
           sArr[t.charAt(i) - 'a']--;
        }

        for(int i=0; i<sArr.length; i++){
            if(sArr[i]!=0){
               return false;
            }
        }

        return true;




        //解法1 排序 通过将字符串转化为char数组，然后对数组进行排序，然后通过Arrays.equals对比char数组是否相同
        //如果是异位词，说明这两个字符串的元素出现的次数是相同的，排序以后肯定会相等
        //如果不是异位词，就不等
        //时间复杂度： 由于排序可以看作是O(logn) ，遍历比较两个char数组为O(n)
        // if(s.length() != t.length()){
        //     return false;
        // }
        // char[] chars = s.toCharArray();
        // char[] chart = t.toCharArray();
        // Arrays.sort(chars);
        // Arrays.sort(chart);

        // return Arrays.equals(chars,chart);

    }
}
// @lc code=end

