package practice.comp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//http://codeforces.com/contest/979/problem/B
public class CF482_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int maxBeauty = 0;
        int maxBeautyCount =0;

        int c =0;
        for(int i=0;i<3;i++){
            String s = in.readLine();
            Map<Character,Integer> map = new HashMap<>();
            int maxChar = s.charAt(0);
            int maxF = 1;
            for(int j=0;j<s.length();j++){
                if(!map.containsKey(s.charAt(j)))
                    map.put(s.charAt(j),0);

                map.put(s.charAt(j),map.get(s.charAt(j))+1);

                if( map.get(s.charAt(j)) > maxF){
                    maxChar = s.charAt(j);
                    maxF = map.get(s.charAt(j));
                }
            }
            int beauty = 0;
            if(maxF+n >= s.length()){
                beauty = s.length();
            }else {
                beauty = maxF + n;
            }
            if(beauty==maxBeauty && maxBeauty!=0 && i==2){
                System.out.println("DRAW");
                return;
            }else if (beauty > maxBeauty){
                maxBeauty = beauty;
                maxBeautyCount=1;
                c =i;
            }else if(beauty == maxBeauty){
                maxBeautyCount++;
            }
        }
        if(maxBeautyCount>1) {
            System.out.println("DRAW");
        return;
        }
        if (c == 0) {
            System.out.println("Kuro");
        } else if(c==1){
            System.out.println("Shiro");
        }else {
            System.out.println("Katie");
        }
    }
}
