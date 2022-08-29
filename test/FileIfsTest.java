package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ifs.FileIfs;

class FileIfsTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	//Will test to file with different order are parameters and see if they read in correctly
	@Test
	void test() throws FileNotFoundException {
		//File 1
		FileIfs affineIfs1 = new FileIfs("C:\\temp\\GoldenDragon.ifs");
		
		//File 2
		FileIfs affineIfs2 = new FileIfs("C:\\temp\\GoldenDragonRO.ifs");
		
		//Checks if the names is the same
		String name1 = affineIfs1.getName();
		String name2 = affineIfs2.getName();
		
		assertEquals(name1, name2);
		
		//Checks if the affines are the same
		for (int i = 0; i < affineIfs1.getAffine().length; i++) {
			for (int j = 0; j < affineIfs1.getAffine()[i].length; j++) 
			{
		
				double affine1 = affineIfs1.getAffine()[i][j];
				double affine2 = affineIfs2.getAffine()[i][j];
				
				assertEquals(affine1, affine2);
			
			}
		}
		
		//Checks if the scales are the same
		double scale1 = affineIfs1.getScale();
		double scale2 = affineIfs2.getScale();
		
		assertEquals(scale1, scale2);
		
		//Checks if the heights are the same
		double height1 = affineIfs1.getHeight();
		double height2 = affineIfs2.getHeight();
		
		assertEquals(height1, height2);
		
		//Checks if the widths are the same
		double width1 = affineIfs1.getWidth();
		double width2 = affineIfs2.getWidth();
		
		assertEquals(width1, width2);
		
		//Checks if the xOffset is the same
		double xOffset1 = affineIfs1.getXoffset();
		double xOffset2 = affineIfs2.getXoffset();
		
		assertEquals(xOffset1, xOffset2);
		
		//Checks if the yOffset is the same
		double yOffset1 = affineIfs1.getYoffset();
		double yOffset2 = affineIfs2.getYoffset();
		
		assertEquals(yOffset1, yOffset2);
		
	}

}
