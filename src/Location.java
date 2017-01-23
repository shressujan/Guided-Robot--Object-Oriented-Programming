/**
 * This class extends the Arraylist of java
 * It has a constructor that takes in row and columns'
 * returns row and column
 * 
 *Note: I have not used this class 
 */
import java.util.ArrayList;


public class Location <T > extends java.util.ArrayList<T>
{
	private int row;
	private int column;
	
	public Location(int inrow, int incol)
	{
		row= inrow;
		column= incol;
	}

	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}

}
