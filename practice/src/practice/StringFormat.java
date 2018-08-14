package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

public class StringFormat {

	public static void main(String args[]){
		Long id = 1234L;
		System.out.println(isFieldDiff(1.41,1.41));
		Integer i = null;
		StringBuilder b = new StringBuilder();
		StringBuilder c = new StringBuilder();
		
		b.append("sudhanshu");
		b.append(i);
		b.insert(0,"sagar");
		if(c.toString()==null)
			System.out.println("-wfjn-");
		System.out.println("-"+c.toString()+"-");
		System.out.println(b.toString());
	
		
        List<Long> idsDeleted = new ArrayList<>();
        temp(idsDeleted);
        System.out.println(idsDeleted);

    	System.out.println(" map print ");
        Map<Integer,List<String>> map = new HashMap<>();
        List<String> str = new ArrayList<>();
        str.add("sud");
        map.put(1,str);
		System.out.println(map);
		str.add("rahul");
//        map.put(2,str);
		System.out.println(map);
		System.out.println(map.get(10));
		System.out.println(map);       
		
		Boolean a= null;
		if(a){
			System.out.println("sudhandhuwef");	
		}
		
	}
	static void temp(List<Long> idsDeleted ){
		idsDeleted.add(123L);
		
	}
	
	static <T> boolean isFieldDiff(T a, T b) {
        if (a == null && b == null) {
            return false;
        } else if ((a != null && b == null) || (a == null && b != null)) {
            return true;
        } else if(a.equals(b)){
            return false;
        }else
            return true;
    }
}



