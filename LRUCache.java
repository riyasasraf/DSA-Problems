import java.util.HashMap;
import java.util.Map;

class LRUCache {

  public class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private void remove(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private void inserthead(Node node) {
    Node afterhead = head.next;
    head.next = node;
    node.prev = head;
    node.next = afterhead;
    afterhead.prev = node;
  }

  int capacity;
  Map<Integer, Node> mpp;
  Node head = new Node(-1, -1);
  Node tail = new Node(-1, -1);

  public LRUCache(int capacity) {
    mpp = new HashMap<>();
    this.capacity = capacity;
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if (!mpp.containsKey(key)) {
      return -1;
    }
    Node node = mpp.get(key);
    remove(node);
    inserthead(node);
    return node.value;
  }

  public void put(int key, int value) {
    if (mpp.containsKey(key)) {
      Node node = mpp.get(key);
      remove(node);
      node.value = value;
      inserthead(node);
    } else {
      if (mpp.size() == capacity) {
        Node lru = tail.prev;
        remove(lru);
        mpp.remove(lru.key);
      }
      Node node = new Node(key, value);
      mpp.put(key, node);
      inserthead(node);
    }
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */