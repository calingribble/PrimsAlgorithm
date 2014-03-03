import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class tree {
	ArrayList<edge> edges;
	ArrayList<edge> MST;
	boolean animationDone;
	
	public tree(ArrayList<edge> edges){
		this.edges = edges;
		this.MST = new ArrayList();
	}
	public tree(){	
		this.edges = new ArrayList();
		genNodes();
		this.MST = new ArrayList();
		this.animationDone = false;
	}
	
	public void drawTree(Graphics2D g2d){
		drawNodes(g2d);
		
	}
	public void drawNodes(Graphics2D g2d){
		drawEdges(g2d);
		g2d.setColor(Color.BLACK);
		g2d.fillOval(250, 40, 25, 25);//a
		g2d.fillOval(500, 40, 25, 25);//b
		g2d.fillOval(290, 80, 25, 25);//c
		g2d.fillOval(460, 80, 25, 25);//d
		g2d.fillOval(375, 100, 25, 25);//e
		g2d.fillOval(260, 160, 25, 25);//f
		g2d.fillOval(375, 160, 25, 25);//g
		g2d.fillOval(490, 160, 25, 25);//h
		g2d.fillOval(320, 200, 25, 25);//i
		g2d.fillOval(430, 200, 25, 25);//j
		g2d.fillOval(120, 240, 25, 25);//k
		g2d.fillOval(180, 240, 25, 25);//l
		g2d.fillOval(570, 240, 25, 25);//m
		g2d.fillOval(630, 240, 25, 25);//n
		g2d.fillOval(320, 280, 25, 25);//o
		g2d.fillOval(430, 280, 25, 25);//p
		g2d.fillOval(260, 320, 25, 25);//q
		g2d.fillOval(375, 320, 25, 25);//r
		g2d.fillOval(490, 320, 25, 25);//s
		g2d.fillOval(375, 380, 25, 25);//t
		g2d.fillOval(290, 400, 25, 25);//u	
		g2d.fillOval(460, 400, 25, 25);//v
		g2d.fillOval(250, 440, 25, 25);//w
		g2d.fillOval(500, 440, 25, 25);//x	
		g2d.setColor(Color.WHITE);
		g2d.drawString("a", 250+10, 40+16);//a
		g2d.drawString("b", 500+10, 40+16);//b
		g2d.drawString("c", 290+10, 80+16);//c
		g2d.drawString("d", 460+10, 80+16);//d
		g2d.drawString("e", 375+10, 100+16);//e
		g2d.drawString("f", 260+10, 160+16);//f
		g2d.drawString("g", 375+10, 160+16);//g
		g2d.drawString("h", 490+10, 160+16);//h
		g2d.drawString("i", 320+10, 200+16);//i
		g2d.drawString("j", 430+10, 200+16);//j
		g2d.drawString("k", 120+10, 240+16);//k
		g2d.drawString("l", 180+10, 240+16);//l
		g2d.drawString("m", 570+10, 240+16);//m
		g2d.drawString("n", 630+10, 240+16);//n
		g2d.drawString("o", 320+10, 280+16);//o
		g2d.drawString("p", 430+10, 280+16);//p
		g2d.drawString("q", 260+10, 320+16);//q
		g2d.drawString("r", 375+10, 320+16);//r
		g2d.drawString("s", 490+10, 320+16);//s
		g2d.drawString("t", 375+10, 380+16);//t
		g2d.drawString("u", 290+10, 400+16);//u
		g2d.drawString("v", 460+10, 400+16);//v
		g2d.drawString("w", 250+10, 440+16);//w
		g2d.drawString("x", 500+10, 440+16);//x
		
	}
	public void drawEdges(Graphics2D g2d){
		g2d.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
		for(int i = 0; i < this.edges.size(); i++){
			g2d.setColor(Color.GRAY);
			g2d.drawLine(this.edges.get(i).x1+12, this.edges.get(i).y1+12, this.edges.get(i).x2+12, this.edges.get(i).y2+12);
			g2d.setColor(Color.BLUE);
			g2d.drawString(this.edges.get(i).distance+"", (this.edges.get(i).x1+12 + this.edges.get(i).x2+12)/2, (this.edges.get(i).y1+12 + this.edges.get(i).y2+12)/2);			
		}
		
	}
	
	public void drawMST(Graphics2D g2d){	
		Font defFont = g2d.getFont();
		//g2d.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		for(int i = 0; i < this.MST.size(); i++){
			g2d.setColor(Color.RED);
			g2d.drawLine(this.MST.get(i).x1+12, this.MST.get(i).y1+12, this.MST.get(i).x2+12, this.MST.get(i).y2+12);
			g2d.setColor(Color.RED);
			g2d.drawString(this.MST.get(i).distance+"", (this.MST.get(i).x1+12 + this.MST.get(i).x2+12)/2, (this.MST.get(i).y1+12 + this.MST.get(i).y2+12)/2);
			
		}	
		g2d.setFont(defFont);
	}
	
	public void animateMST(Graphics2D g2d, int i){	
		Font defFont = g2d.getFont();
		//g2d.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		for(int j = 0; j < i; j++){
			g2d.setColor(Color.RED);
			g2d.drawLine(this.MST.get(j).x1+12, this.MST.get(j).y1+12, this.MST.get(j).x2+12, this.MST.get(j).y2+12);
			g2d.setColor(Color.RED);
			g2d.drawString(this.MST.get(j).distance+"", (this.MST.get(j).x1+12 + this.MST.get(j).x2+12)/2, (this.MST.get(j).y1+12 + this.MST.get(j).y2+12)/2);
			
		}	
		g2d.setFont(defFont);
	}
	
	public void genNodes(){
		this.edges.clear();
		Random rand = new Random();
		int min = 2;
		int max = 19;
		this.edges.add(new edge("A", "K" , rand.nextInt(max - min) + min, 250, 40, 120, 240));
		this.edges.add(new edge("A", "C" , rand.nextInt(max - min) + min, 250, 40, 290, 80));
		this.edges.add(new edge("A", "B" , rand.nextInt(max - min) + min, 250, 40, 500, 40));
		this.edges.add(new edge("B", "D" , rand.nextInt(max - min) + min, 500, 40, 460, 80));
		this.edges.add(new edge("B", "N" , rand.nextInt(max - min) + min, 500, 40, 630, 240));
		this.edges.add(new edge("C", "F" , rand.nextInt(max - min) + min, 290, 80, 260, 160));
		this.edges.add(new edge("C", "E" , rand.nextInt(max - min) + min, 290, 80, 375, 100));
		this.edges.add(new edge("D", "E" , rand.nextInt(max - min) + min, 460, 80, 375, 100));
		this.edges.add(new edge("D", "H" , rand.nextInt(max - min) + min, 460, 80, 490, 160));
		this.edges.add(new edge("E", "G" , rand.nextInt(max - min) + min, 375, 100, 375, 160));
		this.edges.add(new edge("F", "L" , rand.nextInt(max - min) + min, 260, 160, 180, 240));
		this.edges.add(new edge("F", "I" , rand.nextInt(max - min) + min, 260, 160, 320, 200));
		this.edges.add(new edge("G", "I" , rand.nextInt(max - min) + min, 375, 160, 320, 200));
		this.edges.add(new edge("G", "J" , rand.nextInt(max - min) + min, 375, 160, 430, 200));
		this.edges.add(new edge("H", "J" , rand.nextInt(max - min) + min, 490, 160, 430, 200));
		this.edges.add(new edge("H", "M" , rand.nextInt(max - min) + min, 490, 160, 570, 240));
		this.edges.add(new edge("I", "O" , rand.nextInt(max - min) + min, 320, 200, 320, 280));
		this.edges.add(new edge("J", "P" , rand.nextInt(max - min) + min, 430, 200, 430, 280));
		this.edges.add(new edge("K", "L" , rand.nextInt(max - min) + min, 120, 240, 180, 240));
		this.edges.add(new edge("K", "W" , rand.nextInt(max - min) + min, 120, 240, 250, 440));
		this.edges.add(new edge("L", "Q" , rand.nextInt(max - min) + min, 180, 240, 260, 320));
		this.edges.add(new edge("M", "S" , rand.nextInt(max - min) + min, 570, 240, 490, 320));
		this.edges.add(new edge("M", "N" , rand.nextInt(max - min) + min, 570, 240, 630, 240));
		this.edges.add(new edge("N", "X" , rand.nextInt(max - min) + min, 630, 240, 500, 440));
		this.edges.add(new edge("O", "Q" , rand.nextInt(max - min) + min, 320, 280, 260, 320));
		this.edges.add(new edge("O", "R" , rand.nextInt(max - min) + min, 320, 280, 375, 320));
		this.edges.add(new edge("P", "R" , rand.nextInt(max - min) + min, 430, 280, 375, 320));
		this.edges.add(new edge("P", "S" , rand.nextInt(max - min) + min, 430, 280, 490, 320));
		this.edges.add(new edge("Q", "U" , rand.nextInt(max - min) + min, 260, 320, 290, 400));
		this.edges.add(new edge("R", "T" , rand.nextInt(max - min) + min, 375, 320, 375, 380));
		this.edges.add(new edge("S", "V" , rand.nextInt(max - min) + min, 490, 320, 460, 400));
		this.edges.add(new edge("T", "U" , rand.nextInt(max - min) + min, 375, 380, 290, 400));
		this.edges.add(new edge("T", "V" , rand.nextInt(max - min) + min, 375, 380, 460, 400));
		this.edges.add(new edge("U", "W" , rand.nextInt(max - min) + min, 290, 400, 250, 440));
		this.edges.add(new edge("V", "X" , rand.nextInt(max - min) + min, 460, 400, 500, 440));
		this.edges.add(new edge("W", "X" , rand.nextInt(max - min) + min, 250, 440, 500, 440));
	}
	
	
	public void findShortestPath(){
		String[] uniqueNodes = this.findUnqiueNodes();
		System.out.println("# of unqiue nodes:" + uniqueNodes.length);
		
		this.printEdges();		
		edge currentEdge = edges.get(0);		

		
		//find and remove first smallest Edge
		for(int i = 0; i < edges.size(); i++){
			if(edges.get(i).beginNodeName.equals(currentEdge.beginNodeName) && edges.get(i).distance < currentEdge.distance ){
				currentEdge = edges.get(i);
			}		
		}
		MST.add(currentEdge);
		System.out.println(currentEdge.beginNodeName +"----"+currentEdge.distance+"----"+currentEdge.endNodeName+" removed.");
		//edges.remove(currentEdge);
		this.printEdges();
		currentEdge = null;
		

		
		//find and remove remaining smallest edges recursively 
		for(int i = 0; MST.size() < uniqueNodes.length-1; i++){
			
			for(int j = 0; j < edges.size(); j++){
				//if edge node beginning name exists in MST
				if(getMSTArrayList().contains(edges.get(j).beginNodeName)){
					//edge node end name cannot exist in MST 
					if(getMSTArrayList().contains(edges.get(j).endNodeName)){
						 
					}else{
						System.out.println(edges.get(j).beginNodeName +"----"+edges.get(j).distance+"----"+edges.get(j).endNodeName + " Examinable Edge");
						if(currentEdge == null){
							currentEdge = edges.get(j);					
						}else if(edges.get(j).distance < currentEdge.distance){
							currentEdge = edges.get(j);
						}
					}
				}
				
				//if edge node end name exists in MST
				if(getMSTArrayList().contains(edges.get(j).endNodeName)){
					//edge node beginning name cannot exist in MST 
					if(getMSTArrayList().contains(edges.get(j).beginNodeName)){
						 
					}else{
						System.out.println(edges.get(j).beginNodeName +"----"+edges.get(j).distance+"----"+edges.get(j).endNodeName + " Examinable Edge");
						if(currentEdge == null){
							currentEdge = edges.get(j);					
						}else if(edges.get(j).distance < currentEdge.distance){
							currentEdge = edges.get(j);
						}
					}
				}
			}
			
			MST.add(currentEdge);
			System.out.println(currentEdge.beginNodeName +"----"+currentEdge.distance+"----"+currentEdge.endNodeName+" removed.");
			//edges.remove(currentEdge);
			this.printEdges();
			currentEdge = null;
		}
		this.printMST();	
	}
	
	
	
	public String[] findUnqiueNodes() {
		ArrayList<String> nodeList = new ArrayList();
		for(int i = 0; i < edges.size(); i++){
			nodeList.add(edges.get(i).beginNodeName);
			nodeList.add(edges.get(i).endNodeName);	
		}
		Set<String> uniqueNodeList = new HashSet<String>(nodeList);
		String[] uniqueNodes = uniqueNodeList.toArray(new String[uniqueNodeList.size()]);
		return uniqueNodes;
	}
	
	private ArrayList getMSTArrayList() {
		ArrayList<String> nodeList = new ArrayList();
		for(int i = 0; i < MST.size(); i++){
			nodeList.add(MST.get(i).beginNodeName);
			nodeList.add(MST.get(i).endNodeName);	
		}
		return nodeList;
	}
	
	public void printEdges(){
		System.out.println("------------------");
		for(int i = 0; i < edges.size(); i++){
			System.out.println(edges.get(i).beginNodeName +"----"+edges.get(i).distance+"----"+edges.get(i).endNodeName);		
		}
		System.out.println("------------------");
	}
	
	
	public void printMST(){
		System.out.println("********MST********");
		for(int i = 0; i < MST.size(); i++){
			System.out.println(MST.get(i).beginNodeName +"----"+MST.get(i).distance+"----"+MST.get(i).endNodeName);		
		}
		System.out.println("------------------");
	}
	
	public String numToLet(int number) {
		  char[] ls = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		  String r = "";
		  while(true) {
		    r = ls[number % 26] + r;
		    if(number < 26) {
		      break;
		    }
		    number /= 26;
		  }
		  return r;
		}
	
}
