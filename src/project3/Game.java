
package project3;
// Corey Jones CXJ220007
public class Game implements Comparable
{
    private String name;
    
    private int highScore;
    
    private String initials;
    
    private int plays;
    
    private double revenue;
    

    
    
    public Game(String name, int highScore, String initials, int plays, double revenue)
    {
        this.name = name;
        this.highScore = highScore;
        this.initials = initials;
        this.plays = plays;
        this.revenue = revenue;
        
    }
    
    
    
    public String getName()
    {
        return name;
    }
   

    @Override
    public int compareTo(Object object) 
    {

        
        Game g = (Game)object;

        if ( name.compareTo(g.getName()) > 0 )
            return 1;
        
        else if( name.compareTo( g.getName()) == 0) 
            return 0;
        
        else
            return -1;
        
    }
    
   
    
    @Override
    public String toString()
    {    
        return name + "_" + highScore + "_" + initials + "_" + plays + "_" + revenue;
    }
}
