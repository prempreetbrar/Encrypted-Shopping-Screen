import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;

import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.IOException;

/*
  Author: Prempreet Brar
  ---------------------------------------------------------------------------------------
  Purpose of the class: Handles reading passwords, writing orders.
 
  Features:
  - Can read a password from a file, can write an order to a file.
   
  Limitations:
   - File names are hardcoded in, no ability for user to specify their own files.
   - Assumes that the password.txt file actually exists and is in the current directory.
   - Overwrites previous, perhaps sensitive information in the order.txt file when writing.
   - Does not make use of other, perhaps more robust file-handling classes.
*/
public class FileHandler
{
    public static final int EXIT = 0;

    private FileReader fileReader;
    private FileWriter fileWriter;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;

    /* FileHandler method. 
        Features: Creates an instance of a FileHandler.
        Limitations/Assumptions: None
    */
    public FileHandler()
    {
        // Instantiate all readers/writers (even if only to null).
        fileReader = null;
        bufferedReader = null;
        fileWriter = null;
        printWriter = null;
    }

    /* readPassword method. 
        Features: Reads a password from password.txt
        Limitations/Assumptions: password.txt exists and is in the current directory.
    */
    public String readPassword()
    {
        String encryptedPassword = "";

        // Try reading each line of the file, storing the contents in the password.
        try
        {
            fileReader = new FileReader("password.txt");
            bufferedReader = new BufferedReader(fileReader);
            String currentLine = bufferedReader.readLine();

            // Continue reading until you have read all lines.
            while (currentLine != null)
            {
                encryptedPassword += currentLine;
                currentLine = bufferedReader.readLine();
            }

            // Close the readers after you're done.
            fileReader.close();
            bufferedReader.close();
        }

        // If there are any errors, catch them and exit (normally system.exit should not be used,
        // but exceptional circumstance).
        catch (FileNotFoundException exception)
        {
            System.out.println("The file password.txt could not be found.");
            System.out.println("Ensure the file exists and is in the current directory.");
            System.exit(EXIT);
        }
        catch (EOFException exception)
        {
            System.out.println("Unexpectedly reached end of file password.txt when reading.");
            System.exit(EXIT);
        }
        catch (IOException e)
        {
            System.out.println("There was an error in reading data from the file password.txt");
            System.exit(EXIT);
        }

        return encryptedPassword;
    }

    /* writeToFile method. 
        Features: Writes a name and address in an order file.
        Limitations/Assumptions: Overwrites the data in order.txt
    */
    public void writeToFile(String name, String address)
    {
        try
        {
            // Open up the necessary writers.
            fileWriter = new FileWriter("order.txt");
            printWriter = new PrintWriter(fileWriter);
            printWriter.println(name);
            printWriter.println(address);

            // Flush the print writer to ensure everything is instantly written to order.txt.
            fileWriter.close();
            printWriter.flush();
            printWriter.close();
        }
        catch (IOException exception)
        {
            System.out.println("There was an error when writing to order.txt."
                + " Try saving again.");
        }
    }
}
