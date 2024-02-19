package model;

import java.util.*;

public class Board {

    private final Map<Coordinate, Cell> cells;

    public Board() {
        cells = new HashMap<>();
        initializeCells();
    }

    private void initializeCells() {
        Coordinate coordinate;
        Cell cell;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                coordinate = new Coordinate((char) ('A' + col), 1 + row);
                cell = new Cell(this, coordinate);
                cells.put(coordinate, cell);
            }
        }
    }

    public void placePieces() {
        new King(this, new Coordinate('E', 1), King.Type.BLACK);
        new King(this, new Coordinate('E', 8), King.Type.WHITE);

        new Queen(this, new Coordinate('D', 1), Queen.Type.BLACK);
        new Queen(this, new Coordinate('D', 8), Queen.Type.WHITE);

        new Bishop(this, new Coordinate('C', 1), Bishop.Type.BLACK);
        new Bishop(this, new Coordinate('F', 1), Bishop.Type.BLACK);
        new Bishop(this, new Coordinate('C', 8), Bishop.Type.WHITE);
        new Bishop(this, new Coordinate('F', 8), Bishop.Type.WHITE);

        new Knight(this, new Coordinate('B', 1), Knight.Type.BLACK);
        new Knight(this, new Coordinate('G', 1), Knight.Type.BLACK);
        new Knight(this, new Coordinate('B', 8), Knight.Type.WHITE);
        new Knight(this, new Coordinate('G', 8), Knight.Type.WHITE);

        new Rook(this, new Coordinate('A', 1), Rook.Type.BLACK);
        new Rook(this, new Coordinate('H', 1), Rook.Type.BLACK);
        new Rook(this, new Coordinate('A', 8), Rook.Type.WHITE);
        new Rook(this, new Coordinate('H', 8), Rook.Type.WHITE);

        for (int col = 0; col < 8; col++) {
            new Pawn(this, new Coordinate((char) ('A' + col), 2), Pawn.Type.BLACK);
            new Pawn(this, new Coordinate((char) ('A' + col), 7), Pawn.Type.WHITE);
        }
    }

    public boolean contains(Coordinate c) {
        return !(c.getNumber() < 1 || c.getNumber() > 8 || c.getLetter() < 'A' || c.getLetter() > 'H');
    }

    public Cell getCellAt(Coordinate c) {
        if (!contains(c)) return null;
        return cells.get(c);
    }

    public void highlight(Set<Coordinate> coordinates) {
        for (Coordinate c : coordinates)
            cells.get(c).highlight();
    }

    public void resetColor() {
        for (Coordinate c : cells.keySet())
            cells.get(c).resetColor();
    }

}