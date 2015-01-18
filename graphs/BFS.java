package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS {
	private Set<String> visited = new HashSet<String>();
    private Queue<String> queue = new LinkedList<String>();
    private GraphAdjacencyList graph;
    StringBuilder res = new StringBuilder("");
    public BFS(GraphAdjacencyList g, String startingVertex) {
        this.graph = g;
        this.queue.add(startingVertex);
        this.visited.add(startingVertex);
    }
    public String bfs(){
    	while(!queue.isEmpty())
    	{
    	String next = queue.remove(); 
        for (String neighbor : this.graph.getNeighbors(next)) {
            if (!this.visited.contains(neighbor)) {
                this.queue.add(neighbor);
                this.visited.add(neighbor);
            }
        }
        res.append(next).append(" ");
    	}
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
        BFS obj = new BFS(g, startingVertex);
        System.out.println(obj.bfs());
        
	}
}
