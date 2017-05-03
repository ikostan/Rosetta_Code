import java.util.ArrayList;

//List of all classes
public class Classes {

	static ArrayList<String[]> className;
	
	public Classes(){
		
		 className = new ArrayList<String[]>();
		 OneHundredDoors doors = new OneHundredDoors();
		 String[] myString1 = {doors.getTaskName(), doors.getTaskDescription(), doors.getTaskResult()};
		 className.add(myString1);
	}
	
	
	public static String[] getObject(int id){
		
		return className.get(id);
	}
}
