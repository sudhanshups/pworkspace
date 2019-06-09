package practice.specific;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class LC140_5083 {

    /*public String[] findOcurrences(String text, String first, String second) {
        ArrayList<String> thirds = new ArrayList<>();
        String[] words = text.split(" ");

        for (int i = 2; i < words.length; i++) {
            if (words[i - 2].equals(first) && words[i - 1].equals(second)) {
                thirds.add(words[i]);
            }
        }

        return thirds.toArray(new String[0]);
    }*/

    public int numTilePossibilities(String tiles) {
        Set<String> res = new HashSet<>();
        for (int i = 1; i < Math.pow(2, tiles.length()); i++) {
            int n = i;
            StringBuilder s = new StringBuilder();
            while (n != 0) {
                s.append(n % 2);
                n = n / 2;
            }
            String binary = s.toString();
            s = new StringBuilder();
            for (int j = 0; j < binary.length(); j++) {
                if (binary.charAt(j) == '1') {
                    s.append(tiles.charAt(j));
                }
            }
            if (!res.contains(s.toString())) {
                res.add(s.toString());
                getAllPermutation(res, s.toString(), 0);
            }
        }

        return res.size();
    }

    private void getAllPermutation(Set<String> res, String permute, int index) {
        if (index == permute.length()) {
            res.add(permute);
            return;
        }

        char[] newPermute = permute.toCharArray();
        for (int i = index; i < permute.length(); i++) {

            char temp = newPermute[i];

            newPermute[i] = newPermute[index];
            newPermute[index] = temp;

            getAllPermutation(res, new String(newPermute), index + 1);

            temp = newPermute[i];
            newPermute[i] = newPermute[index];
            newPermute[index] = temp;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //int t = Integer.parseInt(in.readLine());
        LC140_5083 lc140_5083 = new LC140_5083();
        System.out.println(lc140_5083.numTilePossibilities("AAABBC"));

        //        System.out.println(lc140_5083.findOcurrences("alice is a good girl she is a good student", "a", "good"));

    }
}

