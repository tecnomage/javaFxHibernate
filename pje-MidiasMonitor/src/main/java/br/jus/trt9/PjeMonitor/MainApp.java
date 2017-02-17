package br.jus.trt9.PjeMonitor;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import br.jus.trt9.PjeMonitor.Model.Audiencia;
import br.jus.trt9.PjeMonitor.view.MonitorPjeController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*
 * @AutoConfigurationPackage
 * 
 * @ComponentScan(basePackages = "br.jus.trt9.PjeMonitor")
 * 
 * @EnableAutoConfiguration
 */

@SpringBootApplication
@ComponentScan(basePackages = "br.jus.trt9.PjeMonitor")
public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	private ObservableList<Audiencia> audData = FXCollections.observableArrayList();
	private ConfigurableApplicationContext applicationContext;
	private static String[] args;

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void init() throws Exception {
		//applicationContext.getAutowireCapableBeanFactory().autowireBean(this);
		
		try {
			applicationContext = SpringApplication.run(MainApp.class);
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// problema do classLoader do javaFX
			loader.setClassLoader(this.getClass().getClassLoader());

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Pje Midias Monitor");

		
		
		//initRootLayout();

		showTableAudiencia();

	}


	public MainApp() {

		audData.add(new Audiencia("12123123213213", LocalDate.now(), "sim"));
		audData.add(new Audiencia("22222222222222", LocalDate.now(), "nao"));
		audData.add(new Audiencia("22222222222222", LocalDate.now(), "nao"));
		audData.add(new Audiencia("55555555555555", LocalDate.now(), "sim"));
		audData.add(new Audiencia("6666666666666", LocalDate.now(), "nao"));
		audData.add(new Audiencia("7777777777777", LocalDate.now(), "nao"));
		audData.add(new Audiencia("8888888888888", LocalDate.now(), "sim"));
		audData.add(new Audiencia("99999999999999", LocalDate.now(), "nao"));
		audData.add(new Audiencia("100010110101001", LocalDate.now(), "nao"));

	}

	/**
	 * Initializes the root layout.
	 */

//	public void initRootLayout() {
//		try {
//			// Load root layout from fxml file.
//			FXMLLoader loader = new FXMLLoader();
//			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
//			rootLayout = (BorderPane) loader.load();
//
//			// problema do classLoader do javaFX
//			loader.setClassLoader(this.getClass().getClassLoader());
//
//			// Show the scene containing the root layout.
//			Scene scene = new Scene(rootLayout);
//			primaryStage.setScene(scene);
//			primaryStage.show();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public void showTableAudiencia() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/visao.fxml"));
			AnchorPane TableOverview = (AnchorPane) loader.load();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(TableOverview);

			// Give the controller acckess to the main app.
			MonitorPjeController controller = loader.getController();
			controller.setMainApp(this);
			System.out.println("carregou main app");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showCadastroClients() {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/clientcadastro.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Cadastro de máquinas");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public ObservableList<Audiencia> getAudData() {
		return audData;
	}

	public void setAudData(ObservableList<Audiencia> audData) {
		this.audData = audData;
	}

	/*
	 * public void salvaClient() {
	 * 
	 * 
	 * Client cliente = new Client("cta123", "19vt");
	 * 
	 * }
	 */

}
