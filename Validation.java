/**
 * Validation class:
 * This class is used to validate the data whether it is a correct input or not 
 * checks whether the string is within the range
 * checks whether it is a number or not and also checks it is within the range
 * 
 */
public class Validation
{
   /**
    * A default constructor for the Validation class.
    */
   public Validation()
   {
       ;
   }
   
   /**
    * This method is used to know whether the inputn parameter is integer or not 
    * 
    * @param integer is a String type which is passed from another method to check for validation
    * @return number is a integer which sends the number if satisfies else sends -1 
    */
   public int integer(String integer)
   {
        int number = -1;
        try
        {
            number = Integer.parseInt(integer);
        }
        catch(NumberFormatException e)
        {
            System.out.print("The input is not a valid integer. Please re-enter the input: ");
        }
        catch (Exception e)
        {
            System.out.print("An unexpected error occurred. Please re-enter the input: ");
        }
        return number;
   }
    
   /**
    * This method is used to check whether name of the ship is within the range or not
    * 
    * @param name is an String which is used to validate with few conditions
    * @return flag is a boolean variable used to know whether it is within the range or not
    */
   public boolean checkName(String name)
   {
       boolean flag = true;
        
       if(name.trim().length() >= 3 && name.trim().length() <= 15)
            flag = false;
       else 
            ;
         
       return flag;
   }  
    
   /**
    * This method is used to check whether the number is within the range or not
    * implicity this method calls another method to know whether the data is integer or not 
    * 
    * @param data is an String which is used to validate with few conditions
    * @param range is an integer which is the size of the grid
    * @return flag is a boolean variable used to know whether it is within the range or not
    */
   public boolean checkNumber(String data,int range) 
   {
       boolean flag = true;
       int number = integer(data);
       if(number >= 0 && number < range)
           flag = false;
       else if (number == -1)
           ;
       else 
           System.out.print("The coordinates entered are not valid. Please reenter them: ");
           
       return flag;
        
   }
   
}