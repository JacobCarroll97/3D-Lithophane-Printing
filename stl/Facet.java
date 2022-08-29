package stl;

/**
 * The purpose of this class is to make a facet out of 3 vertexes.
 *  
 * @author Jacob Carroll
 * @version 1.0
 * @since 1.8
 */

public class Facet{

	private Vertex v1;
	private Vertex v2;
	private Vertex v3;

	private Vertex normal;

	/**
	 * This constructor will take 3 vertexes and assign them to this class.
	 * It will then calculator the normal of the vertexes
	 * 
	 * @param v1 - Vertex
	 * @param v2 - Vertex
	 * @param v3 - Vertex
	 */

	public Facet(Vertex v1,Vertex v2,Vertex v3)
	{
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;

		normal = Vertex.calcNormal(v1, v2, v3);
	}

	/**
	 * This method will output the values in the vertexes in string format
	 * @return String - which contains the normal vertex and the 3 vertexes that made the normal
	 */
	public String toString() 
	{
		String s = " ";

		s += "\nfacet normal ";
		s += normal;

		s +="\n outer loop\n  vertex ";

		s += v1;

		s +="\n  vertex ";
		s += v2;

		s +="\n  vertex ";
		s += v3;

		s += "\n endloop\nendfacet";

		return s;
	}

}
