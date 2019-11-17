package practice.comp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CJ1 {
    static int fill(int []arr,String instructions){
        int c = 1;
        int s =0;
        for(int i=0;i<instructions.length();i++){
            if(instructions.charAt(i)=='C'){
                c=c*2;
                arr[i]=c;
            }else{
                arr[i]=c;
                s+=arr[i];
            }
        }
        return s;
    }
    static int swapTo(int reduce,int mReduce,int ls,int lc){
        int curReduce = reduce;
        for(int i=lc+1;i<=ls;i++){
            if(curReduce>=mReduce){
                return i;
            }
            curReduce +=reduce;
        }
        return ls;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        for(int k =1;k<=t;k++) {
            String[] arg = in.readLine().split(" ");
            int damage = Integer.parseInt(arg[0]);
            int f =0;
            String instructions = arg[1];
            int w[] = new int[instructions.length()];
            int shots = fill(w, instructions);
            /*for (int i = 0; i < instructions.length(); i++) {
                System.out.print(w[i] + " ");
            }*/

            if(shots>damage){
                //System.out.println(shots+" shots, damage "+damage);
                int l = instructions.length();
                int index = l-1;
                int ls = instructions.lastIndexOf('S',index);
                int lc = instructions.lastIndexOf('C',ls);
                //System.out.println("Beg " +shots+" =shots,flips= "+f + " ,"+ lc +" =lc,ls= "+ls);
                while(lc != -1 && ls!=-1 ){
                    int stepReduce = w[lc]/2;
                    int mReduce = (int)Math.floor((double)(shots-damage));
                    int lsToSwap = swapTo(stepReduce,mReduce,ls,lc);
                    shots = shots - (lsToSwap-lc)*stepReduce;
                    f = f + (lsToSwap-lc);
                    //System.out.println(shots+" =shots,flips= "+f + " ,indexSwapped="+ lc +" , "+lsToSwap);
                    ls = lsToSwap -1;
                    instructions = instructions.substring(0,lc)+'S'+instructions.substring(lc+1);
                    lc = instructions.lastIndexOf('C',lc);
                    if(shots<=damage){
                        break;
                    }
                }
            }

            //System.out.println(shots+" =shots,flips= "+f);

            if(shots<=damage)
                System.out.println("Case #"+k+": "+f);
            else
                System.out.println("Case #"+k+": IMPOSSIBLE");
        }
    }
}
