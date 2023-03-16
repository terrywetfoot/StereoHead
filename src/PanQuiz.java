import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class PanQuiz {

	Window window = Window.getInstance();

	public PanQuiz() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		MainMenu mainMenu = new MainMenu();

	}

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		new PanQuiz();
	}

}
