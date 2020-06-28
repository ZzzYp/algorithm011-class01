/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //解法3:优化解法2，从两个数组的尾部开始比较，然后大的值插入nums1的尾部，直到m或者n个元素比较完毕
        //时间复杂度，最坏情况为m和n都遍历到，所以为O(m+n)
        //空间复杂度，没有使用额外空间，为O(1)
        int len1 = m-1;
        int len2 = n-1;
        int len = m + n -1;

        while(len1 >= 0 && len2 >=0){
            nums1[len--] = nums1[len1] >= nums2[len2] ? nums1[len1--]: nums2[len2--]; 
        }

        //存在一种情况，当len1 ==0 ，即num1中的元素已经比较完成，但是nums2中存在未比较的元素的时候，num2中的剩下的元素肯定比nums1中最小的元素还小,直接将nums2中的剩下的len2+1个元素从index=0的位置开始，拷贝到nums1中
        //System.arraycopy(source_arr, sourcePos, dest_arr,  destPos, len);
        System.arraycopy(nums2,0,nums1,0,len2+1);


        //解法2：创建一个长度为m+n的临时数组temp，然后从nums1[m], nums2[n]开始比较
        //如果nums2[n] >= nums1[m]，则将大的数插入到temp(m+n-1)的位置，然后n--， 反之亦然
        //当m或者n等于0是，说明有一个数组已经遍历完毕，那么将剩下的那个数组的所有元素依次插入到temp(m+n-1)处
        //因为每次比较，m或者n都会减1，所以temp[m+n-1]也会减1.即左移一位到空白的地方
        //当m和n都为0的时候，比较完毕，将temp数组插入nums1
        // int[] temp = new int[m+n];
        // while(m + n > 0){
        //     if(m > 0 && n > 0 && nums2[n-1] >= nums1[m-1]){
        //         temp[m+n-1] = nums2[n-1];
        //         n--;
        //     }else if(m > 0 && n > 0 && nums2[n-1] < nums1[m-1]){
        //         temp[m+n-1] = nums1[m-1];
        //         m--;
        //     }else if(m == 0){
        //         temp[m+n-1] = nums2[n-1];
        //         n--;
        //     }else if(n == 0){
        //         temp[m+n-1] = nums1[m-1];
        //         m--;
        //     }
        // }
        // for(int i = 0; i < temp.length; i++){
        //     nums1[i] = temp[i];
        // }


        //解法1：暴力解法,创建一个长度为m+n的数组，然后将元素合并到新数组中并且排序，然后将新数组插入到nums1中
        // int[] temp = new int[m+n];

        // for(int i=0; i < m ;i++){
        //     temp[i] = nums1[i];
        // }
        // for(int i=0; i < n; i++){
        //     temp[m+i] = nums2[i];
        // }

        // Arrays.sort(temp);

        // for(int i=0; i<m+n; i++){
        //     nums1[i] = temp[i];
        // }
    }
}
// @lc code=end

