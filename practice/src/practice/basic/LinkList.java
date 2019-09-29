package practice.basic;

class Node {
	int data;
	Node next;

	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}

public class LinkList {
	Node head = null;

	boolean insert(int data) {
		Node n = new Node(data, null);
		n.next = head;
		head = n;
		return true;
	}

	boolean delete(int data) throws Exception {
		Node p = null, c = head;
		while (c != null) {
			if (c.data == data)
				break;
			p = c;
			c = c.next;
		}
		if (c != null ) {
			if (c.data == head.data) {
				head = head.next;
			} else {
				p.next = c.next;
			}
		}
		System.out.println("Element not found");
		return true;
	}

	void printList() {
		Node node = head;
		while (node != null) {
			System.out.print(String.valueOf(node.data) + " --> ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		LinkList l = new LinkList();
		l.printList();
		l.insert(1);
		l.insert(2);
		l.insert(3);
		l.insert(4);
		l.insert(1);
		l.insert(2);
		l.insert(3);
		l.insert(4);
		l.printList();
		try {
			l.delete(1);
			l.delete(2);
			// l.delete(5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" after 1 2 deletrion");
		l.printList();
		try {
			l.delete(4);
			System.out.println(" after 4 deletrion");
			l.printList();
			l.delete(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" after 4 3  deletrion");
		l.printList();
		System.out.println(" after all deletrion");

		try {
			System.out.println("Deleting 5");
			l.delete(5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception block");
			System.out.println(e);
			/*
			 * System.out.println(e.getMessage()); e.printStackTrace();
			 */
		}
	}
}
