package practice.specific;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class TR2 {


    public static String canReach(int x1, int y1, int x2, int y2) {
        Queue<Point> queue = new LinkedList<>();
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);

        queue.add(p1);
        while (!queue.isEmpty()) {
            Point temp = queue.poll();
//            System.out.println(temp);
            if (temp.x == p2.x && temp.y == p2.y) {
                return "Yes";
            } else {
                Point xAdvance = new Point(temp.x + temp.y, temp.y);
                Point yAdvance = new Point(temp.x, temp.y + temp.x);
                if (notExceedDestination(xAdvance, p2)) {
                    queue.add(xAdvance);
                }
                if (notExceedDestination(yAdvance, p2)) {
                    queue.add(yAdvance);
                }
            }
        }
        return "No";
    }

    public static boolean notExceedDestination(Point p, Point dest) {
        //        if ((p.x > dest.x && p.y == dest.y)
        //                || (p.x == dest.x && p.y > dest.y)
        //                || (p.x > dest.x && p.y > dest.y)) {
        if (p.x > dest.x || p.y > dest.y) {
            return false;
        }

        return true;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int x1 = Integer.parseInt(bufferedReader.readLine().trim());

        int y1 = Integer.parseInt(bufferedReader.readLine().trim());

        int x2 = Integer.parseInt(bufferedReader.readLine().trim());

        int y2 = Integer.parseInt(bufferedReader.readLine().trim());

        String result = TR2.canReach(x1, y1, x2, y2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();

        System.out.println(canReach(1, 4, 5, 9));
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
