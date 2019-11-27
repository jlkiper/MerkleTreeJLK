import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * DataReader.java
 * 
 *  This class will read the file and divide it into DataBlocks (one for each line). 
 * 
 * @author Jaylon Kiper
 * @version 1.0
 * Programming Project 4
 * FALL19
 *
 */
public class DataReader {
		
	public String readFile(String inputFileName) {
		
		StringBuilder sb = new StringBuilder();
		
		String str = " ";
		
		List<String> list = new ArrayList<String>();
		
		BufferedReader reader;
		
		//Searches for text file known as movies.txt.
		try {
			
			reader = new BufferedReader(new FileReader(inputFileName));
			
			while(str != null){
				
				str = reader.readLine();
				sb.append(str);
				sb.append(System.lineSeparator());
				str = reader.readLine();
				
				if(str == null)
					break;
				list.add(str);
				
			}//end while loop
			
		} 
		catch (IOException e){
			
			e.printStackTrace();
			
		}//end catch
		
		return inputFileName;
		
	}//end readFile
	
}//end class
