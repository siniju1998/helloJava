package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FirstServiceImpl implements FirstService{

	/*Following puntuation symbols are considered by the method
	 *  . , ? ! ; : - ( ) { } [ ] " 
	 */
	
	@Override
	public String[] processString(final String inputStr) {
		if ((inputStr == null ) || (inputStr.isEmpty())) {
			return null;
		}
		
		List<String> finalArrayList = new ArrayList<String>();
		String[] inputStrArray;
		
		// remove puntuation symbols from input String 
		String inputStrTemp = inputStr.replaceAll("[\\.\\,\\?\\!\\;\\:\\-\\(\\)\\{\\}\\[\\]\"]", "");
		
		// break temp string into array
		if (inputStrTemp.equals("") == false) {  // there is a change input String can be "". 
			inputStrArray = inputStrTemp.trim().split("\\s+");
		} else {
			inputStrArray = new String[0];
		}
		
		/* There is a chance that single quotes may not be added in between words. 
		 * Example (1) Test ' me 
		 *         (2)  ''
		 * remove those words
		 */
		for(String myWord : inputStrArray) {
			if ((myWord.equals("'") == false) && (myWord.equals("''") == false)) {
				finalArrayList.add(myWord);
			}  
		}
		// return array
		return (String []) finalArrayList.toArray(new String[finalArrayList.size()]);
	}
	
	
}
