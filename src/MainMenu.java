import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MainMenu {
	Window window = Window.getInstance();
	GameRound round;

	public MainMenu() {
		window.displayMenuScene();

		window.playGameRound.addActionListener(e -> {
			try {
				if(round != null) {
					round = null;
				}
				GameRound round = new GameRound(1);
			} catch (UnsupportedAudioFileException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

	}
}
