
public class edge {
	String beginNodeName;
	String endNodeName;
	int distance;
	int x1;
	int y1;
	int x2;
	int y2;
	
	public edge(String beginNode, String endNode, int distance, int x1, int y1, int x2, int y2){
		this.beginNodeName = beginNode;
		this.endNodeName = endNode;
		this.distance = distance;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
}
