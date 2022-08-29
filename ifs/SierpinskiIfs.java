package ifs;

/**
 * This class is the child of AffineTransform 
 * and will set all the variable to make a
 * SierpinkskiIfs
 * @author Jacob Carroll
 * @version 1.0
 * @since 1.8
 */

public class SierpinskiIfs implements AffineTransform {

	private String name = "Sierpinski Gasket";
	private double[][] affine = new double[][]{
		{ .50, 0, 0, .50, 0, 0, .33},
		{ .50, 0, 0, .50, 0, .50, .33},
		{ .50, 0, 0, .50, .43, .25, .34}
	};
	private double scale = -500;
	private int height = 449;
	private int width = 519;
	private int xOffset = 439;
	private int yOffset = 509;

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
