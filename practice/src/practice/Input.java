package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Input {
    public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(in.readLine());

        String[] arg = in.readLine().split(" ");
        int a = Integer.parseInt(arg[0]);

        int[] costs = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // int to string array
        Arrays.stream(costs).mapToObj(String::valueOf).toArray(String[]::new);

    }
}
