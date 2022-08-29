package ifs;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class will generate Ifs you give it and can return
 * the transforms available affines.
 * @author Jacob Carroll
 * @version 1.0
 * @since 1.8
 */

public class IfsCreator {

	//the position to do the math in generateIfs
	final static private int A = 0;
	final static private int B = 1;
	final static private int C = 2;
	final static private int D = 3;
	final static private int E = 4;
	final static private int F = 5;
	final static private int PROB = 6;

	/**
	 * This method will make the list of AffineTransform and return it.
	 * @return name of object which is a string
	 **/

	public AffineTransform[] getTransforms() throws FileNotFoundException {
		AffineTransform[] affineIfs = new AffineTransform[4];

		affineIfs[0] = new BarnsleyFernIfs();
		affineIfs[1] = new SierpinskiIfs();
		affineIfs[2] = new MapleIfs();
		affineIfs[3] = new FileIfs("C:\\temp\\GoldenDragon.ifs");

		return affineIfs;
	}



	/**
	 * This method will take the object of AffineTransform the user wants
	 * and will generate the Ifs array and return it.
	 * @param affineIfs	
	 * 			The AffineTransform object you wish to have generated
	 * @return int 2d array of generated Ifs
	 **/

	public int[][] generateIfs(AffineTransform affineIfs){

		
		//make an array with the width and height of the object
		int[][] output = new int[affineIfs.getWidth()][affineIfs.getHeight()];
		double x = 0;
		double y = 0;

		//for loop to randomly generate Ifs
		for(int i=0; i<(affineIfs.getWidth()*affineIfs.getHeight()); i++)
		{
			double random=Math.random();

			int count = 0;

			double[][] affine;
			affine = affineIfs.getAffine();

			//while loop to check random number against probability 
			while(random > affine[count][PROB]) {
				random -= affine[count][PROB];
				count++;
			}

			{
				//the math to make the ifs
				double u = affine[count][A]*x+affine[count][B]*y+affine[count][E];
				double v = affine[count][C]*x+affine[count][D]*y+affine[count][F];
				x = u;
				y = v;
				int xDisp = (int)(x*affineIfs.getScale()+affineIfs.getXoffset());
				int yDisp = (int)(y*affineIfs.getScale()+affineIfs.getYoffset());
				output[yDisp][xDisp]++;
			}

		}
		return output;
	}
}
