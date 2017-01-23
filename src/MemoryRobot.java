/**
 * This is a memory robot program
 * It allows the memory robot to solve the maze and at the same time keep track of the dead ends that the roboto runs into
 * It also blocks all the dead ends so that the robot doesn't move to the dead end again
 * Author : Sujan Shrestha
 */
import java.util.ArrayList;
import java.util.Random;


public class MemoryRobot extends Robot{

	//Initializing and declaring the variable
	private Random rand=new Random();

	private int direction;
	private boolean empty;
	//private ArrayList<Location>  loc;
	
	/**
	 * This is a constructor
	 * @param inmaze
	 */

	public MemoryRobot(Maze inmaze) {

		super(inmaze);
		//loc= new ArrayList <Location>(); I am not using the array list to store the dead ends
		empty=true;
	}

	public int chooseMoveDirection() {

		direction=rand.nextInt(4);
		return direction;
	}

	/**
	 * Checks the number of neighboring cell open
	 * @return number of open cells
	 */

	public int neighborcell(int row, int col)
	{
		int opencell=0;

		if(checkRobotCell(row-1, col) ==true)
		{
			opencell++;
		}
		if(checkRobotCell(row+1, col)==true)
		{
			opencell++;
		}
		if(checkRobotCell(row, col-1)==true)
		{
			opencell++;
		}
		if(checkRobotCell(row, col+1)==true)
		{
			opencell++;
		}
		return opencell;
	}
	@Override// This method makes the actual move for the Robot if the Robot is valid

	public void move(int direction) 

	{
		// n= 0 go North
		// s = 1 go South
		// w = 2 go West
		// e = 3 go East



		//Creates an empty Space in the current Location after the Robot has made the move to another location
		if(empty==true)
		{
			this.setEmptyCell(this.getCurrentR(), this.getCurrentC());
		}
		if(direction==0)
		{
			if(checkRobotCell(this.getCurrentR()-1, this.getCurrentC())==true)
			{
				//Makes the actual Robot move to the desired destination in the MazeGrid

				this.setRobotCell(this.getCurrentR()-1, this.getCurrentC());


				//Updating the current Row position
				this.setCurrentR(this.getCurrentR()-1);
			}

		}

		else if(direction==1)
		{
			if(checkRobotCell(this.getCurrentR()+1, this.getCurrentC())==true)
			{
				//Makes the actual Robot move to the desired destination in the MazeGrid

				this.setRobotCell(this.getCurrentR()+1, this.getCurrentC());

				//Updating the current Row position
				this.setCurrentR(this.getCurrentR()+1);
			}
		}
		else if(direction==2)
		{
			if(checkRobotCell(this.getCurrentR(), this.getCurrentC()-1)==true)
			{
				//Makes the actual Robot move to the desired destination in the MazeGrid

				this.setRobotCell(this.getCurrentR(), this.getCurrentC()-1);

				//Updating the current Column position
				this.setCurrentC(this.getCurrentC()-1);

			}
		}
		else if(direction==3)
		{
			if(checkRobotCell(this.getCurrentR(), this.getCurrentC()+1)==true)
			{
				//Makes the actual Robot move to the desired destination in the MazeGrid

				this.setRobotCell(this.getCurrentR(), this.getCurrentC()+1);

				//Updating the current Column position
				this.setCurrentC(this.getCurrentC()+1);
			}
		}
		
		//Calling the neighborcell method to check the number of open neighbor cells in the maze

		int openneighborcell=  neighborcell(this.getCurrentR(),this.getCurrentC());
		
		//Check if the cell has reached to dead end or not
		
		if(openneighborcell == 1 )
		{
			//Location l= new Location(this.getCurrentR(), this.getCurrentC());
			//loc.add(l);
			this.setdeadEndCell(this.getCurrentR(), this.getCurrentC());
			
			empty=false;
		}
		// else it is going to empty the space after the robot
	
		else{

			empty=true;
		}

	}

}
