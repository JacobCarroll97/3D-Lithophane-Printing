package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import stl.Vertex;

class VertexTest {

	static Vertex v1;
	static Vertex v2;
	static Vertex v3;
	static Vertex v4;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		v1 = new Vertex(0,0,0);
		v2 = new Vertex(1,0,0);
		v3 = new Vertex(0,1,0);
		v4 = new Vertex(0,0,1);
	}

	@Test
	void test1() {

		assertEquals(v4.toString(), Vertex.calcNormal(v1,v2,v3).toString());
	}
	@Test
	void test2() {

		assertEquals(v2.toString(), Vertex.calcNormal(v1,v3,v4).toString());
	}
	@Test
	void test3() {

		assertEquals(v3.toString(), Vertex.calcNormal(v1,v4,v2).toString());
	}

}
