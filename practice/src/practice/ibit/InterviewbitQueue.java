package practice.ibit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class InterviewbitQueue {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        InterviewbitQueue ibit = new InterviewbitQueue();

        //System.out.println(ibit.simplifyPath("/home/"));
        //System.out.println(ibit.braces("(a)"));

/*        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 2, 1));//[-1, 4, -1, 2, 2]
        System.out.println(ibit.prevSmaller(A));*/

    /*    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 1, 5, 6, 2, 3));
        System.out.println(ibit.largestRectangleArea(A));*/

    /*    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 3, -1, -3, 5, 3, 6, 7));
        System.out.println(ibit.slidingMaximum(A, 10));*/
        /*ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1));
        System.out.println(ibit.RainWaterTrap(A));*/
       /* ArrayList<String> A = new ArrayList<>(Arrays.asList("2", "1", "+", "3", "*"));
        System.out.println(ibit.evaluateReversePolish(A));*/

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(34, 35, 27, 42, 5, 28, 39, 20, 28));
        System.out.println(ibit.nextGreater(A));
        //35 42 42 -1 28 39 -1 28 -1
    }


    public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        int[] res = new int[A.size()];
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for (int i = 0; i < A.size(); i++) {
            while (!s.empty() && A.get(s.peek()) < A.get(i)) {
                res[s.pop()] = A.get(i);
            }
            s.push(i);
        }
        while (!s.empty()) {
            res[s.pop()] = -1;
        }
        return new ArrayList<>(Arrays.stream(res).boxed().collect(Collectors.toList()));
    }

    public int evaluateReversePolish(final List<String> A) {
        int top;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < A.size(); i++) {
            switch (A.get(i)) {
                case "+":
                    top = s.pop();
                    s.push(s.pop() + top);
                    break;
                case "-":
                    top = s.pop();
                    s.push(s.pop() - top);
                    break;
                case "*":
                    top = s.pop();
                    s.push(s.pop() * top);
                    break;
                case "/":
                    top = s.pop();
                    s.push(s.pop() / top);
                    break;
                default:
                    s.push(Integer.parseInt(A.get(i)));
            }
        }
        return s.pop();
    }

    class getMinStack {
        int curMin = 0;
        Stack<Integer> s = new Stack<>();

        public void push(int x) {
            if (s.isEmpty()) {
                curMin = x;
                s.push(x);
            } else if (x < curMin) {
                s.push(2 * x - curMin);
                curMin = x;
            } else {
                s.push(x);
            }
        }

        public void pop() {
            if (!s.empty()) {
                int top = s.pop();
                if (top < curMin) {
                    curMin = 2 * curMin - top;
                }
            }
        }

        public int top() {
            if (!s.empty()) {
                if (s.peek() < curMin) {
                    return curMin;
                }
                return s.peek();
            }
            return -1;
        }

        public int getMin() {
            if (!s.empty()) {
                return curMin;
            }
            return -1;

        }
    }


    public int RainWaterTrap(final List<Integer> A) {
        int n = A.size();
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = A.get(0);
        rightMax[n - 1] = A.get(n - 1);
        for (int i = 1; i < A.size(); i++) {
            leftMax[i] = leftMax[i - 1] > A.get(i) ? leftMax[i - 1] : A.get(i);
        }
        for (int i = A.size() - 2; i >= 0; i--) {
            rightMax[i] = rightMax[i + 1] > A.get(i) ? rightMax[i + 1] : A.get(i);
        }

        int maxWater = 0;
        for (int i = 1; i < A.size() - 1; i++) {
            maxWater += Math.min(leftMax[i], rightMax[i]) - A.get(i);
        }

        return maxWater;
    }

    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        Deque<Integer> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        for (i = 0; i < B - 1 && i < A.size(); i++) {
            while (!queue.isEmpty() && A.get(queue.getLast()) < A.get(i)) {
                queue.removeLast();
            }
            queue.add(i);
        }
        while (i < A.size()) {
            while (!queue.isEmpty() && A.get(queue.getLast()) < A.get(i)) {
                queue.removeLast();
            }
            queue.add(i);
            while (i - queue.peekFirst() >= B) {
                queue.removeFirst();
            }
            res.add(A.get(queue.peekFirst()));
            i++;
        }
        if (A.size() < B) {
            res.add(queue.peekFirst());
        }

        return res;
    }

    public int largestRectangleArea(ArrayList<Integer> A) {
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        int i;
        for (i = 0; i < A.size(); i++) {
            //if(!s.isEmpty() && A.get(s.peek()).compareTo(A.get(i)) < 0){
            while (!s.isEmpty() && A.get(s.peek()).compareTo(A.get(i)) > 0) {
                int topI = s.pop();
                maxArea = Math.max(maxArea, A.get(topI) * (s.empty() ? i : i - s.peek() - 1));
            }
            s.push(i);
        }

        while (!s.isEmpty()) {
            int topI = s.pop();
            maxArea = Math.max(maxArea, A.get(topI) * (s.empty() ? i : i - s.peek() - 1));
        }
        return maxArea;

    }

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int a : A) {
            while (!stack.empty() && stack.peek() >= a) {
                stack.pop();
            }
            if (stack.empty()) {
                res.add(-1);
            } else {
                res.add(stack.peek());
            }
            stack.add(a);
        }

        return res;

    }


    public int braces(String A) {
        Stack<Character> stack = new Stack<>();
        char[] ch = A.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ') {
                continue;
            }
            if (ch[i] != ')') {
                stack.push(ch[i]); // no need to
            } else {//if ()
                if (stack.peek() == '(') {
                    return 1;
                } else {
                    int c = 0;
                    while (stack.peek() != '(') {
                        stack.pop();
                        c++;
                    }
                    if (c == 1)
                        return 1;
                    stack.pop();
                }
            }
        }
        return 0;
    }

    public String simplifyPath(String A) {
        Stack<String> stack = new Stack<>();
        String[] splits = A.split("/");
        for (int i = 0; i < splits.length; i++) {
            if (splits[i].equals(".")) {
                ;
            } else if (splits[i].equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else if (splits[i].length() != 0) {
                stack.push(splits[i]);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }

        String[] path = new String[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            path[i++] = stack.pop();
        }
        StringBuilder s = new StringBuilder();
        for (i = path.length - 1; i >= 0; i--) {
            s.append("/" + path[i]);
        }

        return s.toString();

    }
}
