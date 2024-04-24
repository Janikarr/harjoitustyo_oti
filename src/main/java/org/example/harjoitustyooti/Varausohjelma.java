package org.example.harjoitustyooti;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Varausohjelma extends Application {

    private Parent root;
    private Stage stage;
    private Scene scene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        

        root = FXMLLoader.load(getClass().getResource("VarausOhjelma.fxml"));


        retrieveDataFromDatabase();

        primaryStage.show();
        primaryStage.setTitle("Moi");
        primaryStage.setScene(new Scene(root));

    }


    private void retrieveDataFromDatabase() {


        String url = "jdbc:mysql://localhost:3306/hovi";
        String user = "root";
        String password = "kikiarttumilli";

        try {
            // Establish a connection
            Connection connection = DriverManager.getConnection(url, user, password);

            // Create a statement
            Statement statement = connection.createStatement();

            // Define your SQL query
            String query = "SELECT * FROM henkilo";

            // Execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // Process the result set
            while (resultSet.next()) {
                // Retrieve data by column name
                int id = resultSet.getInt("htun");
                String name = resultSet.getString("enimi");
                // Print or process the retrieved data as needed
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void vaihdaSceneAlue(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Alueet.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

    }

    public void vaihdaSceneVaraukset(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Varaukset.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

    }

    public static void main(String[] args) {
        launch(args);
    }
}

// moikkuli moiii