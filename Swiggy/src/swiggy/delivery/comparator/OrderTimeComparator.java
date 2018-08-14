package swiggy.delivery.comparator;

import java.util.Comparator;

import swiggy.delivery.pojo.Order;

public class OrderTimeComparator implements Comparator<Order>{

	public static final OrderTimeComparator instance=new OrderTimeComparator();
	
	@Override
	public int compare(Order o1, Order o2) {
		if(null==o1 && null == o2) return 0;
		else if(null ==o1) return 1;
		else if(null ==o2) return 2;
		else {
			if(o1.getTime().before(o2.getTime())) {
				return -1;
			}else if(o2.getTime().before(o1.getTime())){
				return 1;
			}
		}
		return 0;
	}

}
