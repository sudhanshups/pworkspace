
public class CacheDriver {
	public static void main(String args[]) {
		Cache c = new Cache();
		c.search(7);
		c.search(0);
		c.search(1);
		c.search(2);
		c.search(0);
		c.search(3);
		c.search(0);
		c.search(4);
		c.search(2);
		c.search(3);
		c.search(0);
		c.search(3);
		c.search(2);
		c.search(1);
		c.search(2);
		c.search(0);
		c.search(1);
		c.search(7);
		c.search(0);
		c.search(1);
		c.displayCache();
		
/*		
		DoublyLinkedList dll = new DoublyLinkedList();
		Node []arr=new Node[]{
				new Node(1, "one"),
				new Node(2, "two"),
				new Node(3, "three"),
				new Node(4, "four")
		};
		dll.pushBack(arr[0]);
		dll.pushBack(arr[1]);
		dll.pushBack(arr[2]);
		dll.displayList();
		dll.pushBack(arr[3]);
		dll.displayList();
		dll.popFront();
		dll.displayList();
		dll.popBack();
		dll.displayList();
		System.out.println(" 1------ ");
		dll.updateToEnd(arr[1]);
		dll.displayList();*/
	}
}