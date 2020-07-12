/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        //解法：回溯， 
        
        if(k <= 0 || n <= 0 || n < k){
           return result;
        }
        generate(n, k, 1, new ArrayList<>());
        return result;
    }

    public void generate(int n, int k, int start, List<Integer> list){
        //terminator
        if(list.size() == k){
           result.add(new ArrayList<>(list));
           return;
        }

        for(int i = start; i < n+1; i++){
           list.add(i);
           generate(n, k, i + 1,  list);
           list.remove(list.size() -1);
        }

    }
}
// @lc code=end

