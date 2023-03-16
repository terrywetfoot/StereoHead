import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;

public class GameRound {

	Window window = Window.getInstance();
	private static GameRound currentRound;


	private int challengeNum;
	private static Challenge currentChallenge;
	private int attemptSum;
	private int numOfChallenges;
	private int score;
	private int difficulty;
	int[] attemptsArray;

	public static Challenge getCurrentChallenge() {
		return currentChallenge;
	}

	public static GameRound getCurrentGameRound() {
		return currentRound;
	}

	void incrementChallenge(int difficultyLevel) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		//		if(challengeNum > 0) {
		//			attemptsArray[challengeNum -1] = currentChallenge.getAttempts();
		//		}
		killChallenge();
		currentChallenge = new Challenge(difficultyLevel);
		challengeNum ++;
		window.challengeNum.setText("Challenge Number: [" + String.valueOf(challengeNum) + " of " + numOfChallenges + "]");
		window.resetGameScene(challengeNum, numOfChallenges);
	}

	void killChallenge() {
		if(currentChallenge != null ) {
			currentChallenge.resetAttempts();
			currentChallenge.stopBand();
			currentChallenge.theBand = null;
			currentChallenge = null;
		}
	}


	public void nextButtonLogic() {
		attemptSum += currentChallenge.getAttempts();
		if (challengeNum <= numOfChallenges) {
			attemptsArray[challengeNum - 1] = currentChallenge.getAttempts();
		}
		if (challengeNum < numOfChallenges) {
			try {
				incrementChallenge(difficulty);
			} catch (UnsupportedAudioFileException e1) {
				// Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// Auto-generated catch block
				e1.printStackTrace();
			} catch (LineUnavailableException e1) {
				//  Auto-generated catch block
				e1.printStackTrace();
			}

		} else {
			//FINISH ROUND
			score = numOfChallenges / (attemptSum * 1000) ;//Placeholder score system
			window.showScore(score);
			window.showAttempts(attemptsArray);
			window.displayFinishedGameScene(numOfChallenges);
			killChallenge();
		}

	} 

	public GameRound(int difficultyLevel) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		currentRound = this;
		difficulty = difficultyLevel;
		System.out.println("Starting Round___");
		window.displayGameScene();
		numOfChallenges = 4; //The number of challenges in a round, currently not interacted with. 
		attemptsArray = new int[numOfChallenges]; //Initialising the attemptsArray to the length of the round.
		incrementChallenge(1);


	}


}
