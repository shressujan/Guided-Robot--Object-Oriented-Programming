/**
 * This class extends the JPanel and creates a panel
 * Used to create a GUI for maze
 * Paint component in used in this class
 */
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MazePanel extends JPanel{

	private Maze maze;
	private Robot robot;
	private Color color;	
	private int height=500;
	private int width=500;
	private int recWid=20;
	private int recHeig=20;

	/**
	 * This method return the height of the panel
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * This method return the width of the panel
	 */
	public int getWidth() {
		return width;
	}
	public void setColor(Color incolor)
	{
		color = incolor;
	}

	/**
	 * This method returns the maze
	 * @return maze
	 */
	public Maze getMaze() {
		return maze;
	}
	public void setMaze(Maze maze) {
		this.maze = maze;
	}
	/**
	 * This method returns the Robot 
	 * @return Robot
	 */
	public Robot getRobot() {
		return robot;
	}
	/**
	 * This sets the value to the robot
	 */
	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	/**
	 * This is a constructor
	 */
	public MazePanel()
	{

	}
	/**
	 * This method is the paintComponent that paints the panel
	 */
	public void paintComponent(Graphics g)				
	{
		super.paintComponents(g);

		//Gets the number of rows and columns from the maze

		int rows= maze.getRows();
		int columns= maze.getColumns();
		try{
			for( int r=0;r<rows; r++)
			{
				for( int c=0; c<columns; c++)
				{
					if(maze.getCell(r, c)=='*')
					{
						g.setColor(color);
					}
					else if(maze.getCell(r, c)=='d')
					{
						g.setColor(Color.YELLOW);
					}
					else
					{
						g.setColor(Color.WHITE);
					}
					//Painting the maze in the panel

					g.fillRect(c*recWid, r*recHeig, recWid, recHeig);
				}
			}

			//Painting the Robot in the maze in the panel

			g.setColor(Color.RED);
			try{

				{
					g.fillOval(robot.getCurrentC()*recWid+3, robot.getCurrentR()*recHeig+3, recWid/2+3, recHeig/2+3);
				}
			}

			catch(NullPointerException ex)
			{

			}
		}
		catch(Exception e)
		{

		}
		repaint();

	}
}

