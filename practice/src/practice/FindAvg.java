package practice;

import java.util.ArrayList;

//Java program to illustrate frequently used 
// Comment tags
 
/**
* <h1>Find average of three numbers!</h1>
* The FindAvg program implements an application that
* simply calculates average of three integers and Prints
* the output on the screen.
*
* @author  Pratik Agarwal
* @version 1.0
* @since   2017-02-18
*/
public class FindAvg 
{
    /**
    * This method is used to find average of three integers.
    * @param numA This is the first parameter to findAvg method
    * @param numB  This is the second parameter to findAvg method
    * @param numC  This is the second parameter to findAvg method
    * @return int This returns average of numA, numB and numC.
    */
    public int findAvg(int numA, int numB, int numC) 
    {
        return (numA + numB + numC)/3;
    }
 
    /**
    * This is the main method which makes use of findAvg method.
    * @param args Unused.
    * @return Nothing.
    */
 
    public static void main(String args[]) 
    {
    	Long a = new Long (5);
    	Long b = new Long (5);
    	if(a==b)
            System.out.println("same ");
    	else 
            System.out.println("different ");
    	
    	new ArrayList<>();
    	
        FindAvg obj = new FindAvg();
        int avg = obj.findAvg(10, 20, 30);
 
        System.out.println( 3>>1);
        
        System.out.println("Average of 10, 20 and 30 is :" + avg);
    }
}