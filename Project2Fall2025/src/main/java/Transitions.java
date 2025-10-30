import javafx.animation.PauseTransition;
import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Transitions {
    private Keno app;
    private Scene scene;
    private StackPane root;

    public Transitions(Keno app) {
        this.app = app;

        root = new StackPane();
        root.setStyle("-fx-background-color: #F2D366;");
        root.setAlignment(Pos.CENTER);

        Text title = new Text("LOADING KENO...");
        title.setFont(Font.font("Montserrat", FontWeight.BOLD, 45));

        root.getChildren().add(title);
        scene = new Scene(root, app.getStageWidth(), app.getStageHeight());

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1.5), title);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);

        PauseTransition pause = new PauseTransition(Duration.seconds(2));

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), root);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);

        fadeOut.setOnFinished(e -> app.showWelcomeScreen());

        fadeIn.play();
        pause.setOnFinished(e -> fadeOut.play());
        pause.playFromStart();
    }

    public Scene getScene() {
        return scene;
    }
}
