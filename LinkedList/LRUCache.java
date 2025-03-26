class LRUCache {
    /*
    1 -> 2 -> 3
    capacity = 3

    3 -> 1 -> 4 
    */
    class ListNode{
        int val;
        int key;
        ListNode next;
        ListNode prev;
        public ListNode(int key, int val){
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
    int size;
    HashMap<Integer, ListNode> map;
    ListNode right;
    ListNode left;
    public LRUCache(int capacity) {
        this.size = capacity;
        this.map = new HashMap<>();
        this.left = new ListNode(0,0);
        this.right = new ListNode(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    public void remove(ListNode node){
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void insert (ListNode node){
        ListNode prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next= this.right;
        this.right.prev = node;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            ListNode n = map.get(key);
            remove(n);
            insert(n);
            return n.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
           remove(map.get(key));
        }
        ListNode n = new ListNode(key,value);
        map.put(key, n);
        insert(n);

        if(map.size() > size){
            ListNode lru = this.left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */