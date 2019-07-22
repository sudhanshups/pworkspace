package practice.ibit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class InterviewbitHeapsMaps {

    Cache cache;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        InterviewbitHeapsMaps ibit = new InterviewbitHeapsMaps();

/*        ArrayList<Integer> chocolates = new ArrayList<>(Arrays.asList( 2147483647, 2000000014, 2147483647));
        System.out.println(ibit.macChocolate(chocolates, 10));*/

        ListNode a = new InterviewbitHeapsMaps.ListNode(1);
        a.next = new InterviewbitHeapsMaps.ListNode(4);
        a.next.next = new InterviewbitHeapsMaps.ListNode(6);

        ListNode b = new InterviewbitHeapsMaps.ListNode(2);
        b.next = new InterviewbitHeapsMaps.ListNode(4);
        b.next.next = new InterviewbitHeapsMaps.ListNode(5);

        ArrayList<ListNode> nodeList = new ArrayList<>();
        nodeList.add(a);
        nodeList.add(b);
        System.out.println(ibit.mergeKLists(nodeList));


        /** LRU cache Implementation */
        System.out.println();
        ibit.initialize(2);
        System.out.println(ibit.get(2));
        ibit.set(2, 6);
        System.out.println(ibit.get(1));
        ibit.set(1, 5);
        ibit.set(1, 2);
        System.out.println(ibit.get(1));
        System.out.println(ibit.get(2));
        //----
    }

    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "cache.Node [key=" + key + ", value=" + value + "]";
        }

    }

    class DoublyLinkedList {
        Node head;
        Node tail;
        int size;
        int LIMIT;

        DoublyLinkedList() {
            head = tail = null;
            size = 0;
        }

        DoublyLinkedList(int limit) {
            head = tail = null;
            size = 0;
            this.LIMIT = limit;
        }

        void pushFront(Node n) {
            n.next = n.prev = null;
            if (head == null) {
                head = tail = n;
            } else {
                n.next = head;
                head.prev = n;
                head = n;
            }
            size++;
        }

        void pushBack(Node n) {
            n.next = n.prev = null;
            if (tail == null) {
                head = tail = n;
            } else {
                tail.next = n;
                n.prev = tail;
                tail = n;
            }
            size++;
        }

        Node popFront() {
            Node n = head;
            if (head != null) {
                head = head.next;
                if (head != null)
                    head.prev = null;
                else {
                    tail = null;
                }
            }
            size--;
            return n;
        }

        Node popBack() {
            Node n = tail;
            if (tail != null) {
                tail = tail.prev;
                if (tail != null)
                    tail.next = null;
            }
            size--;
            return n;
        }

        void updateToEnd(Node n) {
            if (tail == n || size == 1) {
                return;
            } else if (head == n) {
                head = head.next;
                head.prev = null;
                size--;
                pushBack(n);
            } else {
                n.prev.next = n.next;
                n.next.prev = n.prev;
                size--;
                pushBack(n);
            }
        }

    }

    public class Cache {
        DoublyLinkedList dll;
        Map<Integer, Node> map;
        int hit;
        int miss;

        Cache(int limit) {
            dll = new DoublyLinkedList(limit);
            map = new HashMap<Integer, Node>();
            hit = 0;
            miss = 0;
        }

        void insert(Node n) {

            if (dll.size == dll.LIMIT) {
                Node f = dll.popFront();
                map.remove(f.key);
            }
            dll.pushBack(n);
            map.put(n.key, n);
        }

        void update(Node n) {
            dll.updateToEnd(n);
        }

        Node search(int key) {
            Node n = map.get(key);
            if (n != null) {
                //System.out.println("cache.Cache Hit " + n);
                update(n);
            }
            return n;
        }
    }

    public void initialize(int capacity) {
        cache = new Cache(capacity);
    }

    public int get(int key) {
        Node n = cache.search(key);
        if (n == null)
            return -1;
        else return n.value;
    }

    public void set(int key, int value) {
        Node n = cache.search(key);
        if (n != null) {
            //System.out.println("cache.Cache Hit " + n);
            n.value = value;
        } else {
            cache.insert(new Node(key, value));
        }
    }


    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((u, v) -> u.val - v.val);
        priorityQueue.addAll(a);
        ListNode res = null;
        ListNode current = null;
        while (!priorityQueue.isEmpty()) {
            ListNode minNode = priorityQueue.poll();
            if (res == null) {
                res = new ListNode(minNode.val);
                current = res;
            } else {
                current.next = new ListNode(minNode.val);
                current = current.next;
            }

            if (minNode.next != null) {
                priorityQueue.add(minNode.next);
            }
        }

        return res;
    }

    int macChocolate(ArrayList<Integer> chocolates, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((u, v) -> (v - u));
        maxHeap.addAll(chocolates);

        int mod = 1000000000 + 7;
        long maxChocolate = 0;
        while (k != 0) {
            int choco = maxHeap.poll();
            maxHeap.add((int) Math.floor((double) choco / 2));
            maxChocolate += choco;
            if (maxChocolate >= mod) {
                maxChocolate %= mod;
            }
            k--;
        }

        return (int) maxChocolate;
    }
}
