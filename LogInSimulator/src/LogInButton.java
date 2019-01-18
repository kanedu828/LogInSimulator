import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.sql.*;

public class LogInButton implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        //LogInMain main = new LogInMain();
        //System.out.println(main.getUsername());
        try {
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginsimulator", "kanedu", "kanedu");
            String username = DataUtility.extractData("username", LogInMain.getUsername());
            String password = LogInMain.getPassword();
            String actualPassword = DataUtility.extractData("password", username);
            if(password.equals(actualPassword)){
                System.out.println("Log in successful!");
                VBox layout = new VBox();
                Label label = new Label("You're in!");
                Button logout = new Button("Log out");
                logout.setOnAction(e->LogInMain.getWindow().close());
                layout.getChildren().addAll(label, logout);
                Scene scene = new Scene(layout);
                LogInMain.getWindow().setScene(scene);
            }
            else{
                System.out.println("-Incorrect username or password, please try again");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            System.out.println("Incorrect username or password, please try again");
        }
        //Logged in screen


    }


}
