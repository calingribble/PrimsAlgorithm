import java.awt.*;
import javax.swing.*;

public class mainFrame extends JFrame{
	public static final int WIDTH = 1020;
	public static final int HEIGHT = 650;
	public static final String NAME = "Prim's Algorithm - Calin Gribble";
	public static final JPanel displayPanel = new JPanel();
	
	public mainFrame(){
		setTitle(NAME);
		setMinimumSize(new Dimension(WIDTH, HEIGHT ));
		setMaximumSize(new Dimension(WIDTH , HEIGHT));
		setPreferredSize(new Dimension(WIDTH , HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(displayPanel);
		displayPanel.setLayout(null);
		displayPanel.setBounds(0, 0, mainFrame.WIDTH, mainFrame.HEIGHT);
		displayPanel.setFocusable(true);
		displayPanel.setVisible(true);
		displayPanel.add(new mainPanel());
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		pack();		
	}
}