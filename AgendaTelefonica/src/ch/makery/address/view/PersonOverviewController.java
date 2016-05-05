package ch.makery.address.view;

import ch.makery.address.MainApp;
import ch.makery.address.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> IDColumn;
    @FXML
    private TableColumn<Person, String> NomeColumn;
    @FXML
    private TableColumn<Person, String> TelefoneColumn;

    
    @FXML
    private Label IDLabel;
    @FXML
    private Label NomeLabel;
    @FXML
    private Label TelefoneLabel;
    
    // Reference to the main application.
    private MainApp mainApp;

    /**
     * O construtor.
     * O construtor � chamado antes do m�todo inicialize().
     */
    public PersonOverviewController() {
    }

    /**
     * Inicializa a classe controller. Este m�todo � chamado automaticamente
     *  ap�s o arquivo fxml ter sido carregado.
     */
    @FXML
    private void initialize() {
        // Inicializa a tabela de pessoas com duas colunas.
        IDColumn.setCellValueFactory(
                cellData -> cellData.getValue().IDProperty());
        NomeColumn.setCellValueFactory(
                cellData -> cellData.getValue().NomeProperty());
        TelefoneColumn.setCellValueFactory(
                cellData -> cellData.getValue().TelefoneProperty());

        // Limpa os detalhes da pessoa.
        showPersonDetails(null);

        // Detecta mudan�as de sele��o e mostra os detalhes da pessoa quando houver mudan�a.
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }
    
    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        personTable.getItems().remove(selectedIndex);
    }

    /**
     * � chamado pela aplica��o principal para dar uma refer�ncia de volta a si mesmo.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Adiciona os dados da observable list na tabela
        personTable.setItems(mainApp.getPersonData());
    }
    
    private void showPersonDetails(Person person) {
        if (person != null) {
            // Preenche as labels com informa��es do objeto person.
            IDLabel.setText(person.getID());
            NomeLabel.setText(person.getNome());
            TelefoneLabel.setText(person.getTelefone());
            

            // TODO: N�s precisamos de uma maneira de converter o anivers�rio em um String! 
            // birthdayLabel.setText(...);
        } else {
            // Person � null, remove todo o texto.
            IDLabel.setText("");
            NomeLabel.setText("");
            TelefoneLabel.setText("");
        }
    }
}