/**
 * The Game of patience main class
 * @author Thomas Roethenbaugh
 * @version 1.0
 */

import javafx.application.Application;
import javafx.application.Platform;

import javafx.stage.Stage;
import uk.ac.aber.dcs.cs12320.cards.gui.javafx.GUI.GUI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game extends Application {

    private Table table;
    public GUI gui;
    ArrayList<String> cardStrings = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        gui = new GUI(stage);
        Runnable commandLineTask = () -> {
            table = new Table(new Deck(), 0);
            runMenu();
            Platform.exit();
        };
        Thread commandLineThread = new Thread(commandLineTask);
        // This is how we start the thread.
        // This causes the run method to execute.
        commandLineThread.start();
    }

    /**
     * This method will run the command line interface at the start of the program
     */
    private void runMenu() {
        String response;
        do {
            printMenu();
            System.out.println("What would you like to do:");
            Scanner scan = new Scanner(System.in);
            response = scan.nextLine().toUpperCase();
            switch (response) {
                case "1":
                    table.initialiseDeck();
                    gui.cardDisplay(cardStrings);
                    break;
                case "2":
                    table.printDeck();
                    break;
                case "3":
                    table.addPile();
                    cardStrings.add(table.getFirstCardFromDeck() + ".gif");
                    break;
                case "4":
                    table.moveLastPileOntoPrevious();
                    break;
                case "5":
                    table.moveLastPileOverTwoPiles();
                    break;
                case "6":
                    table.amalgamate();
                    break;
                case "7":

                    break;
                case "8":

                    break;
                case "9":
                    table.printScore();
                    break;
                case "Q":
                    break;
                default:
                    System.out.println("That response is not valid");
            }
        } while (!(response.equals("Q")));
    }

    private void printMenu() {
        System.out.println("1 -  Start new game \n2 -  Print the pack out \n3 -  Deal a card \n" +
                "4 -  move last card onto previous pile \n5 -  move last card onto the pile skipping over two piles \n" +
                "6 -  Amalgamate piles in the middle \n7 -  Play for me once \n8 -  Play for me many times" +
                "\n9 -  Show high scores \nq -  Quit");
    }

    public static void main(String args[]) {
        System.out.println("Hello!");
        Application.launch(args);
        System.out.println("Goodbye!");
    }

}
