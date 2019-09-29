package practice;

//salesforce
public class patternExist {


    public static void main(String args[]) throws Exception {
        String s = "xyzxyzxyz";
        int i, j;
        boolean mat = false;
        for (i = 1; i < s.length() / 2 + 1; i++) {
            mat = true;
            for (j = 0; j + i < s.length(); j++) { //j++ --> j=j+i
                if (s.charAt(j) != s.charAt(j + i)) {
                    mat = false;
                    break;
                }
            }
            System.out.println(i + " " + mat + j);
            if (mat == true) {
                break;
            }
        }
        if (mat)
            System.out.println("pattern found");
        else
            System.out.println(" not pattern found");

        //int[] array = Stream.of(s[2].split(" ")).mapToInt(token -> Integer.parseInt(token)).toArray();
        //for (int i = 0; i < array.length; i++)
        //	System.out.println(array[i]);
    }
}