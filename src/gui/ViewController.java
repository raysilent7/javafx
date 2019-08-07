package gui;

import entities.Person;
import gui.util.Constraints;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewController implements Initializable {

    @FXML
    private ComboBox<Person> personComboBox;

    @FXML
    private ObservableList<Person> obsList;

    @FXML
    public void onComboBoxAction () {
        Person person = personComboBox.getSelectionModel().getSelectedItem();
        System.out.println(person);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1000, "Rayan Garcia", "ray.silent@live.com"));
        list.add(new Person(1001, "Livia Flores", "livia.fofinha@gmail.com"));
        list.add(new Person(1002, "Gonça Gonthulu", "gontchulu@gmail.com"));

        obsList = FXCollections.observableArrayList(list);
        personComboBox.setItems(obsList);

        Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
            @Override
            protected void updateItem(Person item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getName());
            }
        };
        personComboBox.setCellFactory(factory);
        personComboBox.setButtonCell(factory.call(null));
    }
}
