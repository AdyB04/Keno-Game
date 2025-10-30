import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.MenuItem;


public class OddsScreen {
    private final Keno app;
    private Scene scene;


    public  OddsScreen(Keno app) {
        this.app = app;
        VBox root = new VBox();
        root.setStyle("-fx-background-color: #E98E89;");
        root.setAlignment(Pos.CENTER);
        root.setSpacing(40);

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

        //Back Button
        Button backButton = new Button("Back To Menu");
        backButton.setStyle("-fx-background-color: BLACK;" + "-fx-text-fill: white;" + "-fx-font-size: 16px;" + "-fx-font-family: 'Montserrat';");
        backButton.setMinSize(150,50);
        backButton.setOnAction(e -> {app.showWelcomeScreen();});
        backButton.setAlignment(Pos.CENTER);

        //Title
        Text Title = new Text("Keno - Odds\n");
        Title.setFont(Font.font("Montserrat", FontWeight.BOLD, 40));
        Title.setFill(Color.BLACK);

        //subTitle
        Text subTitle = new Text("Prize Chart & Odds for $1 Play\n");
        subTitle.setFont(Font.font("Montserrat", FontWeight.BOLD, 30));
        subTitle.setFill(Color.BLACK);

        //Spot1 Text
        Text Spot1Text = new Text("Spot 1 (Pick 1)\n" + "\nMatch       Prize\n" + "\n   1              $2");
        Spot1Text.setFont(Font.font("Montserrat", FontWeight.BOLD,20));
        VBox textBox1 = new VBox(Spot1Text);
        textBox1.setAlignment(Pos.TOP_CENTER);
        textBox1.setPadding(new Insets(20, 10, 10, 20));
        textBox1.setSpacing(10);

        //Spot4 Text
        Text Spot4Text = new Text("Spot 4 (Pick 4)\n" + "\nMatch       Prize\n" + "\n   4             $75\n" + "\n   3             $5\n" +"\n   2             $1\n");
        Spot4Text.setFont(Font.font("Montserrat", FontWeight.BOLD,20));
        VBox textBox2 = new VBox(Spot4Text);
        textBox2.setAlignment(Pos.TOP_CENTER);
        textBox2.setPadding(new Insets(20, 10, 10, 20));
        textBox2.setSpacing(10);


        //Spot8 Text
        Text Spot8Text = new Text("Spot 8 (Pick 8)\n" + "\nMatch       Prize\n"  + "\n   8            $10,000\n" + "\n   7            $750\n" +"\n   6            $50\n" +"\n   5            $12\n" +"\n   4            $2\n");
        Spot8Text.setFont(Font.font("Montserrat", FontWeight.BOLD,20));
        VBox textBox3 = new VBox(Spot8Text);
        textBox3.setAlignment(Pos.TOP_CENTER);
        textBox3.setPadding(new Insets(20, 10, 10, 20));
        textBox3.setSpacing(10);

        //Spot10 Text
        Text Spot10Text = new Text("Spot 10 (Pick 10)\n" + "\nMatch       Prize\n" + "\n  10          $100,000\n" + "\n   9           $4,250\n" +"\n   8           $450\n" +"\n   7           $40\n" +"\n   6           $15\n" +"\n   5           $2\n" +"\n   0           $5\n");
        Spot10Text.setFont(Font.font("Montserrat", FontWeight.BOLD,20));
        VBox textBox4 = new VBox(Spot10Text);
        textBox4.setAlignment(Pos.TOP_CENTER);
        textBox4.setPadding(new Insets(20, 10, 10, 20));
        textBox4.setSpacing(10);

        //1st rectangle
        Rectangle rectangle1= new Rectangle(200, 500);
        rectangle1.setFill(Color.rgb(220, 199, 198));
        rectangle1.setStroke(Color.WHITE);
        rectangle1.setStrokeWidth(2);
        rectangle1.setArcWidth(20);
        rectangle1.setArcHeight(20);

        //Spot1 Text
        StackPane SpotBox1 = new StackPane();
        SpotBox1.getChildren().addAll(rectangle1, textBox1);
        SpotBox1.setAlignment(Pos.CENTER_LEFT);

        //2nd rectangle
        Rectangle rectangle2 = new Rectangle(200, 500);
        rectangle2.setFill(Color.rgb(220, 199, 198));
        rectangle2.setStroke(Color.WHITE);
        rectangle2.setStrokeWidth(2);
        rectangle2.setArcWidth(20);
        rectangle2.setArcHeight(20);

        //Spot4 Text
        StackPane SpotBox2 = new StackPane();
        SpotBox2.getChildren().addAll(rectangle2, textBox2);
        SpotBox2.setAlignment(Pos.CENTER_LEFT);

        //3rd rectangle
        Rectangle rectangle3 = new Rectangle(200, 500);
        rectangle3.setFill(Color.rgb(220, 199, 198));
        rectangle3.setStroke(Color.WHITE);
        rectangle3.setStrokeWidth(2);
        rectangle3.setArcWidth(20);
        rectangle3.setArcHeight(20);

        //Spot8 Text
        StackPane SpotBox3 = new StackPane();
        SpotBox3.getChildren().addAll(rectangle3, textBox3);
        SpotBox3.setAlignment(Pos.CENTER_LEFT);

        //4th rectangle
        Rectangle rectangle4 = new Rectangle(200, 500);
        rectangle4.setFill(Color.rgb(220, 199, 198));
        rectangle4.setStroke(Color.WHITE);
        rectangle4.setStrokeWidth(2);
        rectangle4.setArcWidth(20);
        rectangle4.setArcHeight(20);

        //Spot 10 Text
        StackPane SpotBox4 = new StackPane();
        SpotBox4.getChildren().addAll(rectangle4, textBox4);
        SpotBox4.setAlignment(Pos.CENTER_LEFT);




        //Grouping The rectangles
        HBox oddsRow = new HBox(70);
        oddsRow.setAlignment(Pos.CENTER);
        oddsRow.getChildren().addAll(SpotBox1, SpotBox2,SpotBox3,SpotBox4);


        root.getChildren().addAll(Title,subTitle,oddsRow,backButton);
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(root);

        scene = new Scene(borderPane, app.getStageWidth(), app.getStageHeight());

    }
    public Scene getScene() {
        return scene;
    }
}
