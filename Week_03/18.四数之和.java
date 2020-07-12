/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
       //解法2：还是双指针，添加最小值和target，最大值和target 比较，提高效率
       List<List<Integer>> result = new ArrayList<>();
       if(nums.length < 4){
           return result;
       }
       //对数组排序
       Arrays.sort(nums);
       int len = nums.length;
       for(int i = 0; i < len - 3; i++){
           //i 去重
           if(i > 0 && nums[i] == nums[i-1]){
               continue;
           }            
           //当前最大值和target比较
           int max1 = nums[i] + nums[len-1] + nums[len-2] + nums[len-3];
           if(max1 < target){
              continue;
           }
           //当前最小值和target比较
           int min1 = nums[i] + nums[i+1] + nums[i+2] + nums[i+3];
           if(min1 > target){
              break;
           }
           for(int left = i + 1; left < len -2; left++){
               //left去重
               if(left > i + 1 && nums[left] == nums[left-1]){
                   continue;
               }   

               int mid = left + 1;
               int right = len -1;

               //当前最大值和target比较
               int max2 = nums[i] + nums[left] + nums[right] + nums[right-1];
               if(max2 < target){
                   continue;
               }
               //当前最小值和target比较
               int min2 = nums[i] + nums[left] + nums[mid] + nums[mid+1];
               if(min2 > target){
                   continue;
              
               }


               while(mid < right){
                   int sum = nums[i] + nums[left] + nums[mid] + nums[right];
                   if(sum > target){
                      right--;
                   }else if(sum < target){
                      mid++;
                   }else{
                       List<Integer> list = new ArrayList<>();
                       list.add(nums[i]);
                       list.add(nums[left]);
                       list.add(nums[mid]);
                       list.add(nums[right]);
                       result.add(list);
                       
                       //mid 去重
                       while(mid < right && nums[mid] == nums[mid+1]){
                           mid++;
                       }
                       //rigth 去重
                       while(mid < right && nums[right] == nums[right-1]){
                           right--;
                       }
                       //找到了符合条件的四个数，所以mid前进一位，rigth后退一位
                       mid++;
                       right--;
                   }
               }
           }
       }        



       // //解法1:双指针
       // //思路：参考三数之和，在三数之和外面套一层遍历第四个数的循环
       // List<List<Integer>> result = new ArrayList<>();
       // if(nums.length < 4){
       //     return result;
       // }
       // //对数组排序
       // Arrays.sort(nums);
       // int len = nums.length;
       // for(int i=0; i<len; i++){
       //     //i 去重
       //     if(i > 0 && nums[i] == nums[i-1]){
       //         continue;
       //     }            
       //     for(int left = i + 1; left < len; left++){
       //         //left去重
       //         if(left > i + 1 && nums[left] == nums[left-1]){
       //             continue;
       //         }   
       //         int mid = left + 1;
       //         int right = len -1;
       //         while(mid < right){
       //             int sum = nums[i] + nums[left] + nums[mid] + nums[right];
       //             if(sum > target){
       //                right--;
       //             }else if(sum < target){
       //                mid++;
       //             }else{
       //                 List<Integer> list = new ArrayList<>();
       //                 list.add(nums[i]);
       //                 list.add(nums[left]);
       //                 list.add(nums[mid]);
       //                 list.add(nums[right]);
       //                 result.add(list);
                       
       //                 //mid 去重
       //                 while(mid < right && nums[mid] == nums[mid+1]){
       //                     mid++;
       //                 }
       //                 //rigth 去重
       //                 while(mid < right && nums[right] == nums[right-1]){
       //                     right--;
       //                 }
       //                 //找到了符合条件的四个数，所以mid前进一位，rigth后退一位
       //                 mid++;
       //                 right--;
       //             }
       //         }
       //     }
       // }
       return result;
    }
}
// @lc code=end

