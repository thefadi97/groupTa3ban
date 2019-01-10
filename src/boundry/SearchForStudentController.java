package boundry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import com.mysql.fabric.xmlrpc.Client;

import ClientControl.ClientConsole;
import ClientControl.MainProgram;
import ClientControl.SearchIF;
import entity.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SearchForStudentController {
	//public static Semaphore sem1 = new Semaphore(0);
	private Student studentRespond;
	ClientConsole clientConsole;
    
    @FXML
    private TextField studentID;
    
    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button SearchBtn;


    @FXML 
    public void initialize()
    {
    	if(MainProgram.host.equals("localhost"))
    		clientConsole = new ClientConsole();
    	else {
    		clientConsole = new ClientConsole(MainProgram.host , MainProgram.DEFAULT_PORT);
    	}
    }
    
    @FXML
    void Searchbutton(ActionEvent event) throws IOException, InterruptedException {
    	if(!studentID.getText().isEmpty()) { // if the user entered ID
    		  FXMLLoader loader = new FXMLLoader();
		      loader.setLocation(getClass().getResource("/boundry/studentInfo.fxml"));
		      loader.load();
		      Parent parent = (Parent)loader.getRoot();
		      Scene ResultPanelScene = new Scene(parent);
		      clientConsole.execute(String.format("SELECT * FROM student where StudentID = %d ", Integer.parseInt(studentID.getText())) , " ");
		      //sem1.acquire();
		      Thread.currentThread().sleep(200);
		      Object obj =  clientConsole.getObject();
		      ArrayList<String> arr = new ArrayList<String>();
		      arr = (ArrayList) obj;
				   if(arr != null )
				   		{
					   		studentRespond = new Student((Integer.parseInt(arr.get(0))), arr.get(1) ,arr.get(2) , arr.get(3) , (Integer.parseInt(arr.get(4))));
					   		StudentInfoController si = (StudentInfoController)loader.getController();
				   			si.FillStudentInfo(studentRespond);
				   			MainProgram.primStg.setScene(ResultPanelScene);
				   		}
				   else {
					 PopUp("Wrong Details!" , "No student with this ID");
				 }
    	}
    	else {
    		PopUp("No input!" , "Please enter an ID");
    		
    	}
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
