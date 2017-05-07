
public class Two_D_sliding_block_puzzle implements MainInterface{

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
	
	
	private String taskName = "2D sliding block puzzle game (2048)";
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
