package swiggy.delivery.pojo;

public class TestLocation {

	public static void main(String[] args) {
		Location l1 = new Location(28.471428, 77.108491);
		Location l2 = new Location(28.471157, 77.102035);
		System.out.println(l1.separatedBy(l2));
	}

}
