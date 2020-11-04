import java.util.*;
import java.lang.*;
/** 
 *  Game class:
 *  This class is the base class which interacts with different classes and using different methods
 *  to add player and computer ships and display the battlezone(grid) and perform the actual game.
 *  @author Sarma K.
 *  @version 20th Oct 2018
 */
public class Game
{
    private ShipList playerShips;
    private ShipList computerShips;
    
    /**
     * A Constructor for the Game class
     * Instantiates the ShipList objects
     */
    public Game()
    {
        playerShips = new ShipList();
        computerShips = new ShipList(); 
    }
    
    /**
     * The method that is responsible for the input of coordinates and its validation.
     * @param message a string that is displayed on the screen when promted for input
     * @param range maximum range of coordinate values for a ship
     */
    public int coordinateInput(String message, int range)
    {
        Input in = new Input();
        Validation v = new Validation();
        String temp = in.input(message);
        while(v.checkNumber(temp, range))
        {
            temp = in.input("");
        }
        return Integer.parseInt(temp); 
    }
    
    /**
     * A delay method that uses long values to introduce a small delay when called.
     */
    public void delay()
    {
        long start = new Date().getTime();
        while(new Date().getTime() - start < 1000L);
    }
    
    /**
     * A method that displays the grids i.e. the battle area of both the sides 
     * @param range maximum range of coordinate values for a ship
     * @param computerShipsVisible a boolean value that tell if the ships must be visible or not
     * @param s1 an object of ShipList class
     * @param s2 an object of ShipList class
     */
    public void display(int range, boolean computerShipsVisible, ShipList s1, ShipList s2)
    {
        System.out.println();
        System.out.println();
        System.out.println("Displaying Player's grid");
        gridDisplay(range, s1, true);  //always true for player ships grid display for any ship
        System.out.println();
        System.out.println();
        System.out.println("----------------------------------------------");
        System.out.println();
        System.out.println("Displaying Computer's grid");
        gridDisplay(range, s2, computerShipsVisible);
        System.out.println();
        System.out.println();
    }
    
    /**
     * A method that generates ships accodingly making sure no 2 ships are in the same place and
     * no ships are outside the grid. Generates using CoordinateGenerator() object.
     * @param multipleHits a boolean variable that decides if the hull strength is varibale value or just 1.
     * @param sizeOfGrid an integer variable maximum range of coordinate values for a ship
     * @param maxNoOfShips an integer variable maximum number of ships for a player
     */
    public void computerShipsInput(boolean multipleHits, int sizeOfGrid, int maxNoOfShips)
    {
        int noOfShips = maxNoOfShips;
        int range = sizeOfGrid;
        Input in = new Input();
        Validation v = new Validation();
        CoordinateGenerator cd = new CoordinateGenerator(0,range-1);    
        do
        {
            String name = "Ship "+computerShips.getSize();
            int xcoord = cd.generate();
            int ycoord = cd.generate();
            while(computerShips.getShipHealth(xcoord, ycoord) != '~')
            {
                xcoord = cd.generate();
                ycoord = cd.generate();
            }
            int noOfHitsNeeded;
            if(multipleHits == true)
                noOfHitsNeeded = cd.generate(1,5);
            else
                 noOfHitsNeeded = 1;
                 
            computerShips.addShips(name, xcoord, ycoord, 0, noOfHitsNeeded); //adding ships to the ShipList object
        }while(computerShips.getSize() < noOfShips);    //when playerShips.getSize() == no of ships stopsthe loop
    }
    
    /**
     * A method that accepts input and generates ships accodingly making sure no 2 ships are in the
     * same place and no ships are outside the grid
     * @param multipleHits a boolean variable that decides if the hull strength is varibale value or just 1.
     * @param sizeOfGrid an integer variable maximum range of coordinate values for a ship
     * @param maxNoOfShips an integer variable maximum number of ships for a player 
     */
    public void playerShipsInput(boolean multipleHits, int sizeOfGrid, int maxNoOfShips)
    {
        int noOfShips = maxNoOfShips; 
        int range = sizeOfGrid;
        Input in = new Input();
        Validation v = new Validation();
        CoordinateGenerator cd = new CoordinateGenerator();
        String temp = null;
        do
        {
            System.out.println("Ship"+(playerShips.getSize()+1)+" ready to be configured:");
            String name = in.input("Enter the name of the ship: ");
            while(v.checkName(name))
            {
                 name = in.input("The name of the ship should be between 3 and 15 characters. Please try again.");
            }
            System.out.println();
            int xcoord = coordinateInput("Enter the X-coordinates of the ship: ", range);
            System.out.println();
            int ycoord = coordinateInput("Enter the Y-coordinates of the ship: ", range);
            System.out.println();
            
            while(playerShips.getShipHealth(xcoord, ycoord) != '~')
            {
                System.out.println("A ship already exists at that coordinates. Please enter new coordinates."); 
                System.out.println();
                xcoord = coordinateInput("Enter the X-coordinates of the ship: ", range);
                System.out.println();
                ycoord = coordinateInput("Enter the Y-coordinates of the ship: ", range);
                System.out.println();              
                System.out.println();
            }
            
            int noOfHitsNeeded;
            if(multipleHits == true)
                noOfHitsNeeded = cd.generate(1,5);
            else
                 noOfHitsNeeded = 1;

            playerShips.addShips(name, xcoord, ycoord, 0, noOfHitsNeeded);  //adding ships to the ShipList object
        }while(playerShips.getSize() < noOfShips);                          //when playerShips.getSize() == no of ships stopsthe loop 
    }
    
    /**
     * A method that displays the grids i.e. the battle area of both the sides 
     * @param range maximum range of coordinate values for a ship
     * @param ships an object of ShipList class  
     * @param flag a boolean value that tell if the ships must be visible or not
     */
    public void gridDisplay(int range, ShipList ships, boolean flag)
    {
        for(int i = 0; i < range ; i++)
        {
            for(int j = 0; j < range ; j++)
            {
                char ship = ships.getShipHealth(i,j);
                if(flag == true)        //player ships grid
                    System.out.print(ship+" ");
                if(flag == false)       //computer ships grid
                {
                    if(ship == 'O')
                        System.out.print("~ ");
                    else
                        System.out.print(ship+" ");
                }
            }
            System.out.println();
        }
    }
    
    /**
     * The main method which calls other methods to perform the game operations.
     * Reads the data from the file using the FileIO() object and uses it to pass the values to other 
     * methods for meaningful execution.
     */
    public void start()  //main method
    {
       FileIO test = new FileIO("gamesettings.txt");        
       String[] fileData = test.read();                 //reading the file and retreiving the values
       int range = Integer.parseInt(fileData[0]);
       boolean multiplehits = Boolean.parseBoolean(fileData[1]);
       boolean computerShipsVisible = Boolean.parseBoolean(fileData[2]);
       int noOfShips = Integer.parseInt(fileData[3]);
       System.out.println("Loading....");
       delay();
       System.out.println("Loading preferences.");
       System.out.println("Please wait. ");
       System.out.println("Loading....");
       delay();
       System.out.println();
       System.out.println("Preferences loaded from file");
       
       System.out.println("Grid size(Play area) of the game: ( "+range+" * "+range+" )");
       System.out.println("Maximum number of ships allowed for each contestant: "+noOfShips);
       System.out.println("Multiple hits allowed: "+multiplehits);
       if(computerShipsVisible == true )
            System.out.println("Computer Ships Visible: On");
       else
            System.out.println("Computer Ships Visible: Off");
       System.out.println();
       System.out.println("Player preferences ");
       playerShipsInput(multiplehits, range, noOfShips);        //playerShips input
       System.out.println("Configuring Computer preferences");
       computerShipsInput(multiplehits, range, noOfShips);      //computerShips input
       System.out.println("...");
       delay();
       System.out.println("Configuring Complete");
       System.out.println();
       delay();
       System.out.println("Let the War Begin");
       System.out.println();     
       war(range, computerShipsVisible);                        //game method
       
    }
 
    /**
     * This method is resposible for the actual game after the input is taken.
     * It displays the grid and perform the necessary methods needed to perform a fully functional game
     * @param range maximum range of coordinate values for a ship
     * @param computerShipsVisible a boolean value that tell if the ships must be visible or not
     */
    public void war(int range, boolean computerShipsVisible)
    {
        Input in = new Input();
        Validation v = new Validation();
        FileIO file = new FileIO("gameoutcome.txt");
        CoordinateGenerator cd = new CoordinateGenerator(0,range-1);  
        int xCoord;
        int yCoord;
        String result;
        boolean flag = true;    //flag to change turns
        int playerPoints = 0;
        int computerPoints = 0;
        
        int k = 1;
        
        boolean conditionForLoop = true;
        while(conditionForLoop)
        {
            System.out.println("Press any key to continue;");
            Scanner sc = new Scanner (System.in);
            if(sc.hasNextLine())
                ;
            if(flag == true)
            {
                System.out.println();
                System.out.println();
                System.out.println("Round "+k);
                System.out.println("Player Score: "+playerPoints);
                System.out.println("Computer Score: "+computerPoints);
                display(range, computerShipsVisible,playerShips, computerShips);
            }    
            
            if(flag == true)                //players turn
            {
                
                System.out.println("Player's turn");
                System.out.println("Guess between 0 and "+(range-1));
                xCoord = coordinateInput("Enter the X-coordinate: ", range);
                System.out.println();
                yCoord = coordinateInput("Enter the Y-coordinate: ", range);
                result = computerShips.ifShipHit(xCoord, yCoord);
                if(result.charAt(0) == 'H')
                    playerPoints+= 10;
                System.out.println(result);
                System.out.println();
                flag = false;
                if(computerShips.fleetStatus())
                {
                    System.out.println("You win!!");
                    file.writeResults(playerPoints,"Player",computerPoints,"Computer");
                    conditionForLoop = false;
                }
                
            }
            else                            //computers turn
            {
                System.out.println();
                System.out.println("Computer's turn");
                System.out.println();
                System.out.print("Computer guesses  ");
                int[] shipHits = playerShips.shipHitAlready(); //array that stores a flag and x and y coordinates of a previously hit ship by computer
                if(shipHits[0] == -1)                          // means no ship is hit or ships are destroyed. hence guesses the coordinates
                {
                    xCoord = cd.generate();
                    yCoord = cd.generate();
                    System.out.println(xCoord+","+yCoord);
                    result = playerShips.ifShipHit(xCoord, yCoord);
                    if(result.charAt(0) == 'H')
                        computerPoints+= 10;
                    System.out.println(result);
                    System.out.println();
                }
                else                                        //there is a ship thats hit hence it'll hit that same ship until its destroyed.
                {
                    System.out.println(shipHits[1]+","+shipHits[2]);
                    if(shipHits[0] == 2)
                    {
                        System.out.println("Computer Hits!! Destroyed the enemy's ship!!");
                    }
                    else
                    {
                        System.out.println("Computer Hits!! ");
                    }
                    computerPoints+= 10;
                }
                //display(range, computerShipsVisible, playerShips, computerShips);
                //System.out.println(result);
                if(playerShips.fleetStatus())
                {
                    System.out.println("The Computer Wins!!");
                    file.writeResults(computerPoints,"Computer",playerPoints,"Player");
                    conditionForLoop = false;
                }
                flag = true;
                k++;
            }
               
        }
        
    }
     
    
}