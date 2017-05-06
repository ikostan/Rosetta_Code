import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
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

	static JFrame main;
	
	private final static int totalWidth = 440;
	private static final int ROWS = 4;
	private static final int COLS = 4;
	private static final int padding = 40;
	private static int slideSize = (totalWidth - padding * 2) / ROWS;
	private int numTiles = ROWS * COLS;

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

	//Swap between buttons
	private static void swapTiles(int x, int y, String label){
		
		// slidesLocation | button_15 | buttonsArray | padding | slideSize
		JButton temporary = new JButton();
		
		//TODO swap tiles
		for(int row = 0; row < ROWS; row++){
			 	
			for(int col = 0; col < COLS; col++){
				
				if(locations[row][col][0] == x && locations[row][col][1] == y){
					
					int tempX = locations[row][col][0];
					int tempY = locations[row][col][1];
					
					locations[row][col][0] = buttonsArray[buttonsArray.length - 1].getX();
					locations[row][col][1] = buttonsArray[buttonsArray.length - 1].getY();

					
					
					buttonsArray[buttonsArray.length - 1].setBounds(tempX, tempY, slideSize, slideSize);
					//System.out.println(String.format("\nlabel: %s == button: %s \n", label, slidesLocation[row][col].getText()));
					
				}				
			}
		 }
		
		//getSlidesLocation();						
		
		//TODO
		/*
		if(isWon()){
			//User wins
			JOptionPane.showMessageDialog(null,
				    "Congratulations, you won :-)",
				    "Congratilations",
				    JOptionPane.INFORMATION_MESSAGE);
		}
		*/							
	 } 
	
	//Create initial locations array
	private static void setLocationsArr(){
		
		locations = new int[][][] {
			// column 0	  //column 1  //column 2  //column 3
			{ { x0, y0 }, { x1, y0 }, { x2, y0 }, { x3, y0 } }, //row 0
			{ { x0, y1 }, { x1, y1 }, { x2, y1 }, { x3, y1 } }, //row 1
			{ { x0, y2 }, { x1, y2 }, { x2, y2 }, { x3, y2 } }, //row 2
			{ { x0, y3 }, { x1, y3 }, { x2, y3 }, { x3, y3 } }  //row 3
		};
	}
	
	//Check if user wins
	/*
	private static boolean isWon(){	
		
		//TODO is Won
		
		if(Arrays.deepEquals()){
			return true;
		}
		else{
			return false;
		}
		
	}
	*/
	
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
	
	//Test is value exist in array
	private static JButton arrayContains(String value){
		
		JButton button = null;
		
		for(int i = 0; i< buttonsArray.length; i++){			
			if(buttonsArray[i].getText() == value){				
				button =  buttonsArray[i];
			}
		}
		
		return button;		
	}
	
	// Creates a new object
	public void runObject() {

        main = new JFrame();
		setLocationsArr();
		locations = randTiles(locations);

		buttonsArray = new JButton[] {button_0, button_1, button_2, button_3, 
									  button_4, button_5, button_6, button_7, 
									  button_8, button_9, button_10, button_11, 
									  button_12, button_13, button_14, button_15};

		main.setTitle("15 Puzzle Game");
		main.setDefaultCloseOperation(main.HIDE_ON_CLOSE);
		main.getContentPane().setLayout(null);
		main.setAlwaysOnTop(false);
		main.setSize(totalWidth, totalWidth + (padding * 2));
		main.setResizable(false);

		setButtons();

		main.setLocationRelativeTo(null);
		main.setVisible(true);
	}

	// Set button location
	private void setButtonBounds(int row, int col, JButton button, int[][][] locations) {
									// X 					//Y 		//Height 	//Width
		button.setBounds(locations[row][col][0], locations[row][col][1], slideSize, slideSize);
	}

	
	// Refresh tiles/buttons
	private void refreshButtons() {

		//TODO refresh Buttons
		int i = 0;

		for (int row = 0; row < ROWS; row++) {

			for (int col = 0; col < COLS; col++) {

				setButtonBounds(row, col, buttonsArray[i], locations);						
				main.getContentPane().add(buttonsArray[i]);		
				i++; // Total index
			}
		}
	}
	
	
	// Create tiles/buttons
	private void setButtons() {

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
					buttonsArray[i].addMouseListener(new MouseListener());
					main.getContentPane().add(buttonsArray[i]);
					//main.getContentPane().add(buttonsArray[i]);
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
			
				//TODO Restart button

				for(JButton button : buttonsArray){
					
					main.getContentPane().remove(button);
				}
				
				main.repaint();
				locations = randTiles(locations);
				setButtons();
				main.repaint();				
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
		main.getContentPane().add(btnRestart);

	}

	
	private class MouseListener extends MouseAdapter{		
		
		 //Mouse listener event handler
		 public void mousePressed(MouseEvent me) {
		 
			 //TODO action click on button event						 
			 //JButton button = (JButton)me.getComponent();
			 
			 
			 main.remove((JButton)me.getComponent());
			 main.repaint();
			 
			 //String label = button.getText();
			 //int x = button.getX();
			 //int y = button.getY();
			 
			 //System.out.println(String.format("\nButton: %s X: %d Y: %d", label, x, y)); //DEBUG ONLY
			 
			 //swapTiles(x, y, label);
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
