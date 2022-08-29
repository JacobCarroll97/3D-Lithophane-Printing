package ifs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class is the child of AffineTransform 
 * and will read all the variables from a file
 * and set them to make what ever Ifs object you
 * give it.
 * @author Jacob Carroll
 * @version 1.0
 * @since 1.8
 */

public class FileIfs implements AffineTransform  {

	private String name = "";
	private double[][] affine;
	private double scale;
	private int height;
	private int width;
	private int xOffset;
	private int yOffset;

	/**
	 * This constructor will take in a file location in string 
	 * format and will read through the file to set all the variable 
	 * needed to make an Ifs
	 * @param ifs - this is the ifs that will be rendered into a fractal
	 */

	public FileIfs(String ifs) throws FileNotFoundException{

		File file = new File(ifs);

		try (Scanner input = new Scanner(file)) {

			//while loop to parse each line to check if it has any of the
			//required variables and if it does set them in this class
			while(input.hasNextLine()) {

				String freshInput=input.next();
				if("affine".equals(freshInput)) 
				{
					//x is the variable that contains the number of rows needed for the array
					int x = input.nextInt();;
					//logic to read in an affine list using x
					affine = new double[x][7];
					for(int i = 0; i < x; i++) {
						for(int j = 0; j < 7; j++) {
							affine[i][j] += input.nextDouble();
						}
					}
				}
				else if("yOffset".equals(freshInput)) 
				{
					yOffset += input.nextInt();
				}
				else if("xOffset".equals(freshInput)) 
				{
					xOffset += input.nextInt();
				}
				else if("width".equals(freshInput)) 
				{
					width += input.nextInt();
				}
				else if("height".equals(freshInput)) 
				{
					height += input.nextInt();
				}
				else if("scale".equals(freshInput)) 
				{
					scale += input.nextInt();
				}
				else if("name".equals(freshInput)) 
				{
					name += input.nextLine().trim();
				}
			}
		}
	}

	public String getName()
	{
		return name;
	}

	public double[][] getAffine()
	{
		return affine;
	}

	public double getScale()
	{
		return scale;
	}

	public int getHeight()
	{
		return height;
	}

	public int getWidth()
	{
		return width;
	}

	public int getXoffset()
	{
		return xOffset;
	}

	public int getYoffset()
	{
		return yOffset;
	}

}
