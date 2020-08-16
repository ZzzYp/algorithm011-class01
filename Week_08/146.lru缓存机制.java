/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @lc code=start
class LRUCache {

    public Map<Integer, Node> cache = new HashMap<>();
    public int size;
    public int capacity;
    public Node head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {

        Node node = cache.get(key);
        if(null == node){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        if(node == null){
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if(size > capacity){
                Node tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }
    }

    public void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
        
    }
    public void addToHead(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }        

    public Node removeTail(){
        Node node = tail.prev;
        removeNode(node);
        return node;
    }


    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(){}
        public Node(int _key, int _value){
            key = _key;
            value = _value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

