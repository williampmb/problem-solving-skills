package leetcode.com.algorithms;

import java.util.Hashtable;
import java.util.Map;

class LRUCache {

    DuplexLinkedList head;
    DuplexLinkedList tail;
    Map<Integer, DuplexLinkedList> map;
    int capacity;
    int nodes;

    public LRUCache(int c) {
        capacity = c;
        nodes = 0;
        map = new Hashtable<>();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        DuplexLinkedList cur = map.get(key);
        if (nodes == 1)
            return head.value;

        // least
        if (cur.next == null) {
            tail = cur.prev;
        }
        // not the first
        if (cur.prev != null) {
            cur.prev.next = cur.next;
            cur.next = head;
            head = cur;
        }
        return head.value;
    }

    public void put(int key, int value) {
        DuplexLinkedList cur;
        boolean newValue = false;
        if (!map.containsKey(key)) {
            cur = new DuplexLinkedList(value);
            map.put(key, cur);
            newValue = true;
            nodes++;
        } else {
            cur = map.get(key);
            cur.value = value;
        }

        if (newValue) {
            head.prev = cur;
            cur.next = head;
            head = cur;
            if (tail == null) {
                tail = cur;
            }
        } else {
            // tail and head
            if (cur == tail && cur == head) {

                tail = tail.prev;
            } // tail
            else if (cur == tail) {
                tail = cur;

            } // middle
            else if (cur != head) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
            }
            if (cur != head) {
                cur.next = head;
                head.prev = cur;
                head = cur;
            }

        }

        if (capacity > nodes) {
            if (tail.prev == null) {
                tail = cur;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            map.remove(key);
            nodes--;
        }
    }

    private class DuplexLinkedList {
        DuplexLinkedList next;
        DuplexLinkedList prev;
        int value;

        DuplexLinkedList(int v) {
            value = v;
        }
    }
}