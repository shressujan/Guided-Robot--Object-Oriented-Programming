/**
 * This is the Robot class which is the super class
 * This class is extended in other sub classes
 * This class retuns the name of the robot
 * It returns the empty space
 * It checks if the Cell is open or not
 * It sets the robot to the designated cell
 * IT checks if the maze is completed or not
 * @author Sujan Shrestha
 *
 */
public abstract class Robot {

	//Initializing and declaring the variable
	private char robot='R';
	private char emptySpace=' ';
	private char deadend='d';
	private Maze maze;
	private int exitrow;
	private int exitcolumn;
	private int currentR;
	private int currentC;


	/**
	 * This is the constructor
	 * @param inmaze
	 */
	public Robot(Maze inmaze)
	{
		maze=inmaze;
		exitrow=maze.getExitRow();
		exitcolumn=maze.getExitcolumn();
		currentR=maze.getStartRow();
		currentC=maze.getStartColumn();
		maze.setcell(currentR,currentC , robot);
	}
	/**
	 * This method returns the current row for the robot in the maze
	 * @return currentR
	 */
	public int getCurrentR() {
		return currentR;
	}
	/**
	 * This method returns the current column for the robot in the maze
	 * @return currentC
	 */
	public int getCurrentC() {
		return currentC;
	}


	//This is an abstract method so it does not function here

	public abstract int chooseMoveDirection();

	// This is an abstract method so it does not function here

	public  abstract void move(int direction);
	/**
	 * This method return the name of the Robot
	 * @return robot
	 */
	public char getRobot() {
		return robot;
	}
	/**
	 * This method returns an empty space character
	 * @return emptySpace
	 */
	public char getEmptySpace() {
		return emptySpace;
	}

	/**
	 * This is the method that returns the boolean value for the exit
	 * @return exit
	 */
	public boolean solved()
	{
		boolean exit= false;
		//Checks if the Robot has solved the maze or not
		if(maze.getCell(exitrow, exitcolumn)==robot)
		{
			exit=true;
		}

		return exit;
	}
	/**
	 * Checks if the Cell is open or not if its open then returns true
	 * @param inRow
	 * @param inColumn
	 * @return
	 */
	public boolean checkRobotCell(int inRow, int inColumn)
	{
		boolean result=false;
		if(maze.openCell(inRow, inColumn)==true)
		{
			result=true;
		}
		return result;
	}

	public void setCurrentR(int incurrentR) {
		currentR = incurrentR;
	}
	public void setCurrentC(int incurrentC) {
		currentC = incurrentC;
	}
	/**
	 * This method sets the Robot to the desginated Cell
	 * @param inRow
	 * @param inColumn
	 */
	public void setRobotCell(int inRow, int inColumn)
	{
		maze.setcell(inRow, inColumn, robot);
	}
	/**
	 * This method set the current cell to empty space once the Robot makes its move
	 * @param inRow
	 * @param inColumn
	 */
	public void setEmptyCell(int inRow, int inColumn)
	{
		maze.setcell(inRow, inColumn, emptySpace);
	}
	/**
	 * This method set the current cell to deadend cell once the Robot makes its move
	 * @param inRow
	 * @param inColumn
	 */
	public void setdeadEndCell(int inRow, int inColumn)
	{
	if( inRow!=maze.getExitRow())
	{
		maze.setcell(inRow, inColumn, deadend);
	}
	}
	public void setMaze(Maze maze)
	{
		maze= maze;
	}
}
