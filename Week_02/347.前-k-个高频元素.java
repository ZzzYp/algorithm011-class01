/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //解法1 ：使用堆排序，因为要输出频率高的元素，所以使用最小堆，即堆顶为堆中存储的出现频率最小的元素
        //1，使用map，将元素作为key，出现次数为value，保存起来
        //2，创建一个优先队列作为堆，大小为k，复写compare，使之变为最小优先
        //3，遍历map，然后和堆顶的元素比较，如果大于堆顶的元素，就将堆顶的元素移出，插入新元素
        //4，遍历堆，输出前k个频率高的元素
        //时间复杂度O(nlogk)： 遍历maps，最坏情况为O(n)，插入堆的时候，由于限定了堆大小为k，则复杂度为O(logk)，组合起来就是O(nlogk)
        //空间复杂度O(n)
        Map<Integer,Integer> maps = new HashMap<>();
        for(Integer num : nums){
            if(maps.containsKey(num)){
                maps.put(num, maps.get(num) + 1);
            }else{
                maps.put(num, 1);
            }
        }

        PriorityQueue<Integer> prioQueue = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer n1, Integer n2){
                return maps.get(n1) - maps.get(n2);
            }
        });
 
        for(Integer key : maps.keySet()){
            if(prioQueue.size() >= k){
                int tempKey = prioQueue.peek();
                if(maps.get(key) > maps.get(tempKey)){
                    prioQueue.remove();
                    prioQueue.add(key);
                }
            }else{
                prioQueue.add(key);
            }
        }

        int[] result = new int[prioQueue.size()];
        int i = 0;
        while(!prioQueue.isEmpty()){
            result[i] = prioQueue.remove();
            i++;
        }
        return result;
    }
}
// @lc code=end

