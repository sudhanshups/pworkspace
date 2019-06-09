package practice.ibit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Interviewbitbacktracking {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Interviewbitbacktracking ibit = new Interviewbitbacktracking();

       /* ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(ibit.subsets(A));*/

        //  System.out.println(ibit.combine(4, 2));

/*      ArrayList<Integer> A = new ArrayList<>(Arrays.asList(8, 10, 6, 11, 1, 16, 8));
        System.out.println(ibit.combinationSum(A, 28));*/

/*        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(10, 1, 2, 7, 6, 1, 5));
        System.out.println(ibit.combinationSum2(A, 8));*/

/*        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 2));
        System.out.println(ibit.subsetsWithDup(A));*/

        //       System.out.println(ibit.letterCombinations("23"));

//        System.out.println(ibit.solveNQueens(8));


/*        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(ibit.permute(A));*/

        /*ArrayList<Integer> test = new ArrayList<>(Arrays.asList(1234, 1243, 1324, 1342, 1423, 1432, 2134, 2143, 2314, 2341, 2413, 2431, 3124, 3142, 3214, 3241, 3412, 3421, 4123, 4132, 4213, 4231, 4312, 4321));
        int n = 20, k = 2;
        for (int i = 1; i <= 24; i++) {
            System.out.println(test.get(i - 1));
            System.out.println(ibit.kthPermute(n, i));
            System.out.println(" --------  ");
        }*/

        //System.out.println(ibit.grayCode(3));

        ArrayList<ArrayList<Character>> a = new ArrayList<>();
        a.add(new ArrayList<>("53..7....".chars().mapToObj(e -> (char) e).collect(Collectors.toList())));
        a.add(new ArrayList<>("6..195...".chars().mapToObj(e -> (char) e).collect(Collectors.toList())));
        a.add(new ArrayList<>(".98....6.".chars().mapToObj(e -> (char) e).collect(Collectors.toList())));
        a.add(new ArrayList<>("8...6...3".chars().mapToObj(e -> (char) e).collect(Collectors.toList())));
        a.add(new ArrayList<>("4..8.3..1".chars().mapToObj(e -> (char) e).collect(Collectors.toList())));
        a.add(new ArrayList<>("7...2...6".chars().mapToObj(e -> (char) e).collect(Collectors.toList())));
        a.add(new ArrayList<>(".6....28.".chars().mapToObj(e -> (char) e).collect(Collectors.toList())));
        a.add(new ArrayList<>("...419..5".chars().mapToObj(e -> (char) e).collect(Collectors.toList())));
        a.add(new ArrayList<>("....8..79".chars().mapToObj(e -> (char) e).collect(Collectors.toList())));

        ibit.solveSudoku(a);
        System.out.println(a);


    }


    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        ArrayList<Character> numbers = new ArrayList<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
        solveSudoku(a, numbers);
    }

    private boolean solveSudoku(ArrayList<ArrayList<Character>> a, ArrayList<Character> numbers) {
        int row = -1;
        int col = -1;
        boolean empty = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (a.get(i).get(j).equals('.')) {
                    empty = true;
                    row = i;
                    col = j;
                    break;
                }
            }
            if (empty)
                break;
        }

        if (!empty) {
            return true;
        }

        for (char c1 : numbers) {
            if (isSafe(a, row, col, c1)) {
                a.get(row).set(col, c1);
                if (solveSudoku(a, numbers)) {
                    return true;
                } else {
                    a.get(row).set(col, '.');
                }
            }
        }
        return false;
    }

    boolean isSafe(ArrayList<ArrayList<Character>> a, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (a.get(row).get(i).equals(c) || a.get(i).get(col).equals(c)) {
                return false;
            }
        }
        // check in the 3x3 box
        int boxRowStart = row - (row % 3);
        int boxColStart = col - (col % 3);
        for (int i = boxRowStart; i < boxRowStart + 3; i++) {
            for (int j = boxColStart; j < boxColStart + 3; j++) {
                if (a.get(i).get(j).equals(c)) {
                    return false;
                }
            }
        }
        return true;
    }

    public ArrayList<Integer> grayCode(int a) {
        ArrayList<String> l1 = new ArrayList<>();
        l1.add("0");
        l1.add("1");

        for (int i = 2; i <= a; i++) {
            ArrayList<String> l2 = new ArrayList<>(l1);
            Collections.reverse(l2);
            for (int j = 0; j < l1.size(); j++) {
                l1.set(j, "0" + l1.get(j));
                l2.set(j, "1" + l2.get(j));
            }
            l1.addAll(l2);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (String s : l1) {
            res.add(getNum(s));
        }
        return res;
    }

    private int getNum(String s) {
        int res = 0;
        int pow = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            res += pow * (s.charAt(i) - '0');
            pow <<= 1;
        }
        return res;
    }


    public String kthPermute(int N, int K) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            res.add(i);
        }
        getKthPermutation(res, K, 0);
        StringBuilder s = new StringBuilder();
        for (Integer i : res) {
            s.append(i);
        }
        return s.toString();
    }

    private void getKthPermutation(ArrayList<Integer> res, int K, int index) {
        if (K == 1) {
            return;
        }

        for (int i = index; i < res.size(); i++) {

            int temp = res.get(i);
            res.set(i, res.get(index));
            res.set(index, temp);

            if (res.size() - index > 14) {
                getKthPermutation(res, K, index + 1);
                break;
            } else {
                long count = fact(res.size() - index - 1);
                if (count >= K) {
                    getKthPermutation(res, K, index + 1);
                    break;
                } else {
                    K -= count;
                }
            }

        }
    }

    private long fact(int f) {
        long res = 1;
        for (int i = 1; i <= f; i++) {
            res *= i;
        }
        return res;
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        getAllPermutation(res, A, 0);
        return res;
    }

    private void getAllPermutation(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> permute, int index) {
        ArrayList<Integer> newPermute = new ArrayList<>(permute);
        if (index == permute.size()) {
            res.add(newPermute);
            return;
        }

        for (int i = index; i < newPermute.size(); i++) {
            int temp = newPermute.get(i);
            newPermute.set(i, newPermute.get(index));
            newPermute.set(index, temp);

            getAllPermutation(res, newPermute, index + 1);

            temp = newPermute.get(i);
            newPermute.set(i, newPermute.get(index));
            newPermute.set(index, temp);

        }
    }

    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        boolean[][] queen = new boolean[a][a];

        int queenPlaced = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (!queen[i][j] && isSafe(queen, i, j, a)) {
                    queen[i][j] = true;
                    placeQueen(res, queen, a, queenPlaced + 1, i + 1);
                    queen[i][j] = false;
                }
            }
        }
        return res;
    }

    private void placeQueen(ArrayList<ArrayList<String>> res, boolean[][] queen,
                            int totalQueen, int queenPlaced, int row) {
        if (totalQueen == queenPlaced) {
            ArrayList<String> oneRes = new ArrayList<>();
            for (int i = 0; i < totalQueen; i++) {
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < totalQueen; j++) {
                    if (queen[i][j]) {
                        s.append('Q');
                    } else {
                        s.append('.');
                    }
                }
                oneRes.add(s.toString());
            }
            res.add(oneRes);
            return;
        }

        for (int i = row; i < totalQueen; i++) {
            for (int j = 0; j < totalQueen; j++) {
                if (!queen[i][j] && isSafe(queen, i, j, totalQueen)) {
                    queen[i][j] = true;
                    placeQueen(res, queen, totalQueen, queenPlaced + 1, i + 1);
                    queen[i][j] = false;
                }
            }
        }
    }


    private boolean isSafe(boolean[][] queen, int u, int v, int a) {
        //col
        for (int j = 0; j < a; j++) {
            if (j != v && queen[u][j] == true) {
                return false;
            }
        }
        //row
        for (int i = 0; i < a; i++) {
            if (i != u && queen[i][v] == true) {
                return false;
            }
        }
        //upper left diagonal
        for (int i = u - 1, j = v - 1; i >= 0 && j >= 0; i--, j--) {
            if (queen[i][j] == true) {
                return false;
            }
        }

        //upper right diagonal
        for (int i = u - 1, j = v + 1; i >= 0 && j < a; i--, j++) {
            if (queen[i][j] == true) {
                return false;
            }
        }
        //lower left diagonal
        //upper right diagonal
        for (int i = u + 1, j = v - 1; i < a && j >= 0; i++, j--) {
            if (queen[i][j] == true) {
                return false;
            }
        }
        //lower right diagonal
        for (int i = u + 1, j = v + 1; i < a && j < a; i++, j++) {
            if (queen[i][j] == true) {
                return false;
            }
        }

        return true;
    }


    public ArrayList<String> letterCombinations(String A) {
        ArrayList<String> res = new ArrayList<>();
        Map<Integer, String> keymap = new HashMap<>();
        keymap.put(0, "0");
        keymap.put(1, "1");
        keymap.put(2, "abc");
        keymap.put(3, "def");
        keymap.put(4, "ghi");
        keymap.put(5, "jkl");
        keymap.put(6, "mno");
        keymap.put(7, "pqrs");
        keymap.put(8, "tuv");
        keymap.put(9, "wxyz");

        String key = keymap.get(A.charAt(0) - '0');
        String word = new String();
        for (int j = 0; j < key.length(); j++) {
            wordsByLetterCombinations(keymap, res, A, 1, word + key.charAt(j));
        }

        return res;
    }

    private void wordsByLetterCombinations(Map<Integer, String> keymap, ArrayList<String> res,
                                           String A, int AIndex, String word) {
        if (AIndex >= A.length()) {
            res.add(word);
            return;
        }

        String key = keymap.get(A.charAt(AIndex) - '0');
        for (int j = 0; j < key.length(); j++) {
            wordsByLetterCombinations(keymap, res, A, AIndex + 1, word + key.charAt(j));
        }

    }


    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        A.sort((u, v) -> (u - v));
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        getSubsetDupLexicographically(res, A, new ArrayList<>(), 0);
        return res;
    }

    private void getSubsetDupLexicographically(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> A,
                                               ArrayList<Integer> sub, int index) {
        ArrayList<Integer> newSub = new ArrayList<>(sub);
        res.add(newSub);
        if (index >= A.size()) {
            return;
        }

        for (int i = index; i < A.size(); i++) {
            newSub.add(A.get(i));
            getSubsetDupLexicographically(res, A, newSub, i + 1);
            newSub.remove(newSub.size() - 1);
            while ((i + 1) < A.size() && A.get(i + 1).equals(A.get(i)))
                i++;
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> A, int B) {
        A.sort((u, v) -> u - v);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> combination = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) <= B) {
                combination.add(A.get(i));
                getAllSumCombination2(res, A, combination, i + 1, A.get(i), B);
                combination.remove(combination.size() - 1);
                while ((i + 1) < A.size() && A.get(i + 1).equals(A.get(i)))
                    i++;

            }
        }
        return res;
    }

    private void getAllSumCombination2(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> A,
                                       ArrayList<Integer> combination, int index, int curSum, int desiredSum) {

        ArrayList<Integer> newCombination = new ArrayList<>(combination);
        if (curSum == desiredSum) {
            res.add(newCombination);
            return;
        }
        for (int i = index; i < A.size(); i++) {
            if (curSum + A.get(i) <= desiredSum) {
                newCombination.add(A.get(i));
                getAllSumCombination2(res, A, newCombination, i + 1, curSum + A.get(i), desiredSum);
                newCombination.remove(newCombination.size() - 1);
                while ((i + 1) < A.size() && A.get(i + 1).equals(A.get(i)))
                    i++;
            }
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Set<Integer> s = new TreeSet<>(A);
        A = new ArrayList<>(s);

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> combination = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) <= B) {
                combination.add(A.get(i));
                getAllSumCombination(res, A, combination, i, A.get(i), B);
                combination.remove(combination.size() - 1);
            }
        }
        return res;
    }

    private void getAllSumCombination(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> A,
                                      ArrayList<Integer> combination, int index, int curSum, int desiredSum) {

        ArrayList<Integer> newCombination = new ArrayList<>(combination);
        if (curSum == desiredSum) {
            res.add(newCombination);
            return;
        }
        for (int i = index; i < A.size(); i++) {
            if (curSum + A.get(i) <= desiredSum) {
                newCombination.add(A.get(i));
                getAllSumCombination(res, A, newCombination, i, curSum + A.get(i), desiredSum);
                newCombination.remove(newCombination.size() - 1);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> combination = new ArrayList<>();

        for (int i = 1; i <= A; i++) {
            combination.add(i);
            getAllCombination(res, combination, i + 1, A, B);
            combination.remove(combination.size() - 1);
        }
        return res;
    }

    private void getAllCombination(ArrayList<ArrayList<Integer>> res, final ArrayList<Integer> combination,
                                   int currentEle, int maxEle, int length) {
        ArrayList<Integer> newCombination = new ArrayList<>(combination);
        if (newCombination.size() == length) {
            res.add(newCombination);
            return;
        }
        for (int i = currentEle; i <= maxEle; i++) {
            newCombination.add(i);
            getAllCombination(res, newCombination, i + 1, maxEle, length);
            newCombination.remove(newCombination.size() - 1);
        }
    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        A.sort((u, v) -> (u - v));
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        getSubsetLexicographically(res, A, new ArrayList<>(), 0);
        return res;
    }

    private void getSubsetLexicographically(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> A,
                                            ArrayList<Integer> sub, int index) {
        ArrayList<Integer> newSub = new ArrayList<>(sub);
        res.add(newSub);
        if (index >= A.size()) {
            return;
        }

        for (int i = index; i < A.size(); i++) {
            newSub.add(A.get(i));
            getSubsetLexicographically(res, A, newSub, i + 1);
            newSub.remove(newSub.size() - 1);
        }
    }


}
