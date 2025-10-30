import com.sun.prism.impl.VertexBuffer;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.MenuItem;


public class RulesScreen {
    private final Keno app;
    private Scene scene;

    public RulesScreen(Keno app) {
        this.app = app;
        VBox root = new VBox();
        root.setStyle("-fx-background-color: #E98E89;");
        root.setAlignment(Pos.CENTER);

        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");
        MenuItem rules = new MenuItem("Rules");
        MenuItem odds = new MenuItem("Odds");
        MenuItem exit  = new MenuItem("Exit");
        menu.getItems().addAll(rules, odds, exit);
        menuBar.getMenus().addAll(menu);


        rules.setOnAction(e -> app.showRulesScreen());
        odds.setOnAction((e) -> app.showOddsScreen());
        exit.setOnAction((e) -> System.exit(0));

        //Rectangle
        Rectangle rectangle = new Rectangle(510, 250);
        rectangle.setFill(Color.rgb(220, 199, 198));
        rectangle.setStroke(Color.WHITE);
        rectangle.setStrokeWidth(2);
        rectangle.setArcWidth(20);
        rectangle.setArcHeight(20);

        //Title
        Text title = new Text("Keno - Rules of the game\n");
        title.setFont(Font.font("Montserrat", FontWeight.BOLD, 30));
        title.setFill(Color.BLACK);

        //Rules
        Text rule1 = new Text("- You select 1, 4, 8, or 10 numbers from 1 to 80.\n");
        Text rule2 = new Text("- The game randomly draws 20 unique numbers (1-80)\n");
        Text rule3 = new Text("- You win based on how many of your numbers match\n");
        Text rule4 = new Text("- You may play between 1 and 4 consecutive drawings\n");
        rule1.setFont(Font.font("Montserrat", 20));
        rule2.setFont(Font.font("Montserrat", 20));
        rule3.setFont(Font.font("Montserrat", 20));
        rule4.setFont(Font.font("Montserrat", 20));

        VBox textBox = new VBox(rule1, rule2, rule3, rule4);
        textBox.setAlignment(Pos.CENTER_LEFT);
        textBox.setPadding(new Insets(40, 25, 25, 40));
        textBox.setSpacing(10);
        textBox.setMaxWidth(rectangle.getWidth() - 30);
        textBox.setPrefWidth(rectangle.getWidth() - 30);

        //Combining the rules with the rectangle
        StackPane rulesBox = new StackPane();
        rulesBox.getChildren().addAll(rectangle, textBox);
        rulesBox.setAlignment(Pos.CENTER);


        //Button
        Button backButton = new Button("Back To Menu");
        backButton.setStyle("-fx-background-color: BLACK;" + "-fx-text-fill: white;" + "-fx-font-size: 16px;" + "-fx-font-family: 'Montserrat';");
        backButton.setMinSize(150,50);
        backButton.setOnAction(e -> {app.showWelcomeScreen();});
        backButton.setAlignment(Pos.CENTER);

        //combining everything
        root.getChildren().addAll(title,rulesBox, backButton);
        VBox.setMargin(backButton, new Insets(20, 0, 0, 0));
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(root);

        scene = new Scene(borderPane,app.getStageWidth(), app.getStageHeight());

    }
    public Scene getScene() {
        return scene;
    }

}
