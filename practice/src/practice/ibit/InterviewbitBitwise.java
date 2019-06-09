package practice.ibit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InterviewbitBitwise {

    /*
    x & (x-1) will clear the lowest set bit of x
    x & ~(x-1) extracts the lowest set bit of x (all others are clear). Pretty patterns when applied to a linear sequence.
    x | (x + 1) = x with the lowest cleared bit set.
    x | ~(x + 1) = extracts the lowest cleared bit of x (all others are set).
     */

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        InterviewbitBitwise ibit = new InterviewbitBitwise();
/*        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        System.out.println(ibit.findMinXor(a));
        System.out.println(ibit.numSetBits(4294967295l));
        System.out.println(ibit.reverseBit(4294967293l));*/
    /*    ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 1, 3));
        System.out.println(ibit.singleNumber(a));

        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 1, 1, 2));
        System.out.println(ibit.singleNumber2(a)); */
        //System.out.println(ibit.divideNumber(-2147483648, -10000000));

        int a = 2, b = 3;
        int c = ~(a & b);
        ArrayList<Integer > A = new ArrayList<>();
        A.add(Integer.MAX_VALUE);
        A.add(Integer.MIN_VALUE);
        A.add(Integer.MIN_VALUE);
        System.out.println(ibit.cntBits(A));

    }

    public int cntBits(ArrayList<Integer> A) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int c = 0;
            for (int a : A) {
                if ((a & (1 << i)) == 0) {
                    c++;
                }
            }
            ans += c * (A.size() - c);
        }
        return ans;
    }

    public int UniqueNonotAppearingthrice(final List<Integer> A) {
        int one = 0;
        int two = 0;
        int notThree = 0;
        for (int a : A) {
            two |= one & a;//co appearing twice will come
            one ^= a;
            notThree = ~(one & two);
            one &= notThree;
            two &= notThree;
        }
        return one;
    }

    public int divideNumber(int dividend, int divisor) {
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        if (divisor == 1)
            return dividend;

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);

        // Initialize the quotient
        int quotient = 0;

        while (dividendL >= divisorL) {
            dividendL -= divisorL;
            ++quotient;
        }
        return sign * quotient;
    }


    public int singleNumber(final List<Integer> A) {
        int ans = 0;
        for (int i = 0; i < A.size(); i++) {
            ans = ans ^ A.get(i);
        }
        return ans;
    }

    public long reverseBit(long x) {
        int bit = 32;
        long res = 0;
        while (x > 0) {
            res = (res << 1);
            if ((x & 1) == 1) {
                res += 1;
            }
            x = (x >> 1);
            bit--;
        }
        res = (res << bit);
        return res;
    }

    public int numSetBits(long a) {
        int c = 0;
        int n = 0;
        while (a != 0) {
            if ((a & 1) == 1) {
                c++;
            }
            a = a >> 1;
        }
        return c;
    }

    public int findMinXor(ArrayList<Integer> A) {
        Collections.sort(A);
        int min = A.get(0) ^ A.get(1);
        for (int i = 2; i < A.size(); i++) {
            min = Math.min(min, A.get(i - 1) ^ A.get(i));
        }
        return min;
    }


}
