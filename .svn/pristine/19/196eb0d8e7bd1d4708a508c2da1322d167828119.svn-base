package tds.um.vista.manejador;



import java.io.File;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.*;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import javafx.util.Duration;
import javafx.util.StringConverter;
import tds.um.controlador.AppMusic;
import tds.um.modelo.Cancion;
import tds.um.modelo.ListaCanciones;

public class InterfazController implements Initializable {

	@FXML
	private StackPane panelPila;

	@FXML
	private BorderPane panelPrincipal;

	@FXML
	private GridPane panelExplorar;

	@FXML
	private GridPane panelNuevaLista;

	@FXML
	private GridPane panelReciente;

	@FXML
	private GridPane panelMisListas;

	@FXML
	private GridPane panelReproductor;
	
	@FXML
	private GridPane panelMasReproducidas;
	
	@FXML
	private GridPane gridMenu;

	@FXML
	private ImageView botonBack;

	@FXML
	private ImageView botonForward;

	@FXML
	private ImageView botonReplay;

	@FXML
	private ImageView botonReplayPress;

	@FXML
	private ImageView botonPlay;

	@FXML
	private ImageView botonPause;

	@FXML
	private ImageView botonStop;

	@FXML
	private ImageView muted;

	@FXML
	private ImageView unmuted;

	@FXML
	private ImageView imagenUser;

	@FXML
	private Button boton;

	@FXML
	private JFXSlider timeSlider;

	@FXML
	private JFXSlider volumeSlider;

	@FXML
	private Label playTime;

	@FXML
	private Label transcurrido;

	@FXML
	private Label duracion;

	@FXML
	private Label tituloCancionActual;

	@FXML
	private Label interpreteCancionActual;

	@FXML
	private JFXListView<PanelLabel> list;

	@FXML
	private JFXListView<ListaCanciones> listaRepMenu;

	@FXML
	private JFXButton botonBuscar;

	@FXML
	private JFXButton botonMejorar;

	@FXML
	private JFXButton botonCancelar;
	
	@FXML
	private TableView<Cancion> tablaBusqueda;

	@FXML
	private JFXTextField interprete;

	@FXML
	private JFXTextField titulo;

	@FXML
	private JFXComboBox<String> estilo;

	@FXML
	private ImageView albumCover;

	@FXML
	private TableView<Cancion> tablaMisListas;

	@FXML
	private TableView<Cancion> tablaReciente;
	
	@FXML
	private TableView<Cancion> tablaMasReproducidas;

	@FXML
	private Label labelLista;
	@FXML
	private ContextMenu cm;

	@FXML
	private SplitMenuButton menuUsuario;

	@FXML
	private Label labelBienvenido;

	@FXML
	private Text textoBienvenido;

	@FXML
	private MenuItem menuMejorar;

	@FXML
	private TableView<Cancion> tablaBusquedaNueva;

	@FXML
	private TableView<Cancion> tablaNuevaLista;

	@FXML
	private JFXComboBox<ListaCanciones> comboListas;

	@FXML
	private JFXButton botonVerNew;

	@FXML
	private JFXTextField tituloNew;

	@FXML
	private JFXTextField interpreteNew;

	@FXML
	private JFXComboBox<String> estiloNew;

	@FXML
	private JFXButton addNew;

	@FXML
	private JFXButton remNew;
	
	@FXML
	private JFXButton botonNuevaLista;

	@FXML
	private JFXButton guardarListaNew;

	@FXML
	private JFXButton cancelarNew;

	@FXML
	private JFXButton eliminarLista;

	@FXML
	private Label labelNombreLista;

	private String nombreListaAux = "";
	private AppMusic controlador = AppMusic.getUnicaInstancia();
	private TableView<Cancion> tablaActual = new TableView<Cancion>();
	private double volumenAnterior = 100;
	private MediaPlayer mediaPlayer;
	private boolean repeat = false;
	private boolean atEndOfMedia = false;
	private Duration duration;
	private boolean mismaLista = false;
	private ObservableList<Cancion> cancionesLista;
	private ListaCanciones listaActual;
	private boolean reproduciendoLista = false;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		construirMenu();
		inicializarEstilos();
		inicializarEstilosNew();
		inicializarUsuario();
		inicializarComboListas();
		inicializarMenuUsuario();
		botonNuevaLista.setOnAction(e -> {
			nuevaLista(null);
		});
		
		if(controlador.getCurrentUser().isPremium()) {
			if(controlador.isBirthday(controlador.getCurrentUser())) {
				birthday();
			}
			this.botonMejorar.setVisible(false);
			this.botonCancelar.setVisible(true);
		}else {
			this.botonCancelar.setVisible(false);
			this.botonMejorar.setVisible(true);
		}
				
		KeyCombination play = new KeyCodeCombination(KeyCode.SPACE);
		this.panelReproductor.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {

				if (play.match(event)) {
					try {
						playPause();
					} catch (URISyntaxException e) {
						e.printStackTrace();
					}
				}
			}
		});
	
	}

	private void moverTexto() {
		double sceneWidth = -50;
		double msgWidth = textoBienvenido.getLayoutBounds().getWidth();

		KeyValue initKeyValue = new KeyValue(textoBienvenido.translateXProperty(), sceneWidth);
		KeyFrame initFrame = new KeyFrame(Duration.ZERO, initKeyValue);

		KeyValue endKeyValue = new KeyValue(textoBienvenido.translateXProperty(), 1.0 * msgWidth);
		KeyFrame endFrame = new KeyFrame(Duration.seconds(10), endKeyValue);

		Timeline timeline = new Timeline(initFrame, endFrame);

		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}
	
	@FXML
	private void cancelarBusqueda() {
		this.tablaBusqueda.setVisible(false);
	}
	private void inicializarEstilos() {
		estilo.setEditable(true);
		estilo.getEditor().setEditable(false);
		estilo.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			@Override
			public ListCell<String> call(ListView<String> param) {
				final ListCell<String> cell = new ListCell<String>() {
					{
						super.setPrefWidth(100);
					}

					@Override
					public void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (item != null) {
							setText(item);
						} else {
							setText(null);
						}
					}
				};
				return cell;
			}

		});

		estilo.setConverter(new StringConverter<String>() {

			@Override
			public String toString(String object) {
				return object == null ? "" : object;
			}

			@Override
			public String fromString(String string) {
				return estilo.getItems().stream().filter(i -> i.equals(string)).findAny().orElse(null);
			}

		});
		estilo.setItems(FXCollections.observableArrayList(controlador.getEstilos()));
		estilo.getSelectionModel().selectFirst();
	}

	private void inicializarEstilosNew() {
		estiloNew.setEditable(true);
		estiloNew.getEditor().setEditable(false);
		estiloNew.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			@Override
			public ListCell<String> call(ListView<String> param) {
				final ListCell<String> cell = new ListCell<String>() {
					{
						super.setPrefWidth(100);
					}

					@Override
					public void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (item != null) {
							setText(item);
						} else {
							setText(null);
						}
					}
				};
				return cell;
			}

		});

		estiloNew.setConverter(new StringConverter<String>() {

			@Override
			public String toString(String object) {
				return object == null ? "" : object;
			}

			@Override
			public String fromString(String string) {
				return estiloNew.getItems().stream().filter(i -> i.equals(string)).findAny().orElse(null);
			}
		});
		
		estiloNew.setItems(FXCollections.observableArrayList(controlador.getEstilos()));
		estiloNew.getSelectionModel().selectFirst();
	}

	@FXML
	private void cerrarSesion(ActionEvent event) {
		//cerramos la ventana actual
		Stage aux = (Stage) panelPrincipal.getScene().getWindow();
		aux.close();
		if(mediaPlayer != null) {
			mediaPlayer.dispose();
		}
		controlador.cerrarSesion();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/tds/um/vista/fxml/login.fxml"));
		Parent root;
		try {
			root = loader.load();
	
		Scene scene = new Scene(root);
		Stage appStage = new Stage();
		appStage.setMinWidth(550);
		appStage.setMinHeight(450);
		
		appStage.setMaxWidth(798);
		appStage.setMaxHeight(463);

		appStage.setResizable(true);

		appStage.setScene(scene);
		appStage.show();
		
		//para poder cerrar
		appStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		    @Override
		    public void handle(WindowEvent t) {
		        Platform.exit();
		        System.exit(0);
		    }
		});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@FXML
	private void mejorarCuenta(ActionEvent event) {		
		JFXDialogLayout content = new JFXDialogLayout();
		content.setHeading(new Text(controlador.getCurrentUser().getDescuento().getMensajeCuota()));
		JFXDialog dialogPremium = new JFXDialog(panelPila, content, JFXDialog.DialogTransition.CENTER);

		JFXButton gracias = new JFXButton("Pagar");
		
		gracias.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				controlador.mejorarCuenta(controlador.getCurrentUser());
				inicializarMenuUsuario();
				botonMejorar.setVisible(false);
				botonCancelar.setVisible(true);
				dialogPremium.close();
			}

		});
		content.setActions(gracias);
		dialogPremium.show();
	}
	
	@FXML
	private void cancelarSuscripcion(ActionEvent event) {
		controlador.cancelarSuscripcion(controlador.getCurrentUser());
		inicializarMenuUsuario();
		this.botonCancelar.setVisible(false);
		this.botonMejorar.setVisible(true);
	}

	private void inicializarMediaPlayer() {

		try {
			com.sun.javafx.application.PlatformImpl.startup(() -> {
			});
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Exception: " + ex.getMessage());
		}
		mediaPlayer.setVolume(volumenAnterior);

		mediaPlayer.currentTimeProperty().addListener(new InvalidationListener() {
			public void invalidated(Observable ov) {
				updateValues();
			}
		});

		mediaPlayer.setOnPlaying(new Runnable() {
			public void run() {
				botonPlay.setVisible(false);
				botonPause.setVisible(true);
			}
		});

		mediaPlayer.setOnPaused(new Runnable() {
			public void run() {
				botonPause.setVisible(false);
				botonPlay.setVisible(true);
			}
		});

		mediaPlayer.setOnReady(new Runnable() {
			public void run() {
				duration = mediaPlayer.getMedia().getDuration();
				updateValues();
			}
		});

		mediaPlayer.setCycleCount(repeat ? MediaPlayer.INDEFINITE : 1);
		
		mediaPlayer.setOnEndOfMedia(new Runnable() {
			public void run() {
				if (!repeat) {
					if (tablaActual != null) {
						volumenAnterior = mediaPlayer.getVolume();
						next(null);
						mediaPlayer.setVolume(volumenAnterior);
						updateValues();
						mediaPlayer.play();
					} else {
						botonPause.setVisible(false);
						botonPlay.setVisible(true);
						mediaPlayer.seek(mediaPlayer.getStartTime());
						mediaPlayer.pause();
						updateValues();
					}
				} else {
					mediaPlayer.seek(mediaPlayer.getStartTime());
					updateValues();
				}
			}
		});

		// listeners del slider de tiempo

		timeSlider.valueProperty().addListener(new InvalidationListener() {
			public void invalidated(Observable ov) {
				if (timeSlider.isValueChanging()) {
					mediaPlayer.seek(duration.multiply(timeSlider.getValue() / 100.0));
				}
			}
		});

		timeSlider.valueProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue arg0, Object arg1, Object arg2) {

				if (timeSlider.isPressed()) {
					mediaPlayer.seek(duration.multiply(timeSlider.getValue() / 100.0));
				}
			}
		});
		
		// Listener del slider de volumen
		volumeSlider.valueProperty().addListener(new ChangeListener() {

			@Override
			public void changed(ObservableValue arg0, Object arg1, Object arg2) {
				if (mediaPlayer.getVolume() == 0) {
					muted.setVisible(false);
					unmuted.setVisible(true);
					mediaPlayer.setMute(false);
				}
				if (volumeSlider.getValue() == 0 && !mediaPlayer.isMute()) {
					muted.setVisible(true);
					unmuted.setVisible(false);
					mediaPlayer.setMute(true);
				}
				mediaPlayer.setVolume(volumeSlider.getValue() / 100.0);
			}
		});

	}

	private void cargarCancion(Cancion cancion) {
		if (cancion != null) {
			File f;
			try {
				if (mediaPlayer != null) {
					volumenAnterior = mediaPlayer.getVolume();
					mediaPlayer.dispose();
				}
				Image disco = new Image(
						this.getClass().getResource("/tds/um/vista/fxml/imagenes/disco.png").toURI().toString());
				albumCover.setImage(disco);
				Media hit;
				if(!cancion.getRutaFichero().contains("http")) {
					f = new File(cancion.getRutaFichero());
					hit = new Media(f.toURI().toString());
					
				}else {
					hit = new Media(cancion.getRutaFichero());
				}
				hit.getMetadata().addListener(new MapChangeListener<String, Object>() {
					@Override
					public void onChanged(Change<? extends String, ? extends Object> ch) {
						if (ch.wasAdded()) {
							handleMetadata(ch.getKey(), ch.getValueAdded());
						}
					}
				});
				interpreteCancionActual.setText(cancion.getInterprete().getNombre());
				tituloCancionActual.setText(cancion.getTitulo());
				controlador.addNumReproducciones(cancion);
				controlador.addCancionRecientes(controlador.getCurrentUser(), cancion);
				tablaMasReproducidas.refresh();
				tablaReciente.refresh();
				mediaPlayer = new MediaPlayer(hit);
				inicializarMediaPlayer();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
	}

	private void handleMetadata(String key, Object value) {
		if (key.equals("image")) {
			albumCover.setImage((Image) value);
		}
	}
	
	@FXML
	private void next(MouseEvent event) {
		if (tablaActual.getSelectionModel().getSelectedIndex() + 1 < tablaActual.getItems().size()) {
			volumenAnterior = mediaPlayer.getVolume();
			tablaActual.getSelectionModel().select(tablaActual.getSelectionModel().getSelectedIndex()+1);
			mediaPlayer.setVolume(volumenAnterior);
			updateValues();
			mediaPlayer.play();
		} else {
			tablaActual.getSelectionModel().selectFirst();
		}
	}

	@FXML
	private void previous(MouseEvent event) {
		if (tablaActual.getSelectionModel().getSelectedIndex() - 1 >= 0) {
			volumenAnterior = mediaPlayer.getVolume();
			tablaActual.getSelectionModel().select(tablaActual.getSelectionModel().getSelectedIndex()-1);
			mediaPlayer.setVolume(volumenAnterior);
			updateValues();
			mediaPlayer.play();
		} else {
			tablaActual.getSelectionModel().selectLast();
		}
	}

	@FXML
	private void mute(MouseEvent event) {
		if(mediaPlayer != null) {
			if (mediaPlayer.isMute()) {
				this.unmuted.setVisible(true);
				this.muted.setVisible(false);
				mediaPlayer.setMute(false);
				mediaPlayer.setVolume(volumenAnterior);
			} else {
				this.muted.setVisible(true);
				this.unmuted.setVisible(false);
				mediaPlayer.setMute(true);
				volumenAnterior = mediaPlayer.getVolume();
				volumeSlider.setValue(0);
			}
		}
	}
	
	@FXML
	private void playPause() throws URISyntaxException {	
		Status status;
		if(mediaPlayer != null) {
			status = mediaPlayer.getStatus();
		}else {return;}

		if (status == Status.UNKNOWN || status == Status.HALTED) {
			return;
		}

		if (status == Status.PAUSED || status == Status.READY || status == Status.STOPPED) {
			if (atEndOfMedia) {
				mediaPlayer.seek(mediaPlayer.getStartTime());
				atEndOfMedia = false;
			}
			mediaPlayer.play();
		} else {
			mediaPlayer.pause();
		}
	}
	
	@FXML
	private void stop(MouseEvent event) {
		if(mediaPlayer != null) {
			this.botonPause.setVisible(false);
			this.botonPlay.setVisible(true);
			mediaPlayer.seek(mediaPlayer.getStartTime());
			updateValues();
			mediaPlayer.pause();
		}
	}

	@FXML
	private void repeat(MouseEvent event) {
		if (repeat == true) {
			this.botonReplay.setVisible(true);
			this.botonReplayPress.setVisible(false);
			repeat = false;
		} else {
			this.botonReplayPress.setVisible(true);
			this.botonReplay.setVisible(false);
			repeat = true;
		}
	}

	private void construirMenu() {

		Label explorarLabel = new Label("Explorar");
		Label nuevaListaLabel = new Label("Nueva Lista");
		Label recienteLabel = new Label("Reciente");
		Label masRepLabel = new Label("Mas reproducidas");
		Label misListasLabel = new Label("Mis Listas");

		PanelLabel explorar = new PanelLabel(explorarLabel, panelExplorar);
		PanelLabel reciente = new PanelLabel(recienteLabel, panelReciente);
		PanelLabel nuevaLista = new PanelLabel(nuevaListaLabel, panelNuevaLista);
		PanelLabel masReproducidas = new PanelLabel(masRepLabel,panelMasReproducidas);
		PanelLabel misListas = new PanelLabel(misListasLabel, panelMisListas);
		

		list.getItems().addAll(explorar, reciente, nuevaLista,masReproducidas, misListas);

		list.setCellFactory(new Callback<ListView<PanelLabel>, ListCell<PanelLabel>>() {

			@Override
			public JFXListCell<PanelLabel> call(ListView<PanelLabel> param) {
				JFXListCell<PanelLabel> cell = new JFXListCell<PanelLabel>() {

					@Override
					protected void updateItem(PanelLabel item, boolean empty) {
						super.updateItem(item, empty);
						if (item != null) {
							setText(item.etiqueta.getText());
						} else {
							setText("");
						}
					}
				};
				return cell;
			}
		});

		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<PanelLabel>() {
			@Override
			public void changed(ObservableValue<? extends PanelLabel> observable, PanelLabel oldValue,
					PanelLabel newValue) {
				PanelLabel aux = list.getSelectionModel().getSelectedItem();
				aux.getPanel().setVisible(true);
				for (PanelLabel p : list.getItems()) {
					if (!p.etiqueta.getText().equals(aux.getEtiqueta().getText())) {
						p.getPanel().setVisible(false);
					}
				}
				if (aux.getEtiqueta().equals(misListasLabel)) {					
					panelMisListas.setVisible(true);
					inicializarMisListas();
					
					if(reproduciendoLista == true) {
						listaRepMenu.getSelectionModel().select(listaActual);
					}else {
						tablaMisListas.setVisible(true);
						tablaMisListas.toFront();
						
					}
					
					
				} else if (aux.getEtiqueta().equals(recienteLabel)) {
					cargarRecientes();
					listaRepMenu.setVisible(false);
				} else if (aux.getEtiqueta().equals(masRepLabel)) {
					if(controlador.getCurrentUser().isPremium()) {
						cargarMasReproducidas();
					}else {
						aux.panel.setVisible(false);
						JFXDialogLayout content = new JFXDialogLayout();
						content.setHeading(new Text("Para acceder a este contenido debes ser premium"));
						JFXDialog dialogMasRep = new JFXDialog(panelPila, content, JFXDialog.DialogTransition.CENTER);

						JFXButton cerrar = new JFXButton("Cerrar");
						
						cerrar.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								dialogMasRep.close();
							}

						});
						content.setActions(cerrar);
						dialogMasRep.show();	
					}
					listaRepMenu.setVisible(false);
				} else {
					listaRepMenu.setVisible(false);
				}
			}
		});

	}

	private class PanelLabel {

		private Label etiqueta;
		private Pane panel;

		public PanelLabel(Label etiqueta, Pane panel) {
			this.etiqueta = etiqueta;
			this.panel = panel;
		}

		public Label getEtiqueta() {
			return this.etiqueta;
		}

		public Pane getPanel() {
			return this.panel;
		}

	}

	private void inicializarMisListas() {
		ObservableList styles = listaRepMenu.getStylesheets();
		listaRepMenu = new JFXListView<ListaCanciones>();
		gridMenu.add(listaRepMenu, 0,1);
		listaRepMenu.setPrefWidth(173);
		listaRepMenu.setPrefHeight(262);
		listaRepMenu.getStylesheets().setAll(styles);
		listaRepMenu.setStyle("-fx-background-color:  #0e0f0f; -fx-text-fill: white");

		listaRepMenu.setVisible(true);
		labelLista.setText("Selecciona una PlayList");

		listaRepMenu.setCellFactory(new Callback<ListView<ListaCanciones>, ListCell<ListaCanciones>>() {

			@Override
			public JFXListCell<ListaCanciones> call(ListView<ListaCanciones> param) {
				JFXListCell<ListaCanciones> cell = new JFXListCell<ListaCanciones>() {

					@Override
					protected void updateItem(ListaCanciones item, boolean empty) {
						super.updateItem(item, empty);
						if (item != null) {
							setText("► " + item.getNombreLista());
						} else {
							setText("");
						}
					}
				};
				return cell;
			}
		});

		listaRepMenu.setItems(FXCollections.observableArrayList(controlador.getCurrentUser().getListasReproduccion()));
		

		listaRepMenu.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ListaCanciones>() {
			@Override
			public void changed(ObservableValue<? extends ListaCanciones> observable, ListaCanciones oldValue,
					ListaCanciones newValue) {

				if(listaActual != null && reproduciendoLista && listaActual.equals(listaRepMenu.getSelectionModel().getSelectedItem())) {
					mismaLista = true;
					int indice = tablaActual.getSelectionModel().getSelectedIndex();
					cargarListaOtro(listaRepMenu.getSelectionModel().getSelectedItem());
					tablaActual.getSelectionModel().select(indice);
					mismaLista = false;
				}else {
					cargarListaOtro(listaRepMenu.getSelectionModel().getSelectedItem());	
				}				
			}
		});
				
	}

	@FXML
	private void realizarBusqueda() {

		tablaBusqueda = new TableView<Cancion>();
		panelExplorar.add(tablaBusqueda, 0, 2,5,2);
		this.tablaBusqueda.setVisible(true);
		// this.tablaActual = tablaBusqueda;
		this.tablaBusqueda.getItems().clear();
		tablaBusqueda.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		TableColumn<Cancion, String> tituloCol = new TableColumn<>("Titulo");
		TableColumn<Cancion, String> interpreteCol = new TableColumn<>("Interprete");

		tituloCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
		interpreteCol.setCellValueFactory(
				cellData -> new SimpleStringProperty(cellData.getValue().getInterprete().getNombre()));

		ObservableList<Cancion> canciones = FXCollections.observableArrayList(
				controlador.busquedaCanciones(titulo.getText(), interprete.getText(), estilo.getValue()));

		tablaBusqueda.setItems(canciones);
		tablaBusqueda.getColumns().setAll(tituloCol, interpreteCol);

		cm.getItems().clear();

		MenuItem mi1 = new MenuItem("Reproducir");
		// mi1.setStyle("");
		cm.getItems().add(mi1);

		Menu mi2 = new Menu("Añadir a PlayList");

		cm.getItems().add(mi2);

		MenuItem nueva = new MenuItem("Nueva Lista");
		nueva.setOnAction((event)->{
			nuevaLista(tablaBusqueda.getItems().get(tablaBusqueda.getSelectionModel().getFocusedIndex()));
		});
		
		SeparatorMenuItem sep = new SeparatorMenuItem();

		mi2.getItems().add(nueva);
		
		mi2.getItems().add(sep);

		// Recuperamos listas para construir contextmenu de listas
		for (ListaCanciones listaCanciones : controlador.getCurrentUser().getListasReproduccion()) {
			MenuItem aux = new MenuItem(listaCanciones.getNombreLista());
			mi2.getItems().add(aux);
			// aux.setToggleGroup(grupoLista);
			// TODO:GESTION MENUS
			aux.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent t) {
					// añadir cancion a lista x
					controlador.addCancionPlaylist(
							controlador.getCurrentUser(),tablaBusqueda.getItems().get(tablaBusqueda.getSelectionModel().getFocusedIndex()),
							listaCanciones);
					Notifications.create().position(Pos.TOP_RIGHT).darkStyle().title("Canción añadida")
							.text(tablaBusqueda.getItems().get(tablaBusqueda.getSelectionModel().getFocusedIndex())
									.getTitulo() + " añadida a la playlist " + listaCanciones.getNombreLista())
							.showInformation();
				}
			});
		}

		// Listener para reproducir la cancion

		tablaBusqueda.addEventHandler(MouseEvent.ANY, event -> {
			if (event.getClickCount() == 2 && event.getButton().equals(MouseButton.PRIMARY)) {
				if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
						tablaBusqueda.getSelectionModel().select(tablaBusqueda.getSelectionModel().getFocusedIndex());
				}
				event.consume();
			}
		});

		tablaBusqueda.setRowFactory(tv -> {
			TableRow<Cancion> row = new TableRow<>();
			row.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
				if (e.getButton() == MouseButton.SECONDARY) {
					e.consume();
					tablaBusqueda.setContextMenu(cm);
					mi1.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent t) {
							tablaBusqueda.getSelectionModel().select(row.getIndex());
						}
					});
				}

				if (e.getClickCount() == 1) {
					e.consume();
					tablaBusqueda.getSelectionModel().focus(row.getIndex());
				}
				tablaBusqueda.requestFocus();
			});

			return row;
		});

		tablaBusqueda.getSelectionModel().selectedIndexProperty().addListener((v, oldValue, newValue) -> {
			cargarCancion(tablaBusqueda.getSelectionModel().getSelectedItem());
			if (!tablaActual.equals(tablaBusqueda)) {
				tablaActual.getSelectionModel().clearSelection();
			}
			tablaActual = tablaBusqueda;
			mediaPlayer.play();
			reproduciendoLista = false;
		});

	}

	private void cargarRecientes() {
		
		if(tablaActual != null && !tablaActual.equals(tablaReciente)) {

			tablaReciente = new TableView<Cancion>();
			panelReciente.add(tablaReciente, 0, 1);
	
			this.tablaReciente.setVisible(true);
			// this.tablaActual = tablaReciente;
			this.tablaReciente.getItems().clear();
			tablaReciente.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	
			TableColumn<Cancion, String> tituloCol = new TableColumn<>("Titulo");
			TableColumn<Cancion, String> interpreteCol = new TableColumn<>("Interprete");
	
			tituloCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
			interpreteCol.setCellValueFactory(
					cellData -> new SimpleStringProperty(cellData.getValue().getInterprete().getNombre()));
			
			tablaReciente.prefHeightProperty().bind(panelReciente.heightProperty());
	
			ObservableList<Cancion> canciones = FXCollections.observableArrayList(controlador.getCancionesRecientes(controlador.getCurrentUser()));
	
			tablaReciente.setItems(canciones);
			tablaReciente.getColumns().setAll(tituloCol, interpreteCol);
	
			ContextMenu cm1 = new ContextMenu();
			cm1.getItems().clear();
	
			MenuItem mi1 = new MenuItem("Reproducir");
			cm1.getItems().add(mi1);
	
			Menu mi2 = new Menu("Añadir a PlayList");
	
			cm1.getItems().add(mi2);
	
			MenuItem nueva = new MenuItem("Nueva Lista");
			nueva.setOnAction((event)->{
				nuevaLista(tablaReciente.getItems().get(tablaReciente.getSelectionModel().getFocusedIndex()));
			});
			SeparatorMenuItem sep = new SeparatorMenuItem();
	
			mi2.getItems().add(nueva);
			mi2.getItems().add(sep);
	
			// Recuperamos listas para construir contextmenu de listas
			for (ListaCanciones listaCanciones : controlador.getCurrentUser().getListasReproduccion()) {
				MenuItem aux = new MenuItem(listaCanciones.getNombreLista());
				mi2.getItems().add(aux);
				// aux.setToggleGroup(grupoLista);
				aux.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent t) {
						// añadir cancion a lista x
						controlador.addCancionPlaylist(
								controlador.getCurrentUser(),tablaReciente.getItems().get(tablaReciente.getSelectionModel().getFocusedIndex()),
								listaCanciones);
						Notifications.create().position(Pos.TOP_RIGHT).darkStyle().title("Canción añadida")
								.text(tablaReciente.getItems().get(tablaReciente.getSelectionModel().getFocusedIndex())
										.getTitulo() + " añadida a la playlist " + listaCanciones.getNombreLista())
								.showInformation();
					}
				});
			}
		// Listener para reproducir la cancion
	
			tablaReciente.addEventHandler(MouseEvent.ANY, event -> {
				if (event.getClickCount() == 2 && event.getButton().equals(MouseButton.PRIMARY)) {
					if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
						tablaReciente.getSelectionModel().select(tablaReciente.getSelectionModel().getFocusedIndex());
					}
	
					event.consume();
				}
	
			});
	
			tablaReciente.setRowFactory(tv -> {
				TableRow<Cancion> row = new TableRow<>();
				row.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
					if (e.getButton() == MouseButton.SECONDARY) {
						e.consume();
						tablaReciente.setContextMenu(cm1);
						mi1.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent t) {
								tablaReciente.getSelectionModel().select(row.getIndex());
							}
						});
					}
	
					if (e.getClickCount() == 1) {
						e.consume();
						tablaReciente.getSelectionModel().focus(row.getIndex());
					}
					tablaReciente.requestFocus();
				});
	
				return row;
			});
	
			tablaReciente.getSelectionModel().selectedIndexProperty().addListener((v, oldValue, newValue) -> {
				cargarCancion(tablaReciente.getSelectionModel().getSelectedItem());
				if (!tablaActual.equals(tablaReciente)) {
					tablaActual.getSelectionModel().clearSelection();
				}
				tablaActual = tablaReciente;
				mediaPlayer.play();
				reproduciendoLista = false;
			});
		}

	}
	
	private void cargarMasReproducidas() {
		
		if(tablaActual != null && !tablaActual.equals(tablaMasReproducidas)) {

			
			tablaMasReproducidas = new TableView<Cancion>();
			panelMasReproducidas.add(tablaMasReproducidas, 0, 1);
			this.tablaMasReproducidas.setVisible(true);
			this.tablaMasReproducidas.getItems().clear();
			tablaMasReproducidas.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	
			TableColumn<Cancion, String> tituloCol = new TableColumn<>("Titulo");
			TableColumn<Cancion, String> interpreteCol = new TableColumn<>("Interprete");
			TableColumn<Cancion,String>nRepCol = new TableColumn<>("Nº Reproducciones");
	
			tituloCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
			interpreteCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getInterprete().getNombre()));
			nRepCol.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNumReproduciones())));
			tablaMasReproducidas.prefHeightProperty().bind(panelMasReproducidas.heightProperty());			
			ObservableList<Cancion> canciones = FXCollections.observableArrayList(controlador.getMasReproducidas());
	
			tablaMasReproducidas.setItems(canciones);
			tablaMasReproducidas.getColumns().setAll(tituloCol, interpreteCol,nRepCol);
	
			ContextMenu cm1 = new ContextMenu();
			cm1.getItems().clear();
	
			MenuItem mi1 = new MenuItem("Reproducir");
			cm1.getItems().add(mi1);
	
			Menu mi2 = new Menu("Añadir a PlayList");
	
			cm1.getItems().add(mi2);
	
			MenuItem nueva = new MenuItem("Nueva Lista");
			nueva.setOnAction((event)->{
				nuevaLista(tablaMasReproducidas.getItems().get(tablaMasReproducidas.getSelectionModel().getFocusedIndex()));
			});
			SeparatorMenuItem sep = new SeparatorMenuItem();
	
			mi2.getItems().add(nueva);
			mi2.getItems().add(sep);
	
			// Recuperamos listas para construir contextmenu de listas
			for (ListaCanciones listaCanciones : controlador.getCurrentUser().getListasReproduccion()) {
				MenuItem aux = new MenuItem(listaCanciones.getNombreLista());
				mi2.getItems().add(aux);
				// aux.setToggleGroup(grupoLista);
				aux.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent t) {
						// añadir cancion a lista x
						controlador.addCancionPlaylist(
								controlador.getCurrentUser(),tablaMasReproducidas.getItems().get(tablaMasReproducidas.getSelectionModel().getFocusedIndex()),
								listaCanciones);
						Notifications.create().position(Pos.TOP_RIGHT).darkStyle().title("Canción añadida")
								.text(tablaMasReproducidas.getItems().get(tablaMasReproducidas.getSelectionModel().getFocusedIndex())
										.getTitulo() + " añadida a la playlist " + listaCanciones.getNombreLista())
								.showInformation();
					}
				});
			}
	
			// Listener para reproducir la cancion
	
			tablaMasReproducidas.addEventHandler(MouseEvent.ANY, event -> {
				if (event.getClickCount() == 2 && event.getButton().equals(MouseButton.PRIMARY)) {
					if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
						tablaMasReproducidas.getSelectionModel().select(tablaMasReproducidas.getSelectionModel().getFocusedIndex());
					}
	
					event.consume();
				}
	
			});
	
			tablaMasReproducidas.setRowFactory(tv -> {
				TableRow<Cancion> row = new TableRow<>();
				row.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
					if (e.getButton() == MouseButton.SECONDARY) {
						e.consume();
						tablaMasReproducidas.setContextMenu(cm1);
						mi1.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent t) {
								tablaMasReproducidas.getSelectionModel().select(row.getIndex());
							}
						});
					}
	
					if (e.getClickCount() == 1) {
						e.consume();
						tablaMasReproducidas.getSelectionModel().focus(row.getIndex());
					}
					tablaMasReproducidas.requestFocus();
				});
	
				return row;
			});
	
			tablaMasReproducidas.getSelectionModel().selectedIndexProperty().addListener((v, oldValue, newValue) -> {
					cargarCancion(tablaMasReproducidas.getSelectionModel().getSelectedItem());
					if (!tablaActual.equals(tablaMasReproducidas)) {
						tablaActual.getSelectionModel().clearSelection();
					}
					tablaActual = tablaMasReproducidas;
					mediaPlayer.play();
					reproduciendoLista = false;
			});

		
		}
	}
	
	@FXML
	private void busquedaNueva() {

		this.tablaBusquedaNueva.setVisible(true);
		this.tablaBusquedaNueva.getItems().clear();
		tablaBusquedaNueva.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		TableColumn<Cancion, String> tituloCol = new TableColumn<>("Titulo");
		TableColumn<Cancion, String> interpreteCol = new TableColumn<>("Interprete");

		tituloCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
		interpreteCol.setCellValueFactory(
				cellData -> new SimpleStringProperty(cellData.getValue().getInterprete().getNombre()));

		ObservableList<Cancion> canciones = FXCollections.observableArrayList(
				controlador.busquedaCanciones(tituloNew.getText(), interpreteNew.getText(), estiloNew.getValue()));

		tablaBusquedaNueva.setItems(canciones);
		tablaBusquedaNueva.getColumns().setAll(tituloCol, interpreteCol);


		tablaBusquedaNueva.addEventHandler(MouseEvent.ANY, event -> {
			if (event.getClickCount() == 2 && event.getButton().equals(MouseButton.PRIMARY)) {
				if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
					tablaBusquedaNueva.getSelectionModel().select(tablaBusquedaNueva.getSelectionModel().getFocusedIndex());
				}

				event.consume();
			}

		});

		tablaBusquedaNueva.setRowFactory(tv -> {
			TableRow<Cancion> row = new TableRow<>();
			row.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
				if (e.getClickCount() == 1) {
					e.consume();
					tablaBusquedaNueva.getSelectionModel().focus(row.getIndex());
				}
				tablaBusquedaNueva.requestFocus();
			});

			return row;
		});

		tablaBusquedaNueva.getSelectionModel().selectedIndexProperty().addListener((v, oldValue, newValue) -> {
			cargarCancion(tablaBusquedaNueva.getSelectionModel().getSelectedItem());
			if (!tablaActual.equals(tablaBusquedaNueva)) {
				tablaActual.getSelectionModel().clearSelection();
			}
			tablaActual = tablaBusquedaNueva;
			mediaPlayer.play();
			reproduciendoLista = false;

		});

	}
	
	private void cargarListaOtro(ListaCanciones lista) {
		TableView<Cancion> tablaLista;
		tablaLista = new TableView<Cancion>();
		panelMisListas.add(tablaLista, 0, 1);
		tablaLista.setVisible(true);
		tablaLista.toFront();

		tablaLista.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		TableColumn<Cancion, String> tituloCol = new TableColumn<>("Titulo");
		TableColumn<Cancion, String> interpreteCol = new TableColumn<>("Interprete");

		tituloCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
		interpreteCol.setCellValueFactory(
				cellData -> new SimpleStringProperty(cellData.getValue().getInterprete().getNombre()));
		if (lista != null) {
			labelLista.setText(lista.getNombreLista());
			ObservableList<Cancion> canciones = FXCollections.observableArrayList(lista.getCanciones());
			tablaLista.setItems(canciones);
		}

		tablaLista.getColumns().clear();
		tablaLista.getColumns().setAll(tituloCol, interpreteCol);

		tablaLista.addEventHandler(MouseEvent.ANY, event -> {
			if (event.getClickCount() == 2 && event.getButton().equals(MouseButton.PRIMARY)) {
				if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
					tablaLista.getSelectionModel().select(tablaLista.getSelectionModel().getFocusedIndex());			
				}

				event.consume();
			}

		});

		ContextMenu cMenu = new ContextMenu();
		cMenu.getItems().clear();

		MenuItem mi1 = new MenuItem("Reproducir");
		cMenu.getItems().add(mi1);

		Menu mi2 = new Menu("Añadir a PlayList");

		cMenu.getItems().add(mi2);

		MenuItem nueva = new MenuItem("Nueva Lista");
		nueva.setOnAction((event)->{
			nuevaLista(tablaLista.getItems().get(tablaLista.getSelectionModel().getFocusedIndex()));
		});
		SeparatorMenuItem sep = new SeparatorMenuItem();

		mi2.getItems().add(nueva);
		mi2.getItems().add(sep);
		MenuItem mi3 = new MenuItem("Eliminar de la PlayList");
		mi3.setOnAction((event)->{
			controlador.eliminarCancionPlayList(controlador.getCurrentUser(),tablaLista.getItems().get(tablaLista.getSelectionModel().getFocusedIndex()),
					lista);
			cargarListaOtro(lista);
			Notifications.create().position(Pos.TOP_RIGHT).darkStyle().title("Cancion Eliminada")
			.text(tablaLista.getItems()
					.get(tablaLista.getSelectionModel().getFocusedIndex()).getTitulo()
					+ " Eliminada de la playlist " + lista.getNombreLista()).showError();
		});
		
		
		
		cMenu.getItems().add(mi3);

		for (ListaCanciones listaCanciones : controlador.getCurrentUser().getListasReproduccion()) {
			MenuItem aux = new MenuItem(listaCanciones.getNombreLista());
			mi2.getItems().add(aux);
			aux.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent t) {
					if (lista.equals(listaCanciones)) {
						mismaLista = true;
						controlador.addCancionPlaylist(
								controlador.getCurrentUser(),tablaLista.getItems().get(tablaLista.getSelectionModel().getFocusedIndex()),
								listaCanciones);
						int indice = tablaLista.getSelectionModel().getSelectedIndex();
						Notifications.create().position(Pos.TOP_RIGHT).darkStyle().title("Canción añadida")
								.text(tablaLista.getItems()
										.get(tablaLista.getSelectionModel().getFocusedIndex()).getTitulo()
										+ " añadida a la playlist " + listaCanciones.getNombreLista())
								.showInformation();
						int index = tablaActual.getSelectionModel().getSelectedIndex();
						cargarListaOtro(listaCanciones);
						tablaActual.getSelectionModel().select(index);
						//tablaLista.refresh();
						tablaLista.getSelectionModel().select(indice);
						mismaLista = false;

					} else {
						controlador.addCancionPlaylist(
								controlador.getCurrentUser(),tablaLista.getItems().get(tablaLista.getSelectionModel().getFocusedIndex()),
								listaCanciones);
						Notifications.create().position(Pos.TOP_RIGHT).darkStyle().title("Canción añadida")
								.text(tablaLista.getItems()
										.get(tablaLista.getSelectionModel().getFocusedIndex()).getTitulo()
										+ " añadida a la playlist " + listaCanciones.getNombreLista())
								.showInformation();
					}
				}
			});
		}

		tablaLista.setRowFactory(tv -> {
			TableRow<Cancion> row = new TableRow<>();
			row.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
				if (e.getButton() == MouseButton.SECONDARY) {
					e.consume();
					// TODO:Gestion de menús
					tablaLista.setContextMenu(cMenu);
					mi1.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent t) {
							tablaLista.getSelectionModel().select(row.getIndex());
						}
					});

				}

				if (e.getClickCount() == 1) {
					e.consume();
					tablaLista.getSelectionModel().focus(row.getIndex());
				}
				tablaLista.requestFocus();
			});

			return row;
		});
		tablaLista.getSelectionModel().selectedIndexProperty().addListener((v, oldValue, newValue) -> {
			if (!mismaLista) {
				cargarCancion(tablaLista.getSelectionModel().getSelectedItem());
				tablaActual = tablaLista;
				mediaPlayer.play();
				listaActual = lista;
				reproduciendoLista = true;
			}else{
				tablaActual = tablaLista;
				listaActual = lista;
			}
		});
		
		if(listaActual != null && listaActual.equals(lista)) {
			tablaActual = tablaLista;
		}
		
		
	}

	private void inicializarComboListas() {
		//comboListas.setEditable(false);
		comboListas.setCellFactory(new Callback<ListView<ListaCanciones>, ListCell<ListaCanciones>>() {
			@Override
			public ListCell<ListaCanciones> call(ListView<ListaCanciones> param) {
				final ListCell<ListaCanciones> cell = new ListCell<ListaCanciones>() {
					{
						super.setPrefWidth(100);
					}

					@Override
					public void updateItem(ListaCanciones item, boolean empty) {
						super.updateItem(item, empty);
						if (item != null) {
							setText(item.getNombreLista());
						} else {
							setText(null);
						}
					}
				};
				return cell;
			}

		});
		
		comboListas.setConverter(new StringConverter<ListaCanciones>() {

			@Override
			public String toString(ListaCanciones lista) {
				return lista == null ? null : lista.getNombreLista();
			}

			@Override
			public ListaCanciones fromString(String string) {
				return comboListas.getItems().stream().filter(i -> i.getNombreLista().equals(string)).findAny().orElse(null);
			}
		});
		
		comboListas.setItems(FXCollections.observableArrayList(controlador.getCurrentUser().getListasReproduccion()));
	}

	@FXML
	private void verLista() {
		
		this.tablaNuevaLista = new TableView<Cancion>();
		panelNuevaLista.add(this.tablaNuevaLista, 3, 4);
		
		this.tablaNuevaLista.setVisible(true);
		this.tablaNuevaLista.getItems().clear();
		tablaNuevaLista.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		TableColumn<Cancion, String> tituloCol = new TableColumn<>("Titulo");
		TableColumn<Cancion, String> interpreteCol = new TableColumn<>("Interprete");

		tituloCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
		interpreteCol.setCellValueFactory(
				cellData -> new SimpleStringProperty(cellData.getValue().getInterprete().getNombre()));

		if (comboListas.getValue() != null) {
			
			this.cancionesLista = FXCollections.observableArrayList(comboListas.getValue().getCanciones());
			labelNombreLista.setText(comboListas.getValue().getNombreLista());
			nombreListaAux = comboListas.getValue().getNombreLista();
			tablaNuevaLista.setItems(cancionesLista);
			tablaNuevaLista.getColumns().setAll(tituloCol, interpreteCol);
		} else {
			// Sacamos el dialog y preguntamos si queremos crear lista			
			JFXDialogLayout content = new JFXDialogLayout();
			content.setHeading(new Text("Esta lista no existe, deseas crear una nueva?"));

			JFXDialog dialog = new JFXDialog(this.panelPila, content, JFXDialog.DialogTransition.CENTER);
			JFXButton buttonSi = new JFXButton("Si");
			JFXButton buttonNo = new JFXButton("No");
			buttonSi.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					cancionesLista = FXCollections.observableArrayList(new ArrayList<Cancion>());

					JFXDialogLayout content1 = new JFXDialogLayout();
					content1.setHeading(new Text("Escribe el nombre de la lista"));
					JFXDialog dialog1 = new JFXDialog(panelPila, content1, JFXDialog.DialogTransition.CENTER);
					JFXTextField tf = new JFXTextField();

					tf.setPrefWidth(100);
					tf.setMaxWidth(Control.USE_PREF_SIZE);
					JFXButton loTengo = new JFXButton("Lo tengo!");

					loTengo.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							nombreListaAux = tf.getText();
							labelNombreLista.setText(nombreListaAux);
							dialog1.close();
						}

					});

					content1.setBody(tf);
					content1.setActions(loTengo);
					dialog1.show();
					dialog.close();
					tablaNuevaLista.setItems(cancionesLista);
					tablaNuevaLista.getColumns().setAll(tituloCol, interpreteCol);
				}
			});
			buttonNo.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					cancionesLista = null;
					dialog.close();
				}
			});
			content.setActions(buttonSi, new Label("  "), buttonNo);
			dialog.show();
		}
	}

	
	private void nuevaLista(Cancion cancion) {
		list.getSelectionModel().select(2);
		this.tablaNuevaLista = new TableView<Cancion>();
		panelNuevaLista.add(this.tablaNuevaLista, 3, 4);
		
		this.tablaNuevaLista.setVisible(true);
		this.tablaNuevaLista.getItems().clear();
		tablaNuevaLista.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		TableColumn<Cancion, String> tituloCol = new TableColumn<>("Titulo");
		TableColumn<Cancion, String> interpreteCol = new TableColumn<>("Interprete");

		tituloCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
		interpreteCol.setCellValueFactory(
				cellData -> new SimpleStringProperty(cellData.getValue().getInterprete().getNombre()));
		
		
		
		JFXDialogLayout content = new JFXDialogLayout();
		content.setHeading(new Text("¿ Quieres crear una lista nueva ?"));

		JFXDialog dialog = new JFXDialog(this.panelPila, content, JFXDialog.DialogTransition.CENTER);
		JFXButton buttonSi = new JFXButton("Si");
		JFXButton buttonNo = new JFXButton("No");
		buttonSi.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				cancionesLista = FXCollections.observableArrayList(new ArrayList<Cancion>());

				JFXDialogLayout content1 = new JFXDialogLayout();
				content1.setHeading(new Text("Escribe el nombre de la lista"));
				JFXDialog dialog1 = new JFXDialog(panelPila, content1, JFXDialog.DialogTransition.CENTER);
				JFXTextField tf = new JFXTextField();

				tf.setPrefWidth(100);
				tf.setMaxWidth(Control.USE_PREF_SIZE);
				JFXButton loTengo = new JFXButton("Lo tengo!");

				loTengo.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						nombreListaAux = tf.getText();
						labelNombreLista.setText(nombreListaAux);
						if(cancion != null) {
							tablaNuevaLista.getItems().add(cancion);
						}
						dialog1.close();
					}

				});

				content1.setBody(tf);
				content1.setActions(loTengo);
				dialog1.show();
				dialog.close();
				tablaNuevaLista.setItems(cancionesLista);
				tablaNuevaLista.getColumns().setAll(tituloCol, interpreteCol);
			}
		});
		buttonNo.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				cancionesLista = null;
				dialog.close();
			}
		});
		content.setActions(buttonSi, new Label("  "), buttonNo);
		dialog.show();
	}
	
	@FXML
	private void eliminarLista() {
		if (comboListas.getValue() != null) {
			if(reproduciendoLista && listaActual.equals(comboListas.getValue())) {
				reproduciendoLista = false;
				tablaActual = new TableView<Cancion>();
			}
			controlador.borrarListaCanciones(controlador.getCurrentUser(),comboListas.getValue());
			inicializarComboListas();
			
		}
	}

	@FXML
	private void addNueva() {
		if (tablaBusquedaNueva != null && tablaNuevaLista.isVisible()) {
			tablaNuevaLista.getItems().add(tablaBusquedaNueva.getItems().get(tablaBusquedaNueva.getSelectionModel().getFocusedIndex()));
		}
	}

	@FXML
	private void remNueva() {
		if (!tablaNuevaLista.getSelectionModel().isEmpty()) {
			tablaNuevaLista.getItems().remove(tablaNuevaLista.getSelectionModel().getSelectedIndex());
		}
	}

	@FXML
	private void guardarLista() {
		if(!nombreListaAux.equals("")) {
			controlador.guardarLista(controlador.getCurrentUser(),nombreListaAux,tablaNuevaLista.getItems());
			
			JFXDialogLayout content = new JFXDialogLayout();
			content.setHeading(new Text("La lista "+nombreListaAux+" se ha guardado correctamente"));
			JFXDialog dialogGuardar = new JFXDialog(panelPila, content, JFXDialog.DialogTransition.CENTER);
	
			JFXButton loTengo = new JFXButton("Lo tengo!");
			
			loTengo.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					dialogGuardar.close();
				}
	
			});
			content.setActions(loTengo);
			dialogGuardar.show();
			inicializarComboListas();
		}
	}
	
	
	private void birthday() {
		JFXDialogLayout content = new JFXDialogLayout();
		content.setHeading(new Text("Muchas Felicidades por tu cumpleaños, deseamos\n"
				+ "que pases un gran día acompañado de la mejor música"));
		JFXDialog dialogCumple = new JFXDialog(panelPila, content, JFXDialog.DialogTransition.CENTER);

		JFXButton gracias = new JFXButton("Gracias");
		
		gracias.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				dialogCumple.close();
			}

		});
		content.setActions(gracias);
		dialogCumple.show();
	}

	@FXML
	private void cancelarNew() {
		nombreListaAux = "";
		labelNombreLista.setText(nombreListaAux);
		tablaNuevaLista.setVisible(false);

	}

	private void inicializarUsuario() {
		cargarRecientes();
		cargarMasReproducidas();
		final Circle clip = new Circle(15.5, 15.5, 15.5);
		imagenUser.setClip(clip);
		textoBienvenido.setText("¡Hola " + controlador.getCurrentUser().getNombre() + "!");
		moverTexto();
		setImagenUser();
	}

	private void setImagenUser(Image avatar) {
		imagenUser.setImage(avatar);
	}

	private void setImagenUser() {
		if (controlador.getCurrentUser().getRutaAvatar() != null) {
			InputStream is;
			try {
				is = new URL(controlador.getCurrentUser().getRutaAvatar()).openStream();
				Image image = new Image(is);
				imagenUser.setImage(image);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			try {
				Image defaultAvatar = new Image(
						this.getClass().getResource("/tds/um/vista/fxml/imagenes/user.png").toURI().toString());
				imagenUser.setImage(defaultAvatar);
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
	}

	private void cambiarAvatar(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();

		// filtro de extension
		FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
		FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
		FileChooser.ExtensionFilter extFilterJPEG = new FileChooser.ExtensionFilter("JPEG files (*.jpeg)", "*.JPEG");

		fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG,extFilterJPEG);
		// dialog de eleccion de archivo
		File file = fileChooser.showOpenDialog(null);
		if(file != null) {
			Image image = new Image(file.toURI().toString());
			setImagenUser(image);
			controlador.cambiarAvatar(controlador.getCurrentUser(),file.toURI().toString());
		}
		
	}
	
	private void generarPdf() {
		DirectoryChooser chooser = new DirectoryChooser();
		chooser.setTitle("Elige la carpeta quieres que se guarde el PDF");
		File defaultDirectory = new File("/");
		chooser.setInitialDirectory(defaultDirectory);
		File ruta = chooser.showDialog(null);
		if(ruta != null) {
			controlador.generarPdf(controlador.getCurrentUser(),ruta.getAbsolutePath());
		}		
	}
	
	private void cargarCancionesXML() {
		
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilterXML= new FileChooser.ExtensionFilter("XML files (*.xml)", "*.XML");
		fileChooser.getExtensionFilters().addAll(extFilterXML);
		File file = fileChooser.showOpenDialog(null);
		controlador.cambiarArchivoComponente(file.getAbsolutePath());
		inicializarEstilos();
		inicializarEstilosNew();
		
		JFXDialogLayout content = new JFXDialogLayout();
		content.setHeading(new Text("Se han añadido "+controlador.getCancionesXMLAdded()+ " canciones via HTTP"));
		JFXDialog dialogAdded = new JFXDialog(panelPila, content, JFXDialog.DialogTransition.CENTER);

		JFXButton genial = new JFXButton("Genial!");
		
		genial.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				dialogAdded.close();
			}

		});
		content.setActions(genial);
		dialogAdded.show();	
	}
	
	
	private void eliminarCuenta(ActionEvent event) {
		controlador.eliminarCuenta(controlador.getCurrentUser());
	}
	
	private void inicializarMenuUsuario() {
		this.menuUsuario.getItems().clear();
		menuUsuario.setText(controlador.getCurrentUser().getNickUsuario());
		
		if(controlador.getCurrentUser().isPremium()) {
			MenuItem pdf = new MenuItem("Generar Pdf");
			pdf.setOnAction((event) -> {
				generarPdf();
			});
			
			MenuItem cancelar = new MenuItem("Cancelar Suscripcion");
			cancelar.setOnAction((event) -> {
				cancelarSuscripcion(event);
			});
			
			this.menuUsuario.getItems().add(pdf);
			this.menuUsuario.getItems().add(cancelar);
			
		}else {
			MenuItem mejorar = new MenuItem("Mejorar Cuenta");
			mejorar.setOnAction((event) -> {
				mejorarCuenta(event);
			});
			this.menuUsuario.getItems().add(mejorar);
			
		}
			
		Menu config = new Menu("Configuración");
		MenuItem cAvatar = new MenuItem("Cambiar Avatar");
		cAvatar.setOnAction((event) -> {
			cambiarAvatar(event);
		});
		MenuItem cUsuario = new MenuItem("Cambiar Usuario");
		cUsuario.setOnAction((event) -> {
			cerrarSesion(event);
		});
		MenuItem cSesion = new MenuItem("Cerrar Sesión");
		cSesion.setOnAction((event) -> {
			cerrarSesion(event);
		});
		
		MenuItem cargador = new MenuItem("Cargar xml");
		cargador.setOnAction((event) -> {
			cargarCancionesXML();
		});
		
		MenuItem eliminarCuenta = new MenuItem("Eliminar Cuenta");
		eliminarCuenta.setOnAction((event) -> {
			eliminarCuenta(event);
			cerrarSesion(event);
		});
		
		config.getItems().add(cAvatar);
		config.getItems().add(cUsuario);
		config.getItems().add(eliminarCuenta);
		this.menuUsuario.getItems().add(cargador);
		this.menuUsuario.getItems().add(config);
		this.menuUsuario.getItems().add(cSesion);
	}


	protected void updateValues() {
		if (transcurrido != null && duracion != null && timeSlider != null && volumeSlider != null) {
			Platform.runLater(new Runnable() {
				public void run() {
					Duration currentTime = mediaPlayer.getCurrentTime();
					String formatedTime = formatTime(currentTime, duration);
					String[] parts = formatedTime.split("/");
					String tTranscurrido = parts[0];
					String tDuracion = parts[1];
					transcurrido.setText(tTranscurrido);
					duracion.setText(tDuracion);
					timeSlider.setDisable(duration.isUnknown());
					if (!timeSlider.isDisabled() && duration.greaterThan(Duration.ZERO)
							&& !timeSlider.isValueChanging()) {
						timeSlider.setValue(currentTime.divide(duration.toMillis()).toMillis() * 100.0);
					}
					if (!volumeSlider.isValueChanging()) {
						volumeSlider.setValue((int) Math.round(mediaPlayer.getVolume() * 100));
					}
				}
			});
		}
	}

	private static String formatTime(Duration elapsed, Duration duration) {
		int intElapsed = (int) Math.floor(elapsed.toSeconds());
		int elapsedHours = intElapsed / (60 * 60);
		if (elapsedHours > 0) {
			intElapsed -= elapsedHours * 60 * 60;
		}
		int elapsedMinutes = intElapsed / 60;
		int elapsedSeconds = intElapsed - elapsedHours * 60 * 60 - elapsedMinutes * 60;

		if (duration.greaterThan(Duration.ZERO)) {
			int intDuration = (int) Math.floor(duration.toSeconds());
			int durationHours = intDuration / (60 * 60);
			if (durationHours > 0) {
				intDuration -= durationHours * 60 * 60;
			}
			int durationMinutes = intDuration / 60;
			int durationSeconds = intDuration - durationHours * 60 * 60 - durationMinutes * 60;
			if (durationHours > 0) {
				return String.format("%d:%02d:%02d/%d:%02d:%02d", elapsedHours, elapsedMinutes, elapsedSeconds,
						durationHours, durationMinutes, durationSeconds);
			} else {
				return String.format("%02d:%02d/%02d:%02d", elapsedMinutes, elapsedSeconds, durationMinutes,
						durationSeconds);
			}
		} else {
			if (elapsedHours > 0) {
				return String.format("%d:%02d:%02d", elapsedHours, elapsedMinutes, elapsedSeconds);
			} else {
				return String.format("%02d:%02d", elapsedMinutes, elapsedSeconds);
			}
		}
	}

}
