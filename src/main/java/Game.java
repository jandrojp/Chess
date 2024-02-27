import controller.Input;
import model.*;
import view.Console;
import view.Screen;

import java.util.Scanner;
import java.util.Set;

public class Game {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {

        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("                                                                    " + Console.YELLOW_BACKGROUND + Console.ANSI_BLACK + "  WELCOME TO THE CHESS ! ♟️ " + Console.ANSI_RESET);
        System.out.println();
        int number = Input.getInteger("                                                  SELECT WHAT YOU WANT TO DO (1 - " + Console.GREEN_BACKGROUND + "  PLAY ▶️ " + Console.ANSI_RESET + "  /  2 - " + Console.RED_BACKGROUND + "  EXIT \uD83D\uDEAA  " + Console.ANSI_RESET + " ): ");

        while (number != 1 && number != 2) {
            System.out.println("                                                                 " + Console.ANSI_RED + "   ERROR NUMBER, WRITE 1 OR 2 ! \uD83D\uDE21 " + Console.ANSI_RESET);
            number = Input.getInteger("                                                  SELECT WHAT YOU WANT TO DO (1 - " + Console.GREEN_BACKGROUND + "  PLAY ▶️  " + Console.ANSI_RESET + "  /  2 - " + Console.RED_BACKGROUND + "  EXIT \uD83D\uDEAA  " + Console.ANSI_RESET + " ): ");
        }

        if (number == 1) {

            instructions();
            System.out.println();

            System.out.print("                                                  Name for player #1 ⚪: ");
            String playerWhite = sc.next();
            System.out.print("                                                  Name for player #2 ⚫: ");
            String playerBlack = sc.next();
            System.out.println();

            Board board = new Board();
            board.placePieces();
            Screen.showWhite(board);

            boolean checkmateWhite = false;
            boolean checkmateBlack = false;

            while ((board.getDeletedPieces().count(Piece.Type.BLACK_KING) == 0 &&
                    board.getDeletedPieces().count(Piece.Type.WHITE_KING) == 0) &&
                    !checkmateWhite && !checkmateBlack) {


                System.out.println("                                                  " + Console.YELLOW_BACKGROUND + Console.ANSI_WHITE + "  Move " + playerWhite + " -> ⚪  " + Console.ANSI_RESET);
                System.out.println("                                                  Which piece do you want to move?");

                String coordinateWhite = Input.getCoordinate();
                checkmateWhite = moveWhite(coordinateWhite, board, checkmateWhite);

                if ((board.getDeletedPieces().count(Piece.Type.BLACK_KING) == 0 &&
                        board.getDeletedPieces().count(Piece.Type.WHITE_KING) == 0) &&
                        !checkmateWhite) {

                    System.out.println("                                                  " + Console.YELLOW_BACKGROUND + Console.ANSI_BLACK + "  Move " + playerBlack + " -> ⚫  " + Console.ANSI_RESET);
                    System.out.println("                                                  Which piece do you want to move?");

                    String coordinateBlack = Input.getCoordinate();
                    checkmateBlack = moveBlack(coordinateBlack, board, checkmateBlack);
                }
            }

            System.out.println();

            if (board.getDeletedPieces().count(Piece.Type.BLACK_KING) == 1 || checkmateWhite) {
                if (board.getDeletedPieces().count(Piece.Type.BLACK_KING) == 1) {
                    System.out.println("                                                                  " + Console.ANSI_BLACK + Console.GREY_BACKGROUND + "  \uD83D\uDC80 THE BLACK KING HAS DIED \uD83D\uDC80  " + Console.ANSI_RESET);
                }
                System.out.println();
                System.out.println("                                                  " + Console.ANSI_WHITE + Console.GREEN_BACKGROUND + "  " + playerWhite + " HAS WON THE GAME! \uD83C\uDFC6  " + Console.ANSI_RESET);

            } else if (board.getDeletedPieces().count(Piece.Type.WHITE_KING) == 1 || checkmateBlack) {
                if (board.getDeletedPieces().count(Piece.Type.WHITE_KING) == 1) {
                    System.out.println("                                                                  " + Console.ANSI_WHITE + Console.GREY_BACKGROUND + "  \uD83D\uDC80 THE WHITE KING HAS DIED \uD83D\uDC80  " + Console.ANSI_RESET);
                }
                System.out.println();
                System.out.println("                                                  " + Console.ANSI_BLACK + Console.GREEN_BACKGROUND + "  " + playerBlack + " HAS WON THE GAME! \uD83C\uDFC6  " + Console.ANSI_RESET);
            }


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
        System.out.println("                          -" + Console.ANSI_YELLOW + " Objective" + Console.ANSI_RESET + ": The goal is to put the opponent's king in checkmate, meaning that the king is threatened and there\n                            is no legal way to escape the threat.");
        System.out.println("                          -" + Console.ANSI_YELLOW + " Board" + Console.ANSI_RESET + ": The chess board has 64 squares, arranged in an 8x8 pattern. Each player has a set of 16 pieces at the\n                            beginning of the game.");
        System.out.println("                          -" + Console.ANSI_YELLOW + " Castling" + Console.ANSI_RESET + ": A special move involving the king and a rook. There are two types of castling: short castling (king\n                            side) and long castling (queen side). Certain conditions apply, such as that neither the king nor the rook\n                            have previously moved.");
        System.out.println("                          -" + Console.ANSI_YELLOW + " Pawn on the move" + Console.ANSI_RESET + ": If a pawn moves two squares from its initial position and lands next to an opposing pawn,\n                            the latter can capture the pawn as if it had only advanced one square.");
        System.out.println("                          -" + Console.ANSI_YELLOW + " Pawn promotion" + Console.ANSI_RESET + ": When a pawn reaches the eighth rank, it can be promoted to any other piece (except the king),\n                            usually a queen is chosen.");
        System.out.println();
        System.out.println("                          " + Console.ANSI_YELLOW + "----------------------------------------------------------------------------------------------------------------" + Console.ANSI_RESET);
    }

    public static boolean moveWhite(String startCoordinate, Board board, boolean checkmate) {
        Set<Coordinate> coordinates;

        while (Coordinate.wrongLenght(startCoordinate) ||
                !(board.contains(new Coordinate(startCoordinate.charAt(0), startCoordinate.charAt(1) - 48))) ||
                board.getCellAt(new Coordinate(startCoordinate.charAt(0), startCoordinate.charAt(1) - 48)).isEmpty() ||
                board.getCellAt(new Coordinate(startCoordinate.charAt(0), startCoordinate.charAt(1) - 48)).getPiece().getNextMovements().isEmpty() ||
                board.getCellAt(new Coordinate(startCoordinate.charAt(0), startCoordinate.charAt(1) - 48)).getPiece().getColor().equals(Piece.Color.BLACK)) {

            System.out.println(Console.ANSI_RED + "                                                                         COORDINATE ERROR ! \uD83D\uDE21" + Console.ANSI_RESET);
            startCoordinate = Input.getCoordinate();
        }

        Coordinate chosenCoordinate = new Coordinate(startCoordinate.charAt(0), startCoordinate.charAt(1) - 48);
        System.out.println();


        coordinates = board.getCellAt(chosenCoordinate).getPiece().getNextMovements();
        board.highlight(coordinates);
        Screen.showWhite(board);
        System.out.println("                                                                          REMAINING PIECES ✅" + Console.ANSI_RESET);
        System.out.println(board.getRemainingPieces());
        System.out.println("                                                                           DELETED PIECES ❌" + Console.ANSI_RESET);
        System.out.println(board.getDeletedPieces());

        System.out.println();
        System.out.println("                                                  Where do you want to move it?");
        String finalCoordinate = Input.getCoordinate();
        Coordinate destinationCoordinate;

        while (Coordinate.wrongLenght(finalCoordinate) ||
                !(board.getCellAt(chosenCoordinate).getPiece().canMoveTo(new Coordinate(finalCoordinate.charAt(0), finalCoordinate.charAt(1) - 48)))
                ) {

            System.out.println(Console.ANSI_RED + "                                                                         COORDINATE ERROR ! \uD83D\uDE21" + Console.ANSI_RESET);
            finalCoordinate = Input.getCoordinate();
        }

        destinationCoordinate = new Coordinate(finalCoordinate.charAt(0), finalCoordinate.charAt(1) - 48);
        board.getCellAt(chosenCoordinate).getPiece().moveTo(destinationCoordinate);
        System.out.println();
        board.resetColor();

        Piece p = board.getCellAt(destinationCoordinate).getPiece();
        Set<Coordinate> coordinatesTwo = p.getNextMovements();

        if (p.checkBlack(coordinatesTwo, board)) {
            if (board.checkMateBlack(p)) {
                p.getCell().highlightCheckMate();
            } else {
                p.getCell().highlightCheck();
            }
        } else {
            Screen.showBlack(board);
        }

        if (p.checkBlack(coordinatesTwo, board)) {
            Screen.showBlack(board);

            if (board.checkMateBlack(p)) {
                System.out.println();
                System.out.println("                                                                  " + Console.ANSI_BLACK + Console.RED_BACKGROUND + "  \uD83D\uDC80 CHECKMATE THE BLACK KING \uD83D\uDC80  " + Console.ANSI_RESET);
                checkmate = true;
            } else {
                System.out.println("                                                                " + Console.BLUE_BACKGROUND + Console.ANSI_BLACK + "  ⚠️  THE BLACK KING IS IN CHECK  ⚠️  " + Console.ANSI_RESET);
                System.out.println();
            }
        }

        return checkmate;
    }

    public static boolean moveBlack(String startCoordinate, Board board, boolean checkmate) {
        Set<Coordinate> coordinates;

        while (Coordinate.wrongLenght(startCoordinate) ||
                !(board.contains(new Coordinate(startCoordinate.charAt(0), startCoordinate.charAt(1) - 48))) ||
                board.getCellAt(new Coordinate(startCoordinate.charAt(0), startCoordinate.charAt(1) - 48)).isEmpty() ||
                board.getCellAt(new Coordinate(startCoordinate.charAt(0), startCoordinate.charAt(1) - 48)).getPiece().getNextMovements().isEmpty() ||
                board.getCellAt(new Coordinate(startCoordinate.charAt(0), startCoordinate.charAt(1) - 48)).getPiece().getColor().equals(Piece.Color.WHITE)) {

            System.out.println(Console.ANSI_RED + "                                                                         COORDINATE ERROR ! \uD83D\uDE21" + Console.ANSI_RESET);
            startCoordinate = Input.getCoordinate();
        }

        Coordinate chosenCoordinate = new Coordinate(startCoordinate.charAt(0), startCoordinate.charAt(1) - 48);
        System.out.println();


        coordinates = board.getCellAt(chosenCoordinate).getPiece().getNextMovements();
        board.highlight(coordinates);
        Screen.showBlack(board);
        System.out.println(Console.ANSI_GREEN + "                                                                          REMAINING PIECES ✅" + Console.ANSI_RESET);
        System.out.println(board.getRemainingPieces());
        System.out.println(Console.ANSI_RED + "                                                                           DELETED PIECES ❌" + Console.ANSI_RESET);
        System.out.println(board.getDeletedPieces());

        System.out.println();
        System.out.println("                                                  Where do you want to move it?");
        String finalCoordinate = Input.getCoordinate();
        Coordinate destinationCoordinate;

        while (Coordinate.wrongLenght(finalCoordinate) ||
                !(board.getCellAt(chosenCoordinate).getPiece().canMoveTo(new Coordinate(finalCoordinate.charAt(0), finalCoordinate.charAt(1) - 48)))
                ) {

            System.out.println(Console.ANSI_RED + "                                                                         COORDINATE ERROR ! \uD83D\uDE21" + Console.ANSI_RESET);
            finalCoordinate = Input.getCoordinate();
        }

        destinationCoordinate = new Coordinate(finalCoordinate.charAt(0), finalCoordinate.charAt(1) - 48);
        board.getCellAt(chosenCoordinate).getPiece().moveTo(destinationCoordinate);
        System.out.println();
        board.resetColor();

        Piece p = board.getCellAt(destinationCoordinate).getPiece();
        Set<Coordinate> coordinatesTwo = p.getNextMovements();

        if (p.checkWhite(coordinatesTwo, board)) {

            if (board.checkMateWhite(p)) {
                p.getCell().highlightCheckMate();
            } else {
                p.getCell().highlightCheck();
            }

        } else {
            Screen.showWhite(board);
        }

        if (p.checkWhite(coordinatesTwo, board)) {
            Screen.showWhite(board);

            if (board.checkMateWhite(p)) {
                System.out.println();
                System.out.println("                                                                  " + Console.ANSI_WHITE + Console.RED_BACKGROUND + "  \uD83D\uDC80 CHECKMATE THE WHITE KING \uD83D\uDC80  " + Console.ANSI_RESET);
                checkmate = true;

            } else {
                System.out.println("                                                                " + Console.BLUE_BACKGROUND + Console.ANSI_WHITE + "  ⚠️  THE WHITE KING IS IN CHECK  ⚠️  " + Console.ANSI_RESET);
                System.out.println();
            }
        }

        return checkmate;
    }

}
