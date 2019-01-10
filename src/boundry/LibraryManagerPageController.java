package boundry;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import entity.LibrarayManger;
import entity.Subscriber;
import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LibraryManagerPageController {
	
	LibrarayManger manager;

    @FXML
    private TextField bookCatalogNumberToLoanID;

    @FXML
    private TextField subscriberToRegID;

    @FXML
    private TextField SubscriberLoaningID;
    
    @FXML
    private Label UserNameLabelID;

    @FXML
    private Label TimeLabelID;

    @FXML
    private DatePicker LoanedDateID;

    @FXML
    private TextField subscriberToViewID;

    @FXML
    private DatePicker retunringDateID;

    @FXML
    private TextField subscriberLastNameToRegID;

    @FXML
    private TextField subscriberPassToRegID;

    @FXML
    private TextField subscriberNameToRegID;

    @FXML
    private TextField bookCatalogNumberToReturnID;

    @FXML
    void e49000(ActionEvent event) {

    }

    @FXML
    void LoanConfirmedClicked(ActionEvent event) {

    }

    @FXML
    void ReturnConfirmedClicked(ActionEvent event) {

    }

    @FXML
    void SearchForSubscriberClicked(ActionEvent event) {

    }

    @FXML
    void ActivitesInformationButtonClicked(ActionEvent event) {

    }

    @FXML
    void laonsBookButtonClicked(ActionEvent event) {

    }

    @FXML
    void LateReturningBooksButtonClicked(ActionEvent event) {

    }

    @FXML
    void ProfileButtonClicked(ActionEvent event) {

    }

    @FXML
    void LogOutButtonClicked(ActionEvent event) {

    }

    @FXML
    void SearchForABookClicked(ActionEvent event) {

    }
    
    void FillManagerDetails(User user)
    {
    	manager = new LibrarayManger(user.getID(),user.getPassword(),user.getPermissonType());
    	manager.setFirstName(user.getFirstName());
    	manager.setLastName(user.getLastName());
    	manager.setPassword(user.getPassword());
    	UserNameLabelID.setText(manager.getFirstName() + " " + manager.getLastName());
    	Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        TimeLabelID.setText( sdf.format(cal.getTime()));

    }

}
