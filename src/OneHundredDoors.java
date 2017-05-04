
public class OneHundredDoors implements MainInterface{

	/*
	 Headline text - Task 100 doors
	 
		You are encouraged to solve this task according to the task description, using any language you may know.
		
		- There are 100 doors in a row that are all initially closed.
		- You make 100 passes by the doors.
		- The first time through, visit every door and   toggle   the door   (if the door is closed,   open it;   if it is open,   close it).
		- The second time, only visit every 2nd door   (door #2, #4, #6, ...),   and toggle it.
		- The third time, visit every 3rd door   (door #3, #6, #9, ...), etc,   until you only visit the 100th door.

		Answer the question:   what state are the doors in after the last pass?   Which are open, which are closed?

		Alternate: As noted in this page's discussion page, the only doors that remain open are those whose numbers are perfect squares.

		Opening only those doors is an optimization that may also be expressed; 
		However, as should be obvious, this defeats the intent of comparing implementations across programming languages. 
		
			  
		Answer >>> Open Doors: 1, 4, 9, 16, 25, 36, 49, 64, 81, 100
		SOURCE: https://rosettacode.org/wiki/100_doors
	 */
	
	
	private String taskName = "100 doors";
	private String taskDescription = "You are encouraged to solve this task according to the task description, using any language you may know.\n"
	+ "\n- There are 100 doors in a row that are all initially closed."
	+ "\n- You make 100 passes by the doors."
	+ "\n- The first time through, visit every door and toggle the door (if the door is closed, open it; if it is open, close it)."
	+ "\n- The second time, only visit every 2nd door (door #2, #4, #6, ...), and toggle it."
	+ "\n- The third time, visit every 3rd door (door #3, #6, #9, ...), etc, until you only visit the 100th door.\n"
	+ "\nAnswer the question:   what state are the doors in after the last pass?   Which are open, which are closed?\n"
	+ "\nAlternate: As noted in this page's discussion page, the only doors that remain open are those whose numbers are perfect squares.\n"
	+ "\nOpening only those doors is an optimization that may also be expressed; "
	+ "However, as should be obvious, this defeats the intent of comparing implementations across programming languages."; 
	private String taskLink = "<html><a href=\"https://rosettacode.org/wiki/100_doors\">Source</a></html>";
	private static String result;

	
	private static boolean[] doors;
	
	public OneHundredDoors(){
				
		doors = new boolean[100];
		for(boolean door : doors){		
			//There are 100 doors in a row that are all initially closed.
			door = false;
		}
		
		for(int a = 1; a <= doors.length; a++){ // You make 100 passes by the doors.
			
			// i=1 >>> The first time through, visit every door and toggle the door (if the door is closed, open it; if it is open, close it).
			// i=2 >>> The second time, only visit every 2nd door   (door #2, #4, #6, ...),   and toggle it.
			// i=3 >>> The third time, visit every 3rd door   (door #3, #6, #9, ...), etc,   until you only visit the 100th door.
			// i=4 >>> ...
			for(int b = a - 1; b < doors.length; b = b + a){ 
				
				if(doors[b] == false){
					doors[b] = true;
				}
				else if(doors[b] == true){
					doors[b] = false;
				}
			}		
		}
					
		//Print the results
		int index = 1;
		String output = "";

		for(Boolean door : doors){

			if(door == true){
				output += String.format("Door #%d is opened\n", index);
			}
			index++;
		}
			
		//System.out.println(output);
		setResult(output);
	}
	

	@Override
	public String getTaskName(){
		
		return this.taskName;
	}
	
	@Override
	public String getTaskDescription(){
		
		return this.taskDescription;
	}

	@Override
	public String getTaskLink(){
	
		return this.taskLink;
	}
	
	@Override
	public String getTaskResult(){
		
		return this.result;
	}
	
	@Override
	public void setResult(String newResult){
		
		result = newResult;
	}


	
}
