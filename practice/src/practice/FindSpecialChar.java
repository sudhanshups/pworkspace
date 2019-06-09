package practice;

import java.util.*;

public class FindSpecialChar {

    public static void main(String args[]) throws Exception {

        Scanner in = new Scanner(System.in);

        Set<Character> CustomException = new HashSet<>();
        CustomException.addAll(new ArrayList<>(Arrays.asList()));

        List<String> input = new ArrayList<>();

        for (int lineNo = 0; lineNo < 3; lineNo++) {
            //TODO TAKE AS INPUT
            String line = in.nextLine();
            input.add(line);
        }

        List<String> specialCharDetails = findSpecialCharacters(input, true,
                false, false, false,
                false, CustomException);
        if (specialCharDetails.size() == 0) {
            System.out.println("No special Character");
        } else {
            System.out.println("Special Character at ");
            System.out.println(specialCharDetails);
        }
    }

    public static final int CHARSET = 128;

    static List<String> findSpecialCharacters(List<String> input, boolean csvExceptionsSet, boolean textExceptions1Set,
                                              boolean mathExceptions1Set, boolean mathExceptions2Set, boolean customExceptionSet,
                                              Set<Character> CustomException) {

        boolean charSet[] = new boolean[CHARSET];

        Set<Character> csvException = new HashSet<>(Arrays.asList(',', ' ', '\n', '\r'));
        Set<Character> TextException1 = new HashSet<>(Arrays.asList('!', '"', '#', '$', '%', '&', '|', '\'', '.', '\\', ':', ';', '?', '@', '_', '`', '~', '^'));
        Set<Character> MathException1 = new HashSet<>(Arrays.asList('(', ')', '*', '+', '-', '/', '<', '=', '>', '[', ']', '{', '}'));
        Set<Character> MathException2 = new HashSet<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));


        //TODO take as input
        /*boolean csvExceptionsSet = true;
        boolean textExceptions1Set = false;
        boolean mathExceptions1Set = false;
        boolean mathExceptions2Set = false;
        boolean customExceptionSet = false;*/


        for (int i = 0; i < CHARSET; i++) {
            char c = (char) i;
            if (csvExceptionsSet && csvException.contains(c)) {
                charSet[i] = true;
            } else if (textExceptions1Set && TextException1.contains(c)) {
                charSet[i] = true;
            } else if (mathExceptions1Set && MathException1.contains(c)) {
                charSet[i] = true;
            } else if (mathExceptions2Set && MathException2.contains(c)) {
                charSet[i] = true;
            } else if (customExceptionSet && CustomException.contains(c)) {
                charSet[i] = true;
            } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                charSet[i] = true;
            }
        }

/*        System.out.println("Accepted character set");
        for (int i = 0; i < CHARSET; i++) {
            if(charSet[i])
            System.out.print((char)i+"|");
        }*/


        List<String> specialCharDetails = new ArrayList<>();
        String beginning = "Beginning of the line %d";
        String afterWord = "After text %s at line %d";

        for (int lineNo = 0; lineNo < input.size(); lineNo++) {
            int OuputlineNo = lineNo + 1;

            //TODO TAKE AS INPUT
            String line = input.get(lineNo);

            boolean beginningOfTheLine = true;
            String pre = "";
            String message = "";

            for (int i = 0; i < line.length(); i++) {
                if (i > 0) {
                    beginningOfTheLine = false;
                }


                if (line.charAt(i) > CHARSET || !charSet[line.charAt(i)]) {
                    if (beginningOfTheLine) {
                        message = String.format(beginning, OuputlineNo);
                    } else {
                        message = String.format(afterWord, pre, OuputlineNo);
                    }
                    specialCharDetails.add(message);
                    break;
                }
                pre += line.charAt(i);
                if (pre.length() > 6) {
                    pre = pre.substring(pre.length() - 6);
                }
            }
        }
        return specialCharDetails;
    }

    /*
sudhanshu*
Pratap^reg ,
 Singh

,
|
+

     */
}
