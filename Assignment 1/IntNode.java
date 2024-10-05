package library;

private IntNode head; 

public class IntNode
{
   private int sequenceNumber;
   private int data;
   private IntNode link;   
   
   
   // Precondition:
   // Postcondition: All instance variables of the IntNode class are initialized.
   public IntNode(int initialsequenceNumber, IntNode initialLink, int initialdata)
   {
	   //initializes the variables of the object with the given values
        this.sequenceNumber = initialsequenceNumber;
        this.link = initialLink;
        this.data = initialdata;
        if(head == null)
        	head = this;
   }

   
   // Precondition: This instance of the IntNode class exists.
   // In other words, the object whose method is activated exists as a node in the linked list. 
   // Postcondition: A new node with attributes item and data is created. Item serves as sequenceNumber.
   // The new node is added to the linked list at a position that comes immediately after the node whose method is activated.
   public void addNodeAfter(int data, int item)   
   {
	   if(this != null) { //checks to ensure that this node exists, satisfying the precondition
		   this.link =  new IntNode(item, this, data); //creates a new node and attaches it to the node that's method was activated
	   }
   }
   
   
   // Precondition: This instance of the IntNode class exists.
   // In other words, the object whose method is activated exists as a node in the linked list. 
   // Postcondition: The specific node, which comes immediately after the node whose method is activated, 
   // is removed from the linked list.
   public void removeNodeAfter( )   
   {
	    if(this != null) //checks to ensure that this node exists, satisfying the precondition
	    		this.link = this.link.link;
	    	
	    }
   } 
   
   
   // Precondition: This instance of the IntNode class exists.
   // Postcondition: The sequenceNumber of this node is returned, after setting detectionFlag to false.
   public int getsequenceNumber(boolean detectionFlg)   
   {
	   if(this != null) {
            detectionFlag = false;
            return this.sequenceNumber;
	   }
   }
   
  
   // Precondition: This instance of the IntNode class exists.
   // Postcondition: The link of this node is returned.
   public IntNode getLink( )
   {
	    if(this != null) {                                        
	    	return this.link;
	    }
   } 
    
   
   // Precondition: The linked list contains at least one element.
   // Postcondition: The (sequence number, data) pairs of each node in the linked list, starting with the head,
   // are displayed on the monitor. 
   public void displayNodeData(IntNode head)
   {
	    if(head != null) { //if there is a node in the List, satisfying the precon
	    	IntNode currentNode = head;//a node to hold the node at the current index as it iterates through the list
	    	
	    	while(currentNode != null) { //iterate until there are no more nodes
	    		System.out.println("Sequence Number: "+ currentNode.sequenceNumber);//print the relevant info
	    		System.out.println("Data: "+ currentNode.data +"\n");// then add a new line to make it more readable
	    	
	    		currentNode = currentNode.link;//set the node to the next in the list
	    	}
	    }
   }
   
   
   // Precondition: The head of the linked list is different than null, and its sequenceNumber is different than target.
   // Postcondition: The link to the specific node, which comes before the node whose sequenceNumber is equal to target, 
   // is returned. If the linked list does not contain a node with sequenceNumber equal to target, then null is returned.   
   public IntNode findPrevious(IntNode head, int target)
   {
	    if(head != null && head.sequenceNumber != target) { //if the head isnt null and the target isnt the head
	    	IntNode currentNode = head; //set the placeholder to head
	    	while(currentNode != null) {//search until found or it reaches the end
	    		if(currentNode.link.sequenceNumber == target) { //uses the link of current node so that if found, returns the currentNode.  
	    			return currentNode; //want to return current node since its not a doubly linked list so there is no reference to the previous node
	    		}
	    		currentNode = currentNode.link;// at end of each iteration it moves the current node down the list
	    	}
	    	return null; //if the while loop breaks, nothing has returned so nothing has been found. then we return null
	    }
   }

   
   // Precondition: The head of the linked list is different than null, and its sequenceNumber is smaller than target.
   // Postcondition: The link to the specific node, which comes before the node that is the first in the linked list 
   // to have a sequenceNumber greater than target, is returned. 
   // If no such node is found, the link to the last node in the linked list is returned. 
   public IntNode locatePredecessor(IntNode head, int target)
   {
	    if(head != null && head.sequenceNumber < target) { //to satisfy precon
	    	IntNode currentNode = head; //set temp var to the head
	    	while(currentNode != null) { //search until end of list
	    		if(currentNode.link.sequenceNumber > target) { //return current node if the next one has a seq Num larger than target
	    			return currentNode;
	    		}
	    		else if(currentNode.link == null)//if you get to the end of the list and have not returned yet, return currentNode (which should be the last)
	    			return currentNode;
	    		currentNode = currentNode.link; //iterate through the list
	    	}
   }
  
}
           