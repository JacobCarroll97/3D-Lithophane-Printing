package ifs;

/**
 * This class is the child of AffineTransform 
 * and will set all the variable to make a
 * MapleIfs
 * @author Jacob Carroll
 * @version 1.0
 * @since 1.8
 */

public class MapleIfs implements AffineTransform {

	private String name = "Maple Leaf";
	private double[][] affine = new double[][]{
		{ .51, 0, .01, .14, 1.31, .08, .1},
		{ .50, -.45, .52, .43, .75, -1.49,.35},
		{ .47, .47, -.49, .45, .74, 1.62, .35},
		{ .51, 0, 0, .49, -1.62, -.02, .20}
	};
	private double scale = 100;
	private int height = 702;
	private int width = 885;
	private int xOffset = 340;
	private int  yOffset = 445;

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
