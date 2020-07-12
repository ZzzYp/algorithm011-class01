/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        //解法2：参考全排列I 的回溯 + 剪枝 
        if(null == nums || nums.length <= 0){
            return result;
        }
        //要剪枝，要先对数组排序
        Arrays.sort(nums);

        int len = nums.length;
        //用来标识当前层的元素是否被使用过
        boolean[] used = new boolean[len];

        generate(len, nums, 0, new ArrayList<>(), used);

        return result;
       
    }

    //start表示从0开始递归，当start = len的时候，完成了一次完整的递归，将结果返回
    public void generate(int len, int[] nums, int start, List<Integer> list, boolean[] used){
        //ternimator
        if(start == len){
            result.add(new ArrayList<>(list));
            return;
        }
        //prepare data
        //开始for循环
        for(int i = 0; i < len; i++){
            //如果当前层的元素没有被使用过，就将元素加入list

            //剪枝：
            //1，前提是nums数组进行过排序
            //2，当前层的数和上一次搜索的数在数组中是i 和i-1的关系，当nums[i] == nums[i-1]时，有可能发生重复
            //3，在2的条件下，used[i - 1] = false，即上一次搜索的数在可用的状态下，一定会产生重复，需要剪掉
            //4，可以看图，更加清楚
            if(i > 0 && nums[i] == nums[i-1]  && !used[i - 1]){
                    continue;
            }
            if(!used[i]){

                list.add(nums[i]);
                //将当前层的元素设为已使用
                used[i] = true;
                //递归到下一层，start +1 ,即层数+1
                generate(len, nums, start + 1, list, used);
                //当回溯回到当前层的时候，将状态重置，将已使用重置为未使用
                used[i] = false;
                //将当前层元素移出list
                list.remove(list.size()-1);
            }
        }

    }

    // List<List<Integer>> result = new ArrayList<>();
    // Map<List<Integer>, Integer> maps = new HashMap<>();
    // public List<List<Integer>> permuteUnique(int[] nums) {
    //     //解法1：参考全排列I 的回溯 + 判重 
    //     if(null == nums || nums.length <= 0){
    //         return result;
    //     }
    //     int len = nums.length;
    //     //用来标识当前层的元素是否被使用过
    //     boolean[] used = new boolean[len];

    //     generate(len, nums, 0, new ArrayList<>(), used);

    //     return result;
       
    // }

    // //start表示从0开始递归，当start = len的时候，完成了一次完整的递归，将结果返回
    // public void generate(int len, int[] nums, int start, List<Integer> list, boolean[] used){
    //     //ternimator
    //     if(start == len && !maps.containsKey(list)){
    //         result.add(new ArrayList<>(list));
    //         maps.put(list, 1);
    //         return;
    //     }
    //     //prepare data
    //     //开始for循环
    //     for(int i = 0; i < len; i++){
    //         //如果当前层的元素没有被使用过，就将元素加入list
    //         if(!used[i]){

    //             list.add(nums[i]);
    //             //将当前层的元素设为已使用
    //             used[i] = true;
    //             //递归到下一层，start +1 ,即层数+1
    //             generate(len, nums, start + 1, list, used);
    //             //当回溯回到当前层的时候，将状态重置，将已使用重置为未使用
    //             used[i] = false;
    //             //将当前层元素移出list
    //             list.remove(list.size()-1);
    //         }
    //     }

    // }
}
// @lc code=end

