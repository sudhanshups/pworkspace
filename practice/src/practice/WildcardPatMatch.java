package practice;

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


    public static void main(String args[]) {
        String text = "baaabab";
        String pat = "*****ba*****ab";

        WildcardPatMatch obj = new WildcardPatMatch();
        //System.out.println(obj.patternMatch(text, 0, pat, 0));

        System.out.println(obj.patternMatchDP(text, pat));

    }
}