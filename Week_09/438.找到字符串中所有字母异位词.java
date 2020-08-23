/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        char[] arrs = s.toCharArray();
        char[] arrP = p.toCharArray();

        List<Integer> result = new ArrayList<>();

        int[] needs = new int[26];
        int[] window = new int[26];

        for(int i = 0; i < arrP.length; i++){
            needs[arrP[i] - 'a'] += 1;
        }


        int left = 0;
        int right = 0;

        while(right < arrs.length){
            int currentRight = arrs[right] - 'a';
            right++;
            window[currentRight] += 1;

            while(window[currentRight] > needs[currentRight]){
                int currentLeft = arrs[left] - 'a';
                left++;
                window[currentLeft] -= 1;
            }

            if(right - left == arrP.length){
                result.add(left);
            }
        }

        return result;
    }
}
// @lc code=end

