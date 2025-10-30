import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GameScreen2 {
    private Keno app;
    private Scene scene;
    private int perDraw;
    private int consecGames;
    private int spots;
    private GridPane grid;
    private Set<Integer> userNums = new HashSet<>();
    private Text result;
    private Text payout;
    private Button drawButton;
    private VBox infoBox;
    private HBox TopHBox;
    private int totalWinnings = 0;
    private Button nextDrawButton;
    private Button playAgainButton;
    private boolean isNewLook = false;
    private KenoLogic logic;
    private Button quickPickButton;
    //For seting up the game
    public GameScreen2(Keno app, int perDraw, int consecGames, int spots) {
        this.app = app;
        this.consecGames = consecGames;
        this.spots = spots;
        this.perDraw = perDraw;
        makeGameScreen2();
    }
    //For testing
    public GameScreen2(Keno app, int perDraw, int consecGames, int spots, boolean skipUI) {
        this.app = app;
        this.consecGames = consecGames;
        this.spots = spots;
        this.perDraw = perDraw;
        this.logic = new KenoLogic(spots, perDraw);

        if (!skipUI) {
            makeGameScreen2();
        }
    }
    //The setup for the main Game screen
    public void makeGameScreen2() {
        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: #F2D366;");

        //Exit
        Button ExitButton = new Button("Exit");
        ExitButton.setStyle("-fx-background-color: BLACK;" + "-fx-text-fill: white;" + "-fx-font-size: 16px;" + "-fx-font-family: 'Montserrat';");
        ExitButton.setMinSize(150, 50);
        ExitButton.setOnAction(e -> System.exit(0));

        HBox bottomBox = new HBox(ExitButton);
        bottomBox.setAlignment(Pos.BOTTOM_RIGHT);
        bottomBox.setPadding(new Insets(15));
        borderPane.setBottom(bottomBox);


        // Menu bar
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");
        MenuItem rules = new MenuItem("Rules");
        MenuItem odds = new MenuItem("Odds");
        MenuItem exit = new MenuItem("Exit");
        MenuItem newLookbutton = new MenuItem("New Look");
        menu.getItems().addAll(rules, odds, exit, newLookbutton);
        menuBar.getMenus().addAll(menu);
        menuBar.setStyle("-fx-background-color: White;" + "-fx-text-fill: black;" + "-fx-font-size: 16px;" + "-fx-font-family: 'Montserrat';");

        //Title
        Text title = new Text("Wager: $" + perDraw + "  |  Draws: " + consecGames + "  |  Spots: " + spots);
        title.setFont(Font.font("Montserrat", FontWeight.BOLD, 24));
        BorderPane.setAlignment(title, Pos.CENTER);

        //Lining the Title and MenuBar
        VBox fixMenu = new VBox(menuBar, title);
        fixMenu.setAlignment(Pos.CENTER);
        fixMenu.setSpacing(5);
        fixMenu.setPadding(new Insets(0, 0, 10, 0));


        // grid for the buttons
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        buildGrid();


        // button to quickpick numbers
        quickPickButton = new Button("Quick Pick");
        quickPickButton.setStyle("-fx-background-color: BLACK;" + "-fx-text-fill: white;" + "-fx-font-size: 16px;" + "-fx-font-family: 'Montserrat';");
        quickPickButton.setOnAction(e -> quickPick());


        // actions for menu bar
        rules.setOnAction(e -> app.showRulesScreen());
        odds.setOnAction(e -> app.showOddsScreen());
        exit.setOnAction(e -> System.exit(0));

        // text for results of draw and payout
        result = new Text("Numbers drawn: ");
        payout = new Text("Matches: ");
        result.setFont(Font.font("Montserrat", 16));
        payout.setFont(Font.font("Montserrat", 16));

        //Top
        HBox topBox = new HBox(50, menuBar, title);
        topBox.setAlignment(Pos.CENTER);
        topBox.setPadding(new Insets(10));
        topBox.setStyle("-fx-background-color: #F2D366;");
        borderPane.setTop(topBox);

        //Result Text
        infoBox = new VBox(10, result, payout);
        infoBox.setAlignment(Pos.CENTER_LEFT);
        infoBox.setPadding(new Insets(20));
        borderPane.setRight(infoBox);


        // handling for draw button
        drawButton = new Button("Draw!!!");
        drawButton.setStyle("-fx-background-color: BLACK;" + "-fx-text-fill: white;" + "-fx-font-size: 16px;" + "-fx-font-family: 'Montserrat';");
        drawButton.setDisable(true);
        drawButton.setOnAction(e -> {
            setGridButtonsDisabled(true);   // prevent changing numbers
            quickPickButton.setDisable(true);
            drawNumbers();
        });

        // button to go to next draw if doing more than one
        nextDrawButton = new Button("Continue to next draw");
        nextDrawButton.setStyle("-fx-background-color: BLACK;" + "-fx-text-fill: white;" + "-fx-font-size: 16px;" + "-fx-font-family: 'Montserrat';");
        nextDrawButton.setDisable(true);
        setupNextDrawButton();


        // button to play again
        playAgainButton = new Button("Play Again");
        playAgainButton.setStyle("-fx-background-color: BLACK;" + "-fx-text-fill: white;" +
                "-fx-font-size: 16px;" + "-fx-font-family: 'Montserrat';");
        playAgainButton.setOnAction(e -> app.showWelcomeScreen());
        playAgainButton.setDisable(true);

        //To center the grid and draw button
        VBox centerBox = new VBox(20,topBox,grid, drawButton, nextDrawButton, quickPickButton,playAgainButton);
        centerBox.setAlignment(Pos.CENTER);
        centerBox.setPadding(new Insets(20));
        borderPane.setCenter(centerBox);

        // handle new look menu option
        newLookbutton.setOnAction(e -> {
            if (!isNewLook) {
                borderPane.setStyle("-fx-background-color: #add8e6");
                topBox.setStyle("-fx-background-color: #add8e6");
                result.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 16));
                payout.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 16));
                title.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 24));
                title.setFill(Color.RED);



            } else {
                borderPane.setStyle("-fx-background-color: #F2D366;");
                topBox.setStyle("-fx-background-color: #F2D366;");
                result.setFont(Font.font("Montserrat", FontWeight.BOLD, 16));
                payout.setFont(Font.font("Montserrat", FontWeight.BOLD, 16));
                title.setFont(Font.font("Montserrat", FontWeight.BOLD, 24));
                title.setFill(Color.BLACK);

            }
            isNewLook = !isNewLook;
        });


        scene = new Scene(borderPane, 900, 700);
    }


    // function to build grid of buttons
    private void buildGrid() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                int number = 10 * i + j + 1;
                Button button = new Button(String.valueOf(number));
                button.setPrefSize(60, 60);
                button.setStyle("-fx-font-size: 14px; -fx-font-family: 'Montserrat';");
                button.setOnAction(e -> selectionProcess(button, number));
                grid.add(button, j, i);
            }
        }
    }

    // calls the quickpick function from keno logic
    private void quickPick() {
        userNums.clear();
        userNums = KenoLogic.quickPick(spots);

        for (Node node : grid.getChildren()) {
            if (node instanceof Button) {
                Button btn = (Button) node;  // old-school Java 11 style
                int value = Integer.parseInt(btn.getText());
                if (userNums.contains(value)) {
                    btn.setStyle("-fx-background-color: red; -fx-text-fill: white;");
                } else {
                    btn.setStyle("");
                }
            }
        }
        drawButton.setDisable(userNums.size() != spots);
    }

    // function to add the selected buttons to a set
    private void selectionProcess(Button button, int num) {
        if (userNums.contains(num)) {
            userNums.remove(num);
            button.setStyle("");
        } else {
            if (userNums.size() >= spots) {
                return;
            }
            userNums.add(num);
            button.setStyle("-fx-background-color: red;");
        }
        drawButton.setDisable(userNums.size() != spots);
    }

    // function to draw numbers and see the matches and show results and payout
    private void drawNumbers() {
        Set<Integer> drawnNums = KenoLogic.randDraw();

        Set<Integer> matches = KenoLogic.matches(userNums, drawnNums);

        Integer[] drawOrder = drawnNums.toArray(new Integer[0]);
        Set<Integer> revealed = new HashSet<>();

        Timeline timeline = new Timeline();
        for (int i = 0; i < drawOrder.length; i++) {
            int num = drawOrder[i];
            KeyFrame frame = new KeyFrame(Duration.seconds(i * 0.4), e -> {
                revealed.add(num);
                highlightDrawnNumber(num);
                result.setText("Numbers drawn: " + revealed);
            });
            timeline.getKeyFrames().add(frame);
        }

        timeline.setOnFinished(e -> {
            matches.retainAll(drawnNums);

            grid.getChildren().forEach(node -> {
                if (node instanceof Button) {
                    Button match = (Button) node;
                    int n = Integer.parseInt(match.getText());
                    if (matches.contains(n)) {
                        match.setStyle("-fx-background-color: green; -fx-text-fill: white;");
                    } else if (userNums.contains(n)) {
                        match.setStyle("-fx-background-color: red; -fx-text-fill: white;");
                    } else if (drawnNums.contains(n)) {
                        match.setStyle("-fx-background-color: #FFD700;");
                    } else {
                        match.setStyle("");
                    }
                }
            });

            int wonThisRound = calculatePrize(matches.size()) * perDraw;
            totalWinnings += wonThisRound;
            consecGames--;

            String oldResult = result.getText();
            result.setText(oldResult + "\nDraw Result " + (consecGames + 1) + ": " + drawnNums);

            payout.setText("Matches: " + matches + " | Won this round: $" + wonThisRound
                    + "\nTotal so far: $" + totalWinnings);

            drawButton.setDisable(true);

            if (consecGames > 0) {
                nextDrawButton.setDisable(false);
            } else {
                payout.setText(payout.getText() + "\n\n All draws complete! Final Winnings: $" + totalWinnings);
                nextDrawButton.setDisable(true);
                playAgainButton.setDisable(false);
            }
        });

        timeline.play();
    }

    // function to highlight the drawn numbers
    private void highlightDrawnNumber(int num) {
        grid.getChildren().forEach(node -> {
            if (node instanceof Button) {
                Button btn = (Button) node;
                int n = Integer.parseInt(btn.getText());
                if (n == num) {
                    btn.setDisable(true);
                    btn.setStyle("-fx-background-color: gold; -fx-font-weight: bold;");
                }
            }
        });
    }



    // function to set up the next draw
    private void setupNextDrawButton() {
        nextDrawButton.setOnAction(e -> {
            grid.getChildren().forEach(node -> {
                if (node instanceof Button) {
                    Button btn = (Button) node;
                    int num = Integer.parseInt(btn.getText());
                    if (userNums.contains(num)) {
                        btn.setStyle("-fx-background-color: red; -fx-text-fill: white;");
                    } else {
                        btn.setStyle("");
                    }
                }
            });
            nextDrawButton.setDisable(true);
            drawButton.setDisable(false);
        });
    }

    // function to calcuate prize
    private int calculatePrize(int matchCount) {
        //prize table for Spot8
        KenoLogic tempLogic = new KenoLogic(spots, perDraw);
        return tempLogic.calculatePrize(matchCount);
    }

    private void setGridButtonsDisabled(boolean disable) {
        for (Node node : grid.getChildren()) {
            if (node instanceof Button) {
                ((Button) node).setDisable(disable);
            }
        }
    }

    public Scene getScene() {
        return scene;
    }
}



