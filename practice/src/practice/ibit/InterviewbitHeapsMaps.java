package practice.ibit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


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

        System.out.println("Skyline problem===");
        System.out.println(ibit.getSkyline(new int[][]{{2, 9, 10,}, {3, 7, 15,}, {5, 12, 12,}, {15, 20, 10,}, {19, 24, 8}}));

        System.out.println(Arrays.toString(ibit.maxNumberFrom2ArrayMAintainingOrder(new int[]{3, 4, 6, 5},new int[]{9, 1, 2, 5, 8, 3},5 )));
    }

    public int[] maxNumberFrom2ArrayMAintainingOrder(int[] nums1, int[] nums2, int k) {
        int get_from_nums1 = Math.min(nums1.length, k);
        int[] ans = new int[k];
        for (int i = Math.max(k - nums2.length, 0); i <= get_from_nums1; i++) {
            int[] res1 = solve(nums1, i);
            int[] res2 = solve(nums2, k - i);
            int[] res = new int[k];
            int pos1 = 0, pos2 = 0, tpos = 0;

            while (res1.length > 0 && res2.length > 0 && pos1 < res1.length && pos2 < res2.length) {
                if (compare(res1, pos1, res2, pos2))
                    res[tpos++] = res1[pos1++];
                else
                    res[tpos++] = res2[pos2++];
            }
            while (pos1 < res1.length)
                res[tpos++] = res1[pos1++];

            while (pos2 < res2.length)
                res[tpos++] = res2[pos2++];

            if (!compare(ans, 0, res, 0))
                ans = res;
        }
        return ans;
    }

    public boolean compare(int[] nums1, int start1, int[] nums2, int start2) {
        for (; start1 < nums1.length && start2 < nums2.length; start1++, start2++) {
            if (nums1[start1] > nums2[start2]) return true;
            if (nums1[start1] < nums2[start2]) return false;
        }
        return start1 != nums1.length;
    }

    public int[] solve(int[] nums, int k) {
        int[] res = new int[k];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            while (len > 0 && len + nums.length - i > k && res[len - 1] < nums[i]) {
                len--;
            }
            if (len < k)
                res[len++] = nums[i];
        }
        return res;
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            }
        });
        Queue<Integer> pq = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });

        pq.offer(0);
        int prev = 0;
        for (int[] h : height) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if (prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
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
