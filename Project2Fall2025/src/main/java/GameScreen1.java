import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;



public class GameScreen1 {
    private final Keno app;
    private Scene scene;

    private int perDraw;
    private int consecGames;
    private int spots;

    private boolean isNewLook = false;

    public GameScreen1(Keno app) {
        this.app = app;
        BorderPane borderPane = new BorderPane();
        VBox root = new VBox();
        root.setSpacing(25);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #F2D366;");
        Button continueButton = new Button("Continue");
        continueButton.setStyle("-fx-background-color: BLACK;" + "-fx-text-fill: white;" + "-fx-font-size: 16px;" + "-fx-font-family: 'Montserrat';");
        continueButton.setDisable(true);

        // menu
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");
        borderPane.setTop(menuBar);
        MenuItem rules = new MenuItem("Rules");
        MenuItem odds = new MenuItem("Odds");
        MenuItem exit  = new MenuItem("Exit");
        MenuItem newLookbutton  = new MenuItem("New Look");
        menu.getItems().addAll(rules, odds, exit, newLookbutton);
        menuBar.getMenus().addAll(menu);

        rules.setOnAction(e -> app.showRulesScreen());
        odds.setOnAction((e) -> app.showOddsScreen());
        exit.setOnAction((e) -> System.exit(0));


        // perDraw portion
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.TOP_CENTER);
        Text title = new Text("How much do you want to play per draw?");
        title.setFont(Font.font("Montserrat", FontWeight.BOLD, 32));
        ToggleGroup toggleGroupDrawsCost = new ToggleGroup();
        RadioButton radioButtonDraw1Cost = new RadioButton("$1");
        RadioButton radioButtonDraw2Cost = new RadioButton("$2");
        RadioButton radioButtonDraw3Cost = new RadioButton("$3");
        RadioButton radioButtonDraw5Cost = new RadioButton("$5");
        RadioButton radioButtonDraw10Cost = new RadioButton("$10");
        radioButtonDraw1Cost.setStyle("-fx-font-size: 20px; -fx-mark-size: 25;");
        radioButtonDraw2Cost.setStyle("-fx-font-size: 20px; -fx-mark-size: 25;");
        radioButtonDraw3Cost.setStyle("-fx-font-size: 20px; -fx-mark-size: 25;");
        radioButtonDraw5Cost.setStyle("-fx-font-size: 20px; -fx-mark-size: 25;");
        radioButtonDraw10Cost.setStyle("-fx-font-size: 20px; -fx-mark-size: 25;");


        radioButtonDraw1Cost.setToggleGroup(toggleGroupDrawsCost);
        radioButtonDraw2Cost.setToggleGroup(toggleGroupDrawsCost);
        radioButtonDraw3Cost.setToggleGroup(toggleGroupDrawsCost);
        radioButtonDraw5Cost.setToggleGroup(toggleGroupDrawsCost);
        radioButtonDraw10Cost.setToggleGroup(toggleGroupDrawsCost);
        radioButtonDraw1Cost.setOnAction(e -> {perDraw = 1; checkButtonStatus(continueButton);});
        radioButtonDraw2Cost.setOnAction(e -> {perDraw = 2; checkButtonStatus(continueButton);});
        radioButtonDraw3Cost.setOnAction(e -> {perDraw = 3; checkButtonStatus(continueButton);});
        radioButtonDraw5Cost.setOnAction(e -> {perDraw = 5; checkButtonStatus(continueButton);});
        radioButtonDraw10Cost.setOnAction(e -> {perDraw = 10; checkButtonStatus(continueButton);});
        hBox.getChildren().addAll(radioButtonDraw1Cost, radioButtonDraw2Cost, radioButtonDraw3Cost, radioButtonDraw5Cost, radioButtonDraw10Cost);
        hBox.setSpacing(80);

        //consecuctive games
        HBox hBox2 = new HBox();
        hBox2.setAlignment(Pos.CENTER);
        Text title2 = new Text("How many consecutive draws do you want to play?");
        title2.setFont(Font.font("Montserrat", FontWeight.BOLD, 32));
        ToggleGroup toggleGroupConsecGames = new ToggleGroup();
        RadioButton radioButtonConsecGames1 = new RadioButton("1");
        RadioButton radioButtonConsecGames2 = new RadioButton("2");
        RadioButton radioButtonConsecGames3 = new RadioButton("3");
        RadioButton radioButtonConsecGames4 = new RadioButton("4");
        radioButtonConsecGames1.setStyle("-fx-font-size: 20px; -fx-mark-size: 25;");
        radioButtonConsecGames2.setStyle("-fx-font-size: 20px; -fx-mark-size: 25;");
        radioButtonConsecGames3.setStyle("-fx-font-size: 20px; -fx-mark-size: 25;");
        radioButtonConsecGames4.setStyle("-fx-font-size: 20px; -fx-mark-size: 25;");

        radioButtonConsecGames1.setToggleGroup(toggleGroupConsecGames);
        radioButtonConsecGames2.setToggleGroup(toggleGroupConsecGames);
        radioButtonConsecGames3.setToggleGroup(toggleGroupConsecGames);
        radioButtonConsecGames4.setToggleGroup(toggleGroupConsecGames);
        radioButtonConsecGames1.setOnAction(e -> {consecGames = 1; checkButtonStatus(continueButton);});
        radioButtonConsecGames2.setOnAction(e -> {consecGames = 2; checkButtonStatus(continueButton);});
        radioButtonConsecGames3.setOnAction(e -> {consecGames = 3; checkButtonStatus(continueButton);});
        radioButtonConsecGames4.setOnAction(e -> {consecGames = 4; checkButtonStatus(continueButton);});
        hBox2.getChildren().addAll(radioButtonConsecGames1, radioButtonConsecGames2, radioButtonConsecGames3, radioButtonConsecGames4);
        hBox2.setSpacing(100);

        // spots

        HBox hBox3 = new HBox();
        hBox3.setAlignment(Pos.CENTER);
        Text title3 = new Text("How many numbers (spots) do you want to play?");
        title3.setFont(Font.font("Montserrat", FontWeight.BOLD, 32));
        ToggleGroup toggleGroupSpots = new ToggleGroup();
        RadioButton radioButtonSpots1 = new RadioButton("1");
        RadioButton radioButtonSpots4 = new RadioButton("4");
        RadioButton radioButtonSpots8 = new RadioButton("8");
        RadioButton radioButtonSpots10 = new RadioButton("10");
        radioButtonSpots1.setStyle("-fx-font-size: 20px; -fx-mark-size: 25;");
        radioButtonSpots4.setStyle("-fx-font-size: 20px; -fx-mark-size: 25;");
        radioButtonSpots8.setStyle("-fx-font-size: 20px; -fx-mark-size: 25;");
        radioButtonSpots10.setStyle("-fx-font-size: 20px; -fx-mark-size: 25;");


        radioButtonSpots1.setToggleGroup(toggleGroupSpots);
        radioButtonSpots4.setToggleGroup(toggleGroupSpots);
        radioButtonSpots8.setToggleGroup(toggleGroupSpots);
        radioButtonSpots10.setToggleGroup(toggleGroupSpots);
        radioButtonSpots1.setOnAction(e -> {spots = 1; checkButtonStatus(continueButton);});
        radioButtonSpots4.setOnAction(e -> {spots = 4; checkButtonStatus(continueButton);});
        radioButtonSpots8.setOnAction(e -> {spots = 8;checkButtonStatus(continueButton);});
        radioButtonSpots10.setOnAction(e -> {spots = 10;  checkButtonStatus(continueButton);});
        hBox3.getChildren().addAll(radioButtonSpots1, radioButtonSpots4, radioButtonSpots8, radioButtonSpots10);
        hBox3.setSpacing(100);

        continueButton.setOnAction(e -> app.showGameScreen2(perDraw, consecGames, spots));





        root.getChildren().addAll(title,
                hBox,
                title2,
                hBox2,
                title3,
                hBox3,
                continueButton);

        borderPane.setCenter(root);



        newLookbutton.setOnAction(e -> {
            if (!isNewLook) {
                root.setStyle("-fx-background-color: #add8e6");
                title3.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 32));
                title2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 32));
                title.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 32));
                title3.setFill(Color.RED);
                title2.setFill(Color.RED);
                title.setFill(Color.RED);



            } else {
                root.setStyle("-fx-background-color: #F2D366;");
                title3.setFont(Font.font("Montserrat", FontWeight.BOLD, 32));
                title2.setFont(Font.font("Montserrat", FontWeight.BOLD, 32));
                title.setFont(Font.font("Montserrat", FontWeight.BOLD, 32));
                title3.setFill(Color.BLACK);
                title2.setFill(Color.BLACK);
                title.setFill(Color.BLACK);

            }
            isNewLook = !isNewLook;
        });
        scene = new Scene(borderPane,app.getStageWidth(), app.getStageHeight());

    }
    private void checkButtonStatus(Button button){
        if (perDraw > 0 && consecGames > 0 && spots > 0) {
            button.setDisable(false);
        }


    }



    public Scene getScene() {
        return scene;
    }


}
