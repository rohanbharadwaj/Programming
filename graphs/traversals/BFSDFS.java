package graphs.traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


class Node<E>{
	
	public E data;
	public boolean visited = false;
	public List<Node<E>> adjNodes = new LinkedList<Node<E>>(); // Adjacency List
	public Node(E d) {
		data = d;
	}
	public void addAdjNode(Node<E> node)
	{
		adjNodes.add(node);
		node.adjNodes.add(this);
	}
}
public class BFSDFS<E> {
	
	private List<Node<E>> nodes = new ArrayList<Node<E>>();
	private void bfs(Node<E> root) {
		Queue<Node<E>> q = new LinkedList<Node<E>>();
		q.add(root);
		root.visited = true;
		while(!q.isEmpty()){
			Node<E> n = (Node<E>) q.poll();
			nodes.add(n);
			System.out.print(n.data+",");
			for(Node<E> adj:n.adjNodes){
				if(!adj.visited){
					adj.visited = true;
					q.add(adj);
				}
			}
			
		}
		clear(root);
		
	}
	
	private void dfs(Node<E> root) {
		Stack<Node<E>> s = new Stack<Node<E>>();
		s.push(root);
		root.visited = true;
		while(!s.isEmpty()){
			Node<E> n = (Node<E>) s.pop();
			nodes.add(n);
			System.out.print(n.data+",");
			for(Node<E> adj:n.adjNodes){
				if(!adj.visited){
					adj.visited = true;
					s.push(adj);
				}
			}
			
		}
		clear(root);
		
	}
	private void clear(Node<E> root) {
			Queue<Node<E>> q = new LinkedList<Node<E>>();
			q.add(root);
			root.visited = false;
			while(!q.isEmpty()){
				Node<E> n = (Node<E>) q.poll();
				for(Node<E> adj:n.adjNodes){
					if(adj.visited){
						adj.visited = false;
						q.add(adj);
					}
				}
				
			}
		
	}
	
	public static void main(String[] args) {

		Node<String> frankfurt = new Node<String>("frankfurt");
		Node<String> mannheim = new Node<String>("mannheim");
		Node<String> wurzburg = new Node<String>("wurzburg");
		Node<String> stuttgard = new Node<String>("stuttgard");
		Node<String> kassel = new Node<String>("kassel");
		Node<String> karlsruhe = new Node<String>("karlsruhe");
		Node<String> erfurt = new Node<String>("erfurt");
		Node<String> numberg = new Node<String>("numberg");
		Node<String> augsburg = new Node<String>("augsburg");
		Node<String> munchen = new Node<String>("munchen");

		BFSDFS<String> g = new BFSDFS<String>();

		g.nodes.add(frankfurt);
		g.nodes.add(mannheim);
		g.nodes.add(wurzburg);
		g.nodes.add(stuttgard);
		g.nodes.add(kassel);
		g.nodes.add(karlsruhe);
		g.nodes.add(erfurt);
		g.nodes.add(numberg);
		g.nodes.add(augsburg);
		g.nodes.add(munchen);

		frankfurt.addAdjNode(mannheim);
		frankfurt.addAdjNode(wurzburg);
		frankfurt.addAdjNode(kassel);

		mannheim.addAdjNode(karlsruhe);

		karlsruhe.addAdjNode(augsburg);

		augsburg.addAdjNode(munchen);

		munchen.addAdjNode(kassel);
		munchen.addAdjNode(numberg);

		wurzburg.addAdjNode(erfurt);
		wurzburg.addAdjNode(numberg);

		numberg.addAdjNode(stuttgard);

		System.out.println("BFS:");
		g.bfs(frankfurt);
		
		System.out.println("\nDFS:");
		g.dfs(frankfurt);
	}
}