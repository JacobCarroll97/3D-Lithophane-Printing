package stl;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import stl.Facet;

/**
 * The purpose of this class is to add facets to make an solid
 *  
 * @author Jacob Carroll
 * @version 1.0
 * @since 1.8
 */

public class Solid{

	private String name;

	private List<Facet> facets = new ArrayList<Facet>();


	/**
	 * This is a no-arg constructor that sets the name to blank ("")
	 */
	public Solid()
	{
		name = "";
	}

	/**
	 * This constructor takes a name which is a string and sets the name of the solid
	 * @param name - String
	 */
	public Solid(String name)
	{
		this.name = name;
	}

	/**	
	 * This method will add a facet to the list that makes the solid. Returning true or false depending on outcome.
	 * @param facet - Facet
	 * @return true if the facet was added to the list that makes the solid, false if it didn't.
	 */

	public boolean addFacet(Facet facet)
	{
		facets.add(facet);
		return facets.contains(facet);
	}
	
	/**
	 * This method will add a facet to solid as long as there is 3 or more vertexes
	 * @param vertexes - var vertex (array of any number of vertexes)
	 * @return true if there was more then 3 or more vertexes, false if less than 3
	 */
	
	public boolean addFacet(Vertex ...vertexes)
	{
		if(3 > vertexes.length)
		{
			return false;
		}

		for (int i = 0; i < vertexes.length; i++) {
			if(3 <= vertexes.length - i)
			{
				Facet f1=new Facet(vertexes[i],vertexes[i+1],vertexes[i+2]);
				facets.add(f1);
			}
			if(5 == vertexes.length)
			{
				Facet f1=new Facet(vertexes[i],vertexes[i+2],vertexes[i+3]);
				facets.add(f1);
				Facet f2=new Facet(vertexes[i],vertexes[i+3],vertexes[i+4]);
				facets.add(f2);
				return true;
			}
			if(4 == vertexes.length)
			{			
				Facet f1=new Facet(vertexes[i],vertexes[i+2],vertexes[i+3]);
				facets.add(f1);
				return true;
			}
		}
		return true;
	}

	
	/**
	 * This method will format and return an string
	 * @return String - the formated (STL) text that will run in 3D print
	 */
	
	public String toString() 
	{

		String s = "";

		for(int i = 0; i <facets.size(); i++) {
			s += facets.get(i).toString();
		}

		return s;
	}

	
	/**
	 * This method takes a printWriter which has the file location. It will then write to the location in formatted form (STL)
	 * @param printWriter - pass in the printwriter with the file location
	 */
	public void print(PrintWriter printWriter)
	{

		printWriter.print("solid ");
		printWriter.print(name);
		for(int i = 0; i <facets.size(); i++) {

			printWriter.print(facets.get(i).toString());
		}
		printWriter.print("\nendsolid ");
		printWriter.print(name);
		printWriter.flush();  
		printWriter.close();  


	}

}
