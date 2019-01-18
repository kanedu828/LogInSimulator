import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LogInMain extends Application {
    private static TextField username = new TextField();
    private static TextField password = new TextField();
    private static Stage window;
    private static Scene scene;

    public static void main(String[] args) {
        createConnection();
        launch(args);
    }

    public static void createConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //This statement may be different depending on driver version
            System.out.println("Server connected");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        window.setMaxHeight(300);
        window.setMaxWidth(250);
        window.setMinHeight(300);
        window.setMinWidth(250);

        setScene();
        window.setScene(scene);
        window.show();
    }

    public static String getUsername(){
        String usernameText = username.getText();
        System.out.println(usernameText);
        return usernameText;
    }
    public static String getPassword(){
        String passwordText = password.getText();
        System.out.println(passwordText);
        return passwordText;
    }

    public static Stage getWindow(){
        return window;
    }

    public static Scene getScene(){
        return scene;
    }

    public static void setScene(){
        StackPane stack = new StackPane();
        FlowPane flow = new FlowPane();
        VBox vBox = new VBox();

        Label title = new Label("Log In Simulator");

        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password: ");
        //username = new TextField();
        //password = new TextField();
        Button logInButton = new Button("Log In");
        Button registerButton = new Button("Register");
        logInButton.setOnAction(new LogInButton());
        registerButton.setOnAction(new RegisterButton());
        flow.getChildren().addAll(usernameLabel, username, passwordLabel,password);
        flow.setAlignment(Pos.CENTER);
        flow.setMargin(title,new Insets(10));
        flow.setMargin(username, new Insets(10));
        flow.setMargin(password, new Insets(10));
        flow.setMargin(logInButton, new Insets(10));
        vBox.getChildren().addAll(logInButton,registerButton);
        stack.getChildren().addAll(flow, title, vBox);
        stack.setAlignment(title, Pos.TOP_CENTER);
        vBox.setAlignment(Pos.BOTTOM_CENTER);
        scene = new Scene(stack);
    }
}
