package userinterface;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import customsThreads.GUIUpdateControllThread;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Airport;
import model.CustomDate;
import model.CustomHour;
import model.Flight;

public class Controller {
	
	private Airport airport;
	
    @FXML
    private Label typeOfOrder;
    
    @FXML
    private Label timeOrdering;
	
    @FXML
    private ComboBox<String> comboBox;
    
    @FXML
    private Label date;
    
    @FXML
    private TableView<Flight> tableView;
    
    @FXML
    private TableColumn<CustomDate, String> dateT;

    @FXML
    private TableColumn<CustomHour, String> time;

    @FXML
    private TableColumn<Flight, String> airline;

    @FXML
    private TableColumn<Flight, String> flight;

    @FXML
    private TableColumn<Flight, String> to;

    @FXML
    private TableColumn<Flight, String> term;
    

    @FXML
    private TextField flightsNumber;
    
   
    private ObservableList<Flight> oListFlights; 
    
    
    @FXML
    public void initialize() {
    	
    	
    	
    	
    	
    	
    	try {
			airport = new Airport();
		    airport.sortByFullHour();
		    oListFlights = updateList(); 
			
			for (int i = 0; i < airport.getFlights().length; i++) {
				System.out.println(airport.getFlights()[i]);
			}
			date.setText(airport.getStringHour());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	
    	
     
        time.setCellValueFactory(new PropertyValueFactory<>("hour"));
    	airline.setCellValueFactory(new PropertyValueFactory<>("airline"));
    	flight.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
    	to.setCellValueFactory(new PropertyValueFactory<>("destinationCity"));
    	term.setCellValueFactory(new PropertyValueFactory<>("gate"));
        dateT.setCellValueFactory(new PropertyValueFactory<>("date"));
    	tableView.setItems(oListFlights);
    	GUIUpdateControllThread guiThread = new GUIUpdateControllThread(this); 
    	guiThread.setDaemon(true);
    	guiThread.start();
    	System.out.println(oListFlights.get(0));
    }
    
    @FXML
    void sortByHour(ActionEvent event) {
    	airport.sortByFullHour();
    }
    
    @FXML
    void sortByFlightNumber(ActionEvent event) {
    	airport.sortByFlightNumberInsertion();
    }

    @FXML
    void sortByAirline(ActionEvent event) {
    	airport.sortByAirlineSelection();
    }
    
    @FXML
    void hola(ActionEvent event) {
    	airport.sortByGateBubble();
    	System.out.println("SortByTerminalCalled - controller");
    }
    
    @FXML
    void sortByTerminal(ActionEvent event) {
    	airport.sortByGateBubble();
    }
    
    @FXML
    void sortByDate(ActionEvent event) {
    	airport.sortByDateComparable();
    }
    @FXML
    void generate(ActionEvent event) {
    	int size = Integer.parseInt(flightsNumber.getText());
    	airport.generateFlights(size);
    	airport.sortByFullHour();
    }
    
    @FXML
    void sortByDestine(ActionEvent event) {
    	airport.sortByDestineComparator();
    }
    
    public void update() {
    	typeOfOrder.setText(airport.getTypeO());
    	typeOfOrder.setAlignment(Pos.CENTER);
    	timeOrdering.setText(airport.getTimeO());
    	timeOrdering.setAlignment(Pos.CENTER_LEFT);
    	airport.updateCurrentTime();
    	date.setText(airport.getStringHour());
    	tableView.setItems(oListFlights);
    	updateList();
   
    }

    public ObservableList<Flight> updateList(){
    	Flight[] array = airport.getFlights();
    	List<Flight> list = Arrays.asList(array);
		return oListFlights = FXCollections.observableArrayList(list);
    }
}
