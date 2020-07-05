/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        //解法2，递归
        //分解问题，取个中间值3， 假设3之前的已经反转完毕，3之后的还未反转，null <- 1 <- 2 <- 3 -> 4 -> 5 -> null
        //遍历到3的时候，要将4指向3，应该这样 3.next.next = 3(分解一下就是 3.next = 4 , 4.next = 3, 这样4就指向了3，这个时候，要将3.next = null 将3指向4的连接断开)
        //终止条件为，遍历到列表最后一个的时候停止，即head == null || head.next == null;
        
        if(head == null || head.next == null){
            return head;
         }
         //当遍历到链表尾的时候，即head == null || head.next == null时，return head = 5 ,那么currentNode = 5 为链表反转后的链表头
         //例如，当head.next = 5的时候，下一个递归就为最后一次，return 5，那么这个时候，head = 4
         ListNode currentNode = reverseList(head.next);
         //要反转，让5指向4,那么 4.next.next = 4 ,即 4.next = 5, 然后 5.next = 4 就将5指向了4
         head.next.next = head;
         //上一步完成了反转，但是head还是为4，要将4指向5的链接断掉，即head.next = null; 这是为了防止链表中只有两个元素是，形成循环链表
         head.next = null;
 
         return currentNode;
 
 
         // //解法1 ，遍历，比如要把5->4，
         // //1,但是这是单链表，不知道前驱节点，所以要定义一个变量，存储前驱节点
         // //2,要定义一个变量来存储当前节点，在下一次遍历的时候使用
         // ListNode prevNode = null;
         // ListNode currentNode = head;
         // while(currentNode != null){
         //     //先记录当前节点的下一个节点
         //     ListNode temp = currentNode.next;
         //     //将当前节点指向它的前驱节点
         //     currentNode.next = prevNode;
         //     //记录下一次遍历的前驱节点 = 本次遍历的当前节点
         //     prevNode = currentNode;
         //     //记录当前节点为下一个节点，准备开始下一次遍历,当currentNode = temp = currentNode.next = null的时候，意味着已经遍历完成
         //     currentNode = temp;
         // }
         // //返回prevNode，是因为遍历到最后，prevNode就是新的头节点    
         // return prevNode;    
 
    }
    
}
// @lc code=end

