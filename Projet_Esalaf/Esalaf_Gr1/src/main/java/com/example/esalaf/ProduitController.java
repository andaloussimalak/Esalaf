package com.example.esalaf;
import com.exemple.model.Client;
import com.exemple.model.ClientDAO;
import com.exemple.model.Produit;
import com.exemple.model.ProduitDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class ProduitController implements Initializable{

    @FXML
    private TextField nom;

    @FXML
    private TextField prix;
    @FXML
    private TableView<Produit> prod_tab;

    @FXML
    private TableColumn<Produit, Long> col_id;

    @FXML
    private TableColumn<Produit, String> col_name;

    @FXML
    private TableColumn<Produit, Long> col_price;

    public void UpdateTable(){
        col_id.setCellValueFactory(new PropertyValueFactory<Produit,Long>("id"));
        col_name.setCellValueFactory(new PropertyValueFactory<Produit,String>("nom"));

        col_price.setCellValueFactory(new PropertyValueFactory<Produit,Long>("prix"));


        prod_tab.setItems(getDataProducts());
    }
    @FXML
    protected void onAddButtonClick(){

        Produit prod = new Produit( nom.getText() , Double.parseDouble(prix.getText()));

        try {
            ProduitDAO prodao = new ProduitDAO();

            prodao.save(prod);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        UpdateTable();

    }
    public static ObservableList<Produit> getDataProducts(){

        ProduitDAO produitDAO = null;

        ObservableList<Produit> listfx = FXCollections.observableArrayList();

        try {
            produitDAO = new ProduitDAO();
            for(Produit ettemp : produitDAO.getAll())
                listfx.add(ettemp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listfx ;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UpdateTable();
    }
}
