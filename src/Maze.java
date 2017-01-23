/**
 * This class is instantiated in other classes
 * It scans the files and sets up the maze
 * Author: Sujan Shrestha
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Maze {

	private int rows;
	private int columns;
	private File fileName;
	private int startRow;
	private int startColumn;
	private int exitRow;
	private int exitcolumn;
	private char [][] mazeGrid=null;
	private String rowString="";

	/**
	 * This method returns the number of the Rows in the mazeGrid
	 * @return
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * This method returns the number of the column in the mazeGrid
	 * @return the column
	 */

	public int getColumns() {
		return columns;
	}

	/**
	 * This method returns the start of the row  for the robot in the mazeGrid
	 * @return the Starting row
	 */

	public int getStartRow() {
		return startRow;
	}

	/**
	 * This method returns the start of the column for the robot in the mazeGrid
	 * @return Starting column
	 */

	public int getStartColumn() {
		return startColumn;
	}

	/**
	 * This method returns the exit row for the robot in the mazeGrid
	 * @return Exitrow
	 */
	public int getExitRow() {
		return exitRow;
	}

	/**
	 * This method returns the exit column for the robot in the mazeGrid
	 * @return Exit Column
	 */

	public int getExitcolumn() {
		return exitcolumn;
	}

	/**
	 * This method returns the Cell for the given Row and given Column
	 * @param inRow
	 * @param inColumn
	 * @return the cell
	 */
	public char getCell(int inRow, int inColumn)
	{
		char currentCell=mazeGrid[inRow][inColumn];
		return currentCell;
	}

	/**
	 * This method returns the boolean value True if the cell is open and false if the cell is not empty
	 * @param inRow
	 * @param inColumn
	 * @return  boolean value for the openCell
	 */
	public boolean openCell( int inRow, int inColumn)
	{
		boolean open=false;

		//Checks if the input inRow and inColumn is valid or not and executes the next statement only if the input is valid

		if(inRow>=0 && inRow<rows && inColumn >=0 && inColumn < columns)
		{
			if(mazeGrid[inRow][inColumn]!='*'&& mazeGrid[inRow][inColumn]!='d')
			{
				open=true;
			}
		}
		return open;
	}
	/**
	 * This method sets the character in the specific cell for the given row and given column of the mazeGrid
	 * @param inRow
	 * @param inColumn
	 * @param newCh
	 */
	public void setcell(int inRow, int inColumn, char newCh)
	{

		mazeGrid[inRow][inColumn]=newCh;

	}

	/**
	 * This method returns the display for the mazeGrid
	 */
	public String toString()
	{
		String display="";
		for( int i=0; i<rows;i++)
		{

			for( int j=0;j< columns;j++)
			{
				display+=mazeGrid[i][j];
			}
			display+="\n";

		}
		return display;

	}
	/**
	 * This is the constructor which takes File input and scans the file for information and data
	 * @param inFilename
	 * @throws FileNotFoundException
	 */
	public Maze(File inFilename) throws FileNotFoundException
	{
		try
		{
			fileName=inFilename;
			//Creating an instance for the File Scanner to Scan the File
			Scanner inScan= new Scanner(fileName);
			//Loops until file has  no more data in it
			while(inScan.hasNext())
			{
				//Extracting the data from the given file

				rows=inScan.nextInt();
				columns=inScan.nextInt();
				startRow=inScan.nextInt();
				startColumn= inScan.nextInt();
				exitRow= inScan.nextInt();
				exitcolumn=inScan.nextInt();
				inScan.nextLine();
				mazeGrid= new char[rows][columns];
				for( int i=0; i<rows;i++)
				{
					rowString=inScan.nextLine();

					for( int j=0;j< columns;j++)
					{
						mazeGrid[i][j]=rowString.charAt(j);
					}
				}
			}
			inScan.close();
		}
		catch (Exception e)
		{
			System.out.println("Exception: " + e.getMessage());
			System.exit(0);
		}

	}
	/**
	 * This method sets the maze according the mazefile set in as a parameter
	 * @param file
	 */
	public void setMaze(File file)
	{
		if(file != null)
		{
		try
		{
			fileName=file;
			//Creating an instance for the File Scanner to Scan the File
			Scanner inScan= new Scanner(fileName);
			//Loops until file has  no more data in it
			while(inScan.hasNext())
			{
				//Extracting the data from the given file

				rows=inScan.nextInt();
				columns=inScan.nextInt();
				startRow=inScan.nextInt();
				startColumn= inScan.nextInt();
				exitRow= inScan.nextInt();
				exitcolumn=inScan.nextInt();
				inScan.nextLine();
				mazeGrid= new char[rows][columns];
				for( int i=0; i<rows;i++)
				{
					rowString=inScan.nextLine();

					for( int j=0;j< columns;j++)
					{
						mazeGrid[i][j]=rowString.charAt(j);
					}
				}
			}
			inScan.close();
		}
		catch (Exception e)
		{
			System.out.println("Exception: " + e.getMessage());
			System.exit(0);
		}
		}
		else
		{
			
		}
	}
}
