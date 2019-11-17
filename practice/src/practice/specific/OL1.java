package practice.specific;

import java.io.IOException;
import java.util.*;

public class OL1 {

    public static int getMaximumOutfits(List<Integer> outfits, int money) {
        int j = 0;
        int noOutfit = 0;
        Queue<Integer> bought = new LinkedList<>();
        while (j < outfits.size()) {
            if (money < outfits.get(j) && bought.isEmpty()) {
                j++;
                continue;
            }
            if (money >= outfits.get(j)) {
                bought.add(outfits.get(j));
                money -= outfits.get(j);
                noOutfit = Math.max(noOutfit, bought.size());
                j++;
            } else {
                Integer o1 = bought.poll();
                money += o1;
            }
        }

        return noOutfit;
    }

    public static void main(String[] args) throws IOException {

        OL1 az1 = new OL1();
        List<Integer> a = Arrays.asList(2,2,2,2,2,2);

        System.out.println(az1.getMaximumOutfits(a, 5));

    }


}
