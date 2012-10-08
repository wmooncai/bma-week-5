import java.sql.Timestamp;

/**
 * @author W. Mooncai
 * @version 0.0
 * @since 0.0
 * 
 * Crossfire BMA Week 5 Homework
 * Due: 10/8/2012
 * 
 *     Read chapter 7 in Java: A Beginner's Guide
 *     Programming assignment
 *        + Create a github repository to hold homework.  It should be named bma-week-5.  It should contain an Assignment.java file
 *        + Implement the following static method "static String getElement(String values, int index)"
 *            + If the index is not a valid array index, return null
 *                In the future we'll try to avoid this, but we currently don't have error handling in our toolbox
 *            + Otherwise, return the array element at the index
 *        + Implement a class named Task inside the Assignment.java file
 *            + Do not create a new file.  Place the Task class immediately after the end of the Assignment class in Assignment.java
 *            + Do not implement a main method in Task.
 *            + Add the instance variables you think belong in a Task object
 *            + Implement at least one parameterized constructor for the Task class
 *            + Implement a no-argument constructor for the Task class
 *            + Implement a main() method in the Assignment class that does the following
 *                + Call every constructor implemented in Task at least once, assigning the resulting object to a variable
 *                + Pass each Task object created to "System.out.println(aTask);"
 *            + Try to run Assignment
 *                Why didn't it work?  The compiler has no idea how to convert a Task object into a String
 *            + Implement a toString() method in Task
 *                + The signature has to be "public String toString()" exactly
 *                + Create a String representation of a Task.  This does not need to display every piece of data in the class, 
 *                just the core information.  "Task(title)" would be a sparse but acceptable implementation.
 *            + Try to run Assignment again
 *                + It should work.  If not, try debugging.  If that fails, send an email
 *                
 */

public class Assignment {

	public static void main(String[] args) {
		
		StringBuffer myTaskName = new StringBuffer("My Task ");
		
		// Instantiate new task objects
		Task task1 = new Task(myTaskName.append("1"), (System.currentTimeMillis() + 1));
		Task task2 = new Task(myTaskName.replace((myTaskName.length() - 1)
				, (myTaskName.length()), "2"), (System.currentTimeMillis() + 2));
		Task task3 = new Task();
		
		// Output new task object contents
		System.out.println(task1.toString(Task.NAME_TO_STR));
		System.out.println(task2.toString(Task.NAME_TO_STR, Task.START_DATE_TO_STR));
		System.out.println(task3);
		
	} // main()

	/**
	 * Extract a character from a String
	 * 
	 * @since 0.0
	 * 
	 * @param values	String from which to extract a character
	 * @param index		Index of character to extract
	 * @return			Return the character at index.  If index is invalid, return null.
	 */
	static String getElement(String values, int index) {
		
		if ((index >= 0) && (index < values.length())) {
			return values.substring(index, index);
		} else return null;
		
	} // getElement(String, int)

	/**
	 * Extract a String element from a String array
	 * 
	 * @since 0.0
	 * 
	 * @param values	String from which to extract a character
	 * @param index		Index of character to extract
	 * @return			Return the character at index.  If index is invalid, return null.
	 */
	static String getElement(String[] values, int index) {
		
		if ((index >= 0) && (index < values.length)) {
			return values[index];
		} else return null;
		
	} // getElement(String[], int)
	
} // CLASS Assignment

/**
 * @author Wallace Mooncai
 * @since 0.0
 * 
 * Class Task is a basic task class
 * 
 * @param MAX_NAME_LEN			Maximum length of the Task name
 * 
 * @param NAME_TO_STR			Flag for toString() to output the Task Name
 * @param START_DATE_TO_STR		Flag for toString() to output the Start Date/Time
 * @param END_DATE_TO_STR		Flag for toString() to output the End Date/Time
 * 
 * @param taskName				Name of the Task
 * @param startDateTime			Task Start Date/Time
 * @param endDateTime			Task End Date/Time
 * @param completed				Flag to manually mark this task as complete
 * 
 */

class Task {

	// Constants
	private static final String MY_TASK_NAME = "My Task ";
	public static final int MAX_NAME_LEN = 20;
	
	public static final int NAME_TO_STR = 10;
	public static final int START_DATE_TO_STR = 20;
	public static final int END_DATE_TO_STR = 30;
	public static final int COMPETED_TO_STR = 40;
	
	// Fields
	public StringBuffer taskName = new StringBuffer(MAX_NAME_LEN);
	public long startDateTime;
	public long endDateTime;
	public boolean completed;
	
	// ************************************ Constructor - no args ************************************
	/**
	 * Task Constructor with no arguments
	 * @since 0.0
	 * 
	 * Member fields set to defaults:
	 * @param taskName			Defaults to a generic task name
	 * @param startDateTime		Defaults to current date / time
	 * @param endDateTime		Defaults to current date / time minus 1ms
	 * @param completed			Flag to manually mark this task as complete; defaults to false (incomplete)
	 * 
	 */
	public Task() {
		 
		taskName.replace(0, taskName.length(), MY_TASK_NAME);

		startDateTime = System.currentTimeMillis();
		endDateTime = startDateTime - 1;
				
	} // Task()
	
	// *********************** Constructor - with task name and start time args **********************
	/**
	 * Task Constructor with arguments
	 * @since 0.0
	 * 
	 * @param taskN			Task name
	 * @param dateTime		Set the start date / time.  End date / time is set 1ms prior to start date / time.
	 * 
	 */
	public Task(StringBuffer taskN, long dateTime) {
		
		startDateTime = dateTime;
		endDateTime = dateTime - 1;
		
		if (taskN.length() > MAX_NAME_LEN) {
			taskName = (StringBuffer) taskN.subSequence(0, MAX_NAME_LEN);
		} else taskName.replace(0, taskName.length(), taskN.toString());
		
	} // Task() - 2 args
		
	// ********************************* Constructor - with all args *********************************
	/**
	 * Constructor accepting arguments for all member fields
	 * @since 0.0
	 * 
	 * @param startDT		Start date / time
	 * @param endDT			End date / time
	 * @param taskN			Task name
	 */
	
	public Task(long startDT, long endDT, StringBuffer taskN) {
		
		startDateTime = startDT;
		endDateTime = startDateTime - 1;
		
		if (taskN.length() > MAX_NAME_LEN) {
			taskName = (StringBuffer) taskN.subSequence(0, MAX_NAME_LEN);
		} else taskName.replace(0, taskName.length(), taskN.toString());
		
	} // Task() - all args
	
	// ***************************************** toString() ******************************************
	/**
	 * Function toString(Field Constant Flags) to pretty output desired member fields.
	 * @since 0.0
	 * 
	 * @param Field Constant Flags		Public flags to indicate which member fields to output
	 * @return String describing all member fields
	 * 
	 */
	public String toString(int ... varsToString) {
		
		StringBuffer returnString = new StringBuffer(0);

		for (int memberVar : varsToString) {
			switch (memberVar) {
			case NAME_TO_STR:
				returnString.append("\n      Task Name: " + taskName.toString());
				break;
			case START_DATE_TO_STR:
				returnString.append("\nStart Date/Time: " + startDateTime + " (" + new Timestamp(startDateTime).toString() + ")");
				break;
			case END_DATE_TO_STR:
				returnString.append("\n  End Date/Time: " + endDateTime + " (" + new Timestamp(endDateTime).toString() + ")");
				break;
			case COMPETED_TO_STR:
				returnString.append("\n      Completed: " + completed);
				break;
			} // switch
		} // for loop
		
		return returnString.toString();
		
	} // toString(args)
	
	/**
	 * toString() will pretty output all Task fields
	 * @since 0.0
	 */
	public String toString() {
		
		return toString(NAME_TO_STR, START_DATE_TO_STR, END_DATE_TO_STR, COMPETED_TO_STR);
		// return "\nTask Name: " + taskName.toString() + "\nstartDateTime: " + startDateTime + "\ncomplete: " + completed;
		
	} // toString()
	
} // CLASS Task
