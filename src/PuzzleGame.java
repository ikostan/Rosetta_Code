import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class PuzzleGame extends JFrame implements MainInterface {

	/*
	 * 15 Puzzle Game
	 * 
	 * We fist define a generic package Generic_Puzzle. Upon instantiation, it
	 * can take any number of rows, any number of columns for a rows*columns-1
	 * game. Instead of plain numbers, the tiles on the board can have arbitrary
	 * names (but they should all be of the same length). The package user can
	 * request the name for the tile at a certain (row,column)-point, and the
	 * set of possible moves. The user can move the empty space up, down, left
	 * and right (if possible). If the user makes the attempt to perform an
	 * impossible move, a Constraint_Error is raised.
	 * 
	 * Answer:
	 * 
	 * SOURCE: https://rosettacode.org/wiki/15_Puzzle_Game
	 */

	private static final long serialVersionUID = 1L;

	private String taskName = "Implement the Fifteen Puzzle Game.";
	private String taskDescription = "We fist define a generic package Generic_Puzzle. Upon instantiation,"
			+ "it can take any number of rows, any number of columns for a rows*columns-1 game."
			+ "Instead of plain numbers, the tiles on the board can have arbitrary names"
			+ "(but they should all be of the same length). The package user can request the name"
			+ "for the tile at a certain (row,column)-point, and the set of possible moves."
			+ "The user can move the empty space up, down, left and right (if possible)."
			+ "If the user makes the attempt to perform an impossible move, a Constraint_Error is raised. ";
	private String taskLink = "<html><a href=\"https://rosettacode.org/wiki/15_Puzzle_Game\">Source</a></html>";
	private static String result = "N/A";

	static JFrame puzzle15;
	
	private final static int totalWidth = 440;
	private static final int ROWS = 4;
	private static final int COLS = 4;
	private static final int padding = 40;
	private static int slideSize = (totalWidth - padding * 2) / ROWS;
	private static int numTiles = ROWS * COLS;

	private static int x0 = padding;
	private static int x1 = padding + slideSize;
	private static int x2 = padding + slideSize * 2;
	private static int x3 = padding + slideSize * 3;
	
	private static int y0 = padding;
	private static int y1 = padding + slideSize;
	private static int y2 = padding + slideSize * 2;
	private static int y3 = padding + slideSize * 3;

	private static Random rand;

	private static int[][][] locations;
	private static int[][][] initLocations;
	private static JButton[] buttonsArray;
	
	private JButton button_0, button_1, button_2, button_3, 
					button_4, button_5, button_6, button_7, 
					button_8, button_9, button_10, button_11, 
					button_12, button_13, button_14, button_15;	
		
	
	// Main method
	public static void main(String[] args) {
	
		setLocationsArr();
		locations = randTiles(locations);
		PuzzleGame puzzle = new PuzzleGame();
		puzzle.runObject();
	}

	// Constructor
	public PuzzleGame() {
		
	}

	//Swap buttons
	private static void swapBtn(JButton button){
		
		puzzle15.getContentPane().remove(button);
		puzzle15.getContentPane().remove(buttonsArray[buttonsArray .length - 1]);
		puzzle15.getContentPane().revalidate();
		puzzle15.getContentPane().repaint();
		
		int tempX = button.getX();
		int tempY = button.getY();
		
		button.setLocation(buttonsArray[buttonsArray .length - 1].getX(), buttonsArray[buttonsArray .length - 1].getY());
		buttonsArray[buttonsArray .length - 1].setLocation(tempX, tempY);
		
		puzzle15.getContentPane().add(button);
		puzzle15.getContentPane().revalidate();
		puzzle15.getContentPane().repaint();
	}
	
	//Swap between buttons
	private static void swapTiles(JButton button){
		
		// slidesLocation | button_15 | buttonsArray | padding | slideSize	
		//DEBUG ONLY
		System.out.println(String.format(""
				+ "Empty x: %3d\tButton x:%3d\nEmpty y: %3d\tButton y:%3d\n", 
				buttonsArray[buttonsArray .length - 1].getX(), 
				button.getX(),
				buttonsArray[buttonsArray .length - 1].getY(), 
				button.getY()));
		
		
		if((buttonsArray[buttonsArray .length - 1].getX() == button.getX()) && 
				(buttonsArray[buttonsArray .length - 1].getY() == button.getY() + slideSize)){
			
			swapBtn(button);			
		}
		else if((buttonsArray[buttonsArray .length - 1].getY() == button.getY()) &&
				(buttonsArray[buttonsArray .length - 1].getX() == button.getX() + slideSize)){
			
			swapBtn(button);
		}
		else if((buttonsArray[buttonsArray .length - 1].getY() == button.getY()) && 
				(buttonsArray[buttonsArray .length - 1].getX() == button.getX() - slideSize)){
			
			swapBtn(button);
		}
		else if((buttonsArray[buttonsArray .length - 1].getX() == button.getX()) && 
				(buttonsArray[buttonsArray .length - 1].getY() == button.getY() - slideSize)){
			
			swapBtn(button);
		}
		
		//swapTiles
	 } 
	
	//Create initial locations array
	private static void setLocationsArr(){
		
		initLocations = new int[][][] {
			// column 0	  //column 1  //column 2  //column 3
			{ { x0, y0 }, { x1, y0 }, { x2, y0 }, { x3, y0 } }, //row 0
			{ { x0, y1 }, { x1, y1 }, { x2, y1 }, { x3, y1 } }, //row 1
			{ { x0, y2 }, { x1, y2 }, { x2, y2 }, { x3, y2 } }, //row 2
			{ { x0, y3 }, { x1, y3 }, { x2, y3 }, { x3, y3 } }  //row 3
		};
		
		locations = new int[][][] {
			// column 0	  //column 1  //column 2  //column 3
			{ { x0, y0 }, { x1, y0 }, { x2, y0 }, { x3, y0 } }, //row 0
			{ { x0, y1 }, { x1, y1 }, { x2, y1 }, { x3, y1 } }, //row 1
			{ { x0, y2 }, { x1, y2 }, { x2, y2 }, { x3, y2 } }, //row 2
			{ { x0, y3 }, { x1, y3 }, { x2, y3 }, { x3, y3 } }  //row 3
		};
	}
	
	//Check if user wins
	private static boolean isWon(){	
		
		boolean win = true;
		int i = 0;
		
		for(int row = 0; row < ROWS; row++){
			
			for(int col = 0; col < COLS; col++){
					
				if(!(buttonsArray[i].getX() == initLocations[row][col][0] && buttonsArray[i].getY() == initLocations[row][col][1])){
					win = false;
					break;
				}
				i++;
			}
		}	
		
		if(win == true){
			JOptionPane.showMessageDialog(null,
				    "Congratulations, you won :-)",
				    "Congratulations",
				    JOptionPane.INFORMATION_MESSAGE);
		}
		
		return win;
	}
	
	//Swapping array values
	private static int[][][] randTiles(int[][][] array){

		int[] temporaryArr = new int[2];
		
		int row, col;
		rand = new Random();

		for(int i = 0; i < 37; i++){
				
			row = rand.nextInt(4);
			col = rand.nextInt(4);
			
			if(!(row == 3 && col == 3)){
					
				//Swapping array values
				temporaryArr = array[row][col];
				
				if(row > 0){
					if(col > 0){
						array[row][col] = array[row - 1][col - 1];
						array[row - 1][col - 1] = temporaryArr;	
					} 
					else{
						array[row][col] = array[row-1][col + 1];
						array[row-1][col + 1] = temporaryArr;	
					}
				}
				else{
					if(col < 2){
						array[row][col] = array[row + 1][col + 1];
						array[row + 1][col + 1] = temporaryArr;	
					} 
					else{
						array[row][col] = array[row + 1][col - 1];
						array[row + 1][col - 1] = temporaryArr;	
					}
				}								
			}
		}
	
		return array;
		//randTiles
	}
	
	// Creates a new object
	public void runObject() {

        puzzle15 = new JFrame();
		setLocationsArr();
		locations = randTiles(locations);

		buttonsArray = new JButton[] {button_0, button_1, button_2, button_3, 
									  button_4, button_5, button_6, button_7, 
									  button_8, button_9, button_10, button_11, 
									  button_12, button_13, button_14, button_15};

		puzzle15.setTitle("15 Puzzle Game");
		puzzle15.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		puzzle15.getContentPane().setLayout(null);
		puzzle15.setAlwaysOnTop(false);
		puzzle15.setSize(totalWidth, totalWidth + (padding * 2));
		puzzle15.setResizable(false);

		setButtons();

		puzzle15.setLocationRelativeTo(null);
		puzzle15.setVisible(true);
	}

	// Set button location
	private static void setButtonBounds(int row, int col, JButton button, int[][][] locations) {
									// X 					//Y 		//Height 	//Width
		button.setBounds(locations[row][col][0], locations[row][col][1], slideSize, slideSize);
	}
	
	// Create tiles/buttons
	private static void setButtons() {

		String label = "";
		int i = 0;

		for (int row = 0; row < ROWS; row++) {

			for (int col = 0; col < COLS; col++) {

				if (i < numTiles - 1) {

					label = String.format("%d", (i + 1));

					buttonsArray[i] = new JButton(label);
					buttonsArray[i].setForeground(Color.RED);
					buttonsArray[i].setFont(new Font("Times New Roman", Font.BOLD, 40));
					buttonsArray[i].setBackground(SystemColor.activeCaption);
					setButtonBounds(row, col, buttonsArray[i], locations);
					
					buttonsArray[i].addMouseListener(new MouseAdapter(){
													
							//Mouse listener event handler
							 public void mousePressed(MouseEvent me) {
							 						 
								 JButton button = (JButton)me.getComponent();		 
								 swapTiles(button);
								 isWon();		 			 
							 }		 		 											
					});
					
					puzzle15.getContentPane().add(buttonsArray[i]);
				} 
				else {
					
					//Last (empty) slide/tile
					label = String.format("%d", (i + 1));
					buttonsArray[i] = new JButton(label);
					buttonsArray[i].setBounds((padding + slideSize * 3), (padding + slideSize * 3), slideSize, slideSize);
				}

				i++; // Total index
			}
		}

		
		// Restart button
		JButton btnRestart = new JButton("Restart the game");
		btnRestart.addActionListener(new ActionListener() {
			// Restart the game event handler
			public void actionPerformed(ActionEvent arg0) {
			
				if(isWon()){
					//Restart the game
					restart();
				}
				else{
					
					//Custom button text
					Object[] options = {"Yes",
					                    "No"};
					
					int n = JOptionPane.showOptionDialog(null,
					    "Current game still inprogress.\n"
					    + "Are you sure you want restart the game?",
					    "A Silly Question",
					    JOptionPane.YES_NO_OPTION,
					    JOptionPane.QUESTION_MESSAGE,
					    null,
					    options,
					    options[1]);
					
					System.out.println("Clicked: " + n);
					
					if(n == 0){
						
						//Restart the game
						restart();
					}
				}				
			}
		});
		
		btnRestart.setBounds(
				//X
				(padding + slideSize), 
				//Y
				(padding + (padding/2) + (slideSize * ROWS)),
				//Width
				(slideSize * (COLS / 2)),
				//Height
				padding);
		puzzle15.getContentPane().add(btnRestart);
	}
	
	//Restart the game
	private static void restart(){
		
		for(JButton button : buttonsArray){
			
			puzzle15.getContentPane().remove(button);
		}
		

		locations = randTiles(locations);
		setButtons();
		puzzle15.getContentPane().revalidate();
		puzzle15.getContentPane().repaint();
	}
		
	//Rearrange all buttons to win-win position
	private static void testMethod(){
		
		int i = 0;		
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				if (i < numTiles - 1) {
					setButtonBounds(row, col, buttonsArray[i], initLocations);
					puzzle15.getContentPane().add(buttonsArray[i]);
				} 
				else {
					
					//Last (empty) slide/tile
					buttonsArray[i].setBounds((padding + slideSize * 3), (padding + slideSize * 3), slideSize, slideSize);
				}
				i++; // Total index
			}
		}
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
		// There is nothing to implement
	}
	
	// END
}
