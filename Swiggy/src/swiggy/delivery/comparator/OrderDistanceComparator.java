package swiggy.delivery.comparator;

import java.util.Comparator;

import swiggy.delivery.pojo.DeliveryExecutive;
import swiggy.delivery.pojo.Location;

public class OrderDistanceComparator implements Comparator<DeliveryExecutive>{
	
	private Location refLocation;
	
	public OrderDistanceComparator(Location orderLocation){
		refLocation = orderLocation;
	}
	
	
	@Override
	public int compare(DeliveryExecutive d1, DeliveryExecutive d2) {
		if(null==d1 && null == d2) return 0;
		else if(null ==d1) return 1;
		else if(null ==d2) return 2;
		else {
			double dis1 = d1.getCurrentLoc().separatedBy(refLocation);
			double dis2 = d2.getCurrentLoc().separatedBy(refLocation);
			if(dis1<dis2) {
				return -1;
			}else if(dis1>dis2){
				return 1;
			}
		}
		return 0;
	}

	public Location getRefLocation() {
		return refLocation;
	}

	public void setRefLocation(Location refLocation) {
		this.refLocation = refLocation;
	}

}
