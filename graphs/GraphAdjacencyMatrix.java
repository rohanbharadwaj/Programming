package graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/*
 * Refrence :
 * http://www.codeproject.com/Articles/32212/Introduction-to-Graph-with-Breadth-First-Search-BF
 */

public class GraphAdjacencyMatrix 
{
	public Node rootNode;
	public ArrayList<Node> nodes=new ArrayList<Node>();
	public int[][] adjMatrix;//Edges will be represented as adjacency Matrix
	int size;
	public void setRootNode(Node n)
	{
		this.rootNode=n;
	}
	
	public Node getRootNode()
	{
		return this.rootNode;
	}
	
	public void addNode(Node n)
	{
		nodes.add(n);
	}
	
	//This method will be called to make connect two nodes
	public void connectNode(Node start,Node end)
	{
		if(adjMatrix==null)
		{
			size=nodes.size(); // get size from number of nodes.
			adjMatrix=new int[size][size];
		}

		int startIndex=nodes.indexOf(start);
		int endIndex=nodes.indexOf(end);
		adjMatrix[startIndex][endIndex]=1; // Creating a undirected graph
		adjMatrix[endIndex][startIndex]=1; 
	}
	
	private Node getUnvisitedChildNode(Node n)
	{
		
		int index=nodes.indexOf(n);
		int j=0;
		while(j<size)
		{
			if(adjMatrix[index][j]==1 && ((Node)nodes.get(j)).visited==false)
			{
				return (Node)nodes.get(j);
			}
			j++;
		}
		return null;
	}
	
/*
 * 
Step 1: Push the root node in the Queue.
Step 2: Loop until the queue is empty.
Step 3: Remove the node from the Queue.
Step 4: If the removed node has unvisited child nodes, mark them as visited and insert the unvisited children in the queue.
Based upon the above steps, the following Java code shows the implementation of the BFS algorithm:  	
 */
	
	//BFS traversal of a tree is performed by the bfs() function
	public void bfs()
	{
		
		//BFS uses Queue data structure
		Queue<Node> q=new LinkedList<Node>();
		q.add(this.rootNode);
		printNode(this.rootNode);
		rootNode.visited=true;
		while(!q.isEmpty())
		{
			Node n=(Node)q.remove();
			Node child=null;
			while((child=getUnvisitedChildNode(n))!=null)
			{
				child.visited=true;
				printNode(child);
				q.add(child);
			}
		}
		//Clear visited property of nodes
		clearNodes();
	}
	
	
/*
Step 1: Push the root node in the Stack.  
Step 2: Loop until stack is empty. 
Step 3: Peek the node of the stack.  
Step 4: If the node has unvisited child nodes, get the unvisited child node, mark it as traversed and push it on stack.   
Step 5: If the node does not have any unvisited child nodes, pop the node from the stack.
Based upon the above steps, the following Java code shows the implementation of the DFS algorithm
 */
	//DFS traversal of a tree is performed by the dfs() function
	public void dfs()
	{
		//DFS uses Stack data structure
		Stack<Node> s=new Stack<Node>();
		s.push(this.rootNode);
		rootNode.visited=true;
		printNode(rootNode);
		while(!s.isEmpty())
		{
			Node n=(Node)s.peek();
			Node child=getUnvisitedChildNode(n);
			if(child!=null)
			{
				child.visited=true; //mark as visited
				printNode(child); // visit node
				s.push(child); //push on stack
			}
			else
			{
				s.pop(); //no children -->pop
			}
		}
		//Clear visited property of nodes
		clearNodes();
	}
	
	
	//Utility methods for clearing visited property of node
	private void clearNodes()
	{
		int i=0;
		while(i<size)
		{
			Node n=(Node)nodes.get(i);
			n.visited=false;
			i++;
		}
	}
	
	//Utility methods for printing the node's label
	private void printNode(Node n)
	{
		System.out.print(n.label+" ");
	}

	
	
	

}
