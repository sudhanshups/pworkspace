package practice.specific;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class booking {

    static int[] sort_hotels(String keyword, int[] hotel_ids, String[] reviews) {

        Set<String> keywords = new HashSet<>(Arrays.asList(keyword.split(" ")));

        int n, i;
        n = hotel_ids.length;
        Set<Integer> distinctHotel = new HashSet<>();


        int[][] hotelIdReview = new int[n][2];
        for (i = 0; i < n; i++) {
            hotelIdReview[i][0] = hotel_ids[i];
            distinctHotel.add(hotel_ids[i]);
        }

        for (i = 0; i < n; i++) {
            String[] review = reviews[i].split("[\\s,.]+");
            int s = 0;
            for (String word : review) {
                // System.out.println(word + "+");
                if (keywords.contains(word.toLowerCase()))
                    s++;
            }
            hotelIdReview[i][1] = s;
        }
        Map<Integer, Integer> hotelRank = new TreeMap<>();
        for (i = 0; i < n; i++) {
            if (!hotelRank.containsKey(hotelIdReview[i][0])) {
                hotelRank.put(hotelIdReview[i][0], new Integer(0));
            }
            hotelRank.put(hotelIdReview[i][0], hotelRank.get(hotelIdReview[i][0]) + hotelIdReview[i][1]);
        }
        for (Map.Entry<Integer, Integer> entry : hotelRank.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            //System.out.printf("%s : %s\n", key, value);
        }
        Map<Integer, ArrayList<Integer>> SortedRank = new TreeMap<>(Collections.reverseOrder());

        for (Map.Entry<Integer, Integer> entry : hotelRank.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            ArrayList tempList = null;
            if (SortedRank.containsKey(value)) {
                tempList = SortedRank.get(value);
                if (tempList == null)
                    tempList = new ArrayList();
                tempList.add(key);
            } else {
                tempList = new ArrayList();
                tempList.add(key);
            }
            SortedRank.put(value, tempList);
        }

        //Set <Map.Entry<Integer,ArrayList<Integer>> > set = SortedRank.entrySet();
        Set set = SortedRank.entrySet();

        Iterator it = set.iterator();
        // Show TreeMap elements

        int [] ids = new int[distinctHotel.size()];
        i =0;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            //System.out.print("Key is: " + pair.getKey());

            //System.out.println("Value is: ");
            List<Integer> list = (List<Integer>) pair.getValue();
            Collections.sort(list);
            for (Integer hotelid : list) {
                ids[i++]=hotelid;
                //System.out.println(hotelid);
            }
        }
    return ids;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //reading keywords


        int [] ids = sort_hotels("breakfast beach citycenter location metro view staff price",
                new int []{1,2, 1, 1,2},new String []{
                        "This hotel has a nice view of the citycenter. The location is perfect.",
                        "The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.",
                        "Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.",
                        "They said I couldn't take my dog and there were other guests with dogs! That is not fair.",
                        "Very friendly staff and good cost-benefit ratio. Location is a bit far from citycenter."
                });

        //System.out.println( "sudhanshu");

        for(int i=0;i<ids.length;i++){
            System.out.println(ids[i]);
        }


        /**
        String [] kw = in.readLine().split(" ");

        Set<String> keywords = new HashSet<>(Arrays.asList( kw ));
        int n, i;

        n = Integer.parseInt(in.readLine());
        int[][] hotelIdReview = new int[n][2];
        for (i = 0; i < n; i++) {
            hotelIdReview[i][0] = Integer.parseInt(in.readLine());
        }

        n = Integer.parseInt(in.readLine());
        for (i = 0; i < n; i++) {
            String[] review = in.readLine().split("[\\s,.]+");
            int s = 0;
            for (String word : review) {
               // System.out.println(word + "+");
                if (keywords.contains(word.toLowerCase()))
                    s++;
            }
            hotelIdReview[i][1] = s;
        }
        Map<Integer, Integer> hotelRank = new TreeMap<>();
        for (i = 0; i < n; i++) {
            if (!hotelRank.containsKey(hotelIdReview[i][0])) {
                hotelRank.put(hotelIdReview[i][0], new Integer(0));
            }
            hotelRank.put(hotelIdReview[i][0], hotelRank.get(hotelIdReview[i][0]) + hotelIdReview[i][1]);
        }
        for (Map.Entry<Integer, Integer> entry : hotelRank.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            //System.out.printf("%s : %s\n", key, value);
        }
        Map<Integer, ArrayList<Integer>> SortedRank = new TreeMap<>(Collections.reverseOrder());

        for (Map.Entry<Integer, Integer> entry : hotelRank.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            ArrayList tempList = null;
            if (SortedRank.containsKey(value)) {
                tempList = SortedRank.get(value);
                if (tempList == null)
                    tempList = new ArrayList();
                tempList.add(key);
            } else {
                tempList = new ArrayList();
                tempList.add(key);
            }
            SortedRank.put(value, tempList);
        }

        Set set = SortedRank.entrySet();
        Iterator it = set.iterator();
        // Show TreeMap elements
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.print("Key is: " + pair.getKey());

            System.out.println("Value is: ");
            List<Integer> list = (List<Integer>) pair.getValue();
            Collections.sort(list);
            for (Integer hotelids : list) {
                System.out.println(hotelids);
            }
        }*/
    }
}
