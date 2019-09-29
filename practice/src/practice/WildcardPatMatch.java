package practice;

import java.util.Arrays;

public class WildcardPatMatch {

    public boolean patternMatch(String text, int i, String pat, int j) {
        if (text.length() == i && pat.length() == j) {
            return true;
        } else if (text.length() == i || pat.length() == j) {
            return false;
        }
        if (pat.charAt(j) == '*' || pat.charAt(j) == '?') {
            boolean found = patternMatch(text, i + 1, pat, j + 1);
            if (pat.charAt(j) == '*')
                return found || patternMatch(text, i, pat, j + 1) || patternMatch(text, i + 1, pat, j + 1);
        }
        if (text.charAt(i) == pat.charAt(j)) {
            return patternMatch(text, i + 1, pat, j + 1);
        }
        return false;
    }

    public String patternMatchDP(String text, String pat) {
        int n = text.length();
        int m = pat.length();
        //first i character or text matches with first j character of pat
        boolean dp[][] = new boolean[n + 1][m + 1];

        return "";

    }

    // Function that matches input str with
    // given wildcard pattern
    static boolean strmatch(String str, String pattern,
                            int n, int m) {
        // empty pattern can only match with
        // empty string
        if (m == 0)
            return (n == 0);

        // lookup table for storing results of
        // subproblems
        boolean[][] lookup = new boolean[n + 1][m + 1];

        // initailze lookup table to false
        for (int i = 0; i < n + 1; i++)
            Arrays.fill(lookup[i], false);


        // empty pattern can match with empty string
        lookup[0][0] = true;

        // Only '*' can match with empty string
        for (int j = 1; j <= m; j++)
            if (pattern.charAt(j - 1) == '*')
                lookup[0][j] = lookup[0][j - 1];

        // fill the table in bottom-up fashion
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // Two cases if we see a '*'
                // a) We ignore '*'' character and move
                //    to next  character in the pattern,
                //     i.e., '*' indicates an empty sequence.
                // b) '*' character matches with ith
                //     character in input
                if (pattern.charAt(j - 1) == '*')
                    lookup[i][j] = lookup[i][j - 1] ||
                            lookup[i - 1][j];

                    // Current characters are considered as
                    // matching in two cases
                    // (a) current character of pattern is '?'
                    // (b) characters actually match
                else if (pattern.charAt(j - 1) == '?' ||
                        str.charAt(i - 1) == pattern.charAt(j - 1))
                    lookup[i][j] = lookup[i - 1][j - 1];

                    // If characters don't match
                else lookup[i][j] = false;
            }
        }

        return lookup[n][m];
    }

    public static void main(String args[]) {
        String text = "baaabab";//correct this
        String pat = "*ba*ab*";

        System.out.println(strmatch(text, pat, text.length(), pat.length()));

        WildcardPatMatch obj = new WildcardPatMatch();
        System.out.println(obj.patternMatch(text, 0, pat, 0));

        //System.out.println(obj.patternMatchDP(text, pat));

    }
}