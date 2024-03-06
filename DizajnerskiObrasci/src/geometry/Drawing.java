package geometry;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel{

	public static void main(String[] args) {
		JFrame frame = new JFrame("Drawing");
		frame.setSize(800, 600);
		Drawing drawing = new Drawing();
		frame.getContentPane().add(drawing);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
