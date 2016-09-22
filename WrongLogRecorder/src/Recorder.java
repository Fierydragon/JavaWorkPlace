import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Recorder {
	ArrayList<Node> queue = new ArrayList<Node>();
	
	int find(String fileName){
		for(int i = 0; i < queue.size(); i++){
			if(queue.get(i).fileAndLine.equals(fileName)){
				return i;
			}		
		}
		return -1;
	}
	
	void enqueue(String fileAndLine){
		int index = find(fileAndLine);
		if(index == -1 && queue.size() < 8)
			queue.add(new Node(fileAndLine, 1));
		else if(index != -1){
			Node node = (Node)queue.get(index);
			node.count++;
			System.out.println(node.count);
			queue.set(index, node);
		}
	}
	
	void sort(){
		
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		Recorder rc = new Recorder();
		
		while(input.hasNext()){
			String pathAndLine = input.nextLine();
			//System.out.println(pathAndLine);
			if(pathAndLine.equals("Q"))
				break;
			int index = pathAndLine.lastIndexOf("\\");
			String fileAndLine = pathAndLine.substring(index+1);
			System.out.println(fileAndLine);
			rc.enqueue(fileAndLine);
		}
		
		Comparator<Node> sortByCount = new SortByCount();
		Collections.sort(rc.queue, sortByCount);
		
		for(int i = 0; i < rc.queue.size(); i++){
			Node result = rc.queue.get(i);
			String fileAndLine = result.fileAndLine;
			int index = fileAndLine.indexOf(" ");
			if(index > 16)
				fileAndLine = fileAndLine.substring(index - 16);
			System.out.println(fileAndLine + " " +result.count);
		}
		
		input.close();
	}
	
	

}

class Node {
	String fileAndLine = null;
	int count = 0;
	
	Node(String _fileAndLine,int _count){
		fileAndLine = _fileAndLine;
		count = _count;
	}

}

class SortByCount implements Comparator<Node>{
	public int compare(Node n1, Node n2){
		if(n1.count > n2.count)
			return -1;
		return 1;
	}
}