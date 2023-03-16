import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Band {

	public Sounds[] songToPlay;
	Songs songList = new Songs();

	public Band() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		songToPlay = songList.songs[getRandomSong()];
	}

	public void play() {
		for(int i = 0; i < songToPlay.length; i++) {
			songToPlay[i].playClip();
		};
	}

	public void stop() {
		for(int i = 0; i < songToPlay.length; i++) {
			songToPlay[i].stopClip();
		};
	}

	 int getRandomSong() {
		 Random rand = new Random();
		 int randomSong = rand.nextInt(songList.songs.length);
		 return randomSong;
	}
}
