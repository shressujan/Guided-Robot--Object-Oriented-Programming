
public abstract class  FacingRobot extends Robot {
	
	private String faceDirection="S";
	
	
/**
 * This is the constructor for the FacingRobot class
 * @param inmaze
 */
	public FacingRobot(Maze inmaze) {
		super(inmaze);
		
	}
/**
 * This method does nothing here
 */

	public abstract int chooseMoveDirection();

	/**
	 * This method does nothing here
	 */
	
	public abstract void move(int direction);
	/**
	 * This method returns the direction of the robot that its facing currently
	 * @return
	 */
	public String getFaceDirection() {
		return faceDirection;
	}
/**
 * This method sets the current facing direction for the robot
 * @param infaceDirection
 */
	public void setFaceDirection(String infaceDirection) {
		faceDirection = infaceDirection;
	}

}
