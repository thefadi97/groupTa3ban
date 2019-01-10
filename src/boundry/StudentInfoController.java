package boundry;
import java.io.IOException;
import java.util.ArrayList;

import ClientControl.ClientConsole;
import ClientControl.MainProgram;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StudentInfoController {

	 ClientConsole clientConsole;
	  @FXML
	    private Button BackbtnID;


	    @FXML
	    private ComboBox ComboBoxID;
	    ObservableList<String> list;
	    @FXML
	    private Button StatusUpdtBtn;

	    @FXML
	    private AnchorPane anchorPane;

	    @FXML
	    private AnchorPane studentInfoPane;

	    @FXML
	    private TextField StudentIDField;

	    @FXML
	    private TextField StudentNameField;

	    @FXML
	    private TextField StudentStatusField;

	    @FXML
	    private TextField StudentOprField;


	    @FXML
	    private TextField newStatusTextField;
	    
	    @FXML
	    private CheckBox checkBoxID;
	    
	    @FXML 
	    public void initialize()
	    {
	    	setStatusComboBox() ;
	    	if(MainProgram.host.equals("localhost"))
	    		clientConsole = new ClientConsole();
	    	else {
	    		clientConsole = new ClientConsole(MainProgram.host , MainProgram.DEFAULT_PORT);
	    	}
	    }

    @FXML
    void backButtonClicked(ActionEvent event) throws IOException {
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("SearchForStudent.fxml"));
    	studentInfoPane.getChildren().setAll(pane);
    }

    @FXML
    void UpdateButtonClicked(ActionEvent event) {

    	if(ComboBoxID.getValue() != null)
    	{
    		if(StudentStatusField.getText() == "Frozen" )
    		{
    			if(checkBoxID.isSelected())
    			{
    				checkBoxID.setSelected(false);
    			}
    		}
    		clientConsole.execute(String.format("UPDATE student SET StatusMembership='%s'  WHERE StudentID= %d ", (String)ComboBoxID.getValue() , Integer.parseInt(StudentIDField.getText())) , " ");
    		StudentStatusField.setText((String)ComboBoxID.getValue());
    		
    		
    	}
    	else
    	{
    		PopUp("No Input " , "Please choose a new status for this student!");
    	}
    	
    }
   
    public void FillStudentInfo(Student s)
    {
    	//checkBoxID.setDisable(true);
    	StudentIDField.setText(Integer.toString(s.getStudentID()));
    	StudentNameField.setText(s.getStudentName());
    	StudentStatusField.setText(s.getStudentMemberShip());
    	StudentOprField.setText(s.getOperation());
    	if(s.getFrozen() == 1)
    	{
    		checkBoxID.setSelected(true);
    	}
    	else
    	{
    		checkBoxID.setSelected(false);
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
		Scene scene1= new Scene(layout, 350, 150);    		      
		popupwindow.setScene(scene1);
		popupwindow.showAndWait();  
    }
    
    private void setStatusComboBox() {
    	
  		ArrayList<String> al = new ArrayList<String>();	
  		al.add("Active");
  		al.add("NotRegistered");
  		al.add("Frozen");
  		al.add("Locked");
  		list = FXCollections.observableArrayList(al);
  		ComboBoxID.setItems(list);
  	}
}
