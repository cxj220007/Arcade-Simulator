
package project3;
// Corey Jones CXJ220007
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;


public class Project3 {

 
    
//    // node generator
//    public static Node nodeGen(Game o)
//    {
//        Node n = new Node(o);
//        
//        
//        return n;
//    }
//    
    
    
    
    // database file parser
    public static Game dataParse(String ln)
    {

        String[] sArray = ln.split(", ");
        
        String name = sArray[0];
        
        int highScore = Integer.parseInt(sArray[1]);

        String initials = sArray[2];

        int plays = Integer.parseInt(sArray[3]);

        double revenue = Double.parseDouble( sArray[4].substring(1) );

        return ( new Game(name, highScore, initials, plays, revenue) );

    }
    
    
    
    
    
    
    // batch file parser
    public static Game insertParse(String ln)
    {
        
        
        String name = ln.substring( ln.indexOf("\"") + 1 , ln.lastIndexOf("\"") );

        
        String[] sArray = ln.substring(ln.lastIndexOf("\"") + 2).split(" ");
        
        
        int highScore = Integer.parseInt(sArray[0]);

        String initials = sArray[1];

        int plays = Integer.parseInt(sArray[2]);

        double revenue = Double.parseDouble( sArray[3].substring(1) );


        return ( new Game(name, highScore, initials, plays, revenue) );

    }
    
    
   
    public static void main(String[] args) 
    {
        // (String name, int highScore, String initials, int plays, double revenue)
        try {
            
            // read the file name variables
            Scanner keyboard = new Scanner(System.in);
            
            
            // database input file
            String zy2 = keyboard.nextLine();
            
            // batch command file
            String zy1 = keyboard.nextLine();
          
            
                    
            
//            // open the batch file my end 
//            FileInputStream fileInput = new FileInputStream("update1.txt");
            
            // open the batch file zybooks end
            FileInputStream fileInput = new FileInputStream(zy1);
            
            // read commands from batch file
            Scanner fileLine = new Scanner(fileInput);
            
            
            
//            // open the database file my end
//            FileInputStream fileInputDatabase = new FileInputStream("cidercade1.dat");
            
            // open the database file zybooks end
            FileInputStream fileInputDatabase = new FileInputStream(zy2);
            
            
            // read commands from database file
            Scanner dataBaseFileLine = new Scanner(fileInputDatabase);
            
            
            
            // tree object
            BinTree tree = new BinTree();
            
            
            // open output file
            FileOutputStream fs = new FileOutputStream("cidercade.dat");
            
            // filewriter to write to the writable file
            PrintWriter p = new PrintWriter(fs);
             
            
            
            // loop through database file
            while( dataBaseFileLine.hasNext() )
            {
                String ln = dataBaseFileLine.nextLine();
                
                tree.insert( tree.nodeGen(dataParse(ln)) );
                
                System.out.println("\n");
            }
            
            
            
            
         
            // loop through the entire batch file
            while( fileLine.hasNext() )
            {
                String ln = fileLine.nextLine();
                
     
                // batch command 1 add record
                if( ln.substring(0,1).equals("1") )
                {
                    tree.insert( tree.nodeGen(insertParse(ln)) );

                    System.out.println("\n");
                }
                
                
                // batch command 2 Search contains
                if( ln.substring(0,1).equals("2") )
                {

                    tree.search( ln.substring(2) );
                    
                    System.out.println("\n");
                      
                }
                
                
                
                
                // batch command 3 edit record
                if(ln.substring(0,1).equals("3"))
                {
                    
                    // get the field instruction at [0] and the value to change it to at [1]
                    String[] ok = ln.substring( ln.lastIndexOf("\"") + 2 ).split(" ");
                    
                    // separate name string for search key
                    String name = ln.substring( ln.indexOf("\"") + 1 , ln.lastIndexOf("\"") );
                    
                    
                    // if the element is not in the tree
                    if(tree.searchExact(name) == null )
                    {
                        
//                        System.out.print(name + " NOT FOUND");
                        
                        
                        System.out.println("\n");   
                    }    
                    
                    // else the element is the tree
                    else
                    {
                        // create a string array from the exactSearch()'s toString()
                        String[] objectToString = tree.searchExact(name).toString().split("_");
                        
                        
                        
                        
                        
                        // 3 “name” <field number> = [0], <new value>, = [1]
                        switch( ok[0] )
                        {    
                        // change high score, [1]
                        case "1":

                            // create a new game object, from objectToString, only with a new field to be changed
                            Game newGame1 = new Game( objectToString[0], Integer.parseInt( ok[1] ), 
                            objectToString[2] , Integer.parseInt( objectToString[3] ), Double.parseDouble( objectToString[4] ) );


//                            // the newNode object, with a new payload to pass into the edit function
//                            Node newNode1 = new Node( newGame1 );


                            System.out.println(objectToString[0] + " UPDATED");
                            System.out.println("UPDATE TO high score - VALUE " + ok[1] );
                            tree.edit(name, 1, tree.nodeGen( newGame1 ));


                            System.out.println("\n"); // double line
                            break;



                        // change initials, [2]
                        case "2":
                            // create a new game object, from objectToString, only with a new field to be changed
                            Game newGame2 = new Game( objectToString[0], Integer.parseInt( objectToString[1] ), 
                            ok[1] , Integer.parseInt( objectToString[3] ), Double.parseDouble( objectToString[4] ) );

//
//                            // the newNode object, with a new payload to pass into the edit function
//                            Node newNode2 = new Node( newGame2 );


                            System.out.println(objectToString[0] + " UPDATED");
                            System.out.println("UPDATE TO initials - VALUE " + ok[1] );
                            tree.edit(name, 2, tree.nodeGen( newGame2 ) );


                            System.out.println("\n"); // double line
                            break;  



                        // change number of plays, [3]
                        case "3":
                            // create a new game object, from objectToString, only with a new field to be changed
                            Game newGame3 = new Game( objectToString[0], Integer.parseInt( objectToString[1] ), 
                            objectToString[2] , Integer.parseInt( ok[1] ), Double.parseDouble( objectToString[4] ) );


//                            // the newNode object, with a new payload to pass into the edit function
//                            Node newNode3 = new Node( newGame3 );


                            System.out.println(objectToString[0] + " UPDATED");
                            System.out.println("UPDATE TO plays - VALUE " + ok[1] );
                            tree.edit(name, 3, tree.nodeGen( newGame3 ));

                            System.out.println("\n"); // double line
                            break;
                        }
                    }
                }
                
                
                
                
                // batch command 4 delete record
                if( ln.substring(0,1).equals("4") )
                {

                    // <command number><space><key to delete>
                    if( tree.searchExact( ln.substring(2) ) == null)
                    {
//                        System.out.print(ln.substring(2) + " NOT FOUND");

                        System.out.println("\n"); 
                    }
                        
                    else
                    {
                        tree.remove( ln.substring(2) );
                        
                        
                        System.out.println("\n"); 
                    }
                    
                    
                
                }
                
                
                // batch command 5 sort records
                if( ln.substring(0,1).equals("5") )
                {
                    if(ln.substring(2).equals("asc"))
                    {    
                        

                        tree.inOrder1(); 

                        System.out.println(); // single line
                    }
                    
                    if(ln.substring(2).equals("dec"))
                    {    
                        

                        tree.reverseInOrder1();

                        System.out.println(); // single line
                    }
                    
                }
                
                
                
                
                
            }
            
            // After console printing stuff, Breadth-first print the whole tree to the file
                   
                
            // Queue wit da linked list
            Queue<Node> q = new LinkedList<>();

            if( !p.checkError() )
                tree.bFirst(q, p);

            
            
            // close the files
            p.close();
            fileInputDatabase.close();
            fs.close();
            fileInput.close(); 
        }
 
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
        
        
        
        
        
    }
    
}
