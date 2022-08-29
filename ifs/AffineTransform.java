package ifs;

/**
 * This class is the parent of all AffineTransforms. 
 *  
 * @author Jacob Carroll
 * @version 1.0
 * @since 1.8
 */

public interface AffineTransform {

	/** This method gets the name of the AffineTransform object.
	 * @return name of object which is a string
	 **/
	public String getName();

	/** This method gets the affine array of the AffineTransform object.
	 * @return affine 2d array of object which is a double.
	 **/
	public double[][] getAffine();

	/** This method gets the scale of the AffineTransform object.
	 * @return scale of object which is a double
	 **/
	public double getScale();

	/** This method gets the height of the AffineTransform object.
	 * @return height of object which is a int
	 **/
	public int getHeight();

	/** This method gets the width of the AffineTransform object.
	 * @return width of object which is a int
	 **/
	public int getWidth();

	/** This method gets the xoffset of the AffineTransform object.
	 * @return xoffset of object which is a int
	 **/
	public int getXoffset();

	/** This method gets the yoffset of the AffineTransform object.
	 * @return yoffset of object which is a int
	 **/
	public int getYoffset();

}