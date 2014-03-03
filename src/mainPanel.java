import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class mainPanel extends JPanel{
	JPanel edgePanel;
	JLabel genEdgeLabel;
	JButton genEdgeButton;
	JButton findMSTButton;
	JButton animateMSTButton;
	boolean showMST;
	boolean animateMST;
	tree t;
	int i;
	
	TimerTask animationTimer = new TimerTask(){
		public void run() {
			try{
				if(i < t.MST.size()){
					i++;
				}
			}catch(Exception E){			
			}
		}
	};
	
	public mainPanel(){
		setLayout(null);
		setBounds(0, 0, mainFrame.WIDTH , mainFrame.HEIGHT);
		setBackground(new Color(102, 178, 255));
		render.render(this);	
		render.timer.schedule(animationTimer, 0, 600);

		t = new tree();
		showMST = false;
		
		genEdgeLabel = new JLabel();
		genEdgeLabel.setText("<HTML><b><font size ='5'>Generate Edges:</b><br><font color='purple' size ='2'>Press to generate random edge distances.</html>");
		genEdgeLabel.setLocation(mainFrame.WIDTH - 190,75);
		genEdgeLabel.setSize(180, 60);
		add(genEdgeLabel);
		
		
		genEdgeButton = new JButton("RANDOMIZE EDGES");
		genEdgeButton.setLocation(mainFrame.WIDTH - 190,140);
		genEdgeButton.setSize(160, 30);
		genEdgeButton.setFocusable(false);
		genEdgeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try{
					t = new tree();
					showMST = false;
					animateMST = false;
				}catch(Exception E){
					
				}
			}
	    }); 
		add(genEdgeButton);
		
		findMSTButton = new JButton("FIND MST");
		findMSTButton.setLocation(mainFrame.WIDTH - 190,190);
		findMSTButton.setSize(160, 30);
		findMSTButton.setFocusable(false);
		findMSTButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try{
					if(showMST){
					
					}else{
						t.findShortestPath();
					}
					showMST = true;
					animateMST = false;
				}catch(Exception E){
					
				}
			}
	    }); 
		add(findMSTButton);
		
		animateMSTButton = new JButton("ANIMATE MST");
		animateMSTButton.setLocation(mainFrame.WIDTH - 190,240);
		animateMSTButton.setSize(160, 30);
		animateMSTButton.setFocusable(false);
		animateMSTButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try{
					if(animateMST){
						
					}else{
						t.findShortestPath();
					}
					i = 0;
					animateMST = true;
					showMST = false;				
				}catch(Exception E){
					
				}

			}
	    }); 
		add(animateMSTButton);
		


		edgePanel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				t.drawTree(g2d);
				if(showMST){
					t.drawMST(g2d);
				}
				if(animateMST){
					t.animateMST(g2d, i);
				}    
			}		
		};
		
		edgePanel.setBounds(20, 80, mainFrame.WIDTH - 230, mainFrame.HEIGHT - 130);
		edgePanel.setBackground(new Color(199, 199, 199));
		edgePanel.setLayout(null);
		render.render(edgePanel);
		edgePanel.setFocusable(true);
		edgePanel.setVisible(true);
		edgePanel.setBorder(BorderFactory.createLoweredBevelBorder());
		add(edgePanel);
		
		
		setFocusable(true);
		setVisible(true);
	}
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 52));
		g2d.drawString("Prim's Algorithm", 20, 60);		
	}
}
