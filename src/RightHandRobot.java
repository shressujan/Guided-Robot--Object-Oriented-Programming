
public class RightHandRobot extends FacingRobot {
	/**
	 * This is the RightHandRobot class that extends the FacingRobot class
	 * It takes maze as a input file
	 * It chooses the direction for the robot to move
	 * The move method makes the actual move for the robot
	 * @author Sujan Shrestha
	 *
	 */
		//Initializing and declaring the variable
		private int direction;

		/**
		 * This is the constructor that takes Maze as a input parameter
		 * @param inMaze
		 */
		public RightHandRobot(Maze inMaze)
		{
			super(inMaze);
			
			
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

				if(this.checkRobotCell(this.getCurrentR(), this.getCurrentC()-1)==true)
				{
					direction=2;
					this.setFaceDirection("W");
					}
				//Checks if the given cell is open or not, returns true if the given cell is open else return false
				else if(this.checkRobotCell(this.getCurrentR()+1, this.getCurrentC())==true)
				{
					direction=1;
					this.setFaceDirection("S");
				}
				//Checks if the given cell is open or not, returns true if the given cell is open else return false
				else if(this.checkRobotCell(this.getCurrentR(), this.getCurrentC()+1)==true)
				{
					direction=3;
					this.setFaceDirection("E");
				}
				//Checks if the given cell is open or not, returns true if the given cell is open else return false
				else if(this.checkRobotCell(this.getCurrentR()-1, this.getCurrentC())==true)
				{
					direction=0;
					this.setFaceDirection("N");
				}
			}
			//Checks the direction that Right Hand Robot is Facing currently
			else if(this.getFaceDirection()=="W")
			{
				//Checks if the given cell is open or not, returns true if the given cell is open else return false
				if(this.checkRobotCell(this.getCurrentR()-1, this.getCurrentC())==true)
				{
					direction=0;
					this.setFaceDirection("N");
				}
				//Checks if the given cell is open or not, returns true if the given cell is open else return false
				else if(this.checkRobotCell(this.getCurrentR(), this.getCurrentC()-1)==true)
				{
					direction=2;
					this.setFaceDirection("W");
				}
				//Checks if the given cell is open or not, returns true if the given cell is open else return false
				else if(this.checkRobotCell(this.getCurrentR()+1, this.getCurrentC())==true)
				{
					direction=1;
					this.setFaceDirection("S");
				}
				//Checks if the given cell is open or not, returns true if the given cell is open else return false
				else if(this.checkRobotCell(this.getCurrentR(), this.getCurrentC()+1)==true)
				{
					direction=3;
					this.setFaceDirection("E");
				}

			}
			//Checks the direction that Right Hand Robot is Facing currently
			else if(this.getFaceDirection()=="E")
			{
				//Checks if the given cell is open or not, returns true if the given cell is open else return false
				if(this.checkRobotCell(this.getCurrentR()+1, this.getCurrentC())==true)
				{
					direction=1;
					this.setFaceDirection("S");
				}
				//Checks if the given cell is open or not, returns true if the given cell is open else return false
				else if(this.checkRobotCell(this.getCurrentR(), this.getCurrentC()+1)==true)
				{
					direction=3;
					this.setFaceDirection("E");
				}
				//Checks if the given cell is open or not, returns true if the given cell is open else return false
				else if(this.checkRobotCell(this.getCurrentR()-1, this.getCurrentC())==true)
				{
					direction=0;
					this.setFaceDirection("N");
				}
				//Checks if the given cell is open or not, returns true if the given cell is open else return false
				else if(this.checkRobotCell(this.getCurrentR(), this.getCurrentC()-1)==true)
				{
					direction=2;
					this.setFaceDirection("W");
				}


			}
			//Checks the direction that Right Hand Robot is Facing currently
			else if(this.getFaceDirection()=="N")
			{ 
				//Checks if the given cell is open or not, returns true if the given cell is open else return false
				if(this.checkRobotCell(this.getCurrentR(), this.getCurrentC()+1)==true)
				{
					direction=3;
					this.setFaceDirection("E");
				}
				//Checks if the given cell is open or not, returns true if the given cell is open else return false
				else if(this.checkRobotCell(this.getCurrentR()-1, this.getCurrentC())==true)
				{
					direction=0;
					this.setFaceDirection("N");
				}
				else if(this.checkRobotCell(this.getCurrentR(), this.getCurrentC()-1)==true)
				{
					direction=2;
					this.setFaceDirection("W");
				}
				//Checks if the given cell is open or not, returns true if the given cell is open else return false
				else if(this.checkRobotCell(this.getCurrentR()+1, this.getCurrentC())==true)
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

			//Creates an empty Space in the current Location after the Robot has made the move to another location

			this.setEmptyCell(this.getCurrentR(), this.getCurrentC());
			
			if(direction==0)
			{
				
				//Makes the actual Robot move to the desired destination in the MazeGrid

				this.setRobotCell(this.getCurrentR()-1, this.getCurrentC());

				
				//Updating the current Row position
				this.setCurrentR(this.getCurrentR()-1);


			}

			if(direction==1)
			{

				//Makes the actual Robot move to the desired destination in the MazeGrid

				this.setRobotCell(this.getCurrentR()+1, this.getCurrentC());

				//Updating the current Row position
				this.setCurrentR(this.getCurrentR()+1);

			}
			if(direction==2)
			{

				//Makes the actual Robot move to the desired destination in the MazeGrid

				this.setRobotCell(this.getCurrentR(), this.getCurrentC()-1);

				
				//Updating the current Column position
				this.setCurrentC(this.getCurrentC()-1);


			}
			if(direction==3)
			{

				//Makes the actual Robot move to the desired destination in the MazeGrid

				this.setRobotCell(this.getCurrentR(), this.getCurrentC()+1);

				
				//Updating the current Column position
				this.setCurrentC(this.getCurrentC()+1);

			}

		}

	}

