import java.util.List;

/**
 * DataBlock.java
 * 
 *  This class represents a block of data for which you want to compute a hash.   
 * 
 * @author Jaylon Kiper
 * @version 1.0
 * Programming Project 4
 * FALL19
 *
 */
public class DataBlock{

	//Data being stored into this node.
	private final List<String> dataBlock;
	
	//This initializes the leaf node, which consists of the spcified block of data.
	public DataBlock(final List<String> blocks1and2) {
	
		this.dataBlock = blocks1and2;
		
	}//end DataBlock constructor
	
	//Returns the datablock associated with this leaf
	public List<String> getDataBlock(){
		
		return dataBlock;
		
	}//end getDataBlock method
	
	//Returns a string of the specified byte array, with the values represented in hex.
	
	private String toHexString(final String block) {
		
		final StringBuilder str = new StringBuilder();
		
		str.append("[");
		
		boolean comesFirst = true;
		
		for(int i = 0; i < block.length(); i++) {
			
			final byte b = (byte) i;
			
			if(comesFirst) {
			
				comesFirst = false;
				
			}//end if statement
			else {
				
				str.append(",");
				
			}//end else statement
			
			final int highValue = (b & 0xF0) >> 4;
			final int lowValue = b & 0x0F;
			
			str.append((char) ('0' + (highValue + (highValue / 10 * 7))));
			str.append((char) ('0' + (lowValue + (lowValue / 10 * 7))));
			
		}//end for loop
		
		str.append("]");
		
		
		return(str.toString());
		
	}//end toHexString method
	
	public String toString() {
		
		final StringBuilder str = new StringBuilder();
		
		for(String block: dataBlock) {
			
			str.append(toHexString(block));
			
		}//end for loop
		
		return(str.toString());
		
	}//end toString
	
}//end class
