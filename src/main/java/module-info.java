module org.example.harjoitustyooti {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.harjoitustyooti to javafx.fxml;
    exports org.example.harjoitustyooti;
}