import javafx.application.Application;

import javafx.stage.Stage;


public class Keno extends Application {
    private Stage stage;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
        stage = primaryStage;
        showWelcomeScreen();
        stage.setTitle("Keno");
        showTransition();
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.show();

		
				
		
	}

    public void showWelcomeScreen() {
        WelcomeScreen welcomeScreen = new WelcomeScreen(this);
        stage.setScene(welcomeScreen.getScene());

    }

    public void showRulesScreen() {
        RulesScreen rulesScreen = new RulesScreen(this);
        stage.setScene(rulesScreen.getScene());

    }

    public void showGameScreen1() {
        GameScreen1 gameScreen1 = new GameScreen1(this);
        stage.setScene(gameScreen1.getScene());

    }
    public void showOddsScreen() {
        OddsScreen oddsScreen = new OddsScreen(this);
        stage.setScene(oddsScreen.getScene());

    }
    public void showGameScreen2(int perDraw, int consecDraws, int spots) {
        GameScreen2 gameScreen2 = new GameScreen2(this, perDraw, consecDraws, spots);
        stage.setScene(gameScreen2.getScene());


    }

    public void showTransition(){
        Transitions transition = new Transitions(this);
        stage.setScene(transition.getScene());
    }

    public double getStageHeight(){
        return stage.getHeight();
    }

    public double getStageWidth(){
        return stage.getWidth();
    }
}
