package strategy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import mvc.DrawingFrame;

public class SaveCommands implements Save{

	DrawingFrame frame;

	public SaveCommands(DrawingFrame frame) {

		this.frame = frame;

	}

	@Override
	public void save(String path) {

		File file = new File(path);

		try {

			FileWriter fw = new FileWriter(file);
			fw.write(frame.getTextArea().getText());
			fw.close();
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "Something went wrong!", "Message", JOptionPane.INFORMATION_MESSAGE);

		}

	}

}
