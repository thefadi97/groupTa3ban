package ClientControl;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


//***the program class is a client in our case!***///

public class MainProgram extends Application {
		
	public static String host;
	final public static int DEFAULT_PORT = 5555;
	public static Stage primStg;
	
	
    public static void main(String[] args) {
    	try {
    		host = args[0];
    	}
    	catch(Exception e)
    	{
    		host = "localhost";
    	}
        launch(args);

    }
    @Override

    public void start(Stage primaryStage) throws Exception{
    	Parent  root =   FXMLLoader.load(getClass().getResource("/boundry/login.fxml"));
    	Scene scene = new Scene(root);
    	this.primStg = primaryStage;
    	primaryStage.setTitle("OBL System");
    	primaryStage.setScene(scene);
    	primaryStage.show();

    }
    
   

}
