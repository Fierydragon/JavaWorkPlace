import java.util.LinkedList;

import org.w3c.dom.Node;

public class Graph {
	public enum State {
		unVisited, Visiting, Visited;
	}
	
	public static boolean search(Graph g, Node start, Node end) {
		LinkedList<Node> q = new LinkedList<Node>();
		for(Node u : g.getNotes()){
			u.state = State.unVisited;
		}
		
		q.add(start);
		
		while(!q.isEmpty()){
			Node r = q.poll();
			
			foreach(Node n in r.adjacent){
				if(n.state == unVisited){
					if(n == end)
						return true;
					else{
						n.state = Visiting;
						q.add(n);
					}
				}
			}
			r.state = Visited;
		}
		
		return false;
			
	}
	
	public static boolean searchDSF(Graph g, Node start, Node end){
		for(Node u : g.getNodes()){
			u.state = unVisited;
		}
		
		foreach(Node n in start.adjacent){
			if(n.state == State.unVisited) {
				if(n == end)
					return true;
				
				n.state = State.Visiting;
				searchDSF(g, n, end);
				n.state = Visited;
			}
		}
	}
}
