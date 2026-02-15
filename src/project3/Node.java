
package project3;

// Corey Jones CXJ220007
public class Node<e extends Comparable<e>>
{
    //  NO REFERENCE TO ANYTHING INSIDE GAME.java
    
    Node left;
      
    Node right;

    e payload;

    
    public Node( e object )
    {
        payload = object;
    
    }
    
    public Node()
    {
       
    }
      

    
    public int compareTo(e obj) 
    {
        if( payload.compareTo( obj ) > 0)
        {

            return 1;
        }
        
        
        if(  payload.compareTo( obj ) == 0)
        {

            return 0;
        }
        
        else
        {
 
            return -1;
        }
    }
    
    
    @Override
    public String toString()
    {
    
        return payload.toString();
    }
            
            
}
