/**
 * This is the OwnStrategy Robot class that extends the Robot class and only Works for the Small maze
 * It takes maze as a input file
 * It chooses the direction for the robot to move
 * The move method makes the actual move for the robot
 * @author Sujan Shrestha
 *
 */
public class OwnStrategyRobot extends Robot {
	//Initializing and declaring the variable
	private int direction;
	private int count=1;
	private int count1=1;
	private int count2=1;
	private int count3=1;
	private int count5=1;
	private int count6=1;
	private int exit=1;
	
	/**
	 * This is the constructor for this class
	 * @param inmaze
	 */
	public OwnStrategyRobot(Maze inmaze) {
		super(inmaze);


	}

	@Override
	/**
	 * This method chooses the Direction for the Own Strategy Robot to move in the mazeGrid
	 * @return Direction
	 */
	public int chooseMoveDirection() {

		//List of directions the robot needs to move in the maze 

		// n= 0 go North
		// s = 1 go South
		// w = 2 go West
		// e = 3 go East

		if( count<=5)
		{
			direction=1;//goes South
			count++;
		}
		else if(count1<=2)
		{
			direction=3;//goes East
			count1++;
		}
		else if(count2<=2){
			direction=1;//goes South
			count2++;
		}
		else if(count3<=2)
		{
			direction=3;//goes East
			count3++;
		}
		else if (count5<=2)
		{
			direction=0;//Goes North
			count5++;
		}
		else if (count6<=2)
		{
			direction=3;//Goes East
			count6++;
		}
		else if(exit<=3)
		{
			direction=1;//Goes South
			exit++;
		}
		return direction;
	}

	@Override
	/**
	 * This method makes the Own Strategy Robot move in the direction of input parameter
	 * @param int direction
	 */
	public void move(int direction) 
	{
		// n= 0 go North
		// s = 1 go South
		// w = 2 go West
		// e = 3 go East
		try
		{
			//Creates an empty Space in the current Location after the Robot has made the move to another location

			this.setEmptyCell(this.getCurrentR(), this.getCurrentC());

			if(direction==0)
			{
				//Makes the actual Robot move to the desired destination in the MazeGrid

				this.setRobotCell(this.getCurrentR()-1, this.getCurrentC());

				//Updating the current Row position
				this.setCurrentR(this.getCurrentR()-1);


			}

			else if(direction==1)
			{

				//Makes the actual Robot move to the desired destination in the MazeGrid

				this.setRobotCell(this.getCurrentR()+1, this.getCurrentC());


				//Updating the current Row position
				this.setCurrentR(this.getCurrentR()+1);

			}
			// Robot tries to make move in the East
			else if(direction==3)
			{

				//Makes the actual Robot move to the desired destination in the MazeGrid

				this.setRobotCell(this.getCurrentR(), this.getCurrentC()+1);


				//Updating the current Column position
				this.setCurrentC(this.getCurrentC()+1);

			}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{

			System.out.println("Sorry!!! You tried Working with the \"BiggerMaze\" "
					+ "\n\nThis Program  only Works for the \"Smaller maze\"");

			System.exit(0);
		}

	}

}

