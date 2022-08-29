package ifs;

/**
 * This class is the child of AffineTransform 
 * and will set all the variable to make a
 * BarnsleyFernIfs.
 * @author Jacob Carroll
 * @version 1.0
 * @since 1.8
 */


public class BarnsleyFernIfs implements AffineTransform {

	private String name = "Barnsley Fern";
	private double[][] affine = new double[][]{
		{ 0, 0, 0, .16, 0, 0, .01},
		{ .85, .04, -.04, .85, 0, 1.60,.85},
		{ .20, -.26, .23, .22, 0, 1.60, .07},
		{ -.15, .28, .26, .24, 0, .44, .07}
	};
	private double scale = 100;
	private int height = 503;
	private int width = 1019;
	private int xOffset = 228;
	private int yOffset = 10;

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
