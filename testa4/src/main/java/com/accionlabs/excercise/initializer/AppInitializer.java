package com.accionlabs.excercise.initializer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.accionlabs.excercise.model.LaundryBasket;
import com.accionlabs.excercise.util.PrintSockTypes;
import com.accionlabs.excercise.util.SockTypeFileReader;

public class AppInitializer {
	Properties prop = new Properties();
	final static Logger logger = Logger.getLogger(AppInitializer.class);
	
	private boolean initialize() {
		logger.info("reading property file");
		try (InputStream input = this.getClass().getResourceAsStream("/config.properties")) {        	
	        if (input == null) {
	            logger.error("Sorry, unable to find config.properties");
	            return false;
	        }
	
	        //load a properties file from class path, inside static method
	        prop.load(input);
	
	        // validate property FILE_PATH
			if  (   (prop.getProperty("FILE_PATH") == null) || 
					(prop.getProperty("FILE_PATH").equals("") ))	{				
				logger.error("Empty FILE_PATH property set. Aborting launching app.");
				return false;
			}

			
	        //validate propertie READ_ONLY
			if (        (prop.getProperty("READ_ONLY").equals("ODD") == false) 
					&&  (prop.getProperty("READ_ONLY").equals("EVEN") == false)) {
				logger.error("Not able to understand READ_ONLY property set. Value set is " + prop.getProperty("READ_ONLY") + " Aborting launching app.");
				return false;
			}
			logger.info("reading property file complete.");
	    } catch (IOException ex) {
	        ex.printStackTrace();
	        return false;
	    }
		return true;
	}
	
	public void launchApp() {
		if (initialize() == false) {			
			return;
		}
		LaundryBasket laundryBasket = new LaundryBasket();
        SockTypeFileReader sockReader = new SockTypeFileReader();
        PrintSockTypes printSockTypes = new PrintSockTypes();
        sockReader.readSockTypes(laundryBasket,prop);
        printSockTypes.printSockTypes(laundryBasket, prop);
	}
	
}
