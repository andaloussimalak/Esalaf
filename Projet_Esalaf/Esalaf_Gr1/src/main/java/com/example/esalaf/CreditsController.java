package com.example.esalaf;

import com.exemple.model.Credit;
import com.exemple.model.CreditDAO;
import com.exemple.model.ClientDAO;
import com.exemple.model.ProduitDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.beans.property.SimpleStringProperty;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CreditsController implements Initializable
 {
/*
    @FXML
    private TextField clientNameField;

    @FXML
    private TextField productNameField;

    @FXML
    private TextField creditAmountField;

    @FXML
    private DatePicker creditDateField;
*/
    @FXML
    private TableView<Credit> creditsTable;
/*
    @FXML
    private TableColumn<Credit, String> clientNameColumn;

    @FXML
    private TableColumn<Credit, String> productNameColumn;
*/
    @FXML
    private TableColumn<Credit, Double> creditAmountColumn;

    @FXML
    private TableColumn<Credit, LocalDate> creditDateColumn;

    public String getProductName(Long id) {
        ProduitDAO produitDAO;
        try {
            produitDAO = new ProduitDAO();
            return produitDAO.getProductName(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getClientName(Long id) {
        ClientDAO clientDAO;
        try {
            clientDAO = new ClientDAO();
            return clientDAO.getClientName(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateTable() {
  /*      clientNameColumn.setCellValueFactory(cellData -> {
            Credit credit = cellData.getValue();
            String clientName = getClientName(credit.getClientId());
            return new SimpleStringProperty(String.valueOf(clientName));
        });

        productNameColumn.setCellValueFactory(cellData -> {
            Credit credit = cellData.getValue();
            String productName = getProductName(credit.getProduitId());
            return new SimpleStringProperty(String.valueOf(productName));
        });
*/
        creditAmountColumn.setCellValueFactory(new PropertyValueFactory<Credit, Double>("qte"));
        creditDateColumn.setCellValueFactory(new PropertyValueFactory<Credit, LocalDate>("date"));

        creditsTable.setItems(getCreditData());
    }

    public static ObservableList<Credit> getCreditData() {

        CreditDAO creditDAO = null;

        ObservableList<Credit> credits = FXCollections.observableArrayList();

        try {
            creditDAO = new CreditDAO();
            for (Credit credit : creditDAO.getAll()) {
                credits.add(credit);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return credits;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateTable();
    }
}
