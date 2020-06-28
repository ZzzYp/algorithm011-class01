/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       //解法2：递归
       //子问题分解：合并两个有序列表，相当于 比较两个链表中，两个元素的大小，并且将小的值指向下一次递归的大的值，直到边界条件触发(两个链表中，有一个的尾节点已经比较完成)，停止递归
       
        //l1的尾节点已经比较完成，拼接到了新链表，return 剩下的l2
        if(l1 == null){
            return l2;
        //l2的尾节点已经比较完成，拼接到了新链表，return 剩下的l1
        }else if(l2 == null){
            return l1;
        //当l1的值大于等于l2，则l2的next要指向下次递归比较产生的小值，即在这次比较中的大值l1和下一个值l2.next进行比较
        }else if(l1.val >= l2.val){
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }else{
        //当l1的值小于l2，则l1的next要指向下次递归比较产生的小值，即在这次比较中的大值l2和下一个值l1.next进行比较
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }







        // //解法1：循环遍历
        // //时间复杂度：最坏情况为要遍历完两个链表，为O(m+n) 约等于 O(n);
        // //空间复杂度：没有动态增加内存，为O(1)
        // //创建一个伪节点，指向新链表的头节点
        // ListNode newNodeHead = new ListNode(-1);
        // //初始化新链表的节点 = 伪节点
        // ListNode newNode = newNodeHead;

        // while(l1 != null && l2 != null){
        //     if(l1.val >= l2.val){
        //         //当l1的值大于等于l2，将新链表的尾节点节点newNode，指向较小值的节点l2
        //         newNode.next = l2;
        //         //l2往前移一位，和接下来下次循环的l1进行比较
        //         l2 = l2.next;
        //     }else{
        //        //当l1的值小于l2，将新链表的尾节点newNode，指向较小值的节点l1
        //        newNode.next = l1;
        //        //l1往前移一位，和接下来下次循环的l2进行比较
        //        l1 = l1.next;

        //     }
        //     //将newNode往前移一位，变为新链表的尾节点
        //     newNode = newNode.next;
        // }
 
        // //当遍历完其中一个节点后，将另外一个节点拼接到新链表尾部
        // if(l1 == null){
        //     newNode.next = l2;
        // }else{
        //     newNode.next = l1;
        // }

        // return newNodeHead.next;
              
    }
}
// @lc code=end

