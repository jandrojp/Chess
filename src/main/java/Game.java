import controller.Input;
import model.Board;
import view.Console;
import view.Screen;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {


        menu();

    }

    public static void menu() {

        System.out.println();
        System.out.println("                                                                    " + Console.YELLOW_BACKGROUND + Console.ANSI_BLACK + "  WELCOME TO THE CHESS ! ♟️" + Console.ANSI_RESET);
        System.out.println();
        int number = Input.getInteger("                                                  SELECT WHAT YOU WANT TO DO (1 - " + Console.GREEN_BACKGROUND + "  PLAY ▶️" + Console.ANSI_RESET + "  /  2 - " + Console.RED_BACKGROUND + "  EXIT \uD83D\uDEAA  " + Console.ANSI_RESET + " ): ");

        while (number != 1 && number != 2) {
            System.out.println("                                                                 " + Console.ANSI_RED + "   ERROR NUMBER, WRITE 1 OR 2 ! \uD83D\uDE21 " + Console.ANSI_RESET);
            number = Input.getInteger("                                                  SELECT WHAT YOU WANT TO DO (1 - " + Console.GREEN_BACKGROUND + "  PLAY ▶️" + Console.ANSI_RESET + "  /  2 - " + Console.RED_BACKGROUND + "  EXIT \uD83D\uDEAA  " + Console.ANSI_RESET + " ): ");
        }

        if (number == 1) {
            instructions();
            System.out.println();

        } else {
            System.out.println();
            System.out.println("                                                                        " + Console.YELLOW_BACKGROUND + Console.ANSI_BLACK + "  SEE YOU SOON ! \uD83D\uDD25  " + Console.ANSI_RESET);
        }


    }

    /**
     * Method showing game instructions
     */
    public static void instructions() {
        System.out.println();
        System.out.println("                          " + Console.ANSI_YELLOW + "-----------------------------------------      " + Console.ANSI_RESET + Console.YELLOW_BACKGROUND + Console.ANSI_BLACK + "  INSTRUCTIONS \uD83D\uDCCB  " + Console.ANSI_RESET + Console.ANSI_YELLOW + "      ----------------------------------------" + Console.ANSI_RESET);
        System.out.println();
        System.out.println("                          -" + Console.ANSI_CYAN + " Objective" + Console.ANSI_RESET + ": The objective of the game is to clear the playing field without activating any mines. The playing\n                            field is divided into squares, some of which contain mines and some of which do not.");
        System.out.println("                          -" + Console.ANSI_CYAN + " Mines" + Console.ANSI_RESET + ": Some boxes contain mines, and the player must not click on them. If you click on a mine, you lose the\n                            game. The number of mines is 10 / 40 / 99.");
        System.out.println("                          -" + Console.ANSI_CYAN + " Safe spaces" + Console.ANSI_RESET + ": The game begins with all spaces hidden. The player must click on a square to reveal it. If the\n                            revealed space does not contain a mine, it will display a number indicating how many mines are in the adjacent\n                            spaces.");
        System.out.println("                          -" + Console.ANSI_CYAN + " Opening rules" + Console.ANSI_RESET + ": If you click on an empty space without a mine, all adjacent empty spaces will be revealed until\n                            they reach a number. This can help open up large areas of the playing field safely.");
        System.out.println("                          -" + Console.ANSI_CYAN + " Win" + Console.ANSI_RESET + ": The game is won when all safe spaces have been revealed without activating any mines. The goal is to\n                            clear the playing field safely and efficiently.");
        System.out.println("                          -" + Console.ANSI_CYAN + " Lose" + Console.ANSI_RESET + ": The game is lost when you click on a mine.");
        System.out.println();
        System.out.println("                          " + Console.ANSI_YELLOW + "----------------------------------------------------------------------------------------------------------------" + Console.ANSI_RESET);
    }


    public static void game() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Jugador blancas? ");
        String jugadorBlancas = sc.next();
        System.out.print("Jugador negras? ");
        String jugadorNegras = sc.next();

        System.out.println();

        Board board = new Board();
        board.placePieces();

        System.out.println("Move " + jugadorBlancas + " -> BLACK");
        System.out.println("Which piece do you want to move?");
        System.out.print("Enter a coordinate: ");
        String coordinate = sc.next();

        System.out.println();

        Screen.show(board);
    }
}
