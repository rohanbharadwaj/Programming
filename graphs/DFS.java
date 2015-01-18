package graphs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class DFS {
	private Set<String> visited = new HashSet<String>();
    private Stack<String> stack = new Stack<String>();
    private GraphAdjacencyList graph;
    StringBuilder res = new StringBuilder("");

    public DFS(GraphAdjacencyList g, String startingVertex) {
        this.stack.add(startingVertex);
        this.graph = g;
        this.visited.add(startingVertex);
    }
    public String search()
    {	
//    	while(!stack.isEmpty())
//    	{
//    	String next = stack.peek(); 
//        for (String neighbor : this.graph.getNeighbors(next)) {
//            if (!this.visited.contains(neighbor)) {
//                this.stack.add(neighbor);
//                this.visited.add(neighbor);
//            }
//        }
//        res.append(next).append(" ");
//    	}
    	return res.toString();
    	
    }
    public static void main(String[] args) {
    	GraphAdjacencyList g = new GraphAdjacencyList();
        g.addEdge("A", "B");
        g.addEdge("B", "C");
        g.addEdge("B", "D");
        g.addEdge("B", "A");
        g.addEdge("B", "E");
        g.addEdge("B", "F");
        g.addEdge("C", "A");
        g.addEdge("D", "C");
        g.addEdge("E", "B");
        g.addEdge("F", "B");
        String startingVertex = "B";
        DFS obj = new DFS(g, startingVertex);
        System.out.println(obj.search());
        
	}
    
}
