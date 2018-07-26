package tds.um.vista.manejador;


import java.io.File;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.User;
import insidefx.undecorator.UndecoratorScene;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import tds.um.controlador.AppMusic;
import tds.um.persistencia.AdapatadorUsuarioTDS;
import java.util.Base64;


public class LoginController implements Initializable {
	
	@FXML
	private StackPane panel;
	@FXML
	private JFXTextField usuario;
	@FXML
	private JFXPasswordField password;
	
	@FXML
	private JFXButton botonLogin;
	
	@FXML
	private JFXButton botonFacebook;

	@FXML
	private JFXButton botonRegistrate;
	
	@FXML
	private JFXButton botonCargarCanciones;
	
	@FXML
	private ImageView fondo1;
	
	@FXML
	private Label usuarioIncorrecto;
	
	@FXML
	private Label passwordIncorrecta;
	
	
	static AdapatadorUsuarioTDS uDAO = new AdapatadorUsuarioTDS(); 

	AppMusic controlador = AppMusic.getUnicaInstancia();
	public void initialize(URL location, ResourceBundle resources) {
		
		
		KeyCombination play = new KeyCodeCombination(KeyCode.ENTER);
		this.panel.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {

				if (play.match(event)) {
					botonLogin.fire();
				}
			}
		});
			
	}
	
	private void goToInterfaz(ActionEvent event) throws IOException{		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/tds/um/vista/fxml/interfaz.fxml"));
        Region root = (Region) fxmlLoader.load();   
        
        
        Stage lastStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        lastStage.hide();
        event.consume();
        Stage appStage = new Stage();  
        final UndecoratorScene undecoratorScene = new UndecoratorScene(appStage, root);        
        // Enable fade transition
        /*
        undecoratorScene.setFadeInTransition();
        appStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent we) {
                we.consume();   // Do not hide yet
                //undecoratorScene.setFadeOutTransition();
            }
        });
        */
        undecoratorScene.setFill(Color.TRANSPARENT);
        undecoratorScene.getStylesheets().add(getClass().getResource("/tds/um/vista/fxml/contextmenu.css").toString());
        appStage.initStyle(StageStyle.TRANSPARENT);
        
        appStage.setMinWidth(1024);
        appStage.setMinHeight(576);
        appStage.setWidth(1152);
		appStage.setHeight(648);
        appStage.setScene(undecoratorScene);
        //appStage.setResizable(false);
        appStage.toFront();
        appStage.show(); 
        
        
        //para cerrar todo
    	appStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		    @Override
		    public void handle(WindowEvent t) {
		        Platform.exit();
		        System.exit(0);
		    }
		});
	}
	
	@FXML
	private void tryLog(ActionEvent event) throws IOException {		
		if(!controlador.login(this.usuario.getText(), this.password.getText())){
			this.usuarioIncorrecto.setVisible(true);
			this.passwordIncorrecta.setVisible(true);
		}else {		
			Timeline timeline = new Timeline(new KeyFrame(
			Duration.millis(300),			        
		    ae -> {
				try {
					goToInterfaz(event);
				} catch (IOException e) {						
					e.printStackTrace();
				}        
			}));
			timeline.play();            	
		}
	 }
	
	@FXML
	private void loginFacebook(ActionEvent event) throws IOException, URISyntaxException{
			Timeline timeline = new Timeline(new KeyFrame(
			        Duration.millis(300),			        
	           		ae -> {
						String domain = "https://www.facebook.com/";
						String appId = "114629375984771";					
						String authUrl = "https://graph.facebook.com/oauth/authorize?type=user_agent&client_id="+appId+"&redirect_uri="+domain+"&scope=user_birthday,email";
						String accessToken = "";
						
						
						//Para multiplataforma o mac o windows
						if(System.getProperty("os.name").contains("Windows")) {
							System.setProperty("webdriver.chrome.driver","chromedriver.exe");
						}else {
							System.setProperty("webdriver.chrome.driver","chromedriver");
						}		
						WebDriver driver = new ChromeDriver();  
						
						
						driver.get(authUrl);
									
						
						while(driver != null && !driver.getCurrentUrl().contains("#access_token")) {
												
						}

										
						String url = driver.getCurrentUrl();
						accessToken = url.replaceAll(".*#access_token=(.+)&.*&.*","$1");
						System.out.println(accessToken);
						FacebookClient fbClient = new DefaultFacebookClient(accessToken,Version.VERSION_2_5);					
						User user = fbClient.fetchObject("me", User.class);
						String auxURL = "https://graph.facebook.com/v2.12/"+user.getId()+"/picture?&access_token="+accessToken;
						//La url de la imagen de facebook hace redirect por lo tanto tenemos que burlar ese redirect para coger la imagen original
						HttpURLConnection con;
						try {
							con = (HttpURLConnection) new URL(auxURL).openConnection();
							con.setInstanceFollowRedirects(false);
							con.connect();
							String realURL = con.getHeaderField("Location").toString();						
							byte[] encodedBytes = Base64.getEncoder().encode(user.getId().getBytes());
							String pass = new String(encodedBytes);				
							controlador.loginFB(user.getName(),pass,realURL);
							driver.quit();
							goToInterfaz(event);
						} catch (IOException e) {
								e.printStackTrace();
						}				
            
						}));
			timeline.play();            
	}
	
	@FXML
	private void registrate(ActionEvent event) throws IOException{
		   
		   Timeline timeline = new Timeline(new KeyFrame(
			        Duration.millis(200),
			        
	           		ae -> {
						try {
							FXMLLoader loader = new FXMLLoader(getClass().getResource("/tds/um/vista/fxml/registrate.fxml"));														
				            Parent parent = loader.load();
				            ((Stage)panel.getScene().getWindow()).setScene(new Scene(parent,798,463));
				            
						} catch (IOException e) {					
							e.printStackTrace();
						}
					}));
			timeline.play();				
	}
	
	@FXML
	private void setCarpetaCanciones() {		
		Timeline timeline = new Timeline(new KeyFrame(
			        Duration.millis(300),
			ae -> {
			DirectoryChooser chooser = new DirectoryChooser();
			chooser.setTitle("Elige la carpeta donde estan las canciones");
			File defaultDirectory = new File("/");
			chooser.setInitialDirectory(defaultDirectory);
			File ruta = chooser.showDialog(null);
			if(ruta != null) {
				controlador.cargarCatalogoCanciones(ruta.getAbsolutePath());
			}
		}));
		timeline.play();
		
		
	}
}
