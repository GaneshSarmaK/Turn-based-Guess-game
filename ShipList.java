import java.util.*;
/**
 * ShipList class:
 * This class is used to set the data by calling the method in ship class
 * used to display the ships and size of ships
 * used to get the ship health, checks whether ship exist at the same location, whether the ship was hit, 
 * 
 */
public class ShipList
{
    private ArrayList<Ship> ships;
    
    /**
     * A default constructor for the ShipList class that initializes the ships ArrayList.
     */
    public ShipList()
    {
       ships = new ArrayList<Ship>();
       
    }
    
    /**
     * This method adds ships to the arraylist by using a method of the ship class
     * @param name a string that is the name of the ship
     * @param xPos an integer that has x-coordinate of ship
     * @param yPos an integer that has y-coordinate of ship
     * @param hitsMade an integer that is set as 0 when creating that indicates the number of hits made to that ship
     * @param hitsNeeded asn integer that tells us about the number of hits needed to destroy that ship
     */
    public void addShips(String name, int xPos, int yPos, int hitsMade, int hitsNeeded)
    {
        ships.add(new Ship(name, xPos, yPos, hitsMade, hitsNeeded));
    }
    
    /**
     * A mothod that displays easch ships details
     */
    public void display()
    {
      for(Ship s: ships) 
      {
          s.display();
          
      }
    }
    
    /**
     * A method that checks if all the ships in the ArrayList are destroyed or not
     * @return flag a boolean that says if all ships in the ArrayList are destroyed or not
     */
    public boolean fleetStatus()
    {
        boolean flag = false;
        int size = getSize();
        for(int i = 0; i < ships.size(); i++)
        {
            if(ships.get(i).getNoOfHitsMade() == ships.get(i).getNoOfHitsNeeded())
                size--;
        }
        if(size == 0)
            flag = true;
        return flag;
    }
    
    /**
     * A method that returns the present size of the ArrayList ships
     * @return ships.size() the present size of the ships ArrayList.
     */
    public int getSize()
    {
        return ships.size();
    }
    
    /**
     * A method that tells about a ship's health if the ship is found from the values passed to this method
     * @param xPos an integer that stores the x coordinate 
     * @param yPos an integer that stores the x coordinate
     * @return status a character that tells if the ship is destroyed, hit, undamaged or not found
     */
    public char getShipHealth(int xPos, int yPos)
    {
        int health = -1 ;
        int i = 0;
        char status;
        for(; i < ships.size(); i++)
        {
            if(ships.get(i).getXPos() == xPos && ships.get(i).getYPos() == yPos)
                {
                    health = ships.get(i).getNoOfHitsNeeded() - ships.get(i).getNoOfHitsMade();
                    break;
                }
        }
        if(i != ships.size())
            if(health == 0)
                status = 'X';
            else if(health > 0 && health < ships.get(i).getNoOfHitsNeeded())
                status = 'D';
            else 
                status = 'O';
        else 
            status = '~';
            
        return status;
    }
    
    /**
     * A method that checks if any ship is hit, if yes then changes the number of hits made and returns a string with appropriate data.
     * @param xPos an integer that stores the x coordinate 
     * @param yPos an integer that stores the x coordinate
     * @return flag a String that tells if the ship is destroyed, hit, already destroyed or a miss.
     */
    public String ifShipHit(int xPos, int yPos)
    {
       String flag = "It's a Miss!!";
       for(int i = 0 ; i < ships.size(); i++)
        {
            if(ships.get(i).getXPos() == xPos && ships.get(i).getYPos() == yPos)
            {   
                if(ships.get(i).getNoOfHitsMade() == ships.get(i).getNoOfHitsNeeded())
                    flag = "Ship is already destroyed";
                else if(ships.get(i).getNoOfHitsMade()+1 == ships.get(i).getNoOfHitsNeeded())
                {
                    flag = "Hit!! Destroyed the enemy's ship!!";
                    ships.get(i).setNoOfHitsMade(ships.get(i).getNoOfHitsMade() + 1);
                }
                else
                {
                    flag = "Hit!!";
                    ships.get(i).setNoOfHitsMade(ships.get(i).getNoOfHitsMade() + 1);
                }
                break;
                
            }
        }
       return flag;
    }
    
    /**
     * A method that checks if a ship is already hit or not. (Used by computer only for equality between player nad computer).
     * If a ship is previously hit then it'll check if it is alive or destroyed, if alive it hits the ship.
     * @return flag an integer array which has the hit status, x-coordinates and y-coordinates of the ship if hit else -1 as hit status.
     */
    public int[] shipHitAlready()
    {
        int[] flag = new int[]{-1};
        
        for(int i = 0; i < ships.size(); i++)
        {
            if(ships.get(i).getNoOfHitsMade() >= 1)
            {
                if(ships.get(i).getNoOfHitsMade()+1 == ships.get(i).getNoOfHitsNeeded())
                {
                    flag = new int[]{2,ships.get(i).getXPos(),ships.get(i).getYPos()};
                    ships.get(i).setNoOfHitsMade(ships.get(i).getNoOfHitsMade() + 1);
                    break;
                }
                else if(ships.get(i).getNoOfHitsMade() < ships.get(i).getNoOfHitsNeeded())
                {
                    flag = new int[]{1,ships.get(i).getXPos(),ships.get(i).getYPos()};
                    ships.get(i).setNoOfHitsMade(ships.get(i).getNoOfHitsMade() + 1);
                    break;
                }
                else
                    ;
            }
        }
        return flag;
    }

}
