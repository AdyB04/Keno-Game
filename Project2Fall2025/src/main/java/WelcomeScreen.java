import com.sun.prism.impl.VertexBuffer;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class WelcomeScreen {
    private final Keno app;
    private Scene scene;

    public WelcomeScreen(Keno app) {
        this.app = app;

        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");
        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: #F2D366;");
        borderPane.setTop(menuBar);
        MenuItem rules = new MenuItem("Rules");
        MenuItem odds = new MenuItem("Odds");
        MenuItem exit  = new MenuItem("Exit");
        menu.getItems().addAll(rules, odds, exit);
        menuBar.getMenus().addAll(menu);

        rules.setOnAction(e -> app.showRulesScreen());
        odds.setOnAction((e) -> app.showOddsScreen());
        exit.setOnAction((e) -> System.exit(0));



        VBox centerBox = new VBox();
        centerBox.setAlignment(Pos.CENTER);
        centerBox.setSpacing(10);
        Text title = new Text("Welcome to Keno");
        title.setFont(Font.font("Montserrat", FontWeight.BOLD, 48));


        Button startButton = new Button("Click here to start");
        startButton.setStyle("-fx-background-color: BLACK;" + "-fx-text-fill: white;" + "-fx-font-size: 16px;" + "-fx-font-family: 'Montserrat';");
        startButton.setOnAction(e -> app.showGameScreen1());
        centerBox.getChildren().addAll(title, startButton);
        borderPane.setCenter(centerBox);

        scene = new Scene(borderPane, app.getStageWidth(), app.getStageHeight());



    }

    public Scene getScene() {
        return scene;
    }

}
