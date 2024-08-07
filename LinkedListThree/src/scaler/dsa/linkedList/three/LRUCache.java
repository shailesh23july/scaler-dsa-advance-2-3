package scaler.dsa.linkedList.three;

import java.util.HashMap;

public class LRUCache {
	
	//HashMap
	static HashMap<Integer, DoubleLinkedList> hm = new HashMap<>();
	static DoubleLinkedList dummyHead;
	static DoubleLinkedList dummyTail;
	static int capacity;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache cache = new LRUCache(2);
		 //operation 1
		 set(2, 1);
		 //operation 2
		 set(1,1);
		 //operation 3
		 set(2, 3);
         System.out.println("Done");
         
	}

	public LRUCache(int capacity) {
		dummyHead = new DoubleLinkedList(-1, -1);
		dummyTail = new DoubleLinkedList(-1, -1);
		dummyHead.next = dummyTail;
		dummyTail.prev = dummyHead;
		LRUCache.capacity = capacity; 
	}

	public static int get(int key) {
		if (hm.containsKey(key)) {
			DoubleLinkedList node = hm.get(key);
			removeNode(node);
			addBeforeTail(node);
			return node.value;
		}
        return -1;
	}

	public static void set(int key, int value) {
		if(hm.containsKey(key)) {
			DoubleLinkedList existingNode = hm.get(key);
			removeNode(existingNode);
			existingNode.value = value;
			addBeforeTail(existingNode);
		} else {
			DoubleLinkedList newNode = new DoubleLinkedList(key, value);
			addBeforeTail(newNode);
			hm.put(key, newNode);
			if (hm.size() > capacity) {
				DoubleLinkedList node = dummyHead.next;
				removeNode(node);
				hm.remove(node.key);
			}
		}
	}
	
	public static void removeNode(DoubleLinkedList node) {
		DoubleLinkedList previousNode = node.prev;
		DoubleLinkedList nextNode = node.next;
		previousNode.next = nextNode;
		nextNode.prev = previousNode;
	}
	
	public static void addBeforeTail(DoubleLinkedList node) {
		DoubleLinkedList prevNode = dummyTail.prev;
		prevNode.next = node;
		node.prev = prevNode;
		node.next = dummyTail;
		dummyTail.prev = node;
	}

}
