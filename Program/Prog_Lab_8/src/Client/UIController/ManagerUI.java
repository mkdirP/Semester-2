package Client.UIController;

import Client.Client;
import Client.ClientRun;
import Collection.ObservableOrganization;
import Collection.Organization;
import Manager.OrganizationManager;
import Tools.*;
import com.sun.xml.internal.bind.v2.model.core.ID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManagerUI implements Initializable {

    @FXML
    private Label usernameField;

    @FXML
    private TableView<ObservableOrganization> organizationsTable = new TableView<>();

    @FXML
    private TableColumn<ObservableOrganization, String> ownerCol;

    @FXML
    private TableColumn<ObservableOrganization, Long> IDCol;

    @FXML
    private TableColumn<ObservableOrganization, String> nameCol;

    @FXML
    private TableColumn<?,?> coordinateCol;

    @FXML
    private TableColumn<ObservableOrganization, Float> xCol;

    @FXML
    private TableColumn<ObservableOrganization, Double> yCol;

    @FXML
    private TableColumn<ObservableOrganization, String> dateCol;

    @FXML
    private TableColumn<ObservableOrganization, Long> annualTurnoverCol;

    @FXML
    private TableColumn<ObservableOrganization, String> fullNameCol;

    @FXML
    private TableColumn<ObservableOrganization, Long> employeesCountCol;

    @FXML
    private TableColumn<ObservableOrganization, String> typeCol;

    @FXML
    private TableColumn<ObservableOrganization, String> streetCol;

    @FXML
    private TableColumn<ObservableOrganization, String> zipCodeCol;

    @FXML
    private Button filterLessThanTypeButton;

    @FXML
    private Button removeByIDButton;

    @FXML
    private Button helpButton;

    @FXML
    private Button removeHeadButton;

    @FXML
    private Button printFieldAscendingAnnualTurnoverButton;

    @FXML
    private Button addIfMaxButton;

    @FXML
    private Button groupCountingByIDButton;

    @FXML
    private Button addButton;

    @FXML
    private Button headButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button showButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button mapButton;

    @FXML
    private Button infoButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button executeScriptButton;

    private ObservableList<ObservableOrganization> organizationList;

    @FXML
    void add(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../FXML/AddUI.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 300, 574));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void addIfMax(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../FXML/AddIfMaxUI.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 300, 574));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void clear(ActionEvent event) {
        try {
            String[] commandWithArgs = new String[]{"clear"};

            Tools.handleCommand(commandWithArgs, null);
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void executeScript(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../FXML/ExecuteScriptUI.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 300, 214));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void filterLessThanType(ActionEvent event) {

    }

    @FXML
    void groupCountingByID(ActionEvent event) {

    }

    @FXML
    void head(ActionEvent event) {
        try {
            String[] commandWithArgs = new String[]{"head"};

            Tools.handleCommand(commandWithArgs, null);
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void help(ActionEvent event) {
        try {
            String[] commandWithArgs = new String[]{"help"};

            Tools.handleCommand(commandWithArgs, null);
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void info(ActionEvent event) {
        try {
            String[] commandWithArgs = new String[]{"info"};

            Tools.handleCommand(commandWithArgs, null);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void printFieldAscendingAnnualTurnover(ActionEvent event) {

    }

    @FXML
    void removeByID(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../FXML/RemoveByIDUI.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 300, 214));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void removeHead(ActionEvent event) {
        try {
            String[] commandWithArgs = new String[]{"remove_head"};

            Tools.handleCommand(commandWithArgs, null);
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void save(ActionEvent event) {
        try {
            String[] commandWithArgs = new String[]{"save"};

            Tools.handleCommand(commandWithArgs, null);
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void show(ActionEvent event) {
        try {
            String[] commandWithArgs = new String[]{"show"};

            Tools.handleCommand(commandWithArgs, null);
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void update(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../FXML/UpdateUI.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 300, 620));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void exit(ActionEvent event) {
        try {
            String[] commandWithArgs = new String[]{"exit"};

            Tools.handleCommand(commandWithArgs, null);
            System.exit(0);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void map(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../FXML/MapUI.fxml"));
            //Stage stage = new Stage();
            //stage.setScene(new Scene(root, 1280, 800));
            ClientRun.stage.setScene(new Scene(root,1280,800));
            //stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usernameField.setText(Client.clientInformation.getUserName());

        organizationList = FXCollections.observableArrayList();


        organizationList = OrganizationManager.toObservableList(Client.response.getOrganizationSet());

        ownerCol.setCellValueFactory(new PropertyValueFactory<ObservableOrganization, String>("owner"));
        IDCol.setCellValueFactory(new PropertyValueFactory<ObservableOrganization, Long>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<ObservableOrganization, String>("name"));
        xCol.setCellValueFactory(new PropertyValueFactory<ObservableOrganization, Float>("x"));
        yCol.setCellValueFactory(new PropertyValueFactory<ObservableOrganization, Double>("y"));
        dateCol.setCellValueFactory(new PropertyValueFactory<ObservableOrganization, String>("creationDate"));
        annualTurnoverCol.setCellValueFactory(new PropertyValueFactory<ObservableOrganization, Long>("annualTurnover"));
        fullNameCol.setCellValueFactory(new PropertyValueFactory<ObservableOrganization, String >("fullName"));
        employeesCountCol.setCellValueFactory(new PropertyValueFactory<ObservableOrganization, Long>("employeesCount"));
        typeCol.setCellValueFactory(new PropertyValueFactory<ObservableOrganization, String>("type"));
        streetCol.setCellValueFactory(new PropertyValueFactory<ObservableOrganization, String>("street"));
        zipCodeCol.setCellValueFactory(new PropertyValueFactory<ObservableOrganization, String>("zipCode"));

        organizationsTable.getColumns().addAll(ownerCol, IDCol, nameCol, xCol, yCol, dateCol, annualTurnoverCol, fullNameCol, employeesCountCol, typeCol, streetCol, zipCodeCol);
        organizationsTable.setItems(organizationList);
    }
}