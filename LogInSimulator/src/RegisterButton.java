import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterButton implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        try {
            String username = LogInMain.getUsername();
            String password = LogInMain.getPassword();
            DataUtility.insertData(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Username already exists, please choose a new one.");
        }

    }
}
