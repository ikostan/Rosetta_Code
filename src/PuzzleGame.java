import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class PuzzleGame extends JFrame implements MainInterface{

	/*
	 * 15 Puzzle Game
	 
	 We fist define a generic package Generic_Puzzle. Upon instantiation, 
	 it can take any number of rows, any number of columns for a rows*columns-1 game. 
	 Instead of plain numbers, the tiles on the board can have arbitrary names 
	 (but they should all be of the same length). The package user can request the name 
	 for the tile at a certain (row,column)-point, and the set of possible moves. 
	 The user can move the empty space up, down, left and right (if possible). 
	 If the user makes the attempt to perform an impossible move, a Constraint_Error is raised. 
	 
	 Answer: 
	 
	 SOURCE: https://rosettacode.org/wiki/15_Puzzle_Game
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
	
	
	private final static int totalWidth = 440;
    private static final int ROWS = 4;
    private static final int COLS = 4;
    private static final int padding = 40;
    private static int slideSize = (totalWidth - padding * 2) / ROWS;
	private int numTiles = ROWS * COLS;
	
	private int x0 = padding;
	private int x1 = padding + slideSize;
	private int x2 = padding + slideSize * 2;
	private int x3 = padding + slideSize * 3;
	
	private int y0 = padding;
	private int y1 = padding + slideSize;
	private int y2 = padding + slideSize * 2;
	private int y3 = padding + slideSize * 3;
		
	private Random rand;
	
	private int[][][] locations;
	private JButton button_0, button_1, button_2, button_3, button_4, 
					button_5, button_6, button_7, button_8, button_9, 
					button_10, button_11, button_12, button_13, button_14;
	private JButton[] buttonsArray;
	private int[] tilesArray;

	//Main method
	public static void main(String[] args){
		
		//new PuzzleGame();		
	}
	
	//Constructor
	public PuzzleGame(){
					
	}
	
	//Creates a new object
	public void runObject(){
		
		//new PuzzleGame();
		
		tilesArray = new int[numTiles - 1];
		int index = 1;
		
		for(@SuppressWarnings("unused") int tile : tilesArray){
			
			tile = index;
			//System.out.println(index); //DEBUG ONLY
			index++;
		}
		
		//buttonsArray = new JButton[ROWS * COLS];
		buttonsArray = new JButton[]{button_0, button_1, button_2, button_3, 
									button_4, button_5, button_6, button_7, button_8, 
									button_9, button_10, button_11, button_12, button_13, button_14};
		
		locations = new int[][][]{			
				//0	 	//1	 	 //2	  //3
			{{x0, y0},{x1, y0},{x2, y0},{x3, y0}},	//0
			{{x0, y1},{x1, y1},{x2, y1},{x3, y1}},	//1
			{{x0, y2},{x1, y2},{x2, y2},{x3, y2}},	//2
			{{x0, y3},{x1, y3},{x2, y3},{x3, y3}}	//3
		};
			
		this.setTitle("15 Puzzle Game");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setAlwaysOnTop(true);
		this.setSize(totalWidth, totalWidth + (padding * 2));
		this.setResizable(false);     
				
		setButtons();		
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	//Set button location
	private void setButtonBounds(int row, int col, JButton button, int[][][] locations){
									//X						//Y			//Height	//Width
		button.setBounds(locations[row][col][0], locations[row][col][1], slideSize, slideSize);
	}

	//Create tiles/buttons
	private void setButtons(){
		
		String label = "";
		int i = 0;
		
		for(int row = 0; row < ROWS; row++){
			
			for(int col = 0; col < COLS; col++){
							
				if(i < numTiles - 1){
					
					label = String.format("%d", (i + 1));
					
					buttonsArray[i] = new JButton(label);
					buttonsArray[i].setForeground(Color.RED);
					buttonsArray[i].setFont(new Font("Times New Roman", Font.BOLD, 40));
					buttonsArray[i].setBackground(SystemColor.activeCaption);
					setButtonBounds(row, col, buttonsArray[i], locations);
					
					buttonsArray[i].addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							
							System.out.println(arg0.getActionCommand()); //Returns button label
						}					
						
					});
					
					/*
					buttonsArray[i].addMouseListener(new MouseAdapter(){
						//Mouse listener event handler
						public void mousePressed(MouseEvent me) { 
				            							
							//System.out.println(me.getLocationOnScreen());
							//System.out.println(me); 
							//Object button = me.getSource();
							//System.out.println(button.toString());
				          } 
					});	
					*/
					
					getContentPane().add(buttonsArray[i]);
				} 
				else{
					/*
					//Last (empty) slide
					buttonsArray[i] = new JButton("");
					buttonsArray[i].setForeground(Color.RED);
					buttonsArray[i].setFont(new Font("Times New Roman", Font.BOLD, 40));
					buttonsArray[i].setBackground(SystemColor.controlHighlight);
					buttonsArray[i].setBounds((padding + slideSize * 3), (padding + slideSize * 3), slideSize, slideSize);
					getContentPane().add(buttonsArray[i]);
					*/
				}
				
				i++; //Total index
			}
		}
		
		
		JButton btnNewButton = new JButton("Restart the game");
		btnNewButton.addActionListener(new ActionListener() {
			//Restart the game event handler
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		//Restart button
		btnNewButton.setBounds((padding + slideSize), 
								(((COLS/2) * padding) + (slideSize * ROWS)), 
								(slideSize * (COLS/2)), 
								(padding / (ROWS/2)));
		getContentPane().add(btnNewButton);
		
	}
	
	@Override
	public String getTaskName() {
		// TODO Auto-generated method stub
		return taskName;
	}

	@Override
	public String getTaskDescription() {
		// TODO Auto-generated method stub
		return taskDescription;
	}

	@Override
	public String getTaskLink() {
		// TODO Auto-generated method stub
		return taskLink;
	}

	@Override
	public String getTaskResult() {
		// TODO Auto-generated method stub		
		return result;
	}

	@Override
	public void setResult(String newResult) {
		// TODO Auto-generated method stub
		
	}
	
	//END
}
