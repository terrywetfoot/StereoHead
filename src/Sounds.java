import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.io.File;
import java.io.IOException;

public class Sounds {

	FloatControl panControl;
	Clip clip;
	String name;
	String filePath;

	public Sounds(String name, String audioFilePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		File soundClip = new File(audioFilePath);
		this.filePath = audioFilePath;
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundClip);
		clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		panControl = (FloatControl) clip.getControl(FloatControl.Type.PAN);
		this.name = name;
	}

	public void setPanValue(int pan) {
		float panFloat = (float) pan;
		this.panControl.setValue(panFloat /100);
	}

	public float getPanValue() {
		return this.panControl.getValue() * 100;
	}

	public void playClip() {
		this.clip.setFramePosition(0);
		this.clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void stopClip() {
		this.clip.stop();
		this.clip.flush();
	}

}