import java.util.ArrayList;

public class Main {
	
	/*
	 *SOURCE: https://rosettacode.org/wiki/Rosetta_Code
	 *Rosetta Code is a programming chrestomathy site. 
	 *The idea is to present solutions to the same task in as many different languages as possible, 
	 *to demonstrate how languages are similar and different, and to aid a person with a grounding 
	 *in one approach to a problem in learning another. Rosetta Code currently has 846 tasks, 
	 *198 draft tasks, and is aware of 648 languages, though we do not (and cannot) have solutions 
	 *to every task in every language.
	 */	
	
	private static ArrayList<String[]> subjectList = new ArrayList<>(); 
	String[] myString1 = {"hey","hey","hey"}; 
	
	
	
	public Main() {
		
		String[] myString1= {
				"1",
				"Task 100 doors",
				"You are encouraged to solve this task according to the task description, using any language you may know.\n"
				+ "\n- There are 100 doors in a row that are all initially closed."
				+ "\n- You make 100 passes by the doors."
				+ "\n- The first time through, visit every door and toggle the door (if the door is closed, open it; if it is open, close it)."
				+ "\n- The second time, only visit every 2nd door (door #2, #4, #6, ...), and toggle it."
				+ "\n- The third time, visit every 3rd door (door #3, #6, #9, ...), etc, until you only visit the 100th door.\n"
				+ "\nAnswer the question:   what state are the doors in after the last pass?   Which are open, which are closed?\n"
				+ "\nAlternate: As noted in this page's discussion page, the only doors that remain open are those whose numbers are perfect squares.\n"
				+ "\nOpening only those doors is an optimization that may also be expressed; "
				+ "However, as should be obvious, this defeats the intent of comparing implementations across programming languages. ", 
				"<html><a href=\"https://rosettacode.org/wiki/100_doors\">Source</a></html>"}; 
	    
		
		subjectList.add(myString1);

	}

	public static String[] getSubject(int i){
		
		String[] currentSubject;	
		currentSubject = subjectList.get(i);	
		return currentSubject;
	}

	
	
	/*	 
	static int id = 0;
	static private String header = null;
	static private String task = null;
	static private String question = null;
	 
	public static int getClassId(){		
		return  id;
	}
	
	public static String getHeader(){	
		return header;
	}
	
	public static String getTask(){	
		return task;
	}

	public static String getQuestion(){
		return question;
	}
	*/
	
}
