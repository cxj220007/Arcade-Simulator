
package project3;
// Corey Jones CXJ220007
import java.io.PrintWriter;
import java.util.Queue;



public class BinTree<e extends Comparable<e>>
{
    //  NO REFERENCE TO ANYTHING INSIDE GAME.java

    private Node root;
    
    
    
    // Overloaded constructor, assigning the node parameter to the root node
    public BinTree(Node root)
    {
        this.root = root;
    }
    
    public BinTree()
    {
        root = null;
    }

    // node generator
    public Node nodeGen(e o)
    {
        Node n = new Node(o);
        
        
        return n;
    }
    
    
    
    //  insert
    public void insert(Node nodeToInsert)
    {
        if(root == null)
        {
            String[] sArray = nodeToInsert.payload.toString().split("_");
            System.out.println("RECORD ADDED");
            System.out.print("Name: " + sArray[0] + "\n");
            System.out.print("High Score: " + sArray[1] + "\n");
            System.out.print("Initials: " + sArray[2] + "\n");
            System.out.print("Plays: " + sArray[3] + "\n");
            System.out.printf( "Revenue: $%.2f", Double.parseDouble( sArray[4] ) );
            root = nodeToInsert;
        }
    
        else
        {
            recursiveInsert(root, nodeToInsert);
        }
    }
   
    //  insert recursive
    public void recursiveInsert(Node parent, Node nodeToInsert)
    {
        if( nodeToInsert.compareTo( parent.payload ) < 0 )
        {

            if(parent.left == null)
            {
                parent.left = nodeToInsert;
                String[] sArray = nodeToInsert.payload.toString().split("_");
                System.out.println("RECORD ADDED");
                System.out.print("Name: " + sArray[0] + "\n");
                System.out.print("High Score: " + sArray[1] + "\n");
                System.out.print("Initials: " + sArray[2] + "\n");
                System.out.print("Plays: " + sArray[3] + "\n");
                System.out.printf( "Revenue: $%.2f", Double.parseDouble( sArray[4] ) );
            }
            else
            {
                recursiveInsert(parent.left, nodeToInsert);
            }
        }
        
        else
        {
            if(parent.right == null)
            {
                parent.right = nodeToInsert;
                String[] sArray = nodeToInsert.payload.toString().split("_");
                System.out.println("RECORD ADDED");
                System.out.print("Name: " + sArray[0] + "\n");
                System.out.print("High Score: " + sArray[1] + "\n");
                System.out.print("Initials: " + sArray[2] + "\n");
                System.out.print("Plays: " + sArray[3] + "\n");
                System.out.printf( "Revenue: $%.2f", Double.parseDouble( sArray[4] ) );
            }
            else
            {
                recursiveInsert(parent.right, nodeToInsert);
            }
            
        }
    }
   
    public void bFirst(Queue<Node> q, PrintWriter p)
    {
        if( root != null )
        {
            Node cur = root;

            String s = "";

            q.add(cur);

            while( !q.isEmpty() )
            {
                cur = q.poll();

                if( cur.left != null )
                    q.add( cur.left );
                if( cur.right != null )
                    q.add( cur.right );

                String[] ok = cur.payload.toString().split("_");
                p.print(ok[0] + ", ");
                p.print(ok[1] + ", ");
                p.print(ok[2] + ", ");
                p.print(ok[3] + ", ");
                p.printf( "$%.2f\n", Double.parseDouble( ok[4] ) );

            }
        }

    }
    
    
    public void inOrder1()
    {
        Node n = root;
        
        if( n != null )
        {
            System.out.println("RECORDS SORTED ASCENDING");
            inOrder(root);
        }
    }
    
    public void reverseInOrder1()
    {
        Node n = root;
        
        if( n != null )
        {    
            System.out.println("RECORDS SORTED DESCENDING");
            reverseInOrder(root);
        }
    }
    
    
    
    //  inorder traversal, pass in an empty node, to be reassigned to root
    public void inOrder(Node node)
    {

        if(node == null)
        {
            return;
        }
        
        inOrder(node.left);
        String[] ok = node.payload.toString().split("_");
        System.out.print(ok[0] + ", ");
        System.out.print(ok[1] + ", ");
        System.out.print(ok[2] + ", ");
        System.out.print(ok[3] + ", ");
        System.out.printf( "$%.2f\n", Double.parseDouble( ok[4] ) );
        
        inOrder(node.right);
    }
    
    
    //  postorder traversal, pass in an empty node, to be reassigned to root
    public void reverseInOrder(Node node)
    {

        if(node == null)
        {
            return;
        }

        
        reverseInOrder(node.right);
        String[] ok = node.payload.toString().split("_");
        System.out.print(ok[0] + ", ");
        System.out.print(ok[1] + ", ");
        System.out.print(ok[2] + ", ");
        System.out.print(ok[3] + ", ");
        System.out.printf( "$%.2f\n", Double.parseDouble( ok[4] ) );
        reverseInOrder(node.left);

    }
    
    
    
    
    
    
    
    
    // edit call function. with search key, op to perform and the newnode.payload to copy, minus the op
    //
    public void edit(String key, int operation, Node newNode)
    {
        Node node = searchExact(key);
        
        if( node != null )
        {
            editNode(root, node, operation, newNode);
        }
        
    }
    
    // edit node process
    public Node editNode(Node cur, Node key, int op, Node newNode)
    {
        if(cur != null)
        {
            if( cur.payload.toString().compareTo(key.payload.toString()) == 0 )
            {

    
                // set the current node (which is equal to the key) equal to the new game object passed in
                cur.payload = newNode.payload;
                
                
                // print the payload, formatted
                String[] sArray = cur.payload.toString().split("_");

                System.out.print("High Score: " + sArray[1] + "\n");
                System.out.print("Initials: " + sArray[2] + "\n");
                System.out.print("Plays: " + sArray[3] + "\n");
                System.out.printf( "Revenue: $%.2f", Double.parseDouble( sArray[4] ) );
                
                
                
                return cur;
            }

            if( key.payload.toString().compareTo( cur.payload.toString()) < 0  )
                return editNode(cur.left, key, op, newNode);

            else
                return editNode(cur.right, key, op, newNode);

        }
        return null;
    }
    
    
    
    
    
    
    
    // parent fetch function
    public Node getParent(Node node)
    {
        return getParentRecursive(root, node);
    }
    
    // recursive parent fetch process
    public Node getParentRecursive(Node subRoot, Node node)
    {
        if(subRoot == null)
            return null;
        
        if(subRoot.left == node || subRoot.right == node)
        {   
            return subRoot;
        }
        
        // if smaller, go left
        if( node.payload.toString().compareTo(subRoot.payload.toString()) < 0 )
        {
            return getParentRecursive(subRoot.left, node);
        }
        
        // if larger, go right
        return getParentRecursive(subRoot.right, node);
    }
    
    
    
    
    
    
    
    
    // remove a node function
    public void remove(String key)
    {
        // first recursive method
        Node nodeToRemove = searchExact(key);
        
        // what's the parent of this node we want to delete?
        Node parent = getParent(nodeToRemove);
        
        
        // jumping the gun here, but the node is overridden, and its successor is removed
        // so we don't actually remove the intended node
        String[] sArray = nodeToRemove.payload.toString().split("_");
        System.out.println("RECORD DELETED");
        System.out.print("Name: " + sArray[0] + "\n");
        System.out.print("High Score: " + sArray[1] + "\n");
        System.out.print("Initials: " + sArray[2] + "\n");
        System.out.print("Plays: " + sArray[3] + "\n");
        System.out.printf( "Revenue: $%.2f", Double.parseDouble( sArray[4] ) );
        
        
        // second recursive method ((((:<<
        removeNode(nodeToRemove, parent);
        
        
    }
    
    
    // recursive removal process
    public boolean removeNode(Node node, Node parent)
    {   
        if (node == null)
            return false;
        
        // Node with 2 children
        if(node.left != null && node.right != null)
        {
            // Search for successor in left subtree, and remember its parent
            Node succNode = node.left;
            //  remember this.
            Node succParent = node;
            
            // navigate to the bottom of the left subtree
            while(succNode.right != null)
            {
                succParent = succNode;
                succNode = succNode.right;
            }
            
            
            // copy value from the left subtree into the nodeToDelete
            node.payload = succNode.payload;
            
            
            // recursively remove the found successor
            removeNode(succNode, succParent);
            
            

        }
        
        
        // root with 1 or 0 children
        else if( node == root )
        {
            if( node.left != null )
            {
                root = node.left;
            }
            else
                root = node.right;
        }
        
        
        // left child only
        else if( node.left != null )
        {
            if(parent.left == node)
            {
                parent.left = node.left;
            }
            else
                parent.right = node.left;
        }
        
        // right child only or leaf
        else
        {
            if(parent.left == node)
                parent.left = node.right;
            else
                parent.right = node.right;
        }
        
        
        
        
       
        return true;
    }
    
    
    
    
    
    
    
    
    
    // search the tree for exact match
    public Node searchExact(String key)
    {
        return recursiveSearchExact(root, key);
    }
    
    // recursive exact match search
    public Node recursiveSearchExact(Node node, String key)
    {
        
        if(node != null)
        {
            // if found
            if( node.toString().substring( 0, node.toString().indexOf("_")).compareTo(key) == 0 )
            {
                
//                System.out.println(node.toString().substring(0, node.toString().indexOf(" ")) + " FOUND"); 
//                String[] ok2 = node.payload.toString().split(" ");
//                     
//                System.out.print("High Score: " + ok2[1] + "\n");
//                System.out.print("Initials: " + ok2[2] + "\n");
//                System.out.print("Plays: " + ok2[3] + "\n");
//                System.out.printf("Revenue: $%.2f", Double.parseDouble( ok2[4] ) );
                return node;
            }
            
            // else if key is less than cur node, check left
            else if( key.compareTo( node.payload.toString() ) < 0 )
            {
                return recursiveSearchExact(node.left, key);
            }
            
            // else check right
            else
            {
                return recursiveSearchExact(node.right, key);
            }        
        }

        return null;
    }
    
 
    
    
    
    
    
    
    
    
    
    // search tree for partial matching keys, printing each match as it traverses
    public Node search(String key)
    {
        return recursiveSearch(root, key);
    }
    
    
    // recursive search function for partial matches
    public Node recursiveSearch(Node node, String key)
    {
        
        if(node != null)
        {

            
            // if found, print it and continue as normal
            if( node.toString().contains(key) )
            {
                
                
                System.out.println(node.toString().substring(0, node.toString().indexOf("_")) + " FOUND"); 
                String[] ok2 = node.toString().split("_");
                     
                System.out.print("High Score: " + ok2[1] + "\n");
                System.out.print("Initials: " + ok2[2] + "\n");
                System.out.print("Plays: " + ok2[3] + "\n");
                System.out.printf("Revenue: $%.2f", Double.parseDouble( ok2[4] ) );

                
                if( node.left != null )
                {   
                    return recursiveSearch(node.left, key);
                }
                if( node.right != null  )
                {     
                    return recursiveSearch(node.right, key);
                }
                
            }

            
            // else if key is less than cur node, check left
            if( key.compareTo( node.toString().substring(0, node.toString().indexOf("_")) ) < 0  )
            {
                return recursiveSearch(node.left, key);
            }
            
            // else check right
            else
            { 
                return recursiveSearch(node.right, key);
            }   

                 
        }

        return null;
    }
    
    
    
    
    
    
}
