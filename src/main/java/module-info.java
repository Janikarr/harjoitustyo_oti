module org.example.harjoitustyooti {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.harjoitustyooti to javafx.fxml;
    exports org.example.harjoitustyooti;
}