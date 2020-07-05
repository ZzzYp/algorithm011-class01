import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         //解法2，使用质数
        //26个字母，每个字符对应一个质数,
        //1，将每个字母 - 'a' 的值，对应prime中的下标，然后将得到的质数累乘得到的值作为key
        //2，创建一个map<Integer, List<String>>将key相同的字母，存入对应的list中
        //3，返回map中的value
        if(strs.length == 0){
            return null;
        }
        int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103 };
        Map<Integer, List<String>> maps = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            String str = strs[i];
            int product = 1;
            for(int j=0; j<str.length(); j++){
                char tempchar = str.charAt(j);
                int tempnum = tempchar - 'a';
                product = product * prime[tempnum];
            }

            if(!maps.containsKey(product)){
                List list = new ArrayList<>();
                list.add(str);
                maps.put(product,list);
            }else{
                maps.get(product).add(str);
            }

        }

        return new ArrayList<>(maps.values());

 




        //解法1，遍历，判断
        //1，遍历数组
        //2，获取字符串，将字符串排序，排序后的字符串为key，排序前的字符串为value，放入一个map<string, List<String>>中
        //3，遍历每个字符串，进行排序后，和key作比较，如果相同，则将字符串加入map中key对应的list，否则就put到map中
        //4，将map中的value放入一个list，返回
        //时间复杂度O(nlogs)  排序看作logs，s为字符串长度，还有遍历数组n
        //空间复杂度O(ns)
        // if(strs.length == 0){
        //     return null;
        // }
        // Map<String, List<String>> maps = new HashMap<>();
        // //遍历数组
        // for(int i=0; i<strs.length; i++){
        //     String str = strs[i];
        //     //将字符串转化为char[]数组，方便排序
        //     char[] chStr = str.toCharArray();
        //     //对char[]排序
        //     Arrays.sort(chStr);
        //     //将排序后的数组转化为字符串，当作maps的key
        //     String key = new String(chStr);
        //     //判断maps中是否存在相应的key
        //     if(!maps.containsKey(key)){
        //         //如果不存在，就新建一个列表，然后将字符串插入列表，对应的key和列表插入map
        //         List list = new ArrayList<>();
        //         list.add(str);
        //         maps.put(key,list);
        //     } else {
        //         //如果存在key，则将对应位置的列表取出，将字符串插入
        //         maps.get(key).add(str);
        //     }
        // }
        // //将maps的value的集合存入一个新的列表中，当作结果返回
        // return new ArrayList<>(maps.values());
    }

}
// @lc code=end

