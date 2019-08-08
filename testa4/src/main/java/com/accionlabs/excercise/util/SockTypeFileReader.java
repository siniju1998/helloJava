package com.accionlabs.excercise.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.accionlabs.excercise.initializer.AppInitializer;
import com.accionlabs.excercise.model.LaundryBasket;

/*
 * this reads SocksList file and initializes LaundryBasket object
 * This class expects, the LaundryBasket is initialized outside the class
 */
public class SockTypeFileReader {
	
	final static Logger logger = Logger.getLogger(SockTypeFileReader.class);
	public void readSockTypes(LaundryBasket laundryBasket, final Properties prop) {		
		String strLine;	
		logger.info("reading sockList file.");
		
		try  (InputStream ios = new FileInputStream(prop.getProperty("FILE_PATH"))) {
			// read socks list file
		    BufferedReader bufReader = new BufferedReader(new InputStreamReader(ios));
			while ((strLine = bufReader.readLine()) != null) { // write into model object					
					laundryBasket.addSock(strLine);					
			}
			logger.info("Reading sockList file complete. Number of unique entries in sockListfile is: "+laundryBasket.getSockCount());		
		} catch(Exception e) {			
				StringWriter sw = new StringWriter();				
				e.printStackTrace(new PrintWriter(sw));
				logger.error(sw.toString()); // need to log into log4j
				return;
		} 
		
	}
}
