package boundry;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import entity.Librarian;
import entity.Subscriber;
import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

public class LibrarianPageController {
	
	private Librarian librarian;

    @FXML
    private TextField bookCatalogNumberToLoanID;
    
    @FXML
    private Label UserNameLabelID;
    
    @FXML
    private Label TimeLabelID;

    @FXML
    private TextField subscriberEmailToRegID;

    @FXML
    private TextField SubscriberLoaningID;

    @FXML
    private DatePicker LoanedDateID;

    @FXML
    private TextField subscriberNameToRegID;

    @FXML
    private TextField bookCatalogNumberToReturnID;

    @FXML
    private TextField subscriberPhoneToRegID;

    @FXML
    private TextField subscriberToRegID;

    @FXML
    private TextField subscriberToViewID;

    @FXML
    private DatePicker retunringDateID;

    @FXML
    private TextField subscriberLastNameToRegID;

    @FXML
    private TextField subscriberPassToRegID;

    @FXML
    private Tab SubscriberToViewID;

    @FXML
    void e49000(ActionEvent event) {

    }

    @FXML
    void VerifySubscriberID(ActionEvent event) {

    }

    @FXML
    void VerifyBookCatalogIDforLoan(ActionEvent event) {

    }

    @FXML
    void LoanConfirmedClicked(ActionEvent event) {

    }

    @FXML
    void VerifyBookCatalogID(ActionEvent event) {

    }

    @FXML
    void ReturnConfirmedClicked(ActionEvent event) {

    }

    @FXML
    void SearchForSubscriberClicked(ActionEvent event) {

    }

    @FXML
    void RegisterNewMemberClicked(ActionEvent event) {

    }

    @FXML
    void AddBookToStockClicked(ActionEvent event) {

    }

    @FXML
    void RemoveBookFromStockClicked(ActionEvent event) {

    }

    @FXML
    void ProfileButtonClicked(ActionEvent event) {

    }

    @FXML
    void LogOutButtonClicked(ActionEvent event) {

    }

    @FXML
    void SearchForABookButtonClicked(ActionEvent event) {

    }
    
    void FillLibrarianDetails(User user)
    {
    	librarian = new Librarian(user.getID(),user.getPassword(),user.getPermissonType());
    	librarian.setFirstName(user.getFirstName());
    	librarian.setLastName(user.getLastName());
    	librarian.setPassword(user.getPassword());
    	UserNameLabelID.setText(librarian.getFirstName() + " " + librarian.getLastName());
    	Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        TimeLabelID.setText( sdf.format(cal.getTime()));

    }

}
