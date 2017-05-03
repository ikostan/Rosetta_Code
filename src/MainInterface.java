
public interface MainInterface {

	String taskName = null;
	String taskDescription = null;
	String taskLink = null;
	String result = null;
	
	public static String getTaskName(){
		
		return taskName;
	}
	
	public static String getTaskDescription(){
		
		return taskDescription;
	}

	public static String getTaskLink(){
	
		return taskLink;
	}
	
	public static String getTaskResult(){
		
		return result;
	}
	
	public static void setResult(String newResult){
		
	}
	
}
