/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        if(null == s || s.length() == 0){
            return -1;
        }
        Map<Character, Integer> maps = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(!maps.containsKey(temp)){
                maps.put(temp, 1);
            }else{
                maps.put(temp, maps.get(temp) + 1);
            }
        }

        int index = 0;
        for(Character key : maps.keySet()){
            if(maps.get(key) == 1){
                return index;
            }
            index++;
        }

        return -1;

    }

    
}
// @lc code=end

