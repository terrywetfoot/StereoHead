import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Challenge {

	Window window = Window.getInstance();


	public Band theBand;
	public static Sounds targetMember;
	private int panMargin;
	private int attempts;

	public Challenge(int difficultyLevel) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		System.out.println("Creating new Challenge___");
		window.nextQuestion.setEnabled(false);
		window.checkAnswer.setEnabled(false);
		theBand = new Band();
		panRandom(theBand.songToPlay);
		targetMember = setTargetRandom(theBand.songToPlay);
		panMargin = getPanMargin(difficultyLevel);
		window.targetSound.setText("Your Target is: " + targetMember.name);
	} //END OF CONSTRUCTOR ////////////////////////////

	public void stopBand() {
		if(theBand != null) {
			theBand.stop();
			window.playSound.setEnabled(true);
			window.stopSound.setEnabled(false);
		}

	}

	public void playBand() {
		if(theBand != null) {
			theBand.play();
			window.playSound.setEnabled(false);
			window.stopSound.setEnabled(true);
			window.checkAnswer.setEnabled(true);
		}
	}

	public int getAttempts() {
		return this.attempts;
	}

	public void resetAttempts() {
		this.attempts = 0;
	}

	public void incrementAttempts() {
		this.attempts ++;
		window.attempts.setText("Attempts: " + String.valueOf(this.attempts));
	}

	public void judgeAnswer() {
		int val = window.panPot.getValue();
		int tag = (int) targetMember.getPanValue();
		System.out.println("Target is between: " + (tag - panMargin) + " (" + tag + ") " + (tag + panMargin));
		if(val > tag - panMargin && val < tag + panMargin) {
			//IF CORRECT
			window.answer.setText("CORRECT! It was: " + targetMember.getPanValue() );
			window.checkAnswer.setEnabled(false);
			window.nextQuestion.setEnabled(true);
		} else {
			//IF WRONG
			window.answer.setText("Not quite, try again.");
		}
	}

	//Pans the band across the Stereo Field
	public void panRandom(Sounds[] sounds) {
		//i is 2 to prevent panning of bass/drums
		for (int i = 2; i < sounds.length; i++) {
			int randomPan = (int) (Math.random() * 200 - 100);
			System.out.println("Random Pan: " + sounds[i].name + " " + randomPan);
			sounds[i].setPanValue(randomPan);
		}
	}

	//Selects a random instrument (not Bass or Drums) Which is to be our target
	Sounds setTargetRandom(Sounds[] sounds) {
		int randomSelect = (int) (Math.random() * 5 + 2);
		System.out.println("Random Select: " + sounds[randomSelect].name);
		return sounds[randomSelect];
	}

	//Half implemented Difficulty Level for scaling. Currently only ever level1 
	public int getPanMargin(int difficultyLevel) {

		int level1 = 16;
		int level2 = 10;
		int level3 = 4;
		int level4 = 2;

		switch(difficultyLevel) {
		case 4: 
			return level4;
		case 3: 
			return level3;
		case 2: 
			return level2;
		default: 
			return level1;
		}

	}

}
