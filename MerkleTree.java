import java.security.MessageDigest;
import java.util.List;

/**
 * MerkleTree.java
 * 
 *  This class generates the tree and computes the hashes. 
 *  The hashes for each DataBlock should be stored in the 
 *  leaves of the tree.  The interior nodes should contain 
 *  a hash computed from the hashes of its children.
 * 
 * @author Jaylon Kiper
 * @version 1.0
 * Programming Project 4
 * FALL19
 *
 */
public class MerkleTree {

	//Child trees and leaves
	private MerkleTree leftTree = null;
	private MerkleTree rightTree = null;
	private DataBlock leftLeaf = null;
	private DataBlock rightLeaf = null;
	
	//The hash value to this node and the digest algorithm.
	private byte[] digest;
	private final MessageDigest md;
	
	//Generates a digest for leaf node.
	@SuppressWarnings("unchecked")
	private byte[] digest(DataBlock dataBlock) {
		
		@SuppressWarnings("unused")
		final List<String> db = dataBlock.getDataBlock();
		
		//Creates a hash for the databocj using digest algorithm.
		final int numberOfBlocks = ((List<byte[]>) dataBlock).size();
		
		for(int i = 0; i < numberOfBlocks-1; i++) {
			
			md.update(((List<byte[]>) dataBlock).get(i));
			
		}//end for loop
		
		digest = md.digest(((List<byte[]>) dataBlock).get(numberOfBlocks-1));
		
		return digest;
		
	}//end digest method
	
	//This will initialize the Merkle Tree being empty wit the digest algorithm.
	public MerkleTree(MessageDigest md) {
		
		this.md = md;
		
	}//end MerkleTree method
	
	//Adds two child subtrees
	public void addSubtrees(final MerkleTree leftTree, final MerkleTree rightTree) {
		
		this.leftTree = leftTree;
		this.rightTree = rightTree;
		
		md.update(leftTree.digest());
		digest = md.digest(rightTree.digest());
		
	}//end addSubtrees method
	
	//Adds two child leaves
	public void addLeaves(final DataBlock leftLeaf, final DataBlock rightLeaf) {
		
		this.leftLeaf = leftLeaf;
		this.rightLeaf = rightLeaf;
		
		md.update(digest(leftLeaf));
		digest = md.digest(digest(rightLeaf));
		
	}//end addLeaves method
	
	//Returns left subtree
	public MerkleTree leftSubTree() {
		
		return leftTree;
		
	}//end leftSubTree method
	
	//Returns right subtree
	public MerkleTree rightSubTree() {
			
		return rightTree;
			
	}//end rightSubTree method
	
	//Returns left leaf
	public DataBlock leftLeaf() {
			
		return leftLeaf;
			
	}//end leftLeaf method
	
	//Returns right leaf
	public DataBlock rightLeaf() {
				
		return rightLeaf;
				
	}//end rightLeaf method
	
	//This is the digest associate of the Merkle Tree root
	public byte[] digest() {
		
		return digest;
		
	}//end digest method
	
	//Returns a string of the specified byte array, with the values represented in hex.
	
	private String toHexString(final byte[] array) {
			
		final StringBuilder str = new StringBuilder();
			
		str.append("[");
			
		boolean comesFirst = true;
			
		for(int i = 0; i < array.length; i++) {
				
			final byte b = array[i];
				
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
	
	//Indents the space for the MerkleTree
		public void neat(final int indent) {
		
		for(int i = 0; i < i; i++) {
			
			System.out.print(" ");
			
		}//end for loop
		
		//Print root digest
		System.out.println("Node digest: " + toHexString(digest()));
		
		//Prints leaf
		if(leftLeaf != null && rightLeaf != null) {
			
			for(int i = 0; i < indent + 1; i++) {
				
				System.out.print(" ");
				
			}//end for loop
			
			System.out.println("Left leaf: " + leftLeaf.toString() + " Right leaf: " + rightLeaf.toString());
			
		}//end if statement
		else if(leftTree != null && rightTree != null) {
			
			leftTree.neat(indent + 1);
			rightTree.neat(indent + 1);
			
		}//end else if statement
		else {
			
			System.out.println("Merkle Tree is Empty!");
			
		}//end else statement
		
	}//end neat method
	
}//end class
