/**
 *This Class extends the JFrame and creates a frame
 * Adds the panel to the frame
 * adds menus to the panel
 * Author:Sujan Shrestha
 */
import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageProducer;
import java.io.*;

import javax.swing.*;


public class MazeFrame extends JFrame {
	//List of private variables  that is used in this class

	private File file;
	private Maze maze;
	private Robot robot;
	private Color color=Color.BLUE;
	private MazePanel mazepanel;
	public boolean isTravelling;
	private int height=400;
	private int width= 400;

	private JMenuBar menuBar;
	//JMenu variables created
	private JMenu colorMenu;
	private JMenu fileMenu;
	private JMenu mazeMenu;
	private JMenu robotMenu;


	// Creates The ImageIcon variable

	private ImageIcon image;

	//Creates the private JMenuItem variables

	private JMenuItem solveMenuItem;
	private JMenuItem colorItem;
	private JMenuItem exitMenuItem;
	private JMenuItem rightRobotMenuItem ;
	private JMenuItem leftRobotMenuItem;
	private JMenuItem randomRobotMenuItem;
	private JMenuItem lookAheadRobotMenuItem;
	private JMenuItem ownStrategyRobotMenuItem;
	private JMenuItem memoryRobotMenuItem;
	private JMenuItem selectMaze;

	/**
	 * This is a constructor for this class
	 */
	public MazeFrame()
	{
		setTitle("ROBOT");		//sets the title to robot
		setSize(width, height);//sets the size of the mazeframe
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		image=new ImageIcon("mazesolve.jpg");
		isTravelling= false;

		//Create the menu bar and put it in the window

		JMenuBar bar = buildMenuBar();
		setJMenuBar(bar);

		setVisible(true);
	}

	/**
	 * Create a menu bar
	 * 
	 * @return The created menu bar
	 */
	private JMenuBar buildMenuBar(){
		// Create a menu bar

		// Call "buildColorMenu()" to create a menu and add it into the menu bar

		menuBar = new JMenuBar();
		colorMenu= buildColorMenu();
		colorMenu.setEnabled(false);

		// Call "buildFileMenu()" to create a menu and add it into the menu bar

		fileMenu = buildFileMenu();

		// Call "buildRobotMenu()" to create a menu and add it into the menu bar

		robotMenu= buildRobotMenu();
		robotMenu.setEnabled(false);

		// Call "buildMazeMenu()" to create a menu and add it into the menu bar

		mazeMenu= buildMazeMenu();
		mazeMenu.setEnabled(true);

		menuBar.add(fileMenu);
		menuBar.add(mazeMenu);
		menuBar.add(robotMenu);
		menuBar.add(colorMenu);

		return menuBar;
	}
	private JMenu buildColorMenu()
	{
		colorMenu= new JMenu("BONUS");
		colorMenu.setForeground(Color.BLUE);
		colorItem= new JMenuItem(" Choose Color");
		colorMenu.add(colorItem);

		// Hook up the menu items with the listener
		MyListener listener = new MyListener();

		colorItem.addActionListener(listener);
		return colorMenu;
	}
	/**
	 * This method builds the menuitems for the maze
	 * @returns the mazemenu
	 */
	private JMenu buildMazeMenu(){

		//Create the Menu
		mazeMenu= new JMenu("Maze");
		mazeMenu.setForeground(Color.BLUE);
		//Creating the menuItem
		selectMaze= new JMenuItem("Select Maze");
		selectMaze.setEnabled(true);
		selectMaze.setForeground(Color.BLUE);
		mazeMenu.add(selectMaze);

		// Hook up the menu items with the listener
		MyListener listener = new MyListener();

		selectMaze.addActionListener(listener);

		return mazeMenu;
	}
	/**
	 * This method is used to build the menuitems for the robotmenu
	 * @returns the robotmenu
	 */
	private JMenu buildRobotMenu(){

		// Creates the JMenu

		robotMenu= new JMenu("Robot");
		robotMenu.setForeground(Color.BLUE);
		// Create the menu items

		rightRobotMenuItem = new JMenuItem("Right Hand Robot");
		rightRobotMenuItem.setForeground(Color.RED);
		leftRobotMenuItem= new JMenuItem("Left Hand Robot");
		leftRobotMenuItem.setForeground(Color.BLUE);
		randomRobotMenuItem= new JMenuItem("Random Robot");
		randomRobotMenuItem.setForeground(Color.GRAY);
		lookAheadRobotMenuItem= new JMenuItem("Look Ahead Robot");
		lookAheadRobotMenuItem.setForeground(new Color(128,0,128));
		ownStrategyRobotMenuItem= new JMenuItem("Own Strategy Robot");
		ownStrategyRobotMenuItem.setForeground(new Color(0,100,0));

		memoryRobotMenuItem= new JMenuItem ("Memory Robot");
		memoryRobotMenuItem.setForeground(Color.BLUE);


		//Adding the Menuitems to the menu

		robotMenu.add(rightRobotMenuItem);
		robotMenu.add(leftRobotMenuItem);
		robotMenu.add(randomRobotMenuItem);
		robotMenu.add(lookAheadRobotMenuItem);
		robotMenu.add(ownStrategyRobotMenuItem);
		robotMenu.add(memoryRobotMenuItem);

		// Hook up the menu items with the listener

		MyListener listener = new MyListener();
		rightRobotMenuItem.addActionListener(listener);
		leftRobotMenuItem.addActionListener(listener);
		randomRobotMenuItem.addActionListener(listener);
		ownStrategyRobotMenuItem.addActionListener(listener);
		lookAheadRobotMenuItem.addActionListener(listener);
		memoryRobotMenuItem.addActionListener(listener);

		return robotMenu;

	}
	/**
	 * This method is used to build the fileMenu in the MenuBar
	 * @returns the filemenu
	 */
	private JMenu buildFileMenu(){

		// Creates the JMenu

		fileMenu = new JMenu("File");
		fileMenu.setForeground(Color.blue);

		// Create the menu items

		solveMenuItem = new JMenuItem(" Solve");
		solveMenuItem.setEnabled(false);
		solveMenuItem.setForeground(Color.BLUE);

		exitMenuItem = new JMenuItem(" EXIT");
		exitMenuItem.setForeground(Color.red);


		// Add these menu items into fileMenu

		fileMenu.add(solveMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);

		// Hook up the menu items with the listener

		MyListener listener = new MyListener();
		solveMenuItem.addActionListener(listener);
		exitMenuItem.addActionListener(listener);


		return fileMenu;
	}
	/**
	 * This class is used to listen to menu items in the menus when clicked
	 * It listens to the solvemenuitem, exitmenuitem, left, right, random, own strategy, look ahead robot item 
	 * And implements the respective action 
	 */
	public class MyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Checks for the items clicked in the JMenu

			if (e.getSource() == solveMenuItem)
			{

				//Call the runRobot method

				runRobot();
				repaint();
			}

			if( e.getSource() == colorItem)
			{
				//Will let you select color for the maze in real time
				color= JColorChooser.showDialog(null, "Your color", Color.WHITE);
				if(color==null)
				{
					color= Color.BLUE;
				}
				mazepanel.setColor(color);
				repaint();
				mazepanel.repaint();


			}

			//Checks if the exitMenuItem is clicked

			if(e.getSource() == exitMenuItem){
				System.exit(0);

			}

			// Checks if the Robot menu and menu items is clicked

			if(e.getSource()==rightRobotMenuItem)
			{

				robot= new RightHandRobot(maze);
				mazepanel.setRobot(robot);
				solveMenuItem.setEnabled(true);

				resetMaze();
			}
			if(e.getSource()==leftRobotMenuItem)
			{
				robot= new LeftHandRobot(maze);
				mazepanel.setRobot(robot);
				solveMenuItem.setEnabled(true);

				resetMaze();
			}
			if(e.getSource()==randomRobotMenuItem)
			{
				robot= new RandomRobot(maze);
				mazepanel.setRobot(robot);
				solveMenuItem.setEnabled(true);

				resetMaze();
			}
			if(e.getSource()==ownStrategyRobotMenuItem)
			{
				robot= new OwnStrategyRobot(maze);
				mazepanel.setRobot(robot);
				solveMenuItem.setEnabled(true);
				resetMaze();
			}
			if(e.getSource()==lookAheadRobotMenuItem)
			{
				robot= new TheLookAheadRobot(maze);
				mazepanel.setRobot(robot);
				solveMenuItem.setEnabled(true);
				resetMaze();
			}
			if(e.getSource()== memoryRobotMenuItem)
			{
				robot = new MemoryRobot(maze);
				mazepanel.setRobot(robot);
				solveMenuItem.setEnabled(true);

				resetMaze();
			}

			//Condition check for the selectMaze

			if(e.getSource()==selectMaze)
			{
				try
				{

					file=getFile();	

					//Sets the older mazepanel to null that new mazepanel can be set

					if(maze!=null)
					{
					//	mazepanel.setMaze(null);
						mazepanel.setVisible(false);
					}
					maze= new Maze(file);

					mazepanel= new MazePanel();
					mazepanel.setMaze(maze);
					
					//This sets the size of the mazeframe
					
					setSize(maze.getColumns()*20+18, maze.getRows()*20+70);
					mazepanel.setColor(color);
					colorMenu.setEnabled(true);
					robotMenu.setEnabled(true);	
					add(mazepanel);
					repaint();
					mazepanel.repaint();

				}
				catch (Exception x) {
					System.out.println("Exception: " + x.getMessage());
					System.exit(0);
				}		

			}

		}
	}
	/**
	 * This methods asks the user to choose the file 
	 * Gets the selected file
	 * @returns file
	 */
	public static File getFile()
	{
		JFileChooser chooser;
		try{

			// Get the filename using JFileChoose
			chooser = new JFileChooser();
			int status = chooser.showOpenDialog(null);
			if (status != JFileChooser.APPROVE_OPTION)
			{
				System.out.println("No File Chosen");
				System.exit(0);
			}
			return chooser.getSelectedFile();
		} catch (Exception e)
		{
			System.out.println("Exception: " + e.getMessage());
			System.exit(0);

		}
		return null; //should never get here, but makes compiler happy
	}
	/**
	 * This method runs or actually moves the robot in the maze
	 */
	public void runRobot()
	{
		isTravelling=true;
		try{

			Thread.sleep(200);
			for ( int k = 0; k < 1000000 && !robot.solved(); k++) 

				//this limits the robot's moves, in case it takes too long to find the exit.
			{
				int direction = robot.chooseMoveDirection();
				if (direction >=0)  //invalid direction is -1
					robot.move(direction);
				mazepanel.paintImmediately(0,0,mazepanel.getWidth(), mazepanel.getHeight());				
				Thread.sleep(50);

			}

			//Displays the image once the robot completes the Maze

			JOptionPane.showMessageDialog(null,"	Congratulation!! \nYou Just Finished the Maze","HURRAY!!!!",JOptionPane.INFORMATION_MESSAGE,image);
			solveMenuItem.setEnabled(false);

			isTravelling=false;

		}
		catch(Exception e)
		{
			System.out.println("This shouldn't happen.");
		}
	}
	/**
	 * This method resets the maze
	 */
	public void resetMaze()									
	{
		if(isTravelling==false && maze!=null)
		{
			//Calling the setMaze method from the maze
			maze.setMaze(file);

			repaint();
			mazepanel.repaint();

		}
	}
}








