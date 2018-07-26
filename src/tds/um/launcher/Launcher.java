package tds.um.launcher;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Launcher extends Application {
	@Override

    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tds/um/vista/fxml/login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
		primaryStage.setMinWidth(550);
		primaryStage.setMinHeight(450);
		
		primaryStage.setMaxWidth(798);
		primaryStage.setMaxHeight(463);
	
		
	
        primaryStage.setResizable(true);
        
		
        primaryStage.setScene(scene);
        primaryStage.show();
        
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		    @Override
		    public void handle(WindowEvent t) {
		        Platform.exit();
		        System.exit(0);
		    }
		});
       	
		 
    }

    // main method to support non-JavaFX-aware environments:

    public static void main(String[] args) {
        // starts the FX toolkit, instantiates this class, 
        // and calls start(...) on the FX Application thread:
        launch(args); 
    }
}
