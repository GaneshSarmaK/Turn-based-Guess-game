/** 
 *  CoordinateGenerator class:
 *  Randomly generates values based on the parameters passed using the Math.random();
 *  @author Sarma K.
 *  @version 20th Oct 2018
 */

public class CoordinateGenerator
{
    private int minimumValue;
    private int maximumValue;
    
    /**
     * A Constructor for the CoordinateGenerator class
     */
    public CoordinateGenerator()
    {
        ;
    }
    
     /**
     * A  Parameterized Constructor for the CoordinateGenerator class
     * @param min stores the minimum value
     * @param max stores the maximum value
     */
    public CoordinateGenerator(int min,int max)
    {
        minimumValue = min;
        maximumValue = max;
    }
    
    /**
     * A method that generates a random number between the ranges given to it by using Math.random() method
     * @param min integer values that specifies the minimum value possible
     * @param max integer values that specifies the maximum value possible 
     * @return (int)(Math.random() * range) + minimumValue a random number between min and max values 
     */
    public int generate(int min, int max)
    {
        int range = ( max - min ) + 1;
        return (int)(Math.random() * range) + min;
    }
    
    /**
     * A method that generates a random number between the ranges given to it by using Math.random() method
     * and values from the fields. 
     * @return (int)(Math.random() * range) + minimumValue a random number between min and max values
     */
    public int generate()
    {
        int range = ( maximumValue - minimumValue ) + 1;
        return (int)(Math.random() * range) + minimumValue;
    }
    
    /**
     * A mutator method to set the Minimum value
     * @param minimumValue an integer that sets the minimum value of the random number 
     */
    public void setMinimumValue(int minimumValue)
    {
        this.minimumValue = minimumValue;
    }
    
    /**
     * A mutator method to set the Maximum value
     * @param maximumValue an integer that sets the maximum value of the random number
     */
    public void setMaximumValue(int maximumValue)
    {
        this.maximumValue = maximumValue;
    }
}
