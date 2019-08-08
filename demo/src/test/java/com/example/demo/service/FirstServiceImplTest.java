package com.example.demo.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FirstServiceImplTest {
	String testString;
	@Before
	public void setUp() throws Exception {
		testString = "Dad said: \"It's great to see you, now let's go together\" ";
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testProcessString() {
		
		FirstService firstService = new FirstServiceImpl();
		String[] outputStr = firstService.processString(testString);
		assertEquals("Testing for apostrophe failed", 11, outputStr.length);
		
	}

}
