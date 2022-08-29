import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import ifs.AffineTransform;
import ifs.IfsCreator;
import stl.Solid;
import stl.StlImage;

/**
 * The purpose of this class is to be the main of the project. 
 *  
 * @author Jacob Carroll
 * @version 1.0
 */

public class IfsStlFile {

	public static void main(String[] args) throws FileNotFoundException {

		IfsCreator tempTrans = new IfsCreator();

		AffineTransform affines[] = tempTrans.getTransforms();

		System.out.print("Available fractal images are:");

		System.out.println("");

		int menuCount = 1;

		//get all the choices for the menu
		for(int i = 0; i < affines.length; i++) {
			System.out.print("\t");
			System.out.print(menuCount);
			System.out.print(" ");
			menuCount++;
			System.out.println(affines[i].getName());
		}

		System.out.print("What image number do you want? ");

		Scanner input = new Scanner(System.in);

		//get the user choice
		int choice = input.nextInt();

		while(choice > affines.length || choice < 1)
		{
			System.out.printf("Please select a value from 1 to "+affines.length+" :");
			choice = input.nextInt();
		}

		//creates a creator to call generateIfs
		IfsCreator creator = new IfsCreator();

		int[][] tempArray = creator.generateIfs(affines[choice-1]);

		//creates an StlImage with the required params
		StlImage tempImage = new StlImage(0.8,4.0);

		//make the solid object
		Solid solid = tempImage.createSolid(tempArray,affines[choice-1].getName());

		//make the print writer
		PrintWriter printerWriter = null; 

		//set the printerwriter file location
		printerWriter = new PrintWriter(new File("C:\\temp\\"+affines[choice-1].getName()+".stl"));

		//pass in printerwriter for the solid to print to location
		solid.print(printerWriter);

		input.close();

		System.out.print("Done");
	}

}
