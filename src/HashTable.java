class HashTable {
    private MyMapNode[] buckets;
    private int capacity;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = new MyMapNode[capacity];
    }

    private int getBucketIndex(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(String key, int value) {
        key = key.replaceAll("[^a-zA-Z]", "").toLowerCase();
        int index = getBucketIndex(key);
        MyMapNode head = buckets[index];

        // Search for the word in the bucket
        while (head != null) {
            if (head.key.equals(key)) {
                head.value += value;
                return;
            }
            head = head.next;
        }
        MyMapNode newNode = new MyMapNode(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    public int get(String key) {
        key = key.replaceAll("[^a-zA-Z]", "").toLowerCase();
        int index = getBucketIndex(key);
        MyMapNode head = buckets[index];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return 0;
    }

    public void printHashTable() {
        for (int i = 0; i < capacity; i++) {
            MyMapNode head = buckets[i];
            while (head != null) {
                System.out.println(head.key + ": " + head.value);
                head = head.next;
            }
        }
    }
}