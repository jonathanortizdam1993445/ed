package org.institutoserpis.ed;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayTest {

	@Test
	public void menor() {
		// fail("Not yet implemented");
	
		assertEquals(5,Array.menor(new int[] {5,9,6,14}));
		assertEquals(3,Array.menor(new int[] {5,9,3,14}));
		assertEquals(7,Array.menor(new int[] {9,8,12,7}));
	}

	@Test
	public void index0f(){
		assertEquals(0,Array.indexOf (new int[] {2,21,9,13}, 21));
		assertEquals(0,Array.indexOf (new int[] {2,21,9,13}, 7));
		assertEquals(0,Array.indexOf (new int[] {2,21,9,13}, 13));
	}
	
	@Test
	public void index0f_empty (){
		assertEquals(-1,Array.indexOf (new int[] {2,21,9,13}, 33));
		
	}
	
}
