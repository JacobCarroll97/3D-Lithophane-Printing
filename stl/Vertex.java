package stl;
import java.text.DecimalFormat;

/**
 * The purpose of this class is to make vertexs.
 * It will take in 3 doubles and can calculate the normal of the vertex.
 * It also output the doubles of the vertex
 *  
 * @author Jacob Carroll
 * @version 1.0
 * @since 1.8
 */

public class Vertex {

	private double x = 0;
	private double y = 0;
	private double z = 0;

	private DecimalFormat df = new DecimalFormat("#.##");


	/**
	 * This constructor will take 3 doubles and set the variables in Vertex
	 * @param x - double
	 * @param y - double
	 * @param z - double
	 */
	
	public Vertex(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	
	/**
	 * This method will take 3 vertexes and calculate the normal vertex.
	 * @param v1 - Vertex
	 * @param v2 - Vertex
	 * @param v3 - Vertex
	 * @return normal Vertex
	 */
	
	public static Vertex calcNormal(Vertex v1, Vertex v2, Vertex v3) 
	{ 
		double a1 = v2.x - v1.x;
		double b1 = v2.y - v1.y;
		double c1 = v2.z - v1.z;
		double a2 = v3.x - v1.x;
		double b2 = v3.y - v1.y;
		double c2 = v3.z - v1.z;
		double a = b1 * c2 - b2 * c1; 
		double b = a2 * c1 - a1 * c2; 
		double c = a1 * b2 - b1 * a2; 

		double i = a / Math.sqrt((a*a + b*b + c*c));
		double o = b / Math.sqrt((a*a + b*b + c*c));
		double p = c / Math.sqrt((a*a + b*b + c*c));

		Vertex vN = new Vertex(i,o,p);

		return vN;
	} 

	/**
	 * This method will add the doubles x,y,z to string and return it.
	 * @return string - which are the 3 doubles that make the vertex.
	 **/

	public String toString()
	{
		String s = "";

		s += df.format(x);
		s += " ";
		s += df.format(y);
		s += " ";
		s += df.format(z);

		return s;
	}
}


