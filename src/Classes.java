import java.util.ArrayList;

//List of all classes
public class Classes {

	//Class field
	static ArrayList<String[]> className;
	
	//Constructor
	public Classes(){
		
		 className = new ArrayList<String[]>();
		 
		 //Task 100 doors
		 OneHundredDoors doors = new OneHundredDoors();
		 String[] myString1 = {doors.getTaskName(), doors.getTaskDescription(), doors.getTaskResult()};
		 className.add(myString1);
		 
		 //15 Puzzle Game
		 PuzzleGame puzzleGame = new PuzzleGame();
		 String[] myString2 = {puzzleGame.getTaskName(), puzzleGame.getTaskDescription(), puzzleGame.getTaskResult()};
		 className.add(myString2);
	}
	
	//Return String array object
	public static String[] getObject(int id){
		try{
			//Return object/task
			return className.get(id);
		}
		catch(Exception ex){
			//Error
			String[] error = new String[3];
			error[0] = "N/A";
			error[1] = "There is nothing here:\n" + ex.getMessage().toString();
			error[2] = "N/A";
			return error;
		}
	}
}
