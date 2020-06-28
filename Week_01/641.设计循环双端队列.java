import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=641 lang=java
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
class MyCircularDeque {

    // 用数组
    /** Initialize your data structure here. Set the size of the deque to be k. */
    int[] dqueue;
    int head;
    int tail;
    int maxSize = 0;
    int count = 0;

    public MyCircularDeque(int k) {
        dqueue = new int[k];
        //如果直接用head-- ，tail++ 这样的方式来计算队列的头，尾的位置，就会出现一种情况，只使用insertFront或者只使用insertLast的方式插入数据，填充满队列以后
        //调用getFront 或者getRear的时候，会出现数组越界，是因为只从头插入，则尾部的索引tail没有自增，导致getRear的时候，value = dqueue[tail-1]出现数组越界情况。只从尾部插入同理也会数组越界
        //所以要换一种方式，用取余的方式防止数组越界 即 head = (head -1 + maxsize) % maxSize;   tail = (tail + 1) % maxSiez;
        maxSize = k;

    }
    /**
     * Adds an item at the front of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        dqueue[head = ((head -1 + maxSize) % maxSize)] = value;
        count++;
        PrintArr("MyCircularDeque:insertFront : ", dqueue);
        Print("MyCircularDeque:insertFront : " + "head : " + head + " count :" + count + " tail : " + tail);
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        dqueue[tail] = value;
        tail = (tail + 1) % maxSize;
        count++;
        PrintArr("MyCircularDeque:insertLast : ", dqueue);
        Print("MyCircularDeque:insertLast : " + "head : " + head + " count :" + count + "   tail : " + tail);
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is
     * successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        //分情况
        //如果第一次调用deleteFront时，head > 0,说明有调用insertFront，将value插入队列，比如maxSize = 5，插入了两个，那么head = 3，deleteFront的时候，head = (3+1)%5 = 4%5 = 4,而deleteFront的目的就是将head指向的头删掉(或者说将指向头的head变为head+1)，将head=3变为head=4，就变相的将队列头变为了索引head为4位置的值，实现了删除队列头的操作
        //如果第一次调用deleteFront时，如果head = 0；且队列不为空的话，说明数据都是调用insertLast插入的，这个时候双端队列就相当于一个普通的先进后出的队列，那么head再删除之前，指向的就是数组中的索引为0的位置，是为队列的头，deleteFront就是将head=0变为head=1，所以head = (0+1)%5 = 1
        head = (head + 1) % maxSize;
        count--;
        PrintArr("MyCircularDeque:deleteFront : ", dqueue);
        Print("MyCircularDeque:deleteFront : " + "head : " + head + " count :" + count + " tail : " + tail);
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is
     * successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        //同deleteFront分析
        tail = (tail - 1 + maxSize) % maxSize;
        count--;
        PrintArr("MyCircularDeque:deleteLast : ", dqueue);
        Print("MyCircularDeque:deleteLast : " + "head : " + head + " count :" + count + "   tail : " + tail);
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        PrintArr("MyCircularDeque:getFront : ", dqueue);
        Print("MyCircularDeque:getFront : " + "head : " + head + " count :" + count + "   tail : " + tail);
        return isEmpty() ? -1 : dqueue[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        PrintArr("MyCircularDeque:getRear : ", dqueue);
        Print("MyCircularDeque:getRear : " + "head : " + head + " count :" + count + "   tail : " + tail);
        return isEmpty() ? -1 : dqueue[(tail - 1 + maxSize) % maxSize];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if (count == maxSize) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyCircularDeque obj = new MyCircularDeque(5);

        // boolean param_1 = obj.insertFront(1);
        // Print("insertFront", param_1 ? 0 : 1);
        // boolean param_10 = obj.insertFront(3);
        // Print("insertFront", param_10 ? 0 : 1);
        // boolean param_11 = obj.insertFront(5);
        // Print("insertFront", param_11 ? 0 : 1);
        // boolean param_12 = obj.insertFront(7);
        // Print("insertFront", param_12 ? 0 : 1);
        // boolean param_13 = obj.insertFront(9);
        // Print("insertFront", param_13 ? 0 : 1);

        boolean param_2 = obj.insertLast(2);
        Print("insertLast", param_2 ? 0 : 1);
        boolean param_20 = obj.insertLast(4);
        Print("insertLast", param_20 ? 0 : 1);
        boolean param_21 = obj.insertLast(6);
        Print("insertLast", param_21 ? 0 : 1);
        // boolean param_22 = obj.insertLast(8);
        // Print("insertLast", param_22 ? 0 : 1);
        // boolean param_23 = obj.insertLast(10);
        // Print("insertLast", param_23 ? 0 : 1);

        int param_5 = obj.getFront();
        Print("getFront", param_5);
        int param_6 = obj.getRear();
        Print("getRear", param_6);

        boolean param_3 = obj.deleteFront();
        Print("deleteFront", param_3 ? 0 : 1);
        boolean param_4 = obj.deleteLast();
        Print("deleteLast", param_4 ? 0 : 1);

        boolean param_7 = obj.isEmpty();
        Print("isEmpty", param_7 ? 0 : 1);
        boolean param_8 = obj.isFull();
        Print("isFull", param_8 ? 0 : 1);

    }

    public static void Print(String tag, int value) {
        System.out.println("tag- " + tag + "   : " + value);
    }

    public static void PrintArr(String tag, int[] value) {
        System.out.println("tag- " + tag + "    :  " + Arrays.toString(value));
    }

    public static void Print(String tag) {
        System.out.println(tag);
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k); boolean param_1 =
 * obj.insertFront(value); boolean param_2 = obj.insertLast(value); boolean
 * param_3 = obj.deleteFront(); boolean param_4 = obj.deleteLast(); int param_5
 * = obj.getFront(); int param_6 = obj.getRear(); boolean param_7 =
 * obj.isEmpty(); boolean param_8 = obj.isFull();
 */
// @lc code=end
