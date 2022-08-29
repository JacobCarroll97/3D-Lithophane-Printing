package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import stl.Facet;
import stl.Solid;
import stl.Vertex;

class SolidTest {

	static Vertex v1;
	static Vertex v2;
	static Vertex v3;
	static Vertex v4;
	static Vertex v5;
	static Vertex v6;
	static Vertex v7;
	static Vertex v8;
	static Vertex v9;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		v1 = new Vertex(0,0,0);
		v2 = new Vertex(1,0,0);
		v3 = new Vertex(0,1,0);
		v4 = new Vertex(0,0,1);
		v5 = new Vertex(1,1,0);
		v6 = new Vertex(1,0,1);
		v7 = new Vertex(0,1,1);
		v8 = new Vertex(1,1,1);
		v9 = new Vertex(0.5,0.5,0.5);
	}

	@Test
	void testInvalid() {

		Solid solid = new Solid();
		assertFalse(solid.addFacet(),"If this fails this means the method is not working with no parameters");

		assertFalse(solid.addFacet(v1),"If this fails this means the method is not working with 1 parameters");

		assertFalse(solid.addFacet(v1,v2),"If this fails this means the method is not working with 2 parameters");

		Solid solidEmpty = new Solid();
		assertEquals(solidEmpty.toString(), solid.toString(),"If this fails it means less than 3 parameters are getting added to solid by the method");

	}

	@Test
	void test3() {

		Solid solid = new Solid();
		assertTrue(solid.addFacet(v1,v2,v3),"If this fails this means the method is not working with 3 parameters");

		Solid solid2 = new Solid();
		Facet facet = new Facet(v1,v2,v3);
		solid2.addFacet(facet);

		assertEquals(solid.toString(), solid2.toString(), "If this fails this means the two different adding methods aren't doing the same thing");

	}

	@Test
	void test4() {

		Solid solid = new Solid();
		assertTrue(solid.addFacet(v1,v2,v3,v4),"If this fails this means the method is not working with 4 parameters");

		Solid solid2 = new Solid();
		Facet facet = new Facet(v1,v2,v3);
		solid2.addFacet(facet);
		Facet facet2 = new Facet(v1,v3,v4);
		solid2.addFacet(facet2);

		assertEquals(solid.toString(), solid2.toString(), "If this fails this means the two different adding methods aren't doing the same thing");

	}

	@Test
	void test9() {

		Solid solid = new Solid();
		assertTrue(solid.addFacet(v1,v2,v3,v4,v5,v6,v7,v8,v9),"If this fails this means the method is not working with 4 parameters");

		Solid solid2 = new Solid();
		Facet facet1 = new Facet(v1,v2,v3);
		solid2.addFacet(facet1);
		Facet facet2 = new Facet(v2,v3,v4);
		solid2.addFacet(facet2);
		Facet facet3 = new Facet(v3,v4,v5);
		solid2.addFacet(facet3);
		Facet facet4 = new Facet(v4,v5,v6);
		solid2.addFacet(facet4);
		Facet facet5 = new Facet(v5,v6,v7);
		solid2.addFacet(facet5);
		Facet facet6 = new Facet(v6,v7,v8);
		solid2.addFacet(facet6);
		Facet facet7 = new Facet(v7,v8,v9);
		solid2.addFacet(facet7);


		assertEquals(solid.toString(), solid2.toString(), "If this fails this means the two different adding methods aren't doing the same thing");

	}

}
