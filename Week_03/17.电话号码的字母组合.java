/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        //解法 : 分治回溯
        //1，先将数字对应的字母放入map中
        //2,将问题分解， 举例： 将输入的23 看作是[a,b,c][d,e,f],从这两个数组中，各取一个字符，组合成一个长度为2的字符串
        //3,使用回溯的经典解决方案
        if(null == digits || digits.length() == 0){
            return new ArrayList<>();
        }
        Map<Character, String> maps = new HashMap<>();
        maps.put('2',"abc");
        maps.put('3',"def");
        maps.put('4',"ghi");
        maps.put('5',"jkl");
        maps.put('6',"mno");
        maps.put('7',"pqrs");
        maps.put('8',"tuv");
        maps.put('9',"wxyz");

        List<String> result = new ArrayList<>();
        //generate(maps, result, digits, 0, new StringBuilder());
        generate(maps, result, digits, 0, "");

        return result;

    }
    //优化解法
    //这里利用了每次操作String就相当于新建一个String对象，来省略StringBuilder.deleteCharAt(sb.length() - 1)的操作
    public void generate(Map<Character, String> maps, List<String> result, String digits, int start, String s){
        //ternimator
        if(start == digits.length()){
            result.add(s);
            return;
        }
        //process
        String letter = maps.get(digits.charAt(start));
        for(int j = 0; j < letter.length(); j++){
            //drill down
            generate(maps, result, digits, start + 1, s + letter.charAt(j));
        }

    }


    // //将这个问题分解为，从letter中的每一个元素中再取出一个字母，组成一个字符串
    // public void generate(Map<Character, String> maps, List<String> result, String digits, int start, StringBuilder sb){
        
    //     for(int i = start; i < digits.length(); i++){
    //         String s = maps.get(digits.charAt(i));
    //         for(int j = 0; j < s.length(); j++){
    //             //
    //             sb.append(s.charAt(j));
    //             if(sb.length() == digits.length()){
    //                result.add(sb.toString());
    //             }
    //             generate(maps, result, digits, i+1, sb);
    //             sb.deleteCharAt(sb.length() - 1);
    //         }
    //     }
    // }
}
// @lc code=end

