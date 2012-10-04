/**
 * @author Wallace Mooncai
 * @since 10/1/2012
 * 
 * BMA Week 5 Homework
 * 
 *     Read chapter 7 in Java: A Beginner's Guide
 *     Programming assignment
 *        Create a github repository to hold homework.  It should be named bma-week-5.  It should contain an Assignment.java file
 *        Implement the following static method "static String getElement(String values, int index)"
 *            If the index is not a valid array index, return null
 *                In the future we'll try to avoid this, but we currently don't have error handling in our toolbox
 *            Otherwise, return the array element at the index
 *        Implement a class named Task inside the Assignment.java file
 *            Do not create a new file.  Place the Task class immediately after the end of the Assignment class in Assignment.java
 *            Do not implement a main method in Task.
 *            Add the instance variables you think belong in a Task object
 *            Implement at least one parameterized constructor for the Task class
 *            Implement a no-argument constructor for the Task class
 *            Implement a main() method in the Assignment class that does the following
 *                Call every constructor implemented in Task at least once, assigning the resulting object to a variable
 *                Pass each Task object created to "System.out.println(aTask);"
 *            Try to run Assignment
 *                Why didn't it work?  The compiler has no idea how to convert a Task object into a String
 *            Implement a toString() method in Task
 *                The signature has to be "public String toString()" exactly
 *                Create a String representation of a Task.  This does not need to display every piece of data in the class, 
 *                just the core information.  "Task(title)" would be a sparse but acceptable implementation.
 *            Try to run Assignment again
 *                It should work.  If not, try debugging.  If that fails, send an email
 */

public class Assignment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	} // main()

	static String getElement(String values, int index) {
		
		if ((index >= 0) && (index < values.length())) {
			return values.substring(index, index);
		} else return null;
		
	} // getElement()
	
} // CLASS Assignment


