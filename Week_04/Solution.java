class Solution1 {
    public int search(int[] nums) {
        //二分查找
        //思路：找到排序好序的那一段，然后判断边界和边界相邻的元素是否是排序的，如果不是排序的，那么边界处就是中间无序的地方
        if(nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[left] < nums[mid]){
                //说明左边是有序的
                //那么就找左边的右边界mid和右边界相邻的元素mid+1是否还是有序的，如果不是有序的，那么mid就是中间无序的地方
                if(nums[mid] > nums[mid + 1]){
                    return nums[mid];
                }
                left = mid + 1;
            } else if(nums[mid] < nums[right]){
                //说明右边是有序的
                //那么就找右边的左边界mid和左边界相邻的元素mid-1是否还是有序的，如果不是有序的，那么mid就是中间无序的地方
                if(nums[mid - 1] > nums[mid]){
                    return nums[mid];
                }
                right = mid - 1;
            }
        }
        return -1;
    }

    
     public static void main(String[] args) {
        Solution1 solution = new Solution1();
    
        int target = solution.search(new int[]{5,2,6});

        System.out.println("target  : "+ target);
    }    
    
}
