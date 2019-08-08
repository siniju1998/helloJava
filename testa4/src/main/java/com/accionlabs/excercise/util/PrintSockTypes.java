package com.accionlabs.excercise.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;

import com.accionlabs.excercise.model.LaundryBasket;

/*
 * This class identifies socks with Odd count or event count, print those socks
 */
public class PrintSockTypes {
	
	final static Logger logger = Logger.getLogger(SockTypeFileReader.class);
	public void printSockTypes(LaundryBasket laundryBasket, final Properties prop) {
		
		int modNumb=-1;		
		int modVal; // mod variable to determine odd or even
		boolean oddEvenCountFound = false;
		
		try {
		// initalize mod variable, depending on property set 
		if (prop.getProperty("READ_ONLY").equals("ODD")) {
			modNumb =3;
		} else  if (prop.getProperty("READ_ONLY").equals("EVEN")) {
			modNumb =2;
		}

		// modVal would have been initialized by now.
		logger.info("Socks with "+prop.getProperty("READ_ONLY") + " count are...");		
		Set<String> sockTypes = laundryBasket.getSockTypes();
		
		// identify socks with odd/even count
		for(String sockType: sockTypes) {		
			modVal = (laundryBasket.getSockTypeCount(sockType)  % modNumb);
			if (modVal == 0) {
				logger.info(sockType);	// write into console
				oddEvenCountFound = true;
			}
		}
		// Not even single socks found, display appropriate message
		if (!oddEvenCountFound ) {
			logger.info("No Socks with "+prop.getProperty("READ_ONLY") + " count found.");
		} 
		logger.info("End of socks listing");
		
		} catch(Exception e) {
			StringWriter sw = new StringWriter();				
			e.printStackTrace(new PrintWriter(sw));
			logger.error(sw.toString()); // need to log into log4j
		}
	}
}
