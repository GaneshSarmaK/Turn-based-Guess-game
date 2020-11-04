import java.util.*;
/**
 * Input class:
 * This class is responsible for taking the input
 */
public class Input
{
    
    /**
     * A default constructor for the Input Class.
     */
    public Input()
    {
        ;
    }
    
    /**
     * This method is used to print the message for appropriate input and send it back to calling method
     */
    public String input(String message)
    {
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.next();
        
    }
}
  