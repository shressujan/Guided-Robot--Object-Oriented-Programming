import java.util.Random;
/**
 * This RandomRobot class extends the Robot class
 * It takes maze as a input file
 * It chooses the direction for the robot to move
 * The move method makes the actual move for the robot
 * @author Sujan Shrestha
 *
 */

public class RandomRobot extends Robot
{

	//Initializing and declaring the variable
	private Random rand=new Random();
	private int direction;


	//This is the constructor for the RandomRobot

	public RandomRobot(Maze inMaze)
	{

		super(inMaze);


	}
	//This method chooses the direction for Robots next move

	public int chooseMoveDirection()
	{
		direction=rand.nextInt(4);
		return direction;

	}
	@Override// This method makes the actual move for the Robot if the Robot is valid

	public void move(int direction) 
	{
		{
			// n= 0 go North
			// s = 1 go South
			// w = 2 go West
			// e = 3 go East

			//Creates an empty Space in the current Location after the Robot has made the move to another location

			this.setEmptyCell(this.getCurrentR(), this.getCurrentC());

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

		}
	}
}

