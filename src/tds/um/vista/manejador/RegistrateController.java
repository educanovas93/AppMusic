package tds.um.vista.manejador;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import tds.um.controlador.AppMusic;

public class RegistrateController implements Initializable {

	@FXML
	private JFXTextField apellidos;
	
	@FXML
	private Label wrongApellidos;

	@FXML
	private JFXPasswordField password;
	
	@FXML
	private Label wrongPassword;

	@FXML
	private JFXButton botonCancelar;

	@FXML
	private JFXDatePicker fechaNacimiento;
	@FXML
	private Label wrongFecha;

	@FXML
	private StackPane panelReg;

	@FXML
	private JFXButton botonReg;

	@FXML
	private JFXTextField usuario;
	
	@FXML
	private Label wrongUsuario;
	
	@FXML
	private JFXTextField nombre;
	
	@FXML
	private Label wrongNombre;

	@FXML
	private JFXTextField email;
	
	@FXML
	private Label wrongMail;
	
	private static final Pattern EMAIL_VALIDO = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


	AppMusic controlador = AppMusic.getUnicaInstancia();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		KeyCombination play = new KeyCodeCombination(KeyCode.ENTER);
		this.panelReg.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {

				if (play.match(event)) {
					botonReg.fire();
				}
			}
		});

	}

	private void goToLogin(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/tds/um/vista/fxml/login.fxml"));
		Parent parent = loader.load();
		Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		appStage.setScene(new Scene(parent, 798, 463));
	}
	
	@FXML
	private void cancelarRegistro(ActionEvent event) throws IOException {
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200), ae -> {
			try {
				goToLogin(event);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}));
		timeline.play();
	}

	
	private boolean validarMail(String email) {
		Matcher matcher = EMAIL_VALIDO.matcher(email);
		return matcher.find();
	}
	
	@FXML
	private void registro(ActionEvent event) throws IOException {
		boolean puedoReg = true;
		
		if(this.nombre.getText().equals("")) {
			wrongNombre.setVisible(true);
			puedoReg = false;
		}else {
			wrongNombre.setVisible(false);
		}
		
		if(this.apellidos.getText().equals("")) {
			wrongApellidos.setVisible(true);
			puedoReg = false;
		}else {
			wrongApellidos.setVisible(false);
		}
		
		if(this.email.getText().equals("")) {
			wrongMail.setText("Campo obligatorio *");
			wrongMail.setVisible(true);
			puedoReg = false;
		}else if (!validarMail(this.email.getText())) {
			wrongMail.setText("Email no válido *");
			wrongMail.setVisible(true);
			puedoReg = false;
			
		}else {
			wrongMail.setVisible(false);
		}
		
		if(this.password.getText().equals("")) {
			wrongPassword.setVisible(true);
			puedoReg = false;
		}else {
			wrongPassword.setVisible(false);
		}
		
		if(this.usuario.getText().equals("")) {
			wrongUsuario.setVisible(true);
			puedoReg = false;
		}else {
			wrongUsuario.setVisible(false);
		}
		
		
		if(this.fechaNacimiento.getValue() == null) {
			wrongFecha.setVisible(true);
			puedoReg = false;
		}else {
			wrongFecha.setVisible(false);
		}
		
		if(puedoReg) {

			if (AppMusic.getUnicaInstancia().registrarUsuario(this.nombre.getText(), this.apellidos.getText(),
					this.email.getText(), this.usuario.getText(), this.password.getText(),
					this.fechaNacimiento.getValue(),null)) {
				JFXDialogLayout content = new JFXDialogLayout();
				content.setHeading(new Text("Registro Satisfactorio"));
				content.setBody(new Text("Tus datos de usuario son los siguientes:\nNombre: "
						+ this.nombre.getText() + "\nApellidos: " + this.apellidos.getText() + "\nEmail: " + this.email.getText() + "\nNick de Usuario: "
						+ this.usuario.getText() + "\nPassword:" + "**********" + "\nFecha de Nacimiento: "
						+ this.fechaNacimiento.getValue().toString() + "\n"));

				JFXDialog dialog = new JFXDialog(panelReg, content, JFXDialog.DialogTransition.CENTER);
				JFXButton button = new JFXButton("Lo tengo!");
				button.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						dialog.close();
						try {
							goToLogin(event);
						} catch (Exception e) {

						}

					}
				});
				content.setActions(button);
				dialog.show();
			} else {
				JFXDialogLayout content = new JFXDialogLayout();
				JFXDialog dialog = new JFXDialog(panelReg, content, JFXDialog.DialogTransition.CENTER);
				content.setHeading(new Text("Fallo al registrarse,intentalo de nuevo"));
				content.setBody(new Text("El nick de usuario " + this.usuario.getText() + " no esta disponible."));
				JFXButton button = new JFXButton("Lo tengo!");
				button.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						dialog.close();
						try {
							dialog.close();
						} catch (Exception e) {

						}

					}
				});
				content.setActions(button);
				dialog.show();
				
				
				
				dialog.show();
			}
		}


	}
}
