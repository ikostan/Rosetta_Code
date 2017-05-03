
public class OneHundredDoors {

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
		
			  
		Open Doors: 1, 4, 9, 16, 25, 36, 49, 64, 81, 100
	 */
	
	private final int FIRST = 0;
	private final static int LAST = 99;
	private static boolean[] doors;
	
	public OneHundredDoors(){
				
		doors = new boolean[100];
		for(boolean door : doors){		
			//There are 100 doors in a row that are all initially closed.
			door = false;
		}
	}
	
	public static void main(String[] args) {
		
		new OneHundredDoors();
		
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
			
		
		System.out.println("\n=============\n");
		
		//Print the results
		int index = 1;
		String output = "";

		for(Boolean door : doors){

			if(door == true){
				output += String.format("Door #%d is opened\n", index);
			}
			//System.out.println("looping...");
			index++;
		}
			
		System.out.println(output);
		
	}
	
}
