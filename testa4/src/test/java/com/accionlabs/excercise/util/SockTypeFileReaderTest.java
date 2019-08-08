package com.accionlabs.excercise.util;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accionlabs.excercise.model.LaundryBasket;

public class SockTypeFileReaderTest {
	
	Properties prop = new Properties();
	
	@Before
	public void setUp() throws Exception {
		prop.setProperty("FILE_PATH", "src/test/resources/SocksListTest.txt");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testReadSockTypes() {
		LaundryBasket laundryBasket = new LaundryBasket();
		SockTypeFileReader sockTypeFileReader = new SockTypeFileReader();
		sockTypeFileReader.readSockTypes(laundryBasket, prop);
		assertEquals("Populated Model Object", 6, laundryBasket.getSockCount());		
	}

}
