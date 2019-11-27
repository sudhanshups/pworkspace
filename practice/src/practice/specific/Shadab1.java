package practice.specific;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Shadab1 {

    static int solution(int[] A) {
        boolean[] visited = new boolean[A.length + 1];
        Set<Integer> notTurnedOn = new HashSet<>();
        int res = 0;
        int bulbNo = 1;
        for (int i = 0; i < A.length; i++) {
            if (!visited[bulbNo]) {
                notTurnedOn.add(bulbNo);
            }
            visited[A[i]] = true;
            if (notTurnedOn.contains(A[i])) {
                notTurnedOn.remove(A[i]);
            }
            if (notTurnedOn.isEmpty()) {
                res++;
            }
            bulbNo++;
        }
        return res;
    }

    static int solution2(int[] A) {
        Map<Integer, Long> count = Arrays.stream(A).boxed().collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting()));
        long res = 0;
        long threshold = 1000000000;
        for (Map.Entry<Integer, Long> e : count.entrySet()) {
            res += (e.getValue() * (e.getValue() - 1)) >> 1;
            if (res > threshold)
                return (int) threshold;
        }
        return (int) res;
    }

    public static void main(String[] args) throws IOException {
       /* System.out.println(solution(6, 1, 1));
        System.out.println(solution(1, 3, 1));
        System.out.println(solution(0, 1, 8));
        System.out.println(solution(0, 0, 0));
        System.out.println(solution(1, 1, 1));
*/
        //System.out.println(getFirstKCharacter("abc d efg", 5));

        Shadab1 az1 = new Shadab1();
        int[] arr = new int[]{3, 2, 1};
        System.out.println(az1.solution(arr));
        int[] arr1 = new int[]{};
        System.out.println(az1.solution2(arr1));

    }


}
