package boundry;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import ClientControl.ClientConsole;
import ClientControl.MainProgram;
import entity.Subscriber;
import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MemberPageController {

	Subscriber sub;
	ClientConsole clientConsole;
    @FXML
    private Label UserNameLabelID;
    
    @FXML
    private AnchorPane MemberPane;
    
    @FXML
    private TextField BookNameID;

    @FXML
    private TextField SubscriberID;

    @FXML
    private Label TimeLabelID;

    @FXML
    private TableView<?> ActivitesLogTableID;

    @FXML
    private TableView<?> SubscriberMessagesTableID;
    
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
    void e49000(ActionEvent event) {

    }

    @FXML
    void ExtendABookButtonClicked(ActionEvent event) {

    }

    @FXML
    void ProfileButtonClicked(ActionEvent event) {

    }

    @FXML
    void LogOutButtonClicked(ActionEvent event) throws IOException {
    	
    	clientConsole.execute(String.format("UPDATE user SET IsLogedIn='%s' WHERE userID= %d " , "No" , sub.getID() ), "user");
		try {
			Thread.currentThread().sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("login.fxml"));
    	MemberPane.getChildren().setAll(pane);
    }

    @FXML
    void SearchForABookButtonClicked(ActionEvent event) {

    }
    
    void FillMemberDetails(User user)
    {
    	sub = new Subscriber(user.getID(),user.getPassword(),user.getPermissonType());
    	sub.setFirstName(user.getFirstName());
    	sub.setLastName(user.getLastName());
    	sub.setPassword(user.getPassword());
    	UserNameLabelID.setText(sub.getFirstName() + " " + sub.getLastName());
    	Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        TimeLabelID.setText( sdf.format(cal.getTime()));

    }
   

}
