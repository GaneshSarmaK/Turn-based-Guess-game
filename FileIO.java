import java.util.*;
import java.io.*;

/** 
 *  FileIO class:
 *  This class is used to read the file and split the text in the file using delimiter
 *  also responsible for writing the data into the file. Ex: playerscore, computerscore, winner
 *  
 *  @author Sarma K.
 *  @version 20th Oct 2018
 */
public class FileIO
{
    private String fileName;
    
    /**
     * A parameterized constructor for the FileIO class
     * @param fileName a String that has the name of the file to be read or written to.
     */
    public FileIO(String fileName)
    {
        this.fileName = fileName;
    }
    
    /**
     * This method is used to read the file and split the text in the file using delimiter
     */
    public String[] read()
    {
        String[] input = new String[4];
        int i = 0;
        try{
            BufferedReader stdin = new BufferedReader(new FileReader (fileName));
            String in = stdin.readLine();
            Scanner sc = new Scanner(in).useDelimiter(",");
            while(sc.hasNext())
            { 
                input[i++] = sc.next().trim();
                //System.out.println(input[i-1]);
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("The file was not found");
        }
        catch(IOException e)
        {
            System.out.print("An Input Output error occurred");
        }
        catch(Exception e)
        {
            System.out.print("An unexpected error occurred");
        }
        return input;

    }
    
    /**
     * This method is responsible for writing the data into the file. 
     * Ex: playerscore, computerscore, winner
     */
    public void writeResults(int score1, String name1, int score2,  String name2)
    {
        try{
        FileWriter out = new FileWriter(new File(fileName),true);
        out.write("\n");
        out.write("\n");
        out.write("The "+name1+" score is :"+score1+"\nThe "+name2+" score is :"+score2);
        out.write("\n");
        out.write("The winner is "+name1);
        out.flush();
        out.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("The file was not found");
        }
        catch(IOException e)
        {
            System.out.print("An Input Output error occurred");
        }
        catch(Exception e)
        {
            System.out.print("An unexpected error occurred");
        }
    }
    
}
