package view;

import model.Board;
import model.Coordinate;

public class Screen {

    private static String getLetters() {
        return "                                                                        A  B  C  D  E  F  G  H\n";
    }

    private static String getMiddlePart(Board board, int fila) {
        StringBuilder salida = new StringBuilder("                                                                     " + fila + " ");

        for (int col = 0; col < 8; col++) {
            salida.append(board.getCellAt(new Coordinate((char) ('A' + col), fila)));
        }

        return salida.append(" " + fila + "\n").toString();
    }

    public static void showWhite(Board board) {
        StringBuilder salida = new StringBuilder();
        salida.append(getLetters());

        for (int fila = 1; fila <= 8; fila++) {
            salida.append(getMiddlePart(board, fila));
        }

        salida.append(getLetters());
        System.out.println(salida);
    }

    public static void showBlack(Board board) {
        StringBuilder salida = new StringBuilder();
        salida.append(getLetters());

        for (int fila = 8; fila >= 1; fila--) {
            salida.append(getMiddlePart(board, fila));
        }

        salida.append(getLetters());
        System.out.println(salida);
    }
}
