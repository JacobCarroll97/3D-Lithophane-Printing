package stl;

/**
 * The class will create an STL Image of a solid object
 *  
 * @author Jacob Carroll
 * @version 1.0
 * @since 1.8
 */

public class StlImage {

	private double minThick;
	private double thickScale;
	private double scale = 0.1;
	private double maxValue;

	/**
	 * This constructor takes in 2 doubles one a min and the other a max.
	 * @param min - double
	 * @param max - double
	 */
	
	public StlImage(double min, double max)
	{
		minThick = min;
		thickScale = max-min;
	}

	
	/**
	 * This method will make a solid of desired name and make call to make all the vertexes.
	 * After it makes the vertexes of the object it will add the facet to the solid.
	 * Once done it will return the solid.
	 * @param matrix - int 2d array
	 * @param solidName - string of solid name
	 * @return Will return the solid object
	 */
	public Solid createSolid(int[][] matrix,String solidName)
	{
		Solid Solid = new Solid(solidName);

		for (int i = 0; i < matrix.length-1; i++) {
			for (int j = 0; j < matrix[i].length-1; j++) {

				if(maxValue < matrix[i][j])
				{
					maxValue = matrix[i][j];
				}

			}
		}
		for (int i = 0; i < matrix.length-1; i++) {
			for (int j = 0; j < matrix[i].length-1; j++) {

				Vertex topV1 = createIfsVertex(i ,j,matrix[i][j]);
				Vertex topV2 = createIfsVertex(i+1,j,matrix[i+1][j]);
				Vertex topV3 = createIfsVertex(i+1,j+1,matrix[i+1][j+1]);
				Vertex topV4 = createIfsVertex(i,j+1,matrix[i][j+1]);
				Solid.addFacet(topV1,topV2,topV3,topV4);
			}
		}
		Vertex side1V1 = new Vertex(0,0,0);
		Vertex side1V2 = new Vertex(matrix.length * scale,0,0);
		Vertex side1V3 = new Vertex(matrix.length * scale,0,minThick);
		Vertex side1V4 = new Vertex(0,0,minThick);
		Solid.addFacet(side1V1,side1V2,side1V3,side1V4);

		Vertex side2V1 = new Vertex(0,matrix[0].length * scale,0);
		Vertex side2V2 = new Vertex(0,0,0);
		Vertex side2V3 = new Vertex(0,0,minThick);
		Vertex side2V4 = new Vertex(0,matrix[0].length * scale,minThick);
		Solid.addFacet(side2V1,side2V2,side2V3,side2V4);

		Vertex side3V1 = new Vertex(matrix.length * scale,0,0);
		Vertex side3V2 = new Vertex(matrix.length * scale,matrix[0].length * scale,0);
		Vertex side3V3 = new Vertex(matrix.length * scale,matrix[0].length * scale,minThick);
		Vertex side3V4 = new Vertex(matrix.length * scale,0,minThick);
		Solid.addFacet(side3V1,side3V2,side3V3,side3V4);

		Vertex side4V1 = new Vertex(matrix.length * scale,matrix[0].length * scale,0);
		Vertex side4V2 = new Vertex(0,matrix[0].length * scale,0);
		Vertex side4V3 = new Vertex(0,matrix[0].length * scale,minThick);
		Vertex side4V4 = new Vertex(matrix.length * scale,matrix[0].length * scale,minThick);
		Solid.addFacet(side4V1,side4V2,side4V3,side4V4);

		Vertex botV1 = new Vertex(0,0,0);
		Vertex botV2 = new Vertex(0,matrix[0].length * scale,0);
		Vertex botV3 = new Vertex(matrix.length * scale,matrix[0].length * scale,0);
		Vertex botV4 = new Vertex(matrix.length * scale,0,0);
		Solid.addFacet(botV1,botV2,botV3,botV4);

		return Solid;
	}

	/**
	 * This method takes in 3 doubles and makes a vertex of the wanted size
	 * @param x - double
	 * @param y - double 
	 * @param z - double 
	 * @return returns the vertex which was scaled to the wanted size
	 */
	
	private Vertex createIfsVertex(double x, double y, double z)
	{
		double thickness = minThick + thickScale * Math.sqrt(z/maxValue);
		Vertex v = new Vertex(x*scale,y*scale,thickness);
		return v;
	}
}
