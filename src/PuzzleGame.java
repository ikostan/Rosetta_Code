
public class PuzzleGame implements MainInterface{

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

		
}
