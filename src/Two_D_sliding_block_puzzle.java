import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	
	private static final long serialVersionUID = 1L;
	
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

	private final static int HEIGH = 4;
	private final static int WIDTH = 4;
	private final static int blockSize = 90;
	private final static int padding = blockSize / 2;
	private final static int size = blockSize * HEIGH + padding * 2;
	private final static int btnBorder = 10;
	
	private static String btnLabel;
	private static mouseListener btnListener;
	
	private static JButton button_1, button_2, button_3, button_4, 
							button_5, button_6, button_7, button_8,
							button_9,button_10,button_11,button_12,
							button_13,button_14,button_15,button_16;
	
	private static JButton[] btnArray;
	
	private static Color btnColor; 
	
	private static JFrame framePuzzle;
	private static JTextField textScore;
	private static JTextField textBestScore;
	
	
	//Main method
	public static void main(String[] args){
		
		// TODO Auto-generated method stub
		new Two_D_sliding_block_puzzle().runObject();
	}
	
	
	//Constructor
	public Two_D_sliding_block_puzzle(){
		
		
	}
	
	private static void setFrame(){
		
		framePuzzle.getContentPane().setBackground(new Color(222, 184, 135));
		framePuzzle.getContentPane().setLayout(null);
		framePuzzle.setTitle(taskName);
		framePuzzle.setSize(size - 10, size + padding * 2);
		framePuzzle.setResizable(false);
		framePuzzle.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		framePuzzle.setLocationRelativeTo(null);;
	}
	
	private static void setBtns(){
		
		//TODO re-factor setBtns()
		
		
		int index = 0;
		
		for(int row = 0; row  < WIDTH; row++){
			
			for(int col = 0; col < HEIGHT; col++){
				
				String name = Integer.toString(index);
				
				btnArray[index] = new JButton(btnLabel);
				btnArray[index].setBackground(btnColor);
				btnArray[index].setName(name);
				btnArray[index].setBounds((padding/2 + btnBorder * col + blockSize * col), (padding + btnBorder * row + blockSize * row), blockSize, blockSize);
						     //.setBounds((padding/2 + btnBorder * 0   + blockSize * 0),   (padding + btnBorder * 0   + blockSize * 0),   blockSize, blockSize);

				btnArray[index].addMouseListener(btnListener);
				
				framePuzzle.getContentPane().add(btnArray[index]);
				index++;
			}
		}
		
		framePuzzle.getContentPane().repaint();
		
		/*
		//First row
		button_1 = new JButton("");
		button_1.setBackground(btnColor);
		button_1.setBounds((padding/2 + btnBorder * 0 + blockSize * 0), (padding + btnBorder * 0 + blockSize * 0), blockSize, blockSize);
		framePuzzle.getContentPane().add(button_1);
		
		button_2 = new JButton("");
		button_2.setBackground(btnColor);
		button_2.setBounds((padding/2 + btnBorder * 1 + blockSize * 1), (padding + btnBorder * 0 + blockSize * 0), blockSize, blockSize);
		framePuzzle.getContentPane().add(button_2);
		
		button_3 = new JButton("");
		button_3.setBackground(btnColor);
		button_3.setBounds((padding/2 + btnBorder * 2 + blockSize * 2), (padding + btnBorder * 0 + blockSize * 0), blockSize, blockSize);
		framePuzzle.getContentPane().add(button_3);
		
		button_4 = new JButton("");
		button_4.setBackground(btnColor);
		button_4.setBounds((padding/2 + btnBorder * 3 + blockSize * 3), (padding + btnBorder * 0 + blockSize * 0), blockSize, blockSize);
		framePuzzle.getContentPane().add(button_4);
		
		//Row #2
		button_5 = new JButton("");
		button_5.setBackground(btnColor);
		button_5.setBounds((padding/2 + btnBorder * 0 + blockSize * 0), (padding + btnBorder * 1 + blockSize * 1) , blockSize, blockSize);
		framePuzzle.getContentPane().add(button_5);
			
		button_6 = new JButton("");
		button_6.setBackground(btnColor);
		button_6.setBounds((padding/2 + btnBorder * 1 + blockSize * 1), (padding + btnBorder * 1 + blockSize * 1), blockSize, blockSize);
		framePuzzle.getContentPane().add(button_6);
		
		button_7 = new JButton("");
		button_7.setBackground(btnColor);
		button_7.setBounds((padding/2 + btnBorder * 2 + blockSize * 2), (padding + btnBorder * 1 + blockSize * 1), blockSize, blockSize);
		framePuzzle.getContentPane().add(button_7);
		
		button_8 = new JButton("");
		button_8.setBackground(btnColor);
		button_8.setBounds((padding/2 + btnBorder * 3 + blockSize * 3), (padding + btnBorder * 1 + blockSize * 1), blockSize,blockSize);
		framePuzzle.getContentPane().add(button_8);
		

		//Row #3
		button_9 = new JButton("");
		button_9.setBackground(btnColor);
		button_9.setBounds((padding/2 + btnBorder * 0 + blockSize * 0), (padding + btnBorder * 2 + blockSize * 2), blockSize, blockSize);
		framePuzzle.getContentPane().add(button_9);
		
		button_10 = new JButton("");
		button_10.setBackground(btnColor);
		button_10.setBounds((padding/2 + btnBorder * 1 + blockSize * 1), (padding + btnBorder * 2 + blockSize * 2), blockSize, blockSize);
		framePuzzle.getContentPane().add(button_10);
		
		button_11 = new JButton("");
		button_11.setBackground(btnColor);
		button_11.setBounds((padding/2 + btnBorder * 2 + blockSize * 2), (padding + btnBorder * 2 + blockSize * 2), blockSize, blockSize);
		framePuzzle.getContentPane().add(button_11);
		
		button_12 = new JButton("");
		button_12.setBackground(btnColor);
		button_12.setBounds((padding/2 + btnBorder * 3 + blockSize * 3), (padding + btnBorder * 2 + blockSize * 2), blockSize, blockSize);
		framePuzzle.getContentPane().add(button_12);
		
		
		//Last row (#4)
		button_13 = new JButton("");
		button_13.setBackground(btnColor);
		button_13.setBounds((padding/2 + btnBorder * 0 + blockSize * 0), (padding + btnBorder * 3 + blockSize * 3), blockSize, blockSize);
		framePuzzle.getContentPane().add(button_13);
		
		button_14 = new JButton("");
		button_14.setBackground(btnColor);
		button_14.setBounds((padding/2 + btnBorder * 1 + blockSize * 1), (padding + btnBorder * 3 + blockSize * 3), blockSize, blockSize);
		framePuzzle.getContentPane().add(button_14);
		
		button_15 = new JButton("");
		button_15.setBackground(btnColor);
		button_15.setBounds((padding/2 + btnBorder * 2 + blockSize * 2), (padding + btnBorder * 3 + blockSize * 3), blockSize, blockSize);
		framePuzzle.getContentPane().add(button_15);
		
		button_16 = new JButton("");
		button_16.setBackground(btnColor);
		button_16.setBounds((padding/2 + btnBorder * 3 + blockSize * 3), (padding + btnBorder * 3 + blockSize * 3), blockSize, blockSize);
		framePuzzle.getContentPane().add(button_16);
		*/
		
	}
	
	private static void setRestartBnt(){
		
		JButton btnRestart = new JButton("Restart the game");
		btnRestart.setBounds(123, 462, 189, 23);
		btnRestart.addMouseListener(new MouseAdapter(){
					
			//TODO MouseAdapter
			//Mouse listener event handler
			public void mousePressed(MouseEvent me) {
			 						 
	 			 
			}		 		
			
		});
		framePuzzle.getContentPane().add(btnRestart);
	}
	
	private static void setTxtFields(){
		
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
		
		// TODO runObject()
		framePuzzle = new JFrame();
		
		btnColor = new Color(255, 240, 245);
		
		btnLabel = "";
		
		btnListener = new mouseListener();
		
		btnArray = new JButton[]{button_1, button_2, button_3, button_4, 
								button_5, button_6, button_7, button_8,
								button_9,button_10,button_11,button_12,
								button_13,button_14,button_15,button_16};
		
		
		setFrame();
		setBtns();
		setRestartBnt();
		setTxtFields();
		setLabels();
		
		framePuzzle.setVisible(true);
	}
	
	private class mouseListener extends MouseAdapter{
		
		//TODO MouseAdapter
		//Mouse listener event handler
		public void mousePressed(MouseEvent me) {
		 		
			JButton button = (JButton) me.getSource();
			String btnName = me.getSource().toString();	//DEBUG							
			String[] btnProperties = btnName.split(",");//DEBUG	
			//DEBUG
			for(String btnPropertie : btnProperties){
				//Show all button properties
				System.out.println(String.format("%s", btnPropertie)); //DEBUG
			}
			
			//JButton button = (JButton) me.getComponent(); 
			//System.out.println(String.format("\nName: %s\tLabel: %s", button.getName(), button.getText())); //DEBUG
		}		
	}
	
	//END
}
