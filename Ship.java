/** 
 *  Ship class:
 *  This class is the base class which interacts with different classes and using different methods
 *  to add player and computer ships and display the battlezone(grid) and perform the actual game.
 *  @author Sarma K.
 *  @version 20th Oct 2018
 */

public class Ship
{
   private String shipName;
   private int xPos;
   private int yPos;
   private int noOfHitsMade;
   private int noOfHitsNeeded;
   
   /**
    * A default constructor for the Ship class.
    */
   public Ship()
   {
       shipName = "ship";
       xPos = 0;
       yPos = 0;
       noOfHitsMade = 0;
       noOfHitsNeeded = 1;
   }
   
   /**
    * This method is helpful in setting all the data at a time 
    * for setting the shipname, x-position, y-position, number of hits made and number of hits needed
    * 
    * @param shipName is an string type which is name of the ship
    * @param xPos is an integer which is x-position of the ship
    * @param yPos is an integer which is y-position of the ship
    * @param noOfHitsMade is an integer which holds the number of hits made on a ship
    * @param noOfHitsNeeded is an integer which holds the number of hits needed on a ship to demolish
    */
   public Ship(String shipName, int xPos, int yPos, int noOfHitsMade,int noOfHitsNeeded)
   {
       this.shipName = shipName;
       this.xPos = xPos;
       this.yPos = yPos;
       this.noOfHitsMade = noOfHitsMade;
       this.noOfHitsNeeded = noOfHitsNeeded;  
   }
   
   /**
    * This method is helpful to get the number of hits made on a ship
    * @return noOfHitsMade is an integer variable which returns number of hits made on a ship
    * */
   public int getNoOfHitsMade()
   {
       return noOfHitsMade;
   }
   
   /**
    * This method is helpful to get the number of hits need to be made on a ship to be destroyed
    * @return noOfHitsNeeded is an integer variable which returns number of hits needed on a ship
    * */
   public int getNoOfHitsNeeded()
   {
       return noOfHitsNeeded;
   }
   
   /**
    * This method is helpful to get the name of the ship
    * @return shipName is an String which returns the name of the ship
    * */
   public String getShipName()
   {
       return shipName;
   }
   
   /**
    * This method is helpful to get the x-position of the ship
    * @return xPos is an integer variable which returns x-position
    * */
   public int getXPos()
   {
       return xPos;
   }
   
   /**
    * This method is helpful to get the y-position of the ship
    * @return yPos is an integer variable which returns y-position
    * */
   public int getYPos()
   {
       return yPos;
   }
   
   /**
    * This method is helpful to set the number of hits need to be made on a ship to be destroyed

    * @param noOfHitsNeeded is an integer which is used as a parameter that contains number of hits needed on a ship
    * */
   public void setNoOfHitsNeeded(int noOfHitsNeeded)
   {
       this.noOfHitsNeeded = noOfHitsNeeded;
   }
   
   /**
    * This method is helpful to set the number of hits need to be made on a ship to be destroyed
    * @param noOfHitsMade is an integer which is used as a parameter that contains number of hits made on a ship
    * */
   public void setNoOfHitsMade(int noOfHitsMade)
   {
       this.noOfHitsMade = noOfHitsMade;
   }
   
   /**
    * This method is helpful to set the x-position of the ship
    * @param xPos is an integer which is used as a parameter that contains x-position of a ship
    * */
   public void setXPos(int xPos)
   {
       this.xPos = xPos;
   }
   
   /**
    * This method is helpful to set the y-position of the ship
    * @param yPos is an integer which is used as a parameter that contains y-position of a ship
    * */
   public void setYPos(int yPos)
   {
       this.yPos = yPos;
   }
   
   /**
    * This method is helpful to set the name of the ship
    * @param shipName is an String which is the name of the ship
    * */
   public void setShipName(String shipName)
   {
       this.shipName = shipName;
   }
   
   /**
    * This method is helpful to display all the ship details
    * */
   public void display()
   {
       System.out.println("Ship name: "+ shipName);
       System.out.println("X co-ordinates: "+ xPos+1);
       System.out.println("Y co-ordinates: "+ yPos+1);
       System.out.println("No of Hits made: "+ noOfHitsMade);
       System.out.println("No of Hits needed: "+ noOfHitsNeeded);
       System.out.println();
   }
}