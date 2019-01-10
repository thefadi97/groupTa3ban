// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 
package ClientControl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import boundry.SearchForStudentController;

/**
 * This class constructs the UI for a chat client.  It implements the
 * chat interface in order to activate the display() method.
 * Warning: Some of the code here is cloned in ServerConsole 
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge  
 * @author Dr Robert Lagani&egrave;re
 * @version July 2000
 */
public class ClientConsole implements SearchIF 
{
  //Class variables *************************************************
  
  /**
   * The default port to connect on.
   */
  final public static int DEFAULT_PORT = 5555;
  private Object object;
  
  //Instance variables **********************************************
  
  /**
   * The instance of the client that created this ConsoleChat.
   */
  Client client;

  
  //Constructors ****************************************************

  /**
   * Constructs an instance of the ClientConsole UI.
   *
   * @param host The host to connect to.
   * @param port The port to connect on.
   */
  public ClientConsole() 
  {
    try 
    {
      client= new Client("localhost", DEFAULT_PORT, this);
    } 
    catch(IOException exception) 
    {
      System.out.println("Error: Can't setup connection!" + " Terminating client.");
      System.exit(1);
    }
  }
  
  public ClientConsole(String host, int port) 
  {
    try 
    {
      client= new Client(host, DEFAULT_PORT, this);
    } 
    catch(IOException exception) 
    {
      System.out.println("Error: Can't setup connection!" + " Terminating client.");
      System.exit(1);
    }
  }

  
  //Instance methods ************************************************

  public void execute(String query , String Table)
  {
	  ArrayList<String> arr = new ArrayList<String>();
	  arr.add(query);
	  arr.add(Table);
	  client.handleMessageFromClientUI(arr);
  }

  /**
   * This method overrides the method in the ChatIF interface.  It
   * displays a message onto the screen.
   *
   * @param message The string to be displayed.
   */
  
  
  public void display(String message) 
  {
    System.out.println("> " + message);
  }
  
  public  void sendObject(Object obj)
  {
    this.object = obj;
  //  SearchForStudentController.sem1.release();
  }
  
  public  Object getObject()
  {
	  return this.object;

  }

  
  //Class methods ***************************************************

}
//End of ConsoleChat class
