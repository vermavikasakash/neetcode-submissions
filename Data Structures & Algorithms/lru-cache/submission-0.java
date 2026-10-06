class LRUCache {
    Map<Integer, Node> cache;
    Node head;
    Node tail;
    int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) { // get
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        remove(node); // remove node first
        insert(node); // add this node on head
        return node.value;
    }

    public void remove(Node node) {
        Node B = node; // B
        Node A = node.prev; // A
        Node C = node.next; // C
        A.next = C;
        C.prev = A;
    }

    public void insert(Node node) {
        Node B = node; // "X" - B - "1"

        B.next = head.next;
        head.next.prev = B;

        head.next = B;
        B.prev = head;
    }

    public void put(int key, int value) {
        // Key already exists
        if (cache.containsKey(key)) {
            Node node = cache.get(key);

            node.value = value;

            remove(node);
            insert(node);

            return;
        }

        // New key
        Node newNode = new Node(key, value);

        cache.put(key, newNode);
        insert(newNode);

        // Capacity exceeded
        if (cache.size() > cap) {
            Node lru = tail.prev;

            remove(lru);
            cache.remove(lru.key);
        }
    }
}

 // private class for doubly Linked List
    class Node {
        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
