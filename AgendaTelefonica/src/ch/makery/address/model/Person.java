package ch.makery.address.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe Model para uma Person (pessoa).
 *
 * @author Marco Jakob
 */
public class Person {

    private final StringProperty ID;
    private final StringProperty Nome;
    private final StringProperty Telefone;


    /**
     *  Construtor padrão.
     */
    public Person() {
        this(null, null, null);
    }

    /**
     * Construtor com alguns dados iniciais.
     * 
     * @param firstName Primeiro nome da Pessoa.
     * @param lastName Sobrenome da Pessoa.
     */
    public Person(String ID, String Nome, String Telefone) {
        this.ID = new SimpleStringProperty(ID);
        this.Nome = new SimpleStringProperty(Nome);
        this.Telefone = new SimpleStringProperty(Telefone);
        
     }

    public String getID() {
		return ID.get();
	}
	public void setID(String ID) {
		this.ID.set(ID);
	}
	public StringProperty IDProperty() {
		return ID;
	}
	

	public String getNome() {
		return Nome.get();
	}
	public void setNome(String Nome) {
		this.Nome.set(Nome);
	}
	public StringProperty NomeProperty() {
		return Nome;
	}


	public String getTelefone() {
		return Telefone.get();
	}
	public void setTelefone(String Telefone) {
		this.Telefone.set(Telefone);
	}
	public StringProperty TelefoneProperty() {
		return Telefone;
	}

}