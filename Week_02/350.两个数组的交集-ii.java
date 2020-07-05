import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //解法2：通过hashmap
        //思路：1,将其中一个短的数组遍历，放入map，数组的值为key，出现的次数为value
        //2,遍历长的数组，和map中的key进行比较，如果相同，则将value代表的出现的次数-1
        //3,遍历完成后，将交集值放入一个list中，然后将list中的值再放入数组返回
        if(nums1.length == 0 || nums2.length == 0){
            return new int[0];
          }
          if(nums1.length > nums2.length){
            return intersect(nums2,nums1);
          } 
          //将num1中的元素存入map中，键为数组的值，值为出现的次数count
          Map<Integer,Integer> map = new HashMap<>();
          for(int i=0; i< nums1.length; i++){
              map.put(nums1[i],map.getOrDefault(nums1[i],0) + 1);
          }
          LinkedList<Integer> list = new LinkedList<Integer>();
          //遍历nums2，通过getOrDefault方法，获取相同的key的value，即为相同元素出现的次数
          //如果count大于0，说明有交集元素，将该元素存入LinkedList(节省空间)，然后count-1
          for(int i=0;i<nums2.length;i++){
              int count = map.getOrDefault(nums2[i],0);
              if(count > 0){
                  list.add(nums2[i]);
                  map.put(nums2[i],count-1);
              }
          } 
          //遍历完nums2后，将list中的数据转入数组，返回
          int[] result = new int[list.size()];
          for(int i=0; i < result.length; i++){
              result[i] = list.pop();
          }
   
          return result;
   
   
   
   
   
          // //解法1 , 双指针，先排序，然后使用双指针一次扫描出相同的数字
          // //时间复杂度为  排序的时间复杂度+遍历的时间复杂度+移动交集数组的时间复杂度 =  O(logn) + O(n) + O(k) ≈ O(n);
          // //空间复杂度为O(n)
          // int len1 = nums1.length;
          // int len2 = nums2.length;
          // //空判断
          // if(len1 == 0 || len2 == 0){
          //   return new int[0];    
          // }
          // //对数组排序
          // Arrays.sort(nums1);
          // Arrays.sort(nums2);
          // List<Integer> temp = new ArrayList<>();
          // int i = 0;
          // int j = 0;
          // while(i < len1 && j < len2){
          //     //当nums1[i] > nums2[j]，将遍历num2的索引j前进1
          //     if(nums1[i] > nums2[j]){
          //         j++;  
          //     //当nums1[i] < nums2[j]，将遍历num1的索引i前进1      
          //     }else if(nums1[i] < nums2[j]){
          //         i++;
          //     }else{
          //     //找到了两个数组的交集，遍历各自的索引都前进1，然后将交集的数字放入集合中    
          //         temp.add(nums1[i]);
          //         i++;
          //         j++;
          //     }
          // }
          // //temp中保存的就是交集的数字，创建一个等长的数组，将列表中的数字移动到数组中，返回数组
          // int[] result = new int[temp.size()];
          // for(int k=0; k<temp.size();k++){
          //       result[k] = temp.get(k);
          // }
  
          // return result;
    }
}
// @lc code=end

