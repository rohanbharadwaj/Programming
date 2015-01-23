package linkedList;

class Node {
	private Node next;
	private int data;

	public Node(int data) {
		this.data = data;
	}

	public int data() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node next() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}

public class LinkedList {

	private Node head;

	public LinkedList(int d) {
		this.head = new Node(d);
	}

	public Node head() {
		return head;
	}

	public void appendIntoTail(Node node) {
		Node current = head;

		// find last element of LinkedList i.e. tail
		while (current.next() != null) {
			current = current.next();
		}
		// appending new node to tail in LinkedList
		current.setNext(node);
	}
}
