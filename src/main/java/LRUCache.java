import java.util.*;

class LRUCache {

    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer,Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }


    public int get(int key) {
        if(map.get(key)==null){
            return -1;
        }
        Node node = map.get(key);
        removeNode(node);
        insertAtHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(map.size()==capacity){
            int tailKey = removeTail();
            map.remove(tailKey);
        }
        Node node;
        if(map.containsKey(key)){
            node = map.get(key);
            removeNode(node);
        }else{
            node = new Node(key,value);
        }
        insertAtHead(node);
        map.put(key,node);
    }

    private void removeNode(Node node){
        if(node.prev!=null){
            node.prev.next = node.next;
        }
        if(node.next!=null){
            node.next.prev = node.prev;
        }
    }

    private void insertAtHead(Node node){
        if(head==null){
            head=node;
            tail=node;
            return;
        }
        Node prevHead = head;
        head = node;
        head.next = prevHead;
        head.prev =null;
        prevHead.prev = head;
    }

    private int removeTail(){
        int key = tail.key;
        tail = tail.prev;
        tail.next=null;
        return key;
    }


    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {2=2, 1=1}
        System.out.println(lRUCache.get(1));    // return 1 cache is {1=1, 2=2}
        lRUCache.put(3, 3); // cache is {3=3, 1=1}
        System.out.println(lRUCache.get(2));    // return -1
    }


}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */