import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Two_D_sliding_block_puzzle extends JFrame implements MainInterface{

	/*
	
	DESCRIPTION:
	
	Implement a 2D sliding block puzzle game where blocks with numbers are combined to add their values.
	The rules are that each turn the player must perform a valid move shifting all tiles in one direction 
	(up, down, left or right). A move is valid when at least one tile can be moved in that direction. 
	When moved against each other tiles with the same number on them combine into one. 
	A new tile with the value of 2 is spawned at the end of each turn if there is an empty spot for it. 
	To win the player must create a tile with the number 2048. The player loses if no valid moves are possible.

	The name comes from the popular open-source implementation of this game mechanic, 2048.

	Requirements:

	"Non-greedy" movement. The tiles that were created by combining other tiles should not be combined again during the same turn (move). 
	That is to say that moving the tile row of[2][2][2][2]
	to the right should result in ......[4][4]
	and not.........[8]
	
	"Move direction priority". If more than one variant of combining is possible, move direction shows one that will take effect. 
	For example, moving the tile row of...[2][2][2]
	to the right should result in......[2][4]
	and not......[4][2]

	Adding a new tile on a blank space. Most of the time new "2" is to be added and occasionally (10% of the time) - "4"
	Check for valid moves. The player shouldn't be able to skip their turn by trying a move that doesn't change the board.
	Win condition.
	Lose condition.
	  
	 */
	
	
	private static String taskName = "2D sliding block puzzle game (2048)";
	private String taskDescription = "Implement a 2D sliding block puzzle game where blocks with numbers are combined to add their values.\n" +
	"The rules are that each turn the player must perform a valid move shifting all tiles in one direction\n"+
	"(up, down, left or right). A move is valid when at least one tile can be moved in that direction.\n"+
	"When moved against each other tiles with the same number on them combine into one.\n"+ 
	"A new tile with the value of 2 is spawned at the end of each turn if there is an empty spot for it.\n"+ 
	"To win the player must create a tile with the number 2048. The player loses if no valid moves are possible.\n"+

	"\nThe name comes from the popular open-source implementation of this game mechanic, 2048.\n"+

	"\nRequirements:\n"+

	"\n\"Non-greedy\" movement. The tiles that were created by combining other tiles should not be combined again during the same turn (move).\n"+ 
	"That is to say that moving the tile row of[2][2][2][2]\n"+
	"to the right should result in ......[4][4]\n"+
	"and not.........[8]\n"+
	
	"\n\"Move direction priority\". If more than one variant of combining is possible, move direction shows one that will take effect.\n"+
	"For example, moving the tile row of...[2][2][2]\n"+
	"to the right should result in......[2][4]\n"+
	"and not......[4][2]\n"+

	"\nAdding a new tile on a blank space. Most of the time new \"2\" is to be added and occasionally (10% of the time) - \"4\"\n"+
	"\nCheck for valid moves. The player shouldn't be able to skip their turn by trying a move that doesn't change the board.";
	private String taskLink = "<html><a href=\"https://rosettacode.org/wiki/2048\">Source</a></html>";
	private static String result = "N/A";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Two_D_sliding_block_puzzle();
		
	}

	private final static int HEIGH = 4;
	private final int WIDTH = 4;
	private final static int blockSize = 90;
	private final static int padding = blockSize / 2;
	private final static int size = blockSize * HEIGH + padding * 2;
	
	private static JFrame framePuzzle;
	private static JTextField textScore;
	private static JTextField textBestScore;
	
	public Two_D_sliding_block_puzzle(){
		
		framePuzzle = new JFrame();

		setFrame();
		createButtons();
		setTextFields();
		setLabels();
		
		framePuzzle.setVisible(true);
	}
	
	
	private static void setFrame(){
		
		framePuzzle.getContentPane().setBackground(new Color(222, 184, 135));
		framePuzzle.getContentPane().setLayout(null);
		framePuzzle.setTitle(taskName);
		framePuzzle.setSize(size - 10, size + padding * 2);
		framePuzzle.setResizable(false);
		framePuzzle.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
	}
	
	private static void createButtons(){
		
		JButton button_4 = new JButton("");
		button_4.setBackground(new Color(255, 240, 245));
		button_4.setBounds(322, 45, blockSize, blockSize);
		framePuzzle.getContentPane().add(button_4);
		
		JButton button_2 = new JButton("");
		button_2.setBackground(new Color(255, 240, 245));
		button_2.setBounds(122, 45, 90, 90);
		framePuzzle.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setBackground(new Color(255, 240, 245));
		button_3.setBounds(222, 45, 90, 90);
		framePuzzle.getContentPane().add(button_3);
		
		JButton button_1 = new JButton("");
		button_1.setBackground(new Color(255, 240, 245));
		button_1.setBounds(padding/2, padding, 90, 90);
		framePuzzle.getContentPane().add(button_1);
		
		JButton button_5 = new JButton("");
		button_5.setBackground(new Color(255, 240, 245));
		button_5.setBounds(22, 146, 90, 90);
		framePuzzle.getContentPane().add(button_5);
		
		JButton button_11 = new JButton("");
		button_11.setBackground(new Color(255, 240, 245));
		button_11.setBounds(222, 247, 90, 90);
		framePuzzle.getContentPane().add(button_11);
		
		JButton button_7 = new JButton("");
		button_7.setBackground(new Color(255, 240, 245));
		button_7.setBounds(222, 146, 90, 90);
		framePuzzle.getContentPane().add(button_7);
		
		JButton button_6 = new JButton("");
		button_6.setBackground(new Color(255, 240, 245));
		button_6.setBounds(122, 146, 90, 90);
		framePuzzle.getContentPane().add(button_6);
		
		JButton button_8 = new JButton("");
		button_8.setBackground(new Color(255, 240, 245));
		button_8.setBounds(322, 146, 90, 90);
		framePuzzle.getContentPane().add(button_8);
		
		JButton button_14 = new JButton("");
		button_14.setBackground(new Color(255, 240, 245));
		button_14.setBounds(122, 348, 90, 90);
		framePuzzle.getContentPane().add(button_14);
		
		JButton button_9 = new JButton("");
		button_9.setBackground(new Color(255, 240, 245));
		button_9.setBounds(22, 247, 90, 90);
		framePuzzle.getContentPane().add(button_9);
		
		JButton button_10 = new JButton("");
		button_10.setBackground(new Color(255, 240, 245));
		button_10.setBounds(122, 247, 90, 90);
		framePuzzle.getContentPane().add(button_10);
		
		JButton button_15 = new JButton("");
		button_15.setBackground(new Color(255, 240, 245));
		button_15.setBounds(222, 348, 90, 90);
		framePuzzle.getContentPane().add(button_15);
		
		JButton button_12 = new JButton("");
		button_12.setBackground(new Color(255, 240, 245));
		button_12.setBounds(322, 247, 90, 90);
		framePuzzle.getContentPane().add(button_12);
		
		JButton button_13 = new JButton("");
		button_13.setBackground(new Color(255, 240, 245));
		button_13.setBounds(22, 348, 90, 90);
		framePuzzle.getContentPane().add(button_13);
		
		JButton button_16 = new JButton("");
		button_16.setBackground(new Color(255, 240, 245));
		button_16.setBounds(322, 348, 90, 90);
		framePuzzle.getContentPane().add(button_16);
		
		JButton btnRestart = new JButton("Restart the game");
		btnRestart.setBounds(123, 462, 189, 23);
		framePuzzle.getContentPane().add(btnRestart);
	}
	
	private static void setTextFields(){
		
		textScore = new JTextField();
		textScore.setEditable(false);
		textScore.setBounds(63, 8, 86, 20);
		framePuzzle.getContentPane().add(textScore);
		textScore.setColumns(10);
		
		textBestScore = new JTextField();
		textBestScore.setEditable(false);
		textBestScore.setColumns(10);
		textBestScore.setBounds(299, 8, 86, 20);
		framePuzzle.getContentPane().add(textBestScore);
	}
	
	
	private static void setLabels(){
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setBounds(22, 11, 46, 14);
		framePuzzle.getContentPane().add(lblScore);
		
		JLabel lblBestScore = new JLabel("Best score:");
		lblBestScore.setBounds(224, 11, 65, 14);
		framePuzzle.getContentPane().add(lblBestScore);
	}
	
	@Override
	public String getTaskName() {
		return taskName;
	}

	@Override
	public String getTaskDescription() {
		return taskDescription;
	}

	@Override
	public String getTaskLink() {
		return taskLink;
	}

	@Override
	public String getTaskResult() {
		return result;
	}

	@Override
	public void setResult(String newResult) {
		// There id nothing to implement		
	}

	@Override
	public void runObject() {
		// TODO Auto-generated method stub
		
	}
}
