package linkedList;
//Ref : https://www.youtube.com/watch?v=K7J3nCeRC80
// Explanation of stack 

public class PrintRecurrsive {
	private void print(Node p) {
		if(p==null) return;
		System.out.print(p.data()+" ");
		print(p.next());
	}
	private void printReverse(Node p) {
		if(p==null) return;
		printReverse(p.next());
		System.out.print(p.data()+" ");
	}

	
	public static void main(String[] args) {
		PrintRecurrsive obj = new PrintRecurrsive();
		LinkedList ll = new LinkedList(2);
		ll.appendIntoTail(new Node(4));
		ll.appendIntoTail(new Node(6));
		ll.appendIntoTail(new Node(8));
		ll.appendIntoTail(new Node(9));
		obj.print(ll.head());
		System.out.println("\n");
		obj.printReverse(ll.head());
	}

}
