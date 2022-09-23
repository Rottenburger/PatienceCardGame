/**
 * The GUI class that handles all the visual aspects of the game,
 * it uses the table class to handle all logic
 * @author Thomas Roethenbaugh
 * @version 1.0
 */

package uk.ac.aber.dcs.cs12320.cards.gui.javafx.GUI;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GUI {

    private final Stage stage;
    private String[] cards;
    private boolean done;

    public GUI(Stage stage) {
        this.stage = stage;
        stage.setTitle("Patience");
    }

    /**
     * Called when the user quits the game. It results
     * in the face-down pack of cards not being displayed.
     */
    public void allDone() {
        done = true;
    }

    /**
     * Displays all the face-up cards (just the top showing cards)
     * and if the game is not over then also displays the face-down deck.
     * @param c the list of face-up cards
     */
    public void cardDisplay(ArrayList<String> c) {

        // We need to do this within the GUI thread. We assume
        // that the method is called by a non-GUI thread
        Platform.runLater(() -> {
            cards = new String[c.size()];
            cards = c.toArray(cards);

            ScrollPane sp = new ScrollPane();
            Scene scene = new Scene(sp, 1200, 500);
            scene.setFill(Color.BLACK);
            scene.getStylesheets().add(GUI.class.getResource("styling.css").toExternalForm()); //TODO
            HBox box = new HBox();
            Image image = null;

            if (cards != null) {
                for (String card : cards) {
                    String file = "cards/" + card;
                    image = new Image(getClass().getClassLoader().getResource(file).toString(), true);
                    drawCards(box, image);
                }
            }

            if (!done) {
                // Draws the face-down top card of our pack of cards
                String file = "cards/b.gif";
                image = new Image(getClass().getClassLoader().getResource(file).toString(), true);
                drawCards(box, image);
            }

            sp.setContent(box);
            sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

            stage.setScene(scene);
            stage.show();
        });

    }

    private void drawCards(HBox box, Image image) {
        ImageView iv;
        iv = new ImageView();
        // resizes the image to have width of 100 while preserving the ratio and using
        // higher quality filtering method; this ImageView is also cached to
        // improve performance
        iv.setImage(image);
        iv.setFitWidth(100);
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        iv.setCache(true);

        box.getChildren().add(iv);
    }

}
