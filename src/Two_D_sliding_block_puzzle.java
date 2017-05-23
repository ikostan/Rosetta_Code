import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Two_D_sliding_block_puzzle extends JFrame implements KeyListener, MainInterface{

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
	
	private static Color btnColor, frameColor, txtFieldColor; 
	
	private static JFrame framePuzzle;
	private static JTextField textScore;
	private static JTextField textBestScore;
	
	
	//Main method
	public static void main(String[] args){
		
		// TODO Main function
		new Two_D_sliding_block_puzzle().runObject();
	}
	
	
	//Constructor
	public Two_D_sliding_block_puzzle(){
				
	}
	
	//Setup all components inside the frame 
	private static void setFrame(){
		
		framePuzzle.getContentPane().setBackground(frameColor);
		framePuzzle.getContentPane().setLayout(null);
		framePuzzle.setTitle(taskName);
		framePuzzle.setSize(size - 10, size + padding * 2);
		framePuzzle.setResizable(false);
		framePuzzle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePuzzle.setLocationRelativeTo(null);;
	}
	
	//Create buttons
	private static void setBtns(){
		
		int index = 0;
		
		for(int row = 0; row  < HEIGH; row++){
			
			for(int col = 0; col < WIDTH; col++){
				
				String name = Integer.toString(index);
				
				btnArray[index] = new JButton(btnLabel);
				btnArray[index].setBackground(btnColor);
				btnArray[index].setName(name);
				btnArray[index].setBounds(
						(padding/2 + btnBorder * col + blockSize * col), 
						(padding + btnBorder * row + blockSize * row), 
						blockSize, 
						blockSize);			
				//System.out.println(String.format("(col): %d\tX: %3d\t(row):%d\tY %3d", col, (padding/2 + btnBorder * col + blockSize * col), row, (padding + btnBorder * row + blockSize * row))); //DEBUG
				
				btnArray[index].addMouseListener(btnListener);				
				framePuzzle.getContentPane().add(btnArray[index]);
				index++;
			}
		}
		
		framePuzzle.getContentPane().revalidate();
		framePuzzle.getContentPane().repaint();
		
	}
	
	//Create restart button
	private static void setRestartBnt(){
		
		JButton btnRestart = new JButton("Restart the game");
		btnRestart.setBounds(123, 462, 189, 23);
		btnRestart.addMouseListener(new MouseAdapter(){			
			//Mouse listener event handler
			public void mousePressed(MouseEvent me) {
				//TODO MouseAdapter for setRestartBnt
				 
	 			 
			}		 		
			
		});
		framePuzzle.getContentPane().add(btnRestart);
	}
	
	//Create all text fields
	private static void setTxtFields(){
		
		//Score text field
		textScore = new JTextField();
		textScore.setEditable(false);
		textScore.setColumns(10);
		textScore.setBounds(63, 8, 86, 20);
		textScore.setBackground(txtFieldColor);
		framePuzzle.getContentPane().add(textScore);
		
		//Best score text field
		textBestScore = new JTextField();
		textBestScore.setEditable(false);
		textBestScore.setColumns(10);
		textBestScore.setBounds(299, 8, 86, 20);
		textBestScore.setBackground(txtFieldColor);
		framePuzzle.getContentPane().add(textBestScore);
	}
	
	//Create all labels
	private static void setLabels(){
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setBounds(22, 11, 46, 14);
		framePuzzle.getContentPane().add(lblScore);
		
		JLabel lblBestScore = new JLabel("Best score:");
		lblBestScore.setBounds(224, 11, 65, 14);
		framePuzzle.getContentPane().add(lblBestScore);
	}
	
	@Override
	public void runObject() {
		
		// TODO runObject()
		framePuzzle = new JFrame();
		
		btnColor = SystemColor.textHighlight;
		frameColor = SystemColor.controlHighlight;
		txtFieldColor = Color.lightGray;
		
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
	
	//Keyboard listener methods
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	//Inner Class
	private class mouseListener extends MouseAdapter{	
		//Mouse listener event handler
		public void mousePressed(MouseEvent me) {
		 	
			//TODO MouseAdapter for mouseListener		
			JButton button = (JButton) me.getSource();
				
			/*
			//DEBUG
			String btnName = me.getSource().toString();	//DEBUG							
			String[] btnProperties = btnName.split(",");//DEBUG	
			for(String btnPropertie : btnProperties){
				//Show all button properties
				System.out.println(String.format("%s", btnPropertie)); //DEBUG
			}
			*/
			
			System.out.println(String.format("\nName: %2s\tLabel: %2s", button.getName(), button.getText())); //DEBUG
		}		
	}

	//END
}
