package practice.specific;

import java.io.IOException;
import java.util.*;

public class AZ1 {

    static String findQualifiedNumbers1(int[] a) {
        List<Integer> ans = Arrays.stream(a).filter(x -> containsAll(x)).boxed().collect(java.util.stream.Collectors.toList());
        String z = ans.stream().sorted().map(String::valueOf).collect(java.util.stream.Collectors.joining(","));
        if (z.isEmpty()) return "-1";
        return z;
    }

    private static boolean containsAll(int x) {
        String s = String.valueOf(x);
        return s.contains("1") && s.contains("2") && s.contains("3");
    }


    static public String solution(int A, int B, int C) {
        Map<Character, Integer> characterCountMap = new HashMap<>();
        characterCountMap.put('a', A);
        characterCountMap.put('b', B);
        characterCountMap.put('c', C);

        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Character, Integer> e : characterCountMap.entrySet()) {
            priorityQueue.add(e);
        }

        Map.Entry<Character, Integer> onHold = null;
        StringBuilder stringBuilder = new StringBuilder();

        while (!priorityQueue.isEmpty()) {
            Map.Entry<Character, Integer> cur = priorityQueue.poll();
            if (cur.getValue() <= 0) {
                continue;
            }
            stringBuilder.append(cur.getKey());

            if (onHold != null) {
                priorityQueue.add(onHold);
                onHold = null;
            }
            int curValue = cur.getValue();
            if (curValue > 1) {
                cur.setValue(curValue - 1);
                if (stringBuilder.length() >= 2 && cur.getKey() == stringBuilder.charAt(stringBuilder.length() - 2)) {
                    onHold = cur;
                } else {
                    priorityQueue.add(cur);
                }
            }
        }
        return stringBuilder.toString();
    }

    static public String getFirstKCharacter(String s, int k) {
        if (s.length() <= k)
            return s;

        String sub = s.substring(0, k);
        if (s.charAt(k) == ' ') {
            return sub;
        }
        int lastIndexOfSpace = sub.lastIndexOf(' ');
        return sub.substring(0, lastIndexOfSpace);
    }


    public static void main(String[] args) throws IOException {
       /* System.out.println(solution(6, 1, 1));
        System.out.println(solution(1, 3, 1));
        System.out.println(solution(0, 1, 8));
        System.out.println(solution(0, 0, 0));
        System.out.println(solution(1, 1, 1));
*/
        //System.out.println(getFirstKCharacter("abc d efg", 5));

        AZ1 az1 = new AZ1();
        List<Integer> a = Arrays.asList(1, 0, 0);
        List<Integer> b = Arrays.asList(1, 0, 0);
        List<Integer> c = Arrays.asList(1, 0, 0);
        List<List<Integer>> d = new ArrayList<>();
        d.add(a);
        d.add(b);
        d.add(c);

        System.out.println(az1.minimumDistanceToVisitArea(3, 3, d));

    }

    class Point {
        int i;
        int j;

        Point(int a, int b) {
            i = a;
            j = b;
        }
    }

    int minimumDistanceToVisitArea(int numRows, int numCols, List<List<Integer>> area) {
        //bfs

        boolean[][] visited = new boolean[numRows][numCols];
        visited[0][0] = true;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        queue.add(null);
        int dist = 0;
        boolean found = false;
        int[] x = {-1, +1, 0, 0};
        int[] y = {0, 0, -1, +1};
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (cur == null) {
                if (!queue.isEmpty()) {
                    dist++;
                    queue.add(null);
                }
            } else {
                if (area.get(cur.i).get(cur.j) == 9) {
                    found = true;
                    break;
                }else if(area.get(cur.i).get(cur.j)==1) {
                    for (int i = 0; i < 4; i++) {
                        int nx = cur.i + x[i];
                        int ny = cur.j + y[i];
                        if (isValid(nx, ny, numRows, numCols, visited)) {
                            queue.add(new Point(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        if (found)
            return dist;
        return -1;
    }

    private boolean isValid(int i, int j, int rows, int cols, boolean visited[][]) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j]) {
            return false;
        }
        return true;
    }

}
