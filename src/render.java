import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class render {
	public static Timer timer = new Timer();
	public static final int TARGET_FPS = 60;

	public static void render(final JComponent comp) {

		TimerTask repaint = new TimerTask() {
			@Override
			public void run() {
				comp.repaint();
			}
		};
		timer.schedule(repaint, 0, 1000 / TARGET_FPS);
	}
}