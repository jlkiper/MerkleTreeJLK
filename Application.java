import java.io.*;
import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Application.java
 * 
 * This class should contain the main method that launches your program; 
 * it should prompt the user for a file to hash; then it should instantiate/execute 
 * a DataReader which will create the blocks. Once the blocks are created, the main 
 * method should instantiate and execute a MerkleTree which will consume the DataBlocks 
 * and compute the hashes. As each hash is computed, it should be printed out to the screen 
 * (as a way to ensure it is working). 
 * 
 * @author Jaylon Kiper
 * @version 1.0
 * Programming Project 4
 * FALL19
 *
 */
public class Application {

	private static Scanner scan;

	public static void main(String[] args) throws FileNotFoundException{
		
		scan = new Scanner(System.in);
		
		//Prepare the input file
		System.out.print("Input File Name: ");
		String inputFileName = scan.nextLine();
		
		DataReader dr = new DataReader();
			String readFile = dr.readFile(inputFileName);
		
		MessageDigest md = null;
		
		//Try and catch method defines the message digest algorithm to be used
		try {
			
			md = MessageDigest.getInstance("SHA");
			
		}
		catch(NoSuchAlgorithmException e){
			
			assert false;
			
		}//end try and catch method
		
		//Creates datablocks to be assigned to leaf nodes
				final String block1 = readFile;	
				final String block2 = readFile;	
				final String block3 = readFile;	
				final String block4 = readFile;	
				final String block5 = readFile;	
				final String block6 = readFile;	
				final String block7 = readFile;	
				final String block8 = readFile;	
				final String block9 = readFile;	
				final String block10 = readFile;	
				final String block11 = readFile;	
				final String block12 = readFile;
				final String block13 = readFile;	
				final String block14 = readFile;	
				final String block15 = readFile;	
				final String block16 = readFile;	
		
		//Creates leaf nodes contain datablocks
		final List<String> blocks1and2 = new ArrayList<String>();
			blocks1and2.add(block1);
			blocks1and2.add(block2);
		
		final List<String> blocks3and4 = new ArrayList<String>();
			blocks3and4.add(block3);
			blocks3and4.add(block4);
			
		final List<String> blocks5and6 = new ArrayList<String>();
			blocks5and6.add(block5);
			blocks5and6.add(block6);
		
		final List<String> blocks7and8 = new ArrayList<String>();
			blocks7and8.add(block7);
			blocks7and8.add(block8);
			
		final List<String> blocks9and10 = new ArrayList<String>();
			blocks9and10.add(block9);
			blocks9and10.add(block10);
		
		final List<String> blocks11and12 = new ArrayList<String>();
			blocks11and12.add(block11);
			blocks11and12.add(block12);
		
		final List<String> blocks13and14 = new ArrayList<String>();
			blocks13and14.add(block13);
			blocks13and14.add(block14);
		
		final List<String> blocks15and16 = new ArrayList<String>();
			blocks15and16.add(block15);
			blocks15and16.add(block16);
			
		final DataBlock leaf1 = new DataBlock(blocks1and2);
		
		final DataBlock leaf2 = new DataBlock(blocks3and4);
		
		final DataBlock leaf3 = new DataBlock(blocks5and6);
		
		final DataBlock leaf4 = new DataBlock(blocks7and8);
		
		final DataBlock leaf5 = new DataBlock(blocks9and10);
		
		final DataBlock leaf6 = new DataBlock(blocks11and12);
		
		final DataBlock leaf7 = new DataBlock(blocks13and14);
		
		final DataBlock leaf8 = new DataBlock(blocks15and16);
		
		//Builds Merkle Tree from leaves
		final MerkleTree branch1 = new MerkleTree(md);
			branch1.addLeaves(leaf1, leaf2);
		
		final MerkleTree branch2 = new MerkleTree(md);
			branch2.addLeaves(leaf3, leaf4);
		
		final MerkleTree branch3 = new MerkleTree(md);
			branch3.addLeaves(leaf5, leaf6);
		
		final MerkleTree branch4 = new MerkleTree(md);
			branch4.addLeaves(leaf7, leaf8);
			
		final MerkleTree mt = new MerkleTree(md);
			mt.addSubtrees(branch1, branch2);
			
			mt.addSubtrees(branch3, branch4);
		
		//Returns the digest for the entire tree
			mt.neat(0);
			
	}//end main

}//end class
