package linkedList;

public class Reverse {

	private Node head;

	public Reverse(int d) {
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

	public  class Node {
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
	private void reverse() {
		Node current,prev,next;
		current = head;//current node at any stage
		prev = null; // at begining prev is null
		//list is empty head = null
		while(current!=null){
			next = current.next;//first preserve next node info
			current.next = prev;
			prev = current;
			current = next;
		}
		// prev will have address of last node
		head = prev; // head should be equal to addr in prev
		
	}
	public static void main(String[] args) {
		Reverse obj = new Reverse(2);
		obj.appendIntoTail(obj.new Node(4));
		obj.appendIntoTail(obj.new Node(6));
		obj.appendIntoTail(obj.new Node(8));
		obj.reverse();
		Node cur = obj.head();
		while(cur!=null){
			System.out.print(cur.data+"-->");
			cur=cur.next;
		}
		System.out.println("null");
	}

}
