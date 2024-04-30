package org.example.calendartest;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class ListViewController implements Initializable {
    @FXML
    private ListView<CalendarActivity> listView;
    @FXML
    private TextField textField;
    List<CalendarActivity> activities = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ZonedDateTime dateFocus = ZonedDateTime.now();
        List<CalendarActivity> calendarActivities = new ArrayList<>();
        List<String> textRepresentations = new ArrayList<>();
        int year = dateFocus.getYear();
        int month = dateFocus.getMonth().getValue();

        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            ZonedDateTime time = ZonedDateTime.of(year, month, random.nextInt(27)+1, 16,0,0,0,dateFocus.getZone());
            CalendarActivity a = new CalendarActivity(time, "Ace", 2145151);
            calendarActivities.add(a);
            textRepresentations.add(a.getClientName() + " " + a.getDate().getMonth().getValue() + "/" + a.getDate().getDayOfMonth());
        }
        activities.addAll(calendarActivities);
        listView.getItems().addAll(calendarActivities);
        listView.setOnMouseClicked(event -> {
            CalendarActivity b = listView.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText(b.toString());
            alert.showAndWait();
        });
    }
    @FXML
    protected void search() {
        String input = textField.getCharacters().toString();
        var filtered = activities.stream().filter(s -> s.getClientName().contains(input)).toList();
        listView.getItems().clear();
        for (CalendarActivity a : filtered) {
            listView.getItems().add(a);
        }
    }


}
