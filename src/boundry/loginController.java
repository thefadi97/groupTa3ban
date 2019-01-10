package boundry;

import java.io.IOException;
import java.util.ArrayList;

import ClientControl.ClientConsole;
import ClientControl.MainProgram;
import entity.Person;
import entity.Student;
import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class loginController {
	
	ClientConsole clientConsole;
	User user;

    @FXML
    private PasswordField passID;

    @FXML
    private TextField userID;
    
    @FXML 
    public void initialize()
    {
    	if(MainProgram.host.equals("localhost"))
    		clientConsole = new ClientConsole();
    	else {
    		clientConsole = new ClientConsole(MainProgram.host , MainProgram.DEFAULT_PORT);
    	}
    }

    @SuppressWarnings("unused")
	@FXML
    void logInButtonClicked(ActionEvent event) {
    	if(!userID.getText().isEmpty() && !passID.getText().isEmpty()) { // if the user entered ID
		      clientConsole.execute(String.format("SELECT * FROM user WHERE userID = %d", Integer.parseInt(userID.getText())) , "user");
		      //sem1.acquire();
		      try {
				Thread.currentThread().sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      Object obj =  clientConsole.getObject();
		      ArrayList<String> arr = new ArrayList<String>();
		      arr = (ArrayList) obj;
				   if(arr != null ) // there is user in the data base with this id and password
				   		{
					   if(!arr.get(0).equals("User already is logged in")) {//if yes so goto to else
					      User user = new User(Integer.parseInt(arr.get(0)) ,arr.get(1), arr.get(2));
					      user.setFirstName(arr.get(3));
					      user.setLastName(arr.get(4));
					      user.setIsLogedIn(true);
					   		if(user.getPermissonType().equals("Member")) // its a subscriber login
					   		{
					   			FXMLLoader loader = new FXMLLoader();
					   			loader.setLocation(getClass().getResource("/boundry/MemberPage.fxml"));
					   			try {
									loader.load();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
					   			Parent parent = (Parent)loader.getRoot();
					   			Scene ResultPanelScene = new Scene(parent);
					   			MemberPageController MPC = (MemberPageController)loader.getController();
					   			MPC.FillMemberDetails(user);
					   			MainProgram.primStg.setScene(ResultPanelScene);
					   		}
					   		else if(user.getPermissonType() == "Librarian") // its a librarian login
					   		{
					   			FXMLLoader loader = new FXMLLoader();
					   			loader.setLocation(getClass().getResource("/boundry/LibrarianPage.fxml"));
					   			try {
									loader.load();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
					   			Parent parent = (Parent)loader.getRoot();
					   			Scene ResultPanelScene = new Scene(parent);
					   			LibrarianPageController LPC = (LibrarianPageController)loader.getController();
					   			LPC.FillLibrarianDetails(user);
					   			MainProgram.primStg.setScene(ResultPanelScene);
					   		}
					   		else if(user.getPermissonType() == "Manager") // its a manager login
					   		{
					   			FXMLLoader loader = new FXMLLoader();
					   			loader.setLocation(getClass().getResource("/boundry/LibraryManagerPage.fxml"));
					   			try {
									loader.load();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
					   			Parent parent = (Parent)loader.getRoot();
					   			Scene ResultPanelScene = new Scene(parent);
					   			LibraryManagerPageController LMC = (LibraryManagerPageController)loader.getController();
					   			LMC.FillManagerDetails(user);
					   			MainProgram.primStg.setScene(ResultPanelScene);
					   		}
				   		}
    	else//user already logged in in another computer
   		{
   			PopUp("Already Logged in!" , "This user is already logged in from another computer");
   		}
  	}
    	}
  	else {
  		PopUp("No input!" , "Please enter an ID and Password");
  			}
    }

    @FXML
    void SearchForABookClicked(ActionEvent event) {

    }

    public void PopUp(String str1 , String str2)
    {
    	Stage popupwindow=new Stage();    	      
		popupwindow.initModality(Modality.APPLICATION_MODAL);
		popupwindow.setTitle(str1);    
		Label label1= new Label(str2);    	
		Button button1= new Button("OK");    		         		     
		button1.setOnAction(e -> popupwindow.close());    		         		     
		VBox layout= new VBox(10);    		        		      
		layout.getChildren().addAll(label1, button1);   		      
		layout.setAlignment(Pos.CENTER);    		      
		Scene scene1= new Scene(layout, 200, 130);    		      
		popupwindow.setScene(scene1);
		popupwindow.showAndWait();  
    }
}
