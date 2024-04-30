module org.example.calendartest {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.calendartest to javafx.fxml;
    exports org.example.calendartest;

}