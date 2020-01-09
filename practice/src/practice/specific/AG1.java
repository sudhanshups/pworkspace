package practice.specific;

import java.io.IOException;
import java.util.*;

public class AG1 {

    static Map<String, Integer> monthToId = new HashMap<>();

    static class DateComparator implements Comparator<String> {
        public int compare(String u, String v) {
            String[] split1 = u.split(" ");
            String[] split2 = v.split(" ");
            int c = split1[2].compareTo(split2[2]);
            if (c != 0) return c;
            c = monthToId.get(split1[1]).compareTo(monthToId.get(split2[1]));
            if (c != 0) return c;
            return split1[0].compareTo(split2[0]);
        }
    }

    public static List<String> sortDates(List<String> dates) {
        List<String> month = new ArrayList<>(Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));
        for (int i = 0; i < month.size(); i++) {
            monthToId.put(month.get(i), i);
        }
        Collections.sort(dates,new DateComparator());
        return dates;
    }


    public static void main(String[] args) throws IOException {
        List<String> dates = new ArrayList<>(Arrays.asList("01 Mar 2017", "03 Feb 2017", "15 Jan 1998"));
        System.out.println(sortDates(dates));
    }

}
