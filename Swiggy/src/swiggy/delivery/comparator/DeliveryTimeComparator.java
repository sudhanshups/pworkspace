package swiggy.delivery.comparator;

import java.util.Comparator;

import swiggy.delivery.pojo.DeliveryExecutive;

public class DeliveryTimeComparator implements Comparator<DeliveryExecutive> {
	
	public static final DeliveryTimeComparator instance=new DeliveryTimeComparator();

	@Override
	public int compare(DeliveryExecutive o1, DeliveryExecutive o2) {
		if(null==o1 && null == o2) return 0;
		else if(null ==o1) return 1;
		else if(null ==o2) return 2;
		else {
			if(o1.getLastOrderTime().before(o2.getLastOrderTime())) {
				return -1;
			}else if(o2.getLastOrderTime().before(o1.getLastOrderTime())){
				return 1;
			}
		}
		return 0;
	}

}
