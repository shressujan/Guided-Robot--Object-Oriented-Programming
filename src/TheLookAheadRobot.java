/**
 * I worked with "Josh" to figure out the recursion for the robot
 * This class is the sub class that extends the Facing Robot class
 * It takes maze as an input
 * It will choose the directions for the Robot to guide through the maze
 * It will use recursion so that Robot makes number of moves in the  given time
 * It will exit the Robot 
 * 
 * @author Sujan Shrestha worked with Josh
 *
 */
public class TheLookAheadRobot extends FacingRobot{

	//Initializing and declaring the variable
	private int direction;

	public TheLookAheadRobot(Maze inmaze) {
		super(inmaze);


	}
	@Override
	/**
	 * This method chooses the Direction for the RightHandRobot to move in the mazeGrid
	 * @return Direction
	 */
	public int chooseMoveDirection() 

	{
		// 0=North
		// 1=South
		// 2=West
		// 3=East
		//Checks the direction that Right Hand Robot is Facing currently
		if(this.getFaceDirection()=="S")
		{
			//Checks if the given cell is open or not, returns true if the given cell is open else return false

			if(checkRobotCell((this.getCurrentR()+1), (this.getCurrentC()))==true)
			{
				direction=1;
				this.setFaceDirection("S");
			}
			else if(checkRobotCell((this.getCurrentR()), (this.getCurrentC()-1))==true)
			{
				direction=2;
				this.setFaceDirection("W");
			}
			//Checks if the given cell is open or not, returns true if the given cell is open else return false

			//Checks if the given cell is open or not, returns true if the given cell is open else return false
			else if(checkRobotCell((this.getCurrentR()), (this.getCurrentC()+1))==true)
			{
				direction=3;
				this.setFaceDirection("E");
			}
			//Checks if the given cell is open or not, returns true if the given cell is open else return false
			else if(checkRobotCell((this.getCurrentR()-1), (this.getCurrentC()))==true)
			{
				direction=0;
				this.setFaceDirection("N");
			}
		}
		//Checks the direction that Right Hand Robot is Facing currently
		else if(this.getFaceDirection()=="W")
		{
			//Checks if the given cell is open or not, returns true if the given cell is open else return false
			if(checkRobotCell((this.getCurrentR()), (this.getCurrentC()-1))==true)
			{
				direction=2;
				this.setFaceDirection("W");
			}
			//Checks if the given cell is open or not, returns true if the given cell is open else return false
			else if(checkRobotCell((this.getCurrentR()-1), (this.getCurrentC()))==true)
			{
				direction=0;
				this.setFaceDirection("N");
			}

			//Checks if the given cell is open or not, returns true if the given cell is open else return false
			else if(checkRobotCell((this.getCurrentR()+1), (this.getCurrentC()))==true)
			{
				direction=1;
				this.setFaceDirection("S");
			}
			//Checks if the given cell is open or not, returns true if the given cell is open else return false
			else if(checkRobotCell((this.getCurrentR()), (this.getCurrentC()+1))==true)
			{
				direction=3;
				this.setFaceDirection("E");
			}

		}
		//Checks the direction that Right Hand Robot is Facing currently
		else if(this.getFaceDirection()=="E")
		{
			//Checks if the given cell is open or not, returns true if the given cell is open else return false
			if(checkRobotCell((this.getCurrentR()), (this.getCurrentC()+1))==true)
			{
				direction=3;
				this.setFaceDirection("E");
			}
			//Checks if the given cell is open or not, returns true if the given cell is open else return false
			else if(checkRobotCell((this.getCurrentR()+1), (this.getCurrentC()))==true)
			{
				direction=1;
				this.setFaceDirection("S");
			}

			//Checks if the given cell is open or not, returns true if the given cell is open else return false
			else if(checkRobotCell((this.getCurrentR()-1), (this.getCurrentC()))==true)
			{
				direction=0;
				this.setFaceDirection("N");
			}
			//Checks if the given cell is open or not, returns true if the given cell is open else return false
			else if(checkRobotCell((this.getCurrentR()), (this.getCurrentC()-1))==true)
			{
				direction=2;
				this.setFaceDirection("W");
			}


		}
		//Checks the direction that Right Hand Robot is Facing currently
		else if(this.getFaceDirection()=="N")
		{ 
			//Checks if the given cell is open or not, returns true if the given cell is open else return false
			if(checkRobotCell((this.getCurrentR()-1), (this.getCurrentC()))==true)
			{
				direction=0;
				this.setFaceDirection("N");
			}
			//Checks if the given cell is open or not, returns true if the given cell is open else return false
			else if(checkRobotCell((this.getCurrentR()), (this.getCurrentC()+1))==true)
			{
				direction=3;
				this.setFaceDirection("E");
			}

			else if(checkRobotCell((this.getCurrentR()), (this.getCurrentC()-1))==true)
			{
				direction=2;
				this.setFaceDirection("W");
			}
			//Checks if the given cell is open or not, returns true if the given cell is open else return false
			else if(checkRobotCell((this.getCurrentR()+1), (this.getCurrentC()))==true)
			{
				direction=1;
				this.setFaceDirection("S");
			}


		}
		return direction;
	}
	@Override
	/**
	 * This method makes the RightHandRobot move in the direction of input parameter
	 * @param int direction
	 */
	public void move(int direction)
	{
		// n= 0 go North
		// s = 1 go South
		// w = 2 go West
		// e = 3 go East

		//Creates an empty Space in the current Location prior to the Robot has made the move to another location

		this.setEmptyCell(this.getCurrentR(), this.getCurrentC());

		if(direction==0)
		{

			if(checkRobotCell(this.getCurrentR()-1, this.getCurrentC())==true)
			{
				//Updating the current Row position
				this.setCurrentR(this.getCurrentR()-1);


				move(direction);
			}
			else
			{
				//Makes the actual Robot move to the desired destination in the MazeGrid

				this.setRobotCell(this.getCurrentR(), this.getCurrentC());


			}
		}

		else if(direction==1)
		{


			if(checkRobotCell(this.getCurrentR()+1, this.getCurrentC())==true)
			{
				//Updating the current Row position
				this.setCurrentR(this.getCurrentR()+1);
				move(direction);
			}
			else
			{
				//Makes the actual Robot move to the desired destination in the MazeGrid

				this.setRobotCell(this.getCurrentR(), this.getCurrentC());


			}
		}
		else if(direction==2)
		{


			if(checkRobotCell(this.getCurrentR(), this.getCurrentC()-1)==true)
			{
				//Updating the current Column position
				this.setCurrentC(this.getCurrentC()-1);
				move(direction);

			}
			else
			{
				//Makes the actual Robot move to the desired destination in the MazeGrid

				this.setRobotCell(this.getCurrentR(), this.getCurrentC());



			}

		}
		else if(direction==3)
		{

			if(checkRobotCell(this.getCurrentR(), this.getCurrentC()+1)==true)
			{
				//Updating the current Column position
				this.setCurrentC(this.getCurrentC()+1);
				move(direction);
			}
			else
			{
				//Makes the actual Robot move to the desired destination in the MazeGrid

				this.setRobotCell(this.getCurrentR(), this.getCurrentC());


			}

		}

	}

}

