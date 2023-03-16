import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Window {

	private static Window instance = null;

	JFrame window = new JFrame();
	JPanel gameScene = new JPanel();
	JPanel mainMenuScene = new JPanel();
	JPanel finishedGameScene = new JPanel();
	JPanel attemptsPanel = new JPanel();

	//GAME SCENE CONTENTS
	JLabel targetSound = new JLabel();
	JLabel answer = new JLabel();
	JLabel attempts = new JLabel("Attempts: 0");
	JLabel challengeNum = new JLabel();
	JButton returnToMenu = new JButton("Return to Menu");
	JButton playSound = new JButton("Play Song");
	JButton stopSound = new JButton("Stop Song");
	JButton checkAnswer = new JButton("Submit Guess");
	JButton nextQuestion = new JButton("Next Question");

	//PANPOT - Part of Game Scene
	PanPot panPot = new PanPot();
	JLabel panPotLabel = panPot.label;

	//FINISHED GAME SCENE CONTENTS
	JLabel score = new JLabel();

	//MAIN MENU SCENE CONTENTS
	JLabel mainMenuTitle = new JLabel("Welcome to StereoHead. Headphones advised for best Stereo Seperation.");
	JButton playGameRound = new JButton("Play a round");

	///////////////////////////////////////////////////////
	///CONSTRUCTOR
	public Window() {

		window.setTitle("StereoHead");
		window.setSize(900, 300);
		window.setLocation(2000, 100);
		window.setResizable(false);

		//ACTION LISTENERS_____
		//PLAY BUTTON
		playSound.addActionListener(e -> {
			System.out.println("TEST");
			System.out.println("attempts for this chall: " + getChallenge().getAttempts());
			getChallenge().playBand();
		});
		//STOP BUTTON
		stopSound.addActionListener(e -> {
			if(getChallenge() != null) {
				getChallenge().stopBand();
			}
		});
		//SUBMIT BUTTON
		checkAnswer.addActionListener(e -> {
			getChallenge().incrementAttempts();
			getChallenge().judgeAnswer();
		});
		//RETURN TO MENU BUTTON
		returnToMenu.addActionListener(e -> {
			if(getChallenge() != null) {
				getChallenge().stopBand();
				getChallenge().theBand = null;
			}
			displayMenuScene();
		});
		nextQuestion.addActionListener(e -> {
			getGameRound().nextButtonLogic();
		});

		//MAIN MENU SCENE
		mainMenuScene.add(mainMenuTitle);
		mainMenuScene.add(playGameRound);

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	void resetGameScene(int challengeNum, int numOfChallenges) {
		answer.setText("Select your pan guess via the slider.");
		attempts.setText("Attempts: 0");
		panPot.reset();

		if (challengeNum == numOfChallenges) {
			nextQuestion.setText("Finish Game");
		} else {
			nextQuestion.setText("Next Question");
		}

	}

	void displayGameScene() {
		stopSound.setEnabled(false);
		//12Box Grid Layout
		gameScene.setLayout(new GridLayout(4, 3, 10, 10));
		gameScene.add(challengeNum);
		gameScene.add(targetSound);
		gameScene.add(attempts);
		//----------------------
		gameScene.add(playSound);
		gameScene.add(answer);
		gameScene.add(checkAnswer);
		//----------------------
		gameScene.add(stopSound);
		gameScene.add(panPot); 
		gameScene.add(nextQuestion);
		//----------------------
		gameScene.add(new JLabel()); //Blank Space
		gameScene.add(panPotLabel);
		gameScene.add(returnToMenu);
		//----------------------
		centreItem(challengeNum);
		centreItem(attempts);
		centreItem(targetSound);
		centreItem(answer);
		centreItem(panPotLabel);
		window.setContentPane(gameScene);
		window.setVisible(true);
	}	

	void displayFinishedGameScene(int numOfChallenges) {
		System.out.println("Displaying Score Page / Finished Game Scene");

		finishedGameScene.setLayout(new GridLayout(3, 1, 10, 10));
		finishedGameScene.add(score);
		attemptsPanel.setLayout(new GridLayout(numOfChallenges, 1, 10, 10));
		finishedGameScene.add(attemptsPanel);
		finishedGameScene.add(returnToMenu);
		window.setContentPane(finishedGameScene);

		window.setVisible(true);

	}

	void showScore(int inputScore) {
		score.setText("YOU SCORED: " + inputScore);
	} 

	void showAttempts(int[] attemptsArray) {
		attemptsPanel.removeAll();
		for(int i = 0; i < attemptsArray.length; i++) {
			String label = String.valueOf(attemptsArray[i]);
			attemptsPanel.add(new JLabel((i + 1) + ") Attempts: " + label));
		}
	}


	void displayMenuScene() {
		System.out.println("Displaying Menu");
		window.setContentPane(mainMenuScene);
		gameScene.removeAll();
		window.setVisible(true);
	}

	void centreItem(JLabel item) {
		item.setHorizontalAlignment(SwingConstants.CENTER);
		item.setVerticalAlignment(SwingConstants.CENTER);

	}

	//SINGLETON 
	public static Window getInstance() {
		if (instance == null) {
			instance = new Window();
		}
		return instance;
	}

	public GameRound getGameRound() {
		return GameRound.getCurrentGameRound();
	}

	public Challenge getChallenge() {
		return GameRound.getCurrentChallenge();
	}

}
