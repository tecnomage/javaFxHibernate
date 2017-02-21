package br.jus.trt9.PjeMonitor.view;

import java.time.LocalDate;

import br.jus.trt9.PjeMonitor.MainApp;
import br.jus.trt9.PjeMonitor.Model.Audiencia;
import br.jus.trt9.PjeMonitor.Model.Client;
import br.jus.trt9.PjeMonitor.dao.ClientDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.StringConverter;

public class MonitorPjeController {

	@FXML
	private TableView<Audiencia> audTable;

	@FXML
	private TableColumn<Audiencia, String> audId;

	@FXML
	private TableColumn<Audiencia, LocalDate> dataId;

	@FXML
	private TableColumn<Audiencia, String> assId;

	@FXML
	private ComboBox<Client> clientcomboBox;

	@FXML
	private Button BtnListaId = new Button();

	@FXML
	private Button BtnListarMaq;

	private ObservableList<Client> myClientComboBoxData = FXCollections.observableArrayList();

	// referencia a aplicacao principal
	private MainApp mainapp;

	private ClientDao clientDao = new ClientDao();

		public MonitorPjeController() {

	}

	@FXML
	private void initialize() {
		audId.setCellValueFactory(cellData -> cellData.getValue().processoProperty());
		dataId.setCellValueFactory(cellData -> cellData.getValue().dataProperty());
		assId.setCellValueFactory(cellData -> cellData.getValue().assinadoProperty());

		Client client = new Client("teste123", "21 vt");

		// sets the combobox options
		myClientComboBoxData.add(client);
		myClientComboBoxData.add(new Client("cta122223", "10 vt"));
		myClientComboBoxData.add(new Client("cta122223", "17 vt"));
		myClientComboBoxData.add(new Client("cta120337", "18 vt"));

		clientcomboBox.setItems(myClientComboBoxData);

		clientcomboBox.setCellFactory((comboBox) -> {
			return new ListCell<Client>() {
				@Override
				protected void updateItem(Client item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText(item.getVara());
					}
				}
			};
		});

		clientcomboBox.setConverter(new StringConverter<Client>() {

			@Override
			public String toString(Client maquina) {
				if (maquina == null) {
					return null;
				} else {
					return maquina.getVara();
				}
			}

			@Override
			public Client fromString(String string) {
				// TODO Auto-generated method stub
				return null;
			}
		});

	
		BtnListaId.setOnAction( a -> {
			clientDao.salva(new Client("cta444", "11 vt"));
		});
	
	
	}

	public void setMainApp(MainApp mainApp) {
		this.mainapp = mainApp;

		audTable.setItems(mainApp.getAudData());

	}

	
	
	
	// TODO em caso de erro enviar msg de erro
	@FXML
	public void mouseEvent() {
		Client client = new Client(1, "cta 12344", "18 vt");
		clientDao.salva(client);

	}

	public ObservableList<Client> getMyClientComboBoxData() {
		return myClientComboBoxData;
	}

	public void setMyClientComboBoxData(ObservableList<Client> myClientComboBoxData) {
		this.myClientComboBoxData = myClientComboBoxData;
	}

}
